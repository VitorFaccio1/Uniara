import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.task.ExternalTask;

public class InscricaoWorker {
	private static CandidatoDAO candidatoDAO = new CandidatoDAO(false);
	private static String meuEmail = "vitorfaccio5@gmail.com";
	private static String minhaSenha = "hiegwcuwbptskzqr";

	public static void main(String[] args) {
		var client = ExternalTaskClient.create().baseUrl("http://localhost:8082/engine-rest")
				.asyncResponseTimeout(10000).maxTasks(1).build();

		client.subscribe("armazena-inscricao").handler((externalTask, externalTaskService) -> {
			try {
				var candidato = criarCandidato(externalTask);

				if (!candidatoDAO.CandidatoJaInscrito(candidato)) {
					System.out.println("Inserindo candidato:");
					System.out.println(candidato.toString());

					candidatoDAO.inserirCandidato(candidato);

					enviarEmailConfirmacao(candidato.getEmail());
					System.out.println("\nEmail enviado com sucesso!!!");
				}
			} catch (Exception e) {
				System.out.println("\nErro ao tentar inserir o candidato, tente novamente!");
				System.out.println(e.getMessage());
			}

			externalTaskService.complete(externalTask);
		}).open();
	}

	private static CandidatoTO criarCandidato(ExternalTask externalTask) {
		var nome = (String) externalTask.getVariable("nome");
		var cpf = (String) externalTask.getVariable("cpf");
		var telefone = (String) externalTask.getVariable("telefone");
		var email = (String) externalTask.getVariable("email");
		var endereco = (String) externalTask.getVariable("endereco");
		var cidade = (String) externalTask.getVariable("cidade");
		var estado = (String) externalTask.getVariable("estado");
		var cep = (String) externalTask.getVariable("cep");

		return new CandidatoTO(nome, cpf, telefone, email, endereco, cidade, estado, cep);
	}

	private static void enviarEmailConfirmacao(String emailCandidato) throws Exception {
		var email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
		email.setSSLOnConnect(true);

		email.setFrom(meuEmail);
		email.setSubject("UNIARA - Confirmação de inscrição");
		email.setMsg("Inscrição confirmada na UNIARA com sucesso!");
		email.addTo(emailCandidato);
		email.send();
	}
}
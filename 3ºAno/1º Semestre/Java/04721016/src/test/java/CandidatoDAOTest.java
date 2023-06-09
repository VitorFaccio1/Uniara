import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CandidatoDAOTest {

	private static CandidatoDAO candidatoDAOTest;

	@BeforeEach
	public void setup() {
		candidatoDAOTest = new CandidatoDAO(true);
	}

	@Test
	public void testInserirCandidato() {
		CandidatoTO candidato = new CandidatoTO("João", "123456789", "999999999", "joao@test.com", "Rua A", "Cidade A",
				"Estado A", "12345");

		candidatoDAOTest.inserirCandidato(candidato);

		Assertions.assertTrue(candidatoDAOTest.CandidatoJaInscrito(candidato));
	}

	@Test
	public void testCandidatoJaInscrito() {
		CandidatoTO candidato = new CandidatoTO("Maria", "987654321", "888888888", "maria@test.com", "Rua B",
				"Cidade B", "Estado B", "54321");

		Assertions.assertFalse(candidatoDAOTest.CandidatoJaInscrito(candidato));

		candidatoDAOTest.inserirCandidato(candidato);

		Assertions.assertTrue(candidatoDAOTest.CandidatoJaInscrito(candidato));
	}

	@AfterAll
	public static void deletar() {
		candidatoDAOTest.deletarTodosCandidatos();
	}
}
function VerificaIdade(){
    var idade = document.getElementById("idade").value
    var botaoFinaliza = document.getElementById("finalizaCompra")

    if(idade < 18 ){
        alert("Você nao pode comprar  bebida alcoolicas!!!")
        botaoFinaliza.style.display = "none"
    }
}

function FinalizarCompra(){
    var nome = document.getElementById("nome").value
    var cidade = document.getElementById("cidade").value
    var endereco = document.getElementById("endereco").value
    var idade = document.getElementById("idade").value
    var numero = document.getElementById("numero").value
    var qtd = document.getElementById("quantidade").value


    if(qtd < 1 || nome == "" || cidade == "" || endereco == "" || idade == "" || numero == "")
        alert("Insira dados corretos")
    else{
        alert("Compra realizada com sucesso!!!!")
    }
}
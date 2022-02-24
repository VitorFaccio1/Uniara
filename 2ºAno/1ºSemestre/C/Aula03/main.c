#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */


float dividir(float a, float b){
	if(b != 0){
		return (a / b);
	}
	else{
		return (-100);		
	}
}

float multiplicar(float a, float b){
	return (a * b);
}

float somar(float a, float b){
	return (a + b);
}

float subtrair(float a, float b){
	return (a - b);
}

int main(int argc, char *argv[]) {
	
	float a, b, soma = 0 , subtrai = 0, divide = 0, multiplica = 0;
	int operacao;
	
	do{
		
		printf("\nCalculadora\n");
		printf("1)Somar\n2)Subtrair\n3)Multiplicar\n4)Dividir\n5)Sair\n");
		printf("Digite a operacao: ");
		scanf("%d", &operacao);

    	
		if(operacao < 5){
			printf("Digite o primeiro numero: ");
			scanf("%f", &a);

			printf("Digite o segundo numero: ");
			scanf("%f", &b);   
    		}
	
		switch(operacao){
			case 1: 
				soma = somar(a,b);
				printf("Resultado soma: %.2f\n", soma);
				break;
			case 2: 
				subtrai = subtrair(a,b);
				printf("Resultado subtracao: %.2f\n", subtrai);
				break;
			case 3: 
				multiplica = multiplicar(a,b);
				printf("Resultado multiplicacao: %.2f\n", multiplica);
				break;
			case 4: 
				divide = dividir(a,b);
				if(divide != -100)
				    printf("Resultado divisao: %.2f\n", divide);
				else
				    printf("Impossivel dividir por zero, tente novamente!\n");
				break;
			case 5:
			    break;
			default: 
			    printf("\nInsira um numero correto\n");
			    break;
		}	
	}while(operacao != 5);

	return 0;
}

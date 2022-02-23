#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	//tipoDado nomeVariavel
	float peso, altura, imc;
	
	printf("informe seu peso: ");
	fflush(stdin);
	scanf("%f", &peso);
		
	printf("\nInforme sua altura: ");
	fflush(stdin);
	scanf("%f", &altura);
	
   	imc = peso /(altura*altura);
	
	printf("\nSeu IMC e de : %f", imc);
	
	if(imc < 17.3){
		printf("\nVoce esta na magreza");
	}else if(17.3 <= imc < 25.5){
		printf("\nVoce esta no normal");
	}else if(25.5 <= imc < 29.7){
		printf("\nVoce esta no sobre peso");
	}else{
		printf("\nVoce esta na obesidade");
	}
		
	return 0;
}

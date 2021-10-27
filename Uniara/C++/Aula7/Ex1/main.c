#include <stdio.h>
#include <stdlib.h>

#define TAM 15

int main(int argc, char *argv[]) {
	int vetor[TAM], controle = 0,i;
	char resposta;
	
	do{
		printf("Digite um numero inteiro: ");
		fflush(stdin);
		scanf("%i", &vetor[controle]);
		
		controle++;
		
		printf("\nDeseja continuar s ou n: ");
		fflush(stdin);
		scanf("%c", &resposta);
	}while(resposta == 's' || resposta == 'S' && controle < TAM);
	
	for(i = 0; controle > i; i++){
		printf("%i", vetor[i]);
	}
			
	return 0;   
}

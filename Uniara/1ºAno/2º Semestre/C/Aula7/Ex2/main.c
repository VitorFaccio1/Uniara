#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#define TAM 15

int main(int argc, char *argv[]) {
	int vetor[TAM], controle = 0,i, soma = 0, aux = 0;
	float media = 0;
	char resposta;
	setlocale(LC_ALL,"Portuguese");
	do{
		printf("Digite um numero inteiro: ");
		fflush(stdin);
		scanf("%i", &vetor[controle]);
		
		controle++;
		
		printf("\nDeseja continuar s ou n: ");
		fflush(stdin);
		scanf("%c", &resposta);
	}while(resposta == 's' || resposta == 'S' && controle < TAM);
	
	int maior = vetor[0];
	int menor = vetor[0];
	for(i = 0; controle > i; i++){
		if(vetor[i] > maior)
			maior = vetor[i];	
		if(vetor[i] < menor)
		menor = vetor[i];	
		
		soma += vetor[i];
		
		media = soma/controle;
	}
	printf("O maior elemento é: %i", maior);
	printf("\nO menor elemento é: %i", menor);	
	printf("\nA soma é: %i", soma);	
	printf("\nA média é: %.2f", media);
	
	for(i = 0; i < controle - 1; i++){
		if(vetor[i] > vetor[i+1]){
			aux = vetor[i];
			vetor[i] = vetor[i+1];
			vetor[i+1] = aux;
			i = -1;
		}
	}
	printf("\n");
	for(i = 0; i < controle; i++){
		printf("%i", vetor[i]);
	}
	return 0;   
}

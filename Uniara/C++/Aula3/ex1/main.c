#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main(int argc, char *argv[]) {
	
	setlocale(LC_ALL,"Portuguese");
	char resposta;
	int idade;
	
	printf("Digite sua idade: ");
	fflush(stdin);
	scanf("%i", &idade);
	
	printf("Deseja continuar? (S/n): ");
	fflush(stdin);
	scanf("%c", &resposta);
	
	printf("Idade: %i - resposta: %c", idade, resposta);
		
	char nome[50];
	
	printf("\nInsira seu nome: ");	
	fflush(stdin);
	//le apenas 1 string (sem espaços)
	//scanf("%s", nome);
	//le +1 string (com espaços)
	gets(nome);
	
	printf("Seu nome é: %s", nome);
		
	return 0;
}

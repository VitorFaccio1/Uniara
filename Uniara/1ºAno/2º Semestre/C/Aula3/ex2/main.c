#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	//o nome pode conter espa�os, mas o email n�o.
	
	setlocale(LC_ALL, "Portuguese");
	char nome[50];
	char email[50];
	
	printf("Insira seu nome: ");
	fflush(stdin);
	gets(nome);
	
	printf("Insira seu e-mail: ");
	fflush(stdin);
	scanf("%s", email);	
	
	printf("\nSeu nome �: %s\nSeu e-mail �: %s ",nome, email);
	
	return 0;
}

#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	int numero;
	
	printf("Hello world!\n");
	
	printf("Ola mundo!\n");
	
	printf("Digite um numero inteiro: ");
	fflush(stdin);
	scanf("%i", &numero);

	printf("o numero digitado foi %i", numero);
	
	return 0;
}

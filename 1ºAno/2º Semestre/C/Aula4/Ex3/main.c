#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	int saque, saque100, saque50, saque20, saque10, resto100, resto50, resto20, resto10;
	
	printf("Informe o valor do saque: ");
	fflush(stdin);
	scanf("%i", &saque);
	
		resto100 = saque % 100;
		saque100 = saque/100;

		resto50 = resto100 % 50;
		saque50 = resto100/50;

		resto20 = resto50 % 20;
		saque20 = resto50/20;
		
		resto10 = saque20 % 10;
		saque10 = resto20/10;			
	
	printf("\nNecessarias %i notas de 100reais", saque100);
	printf("\nNecessarias %i notas de 50reais", saque50);
	printf("\nNecessarias %i notas de 20reais", saque20);
	printf("\nNecessarias %i notas de 10reais", saque10);

	
	return 0;
}

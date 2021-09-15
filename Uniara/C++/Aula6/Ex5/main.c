#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	int contador = 0;
	float soma, valor;
	
	for(contador; contador < 10; contador++){
		printf("Informe um valor: ");
		fflush(stdin);
		scanf("%f", &valor);
		
		soma += valor;
	}
	
	printf("A soma e de: %f", soma);
	
	return 0;
}

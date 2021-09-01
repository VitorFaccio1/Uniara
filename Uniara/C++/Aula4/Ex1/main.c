#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int idade;
	
	printf("Digite sua idade: ");
	fflush(stdin);
	scanf("%i", &idade);
	
	if(idade >= 18 )
		printf("Liberado");
	else
		printf("Negado");
	
	return 0;
}

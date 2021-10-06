#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	int numero, contador;
	
	printf("Insira um numero: ");
	fflush(stdin);
	scanf("%i", &numero);
	
	if(numero <= 0){
		printf("Insira um numero valido!!!!");
	}else{
		for(contador = 1; contador <= numero; contador++){
			if(numero % contador == 0){
				printf("Divisivel por: %i\n", contador);
			}
		}
	}
	return 0;
}

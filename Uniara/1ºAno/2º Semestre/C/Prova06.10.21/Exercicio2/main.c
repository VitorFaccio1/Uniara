#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
 	int diarias, resultado;
 	
 	printf("Insira o numero de diarias: ");
 	fflush(stdin);
 	scanf("%i", &diarias);
 	
	if(diarias > 15){
 		resultado = (600 * diarias) + (55 * diarias);
	}
	
	if(diarias == 15){
		resultado = (600 * diarias) + (60 * diarias);
	}
		
	if(diarias < 15){
		resultado = (600 * diarias) + (65 * diarias);
	}
	
	printf("O valor total da conta: R$ %i", resultado);

	return 0;
}

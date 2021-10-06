#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	int contador, resultado, aux;
		
	for(contador = 0; contador < 25; contador++){
		if(contador==0){
			printf("1\n");
		}else{
			resultado = aux*4;
			
			aux = resultado;
			
			printf("%i\n", resultado);	
		}
	}
	
	return 0;
}

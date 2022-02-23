#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	int altura, largura, i, j;
	
	do{
		printf("Quanto de altura voce quer sua matriz: ");
		fflush(stdin);
		scanf("%i", &altura);
	}while(altura <= 0);
	
	do{
		printf("Quanto de largura voce quer sua matriz: ");
		fflush(stdin);
		scanf("%i", &largura);
	}while(largura <= 0);
	
	
	int matriz[altura][largura];
	
	for(i = 0; i < largura; i++){
		for(j = 0; j < altura; j++){
			matriz[i][j] = 0;
		}
	}
	
	for(i = 0; i < altura; i++){
		for(j = 0; j < largura; j++){
			  printf("%3d" ,matriz[i][j]);
		}
		printf("\n");
	}
	
	return 0;
}

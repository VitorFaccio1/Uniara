#include <stdio.h>
#include <stdlib.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	float media, frequencia; 
	
	printf("Informe sua nota: ");
	fflush(stdin);
	scanf("%f", &media            );
	
	
	printf("Informe sua frequência: ");
	fflush(stdin);
	scanf("%f", &frequencia);
	
	if(frequencia >= 0.75){
		printf("\nAluno foi aprovado na frequência");
		if(media >= 6)
			printf("\nAluno aprovado totalmente!");
		else{
			if(media >= 3)
				printf("\nAluno de exame final!");
			else
				printf("\nReprovado por nota!");		
		}	
	}
	else
		if(frequencia >= 0.7)
			printf("\nAluno de exame final");
		else
			printf("\nAluno reprovado por falta");
	
	
	return 0;
}

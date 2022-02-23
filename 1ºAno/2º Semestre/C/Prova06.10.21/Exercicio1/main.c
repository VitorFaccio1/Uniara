#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	float a,b,c,d,resultado, mq;
	
	printf("Insiria o valor de A: ");
	fflush(stdin);
	scanf("%f", &a);
	
	printf("Insiria o valor de B: ");
	fflush(stdin);
	scanf("%f", &b);
	
	printf("Insiria o valor de C: ");
	fflush(stdin);
	scanf("%f", &c);
	
	printf("Insiria o valor de D: ");
	fflush(stdin);
	scanf("%f", &d);
	
	resultado = ((a*a)+(b*b)+(c*c)+(d*d))/4;
	
	mq = sqrt(resultado);
	
	printf("Media quadratica: %f", mq);
	
	return 0;
}

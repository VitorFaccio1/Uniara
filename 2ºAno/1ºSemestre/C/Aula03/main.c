#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */


float dividir(float a, float b){
	if(b != 0){
		return (a / b);
	}
	else{
		return (-100);		
	}
}

float multiplicar(float a, float b){
	return (a * b);
}

float somar(float a, float b){
	return (a + b);
}

float subtrair(float a, float b){
	return (a - b);
}

int main(int argc, char *argv[]) {
	
	float a, b, soma = 0 , subtrai = 0, divide = 0, multiplica = 0;
	int operacao;
	
	do{
		
    	printf("####################\n");
    	printf("1)Somar\n2)Subtrair\n3)Multiplicar\n4)Dividir\n5)Sair\n");
    	printf("####################\n");
    	printf("Digite a operacao: ");
    	scanf("%d", &operacao);
    	
    	
    	if(operacao != 5){
    	    printf("Digite o primeiro numero: ");
        	scanf("%f", &a);
        	
        	printf("Digite o segundo numero: ");
        	scanf("%f", &b);   
    	}
	
    	switch(operacao){
    		case 1: 
    			soma = somar(a,b);
    			printf("%2.f\n", soma);
    			return 0;
    			break;
    		case 2: 
    			subtrai = subtrair(a,b);
    			printf("%2.f\n", subtrai);
    			break;
    		case 3: 
    			multiplica = multiplicar(a,b);
    			printf("%2.f\n", multiplica);
    			break;
    		case 4: 
    			divide = dividir(a,b);
    			if(divide != -100)
    			    printf("%2.f\n", divide);
    			else
    			    printf("Impossivel dividir por zero, tente novamente!\n");
    			break;
    	}	
	}while(operacao != 5);

	return 0;
}
	

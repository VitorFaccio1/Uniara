#include <stdio.h>

int main()
{
	int tamanhoLinha = 10, tamanhoColuna = 10;
    int matriz[tamanhoLinha][tamanhoColuna], linha, coluna;
    int valoresArmazenadosDiagonalSecundaria[tamanhoLinha], valoresArmazenadosDiagonalPrincipal[tamanhoLinha];

    for(coluna = 0; coluna < tamanhoColuna; coluna++){
        for(linha = 0; linha < tamanhoLinha; linha++){
            matriz[linha][coluna] = rand()%100;
        }
    }
    
    for(coluna = 0; coluna < tamanhoColuna; coluna++){
        for(linha = 0; linha < tamanhoLinha; linha++){
                printf("%3d", matriz[linha][coluna]);
            }
            printf("\n");
        }

	for(coluna = 0; coluna < tamanhoColuna; coluna++){
        for(linha = 0; linha < tamanhoLinha; linha++){
            if(linha == coluna){
                valoresArmazenadosDiagonalPrincipal[linha] = matriz[coluna][linha];
            }
        }
    }
	
    for(coluna = 9; coluna >= 0; coluna--){
        for(linha = 0; linha < tamanhoLinha; linha++){
            if(coluna + linha == 9){
                valoresArmazenadosDiagonalSecundaria[linha] = matriz[coluna][linha];
            }
        }
    }
    
    printf("\nNumeros da diagonal principal: ");
    for(linha = 0; linha < tamanhoLinha; linha++){
        printf("%i, ", valoresArmazenadosDiagonalPrincipal[linha]);
    }
    
    printf("\nNumeros pares da diagonal principal: ");
	for(linha = 0; linha < tamanhoLinha; linha++){
		if(valoresArmazenadosDiagonalPrincipal[linha] % 2 == 0){
			printf("%i, ", valoresArmazenadosDiagonalPrincipal[linha]);
		}
    }
    
    printf("\nNumeros impares da diagonal principal: ");
	for(linha = 0; linha < tamanhoLinha; linha++){
		if(valoresArmazenadosDiagonalPrincipal[linha] % 2 == 1){
			printf("%i, ", valoresArmazenadosDiagonalPrincipal[linha]);
		}
    }
    
	printf("\n\nNumeros da diagonal secundaria: ");
    for(linha = 0; linha < tamanhoLinha; linha++){
        printf("%i, ", valoresArmazenadosDiagonalSecundaria[linha]);
    }
    
    printf("\nNumeros pares da diagonal secundaria: ");
	for(linha = 0; linha < tamanhoLinha; linha++){
		if(valoresArmazenadosDiagonalSecundaria[linha] % 2 == 0){
			printf("%i, ", valoresArmazenadosDiagonalSecundaria[linha]);
		}
    }
    
    printf("\nNumeros impares da diagonal secundaria: ");
	for(linha = 0; linha < 10; linha++){
		if(valoresArmazenadosDiagonalSecundaria[linha] % 2 == 1){
			printf("%i, ", valoresArmazenadosDiagonalSecundaria[linha]);
		}
    }
    
    


    return 0;
}


#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int i = 0;
	
	for(;i<101; i++){
		if(i%2==0)
			printf("\n%i",i);
	}
	return 0;
}

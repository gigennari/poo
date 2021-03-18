#include <stdio.h>

float NovaParcela(float s_anterior, float j){

    float S_novo = s_anterior * (1 + (j/100));
    return S_novo;

}

int main(){

    //parcela incial 
    float S = 200;    
    //numero de parcelas 
    int N = 5;
    //juros mensais em %
    int J = 1;

    printf("As parcelas do financiamento:\n");

    printf("%.2f; ", S);
    
    for (int i = 1; i < N; i++){
        
        float S_novo = NovaParcela(S, J);
        printf("%.2f; ", S_novo);
        S = S_novo;
    }
    printf("\n");
    return 0;
}
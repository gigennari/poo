package Anotações de Aula;

public class Emprestimo {
    float s, j, corrente; 
    int n, i; 
    
    Emprestimo(float s, float j, int n){
    this.s = s;
    this.j = j;
    this.corrente = s;
    this.n = n;
    this.i = 0;
    }
    
    public class void ProximaParcela(){
    
    if (i != 0) {
        corrente = corrente * (1+j);
    }
    i++;
    System.out.println (corrente); 
    }
    
}
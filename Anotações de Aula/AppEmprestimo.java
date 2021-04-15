package Anotações de Aula;

public class AppEmprestimo {

        public static void main(String args[]){
              Emprestimo e1 = new Emprestimo(200, 0.01, 5);
        
        for (int i = 0; i < e1.n; i++){   
             e1.ProximaParcela();
        }
}

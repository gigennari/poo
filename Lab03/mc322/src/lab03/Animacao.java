package lab03;

public class Animacao {

	String comandos;
    AquarioLombriga aquario;
    
    Animacao(String sequencia){
        int tam_aq = Integer.valueOf(sequencia.substring(0,2));
        int tam_lom = Integer.valueOf(sequencia.substring(2,4));
        int pos_inicial = Integer.valueOf(sequencia.substring(4,6));
      
        aquario = new AquarioLombriga(tam_aq, tam_lom, pos_inicial-1);
        
        this.comandos = sequencia.substring(6, sequencia.length());
        
    }
    
    void ExecutarAnimacoes(){
        aquario.Apresentar();
        int n = comandos.length();
        for(int i = 0; i < n; i++){
            switch (comandos.charAt(i)) {
              case 'C' : aquario.Crescer(); break;
              case 'M' : aquario.Mover(); break;
              case 'V' : aquario.Virar(); break;
              default: System.out.println("comando invalido\n");
            }
            aquario.Apresentar();
        }
            
    }
       
}

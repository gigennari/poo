package lab03;

import java.lang.String;
import java.lang.Math;

public class AquarioLombriga {
	int tam_aq, tam_lom, pos_inicial, pos_final, orientacao;
    String linha = "";
    
    AquarioLombriga(int tam_aq, int tam_lom, int pos_inicial){
        this.tam_aq = tam_aq;
        this.tam_lom = tam_lom;
        this.pos_inicial = pos_inicial; 
        this.pos_final = pos_inicial + tam_lom - 1; 
        this.orientacao = 0; //0 para cabeça na direita, 1 para cabeça na esquerda
        
        //se a lombriga for maior que o aquário 
        if(tam_lom > tam_aq) {
        	tam_aq = tam_lom;	//aumentar tamanho do aquário
        }
      //se ela for menor
        else {
        	//se não couber dada a posição inicial, colocar começando no canto esquerdo do aquário
        	if(pos_inicial+tam_lom > tam_aq) {
        		pos_inicial = 0;
        		pos_final = tam_lom - 1;
        	}
        	
        }
        
        //preencher carcteres 
        for (int i = 0; i < tam_aq; i++){
            if (i >= pos_inicial && i <= pos_final)
            {
                if(i == pos_final)
                {
                    linha = linha + "0";
                }
                else {
                	linha = linha + "@";
                }   
            }
            else {
            	linha = linha + "#";
            }   
        }
            
    }
    
    void Virar(){  
        char c_final = linha.charAt(pos_final);
        char c_inicial =  linha.charAt(pos_inicial);
        
        char[] chars = linha.toCharArray();
        chars[pos_final] = c_inicial;
        chars[pos_inicial] = c_final;
        linha = String.valueOf(chars);
        
        //mudar orientacao 
        orientacao = Math.abs(orientacao - 1); //se for 0 vira 1 e se for 1 vira 0     
    }
    
    void Crescer( ){
        //só pode crescer 1 unidade e se couber no tamnho do aquário
        //se estiver p direita #@@@0#
        
        
        if (orientacao == 0){
             if(pos_inicial > 0){
            	 pos_inicial -= 1;
                 char[] chars = linha.toCharArray();
                 chars[pos_inicial] = '@';
                 linha = String.valueOf(chars); 
                 tam_lom += 1;
             }
        }
        //se estiver p esquerda #0@@@#
        else{
            if(pos_final < tam_aq){
            	pos_final += 1;
                char[] chars = linha.toCharArray();
                 chars[pos_final] = '@';
                 linha = String.valueOf(chars);
                tam_lom += 1;  
            }
        }   
    }
    
    void Mover(){
        //move na direção da cabeça se houver espaço, senão vira 
        
        //se estiver p direita #@@@0#
        if (orientacao == 0){
             if(pos_final < tam_aq-1){
            	 char[] chars = linha.toCharArray();
                 chars[pos_final] = '@';
                 pos_final += 1;
                 chars[pos_final] = '0';
                 chars[pos_inicial] = '#';
                  pos_inicial += 1;
                 linha = String.valueOf(chars);
                
             }
            else{
                Virar();
            }
        }
        //se estiver p esquerda #0@@@#
        else{
            if(pos_inicial > 0){
            	char[] chars = linha.toCharArray();
                chars[pos_inicial] = '@';
                pos_inicial -= 1;
                chars[pos_inicial] = '0';
                chars[pos_final] = '#';
                 pos_final -= 1; 
                linha = String.valueOf(chars);              
            }
            else{
                Virar();
            }
        }  
        
    }
    
    void Apresentar(){
        System.out.println(linha);
    }   
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 * @author Vitor
 */
public class CPF {
    
    static int digitoUm (int[] numCPF){
        int soma = 0;
        for(int i = 10; i>1; i-- ){
            soma = soma + i*numCPF[10-i];
        }
        soma =soma%11;
        if (soma == 0 || soma == 1){
            return 0;
        }
        else{
            return (11 - soma);
        }
    }
    
    static int digitoDois (int[] numCPF, int digito1){
        int soma = 0;
        for(int i = 11; i>2; i-- ){
            soma = soma + i*numCPF[11-i];
        }
        soma = soma + 2*digito1;
        soma =soma%11;
        if (soma == 0 || soma == 1){
            return 0;
        }
        else{
            return (11 - soma);
        }
    }
    
    static int[] retornaDigitos(String strgCPF){
        int [] numCPF = new int[9];
        for(int i = 0; i < 9; i++){
            numCPF[i] = Integer.valueOf(strgCPF.substring(i, i+1));
        }
        int primDig = digitoUm(numCPF);
        int secDig = digitoDois(numCPF, primDig);
        int[] resposta = {primDig, secDig};
        return resposta;
    }
    
    static void retornaCPF(){
        String strgCPF = JOptionPane.showInputDialog("Entre com o CPF (9 digitos)");
        int[] digitos = retornaDigitos(strgCPF);
        JOptionPane.showMessageDialog(null, "O CPF é: "+strgCPF+"-"+digitos[0]+""+digitos[1]);       
    }
    
    static void verificaCPF(){
        String strgCPF = JOptionPane.showInputDialog("Entre com o CPF (11 digitos)");
        int[] digitos = retornaDigitos(strgCPF);
        if(strgCPF.substring(9, 10).equals(String.valueOf(digitos[0])) && strgCPF.substring(10, 11).equals(String.valueOf(digitos[1]))){
            JOptionPane.showMessageDialog(null, "É válido.");
        }
        else JOptionPane.showMessageDialog(null, "Não é válido.");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean sair = false;
        while(!sair){
        	JOptionPane.showMessageDialog(null,"Escolha:\n1 para descobrir os últimos algarismos com os primeiros 9 dígitos do CPF.\n2 para verificar um CPF completo.\n3 para sair.");
            String opcao = JOptionPane.showInputDialog("Escolha 1, 2 ou 3","1");         
            try{
                if(opcao.equals("1")){
                    retornaCPF();                    
                }
                else if(opcao.equals("2")){
                    verificaCPF();
                }
                else if(opcao.equals("3")){
                	sair = true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Dados inválidos");
                }
            }
            catch(Exception NullPointerException){
                sair = true;
            }  
        }
    }
}

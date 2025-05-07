
package com.mycompany.vortex;

import javax.swing.JOptionPane;


public class Login {
    
    private String login="e-mailTest";
    private String senha="senhaTeste";

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
        public  void fazerLogin() {
        double verificador = 1;
        
        while (verificador == 1) {

            String vlogin = JOptionPane.showInputDialog("Digite o seu Login");
            String vsenha = JOptionPane.showInputDialog("Digite o sua senha");

            if (vlogin.equals(getLogin()) && vsenha.equals(getSenha())) {
                JOptionPane.showMessageDialog(null, "Entrando na conta...");
                verificador = 2;
               
            } else {
                JOptionPane.showMessageDialog(null, "Senha ou login incorreto");
                verificador =Double.parseDouble(  JOptionPane.showInputDialog("Digite: \n1-Para tentar denovo \n2-Para voltara para o menu anterior"));
                

            }

        }

    }
    
}


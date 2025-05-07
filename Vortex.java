package com.mycompany.vortex;

import javax.swing.JOptionPane;

public class Vortex {

    public static void main(String[] args) {
        int escolha=1;
        Login loginObjeto = new Login();
        while(escolha!=0){
        JOptionPane.showMessageDialog(null, "Bem vindo ao Vortex");
        char op = 1;
        op = (JOptionPane.showInputDialog("Digite:\n1-LOGIN \n2-CADASTRAR \n0-FECHAR O SISTEMA")).charAt(0);
        escolha= op -'0';
        switch (op) {
            case '1': {
             loginObjeto.fazerLogin();

            }
            break;
            case '2': {

            }
            break;

        }
       }
    }



}

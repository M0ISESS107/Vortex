package com.mycompany.vortex;

import javax.swing.JOptionPane;

public class Vortex {

    public static void main(String[] args) {
        
        
        int escolha=1;
        int seguinte=0;
        
        Entrar loginObjeto = new Entrar();
        Perfil perfil = new Perfil();
        PaginaInicial paginaInicial = new PaginaInicial();
        
        while(escolha!=0 || seguinte==2){
        
        JOptionPane.showMessageDialog(null, "Bem vindo ao Vortex");
        char op = '1';
        op = (JOptionPane.showInputDialog("Digite:\n1-LOGIN \n2-CADASTRAR \n0-FECHAR O SISTEMA")).charAt(0);
        escolha= op -'0';
        
        switch (op) {
            case '1': {
             loginObjeto.fazerLogin();

            }
            break;
            case '2': {
                seguinte=loginObjeto.fazerCadastro();
                if(escolha!=0 || seguinte==2 ){paginaInicial.paginaInicial(loginObjeto);
         seguinte=0;
         escolha=0;}

            }
            break;
            case '0':{System.exit(0);}break;

        }
        
        
         
       }
       
    }

}

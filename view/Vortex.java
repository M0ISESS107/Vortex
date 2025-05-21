package com.mycompany.vortex.view;
import com.mycompany.vortex.model.Entrar;
import com.mycompany.vortex.model.FormasDePagamento;
import com.mycompany.vortex.model.PaginaInicial;
import com.mycompany.vortex.model.Perfil;
import javax.swing.JOptionPane;

public class Vortex {

    public void iniciar(Entrar loginObjeto) {
        int escolha = 1;
        int seguinte = 0;

        FormasDePagamento formasDePagamento = loginObjeto.getFormasDePagamento();
        PaginaInicial paginaInicial = new PaginaInicial(loginObjeto, formasDePagamento);
        Perfil perfil = new Perfil(formasDePagamento);

        while (escolha != 0 || seguinte == 2) {
            JOptionPane.showMessageDialog(null, "Bem vindo ao Vortex");
            char op = (JOptionPane.showInputDialog("Digite:\n1-LOGIN \n2-CADASTRAR \n0-FECHAR O SISTEMA")).charAt(0);
            escolha = op - '0';

            switch (op) {
                case '1' -> {
                seguinte = loginObjeto.fazerLogin();
                    if (escolha != 0 || seguinte == 2) {
                        paginaInicial.paginaInicial(loginObjeto);
                        seguinte = 0;
                        escolha = 0;}}
                case '2' -> {
                    seguinte = loginObjeto.fazerCadastro();
                    if (escolha != 0 || seguinte == 2) {
                        paginaInicial.paginaInicial(loginObjeto);
                        seguinte = 0;
                        escolha = 0;
                    }
                }
                case '0' -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    public static void main(String[] args) {
        Entrar loginObjeto = new Entrar();
        new Vortex().iniciar(loginObjeto);
    }
}

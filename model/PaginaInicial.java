package com.mycompany.vortex.model;

import javax.swing.JOptionPane;

public class PaginaInicial extends Perfil {
    private FormasDePagamento formasDePagamento;

    public PaginaInicial(Entrar loginObjeto, FormasDePagamento formasDePagamento) {
        super(formasDePagamento);
        this.formasDePagamento = formasDePagamento;
    }

    public void paginaInicial(Entrar loginObjeto) {
        BibliotecaJogos meusJogos = new BibliotecaJogos();
        Loja loja = new Loja();

        String menu = """
                =============================
                Página Inicial
                =============================
                1- Perfil
                2- Catálogo de jogos
                3- Destaques
                4- Assinatura
                5- Loja
                6- Amigos
                7- Configuração
                -----------------------------
                Escolha uma opção:
                """;
        char op;

        do {
            op = (JOptionPane.showInputDialog(menu)).charAt(0);
            switch (op) {
                case '1' -> perfil(loginObjeto, formasDePagamento);
                case '2' -> meusJogos.bibliotecaJogos(this);
                case '3' -> JOptionPane.showMessageDialog(null, "📚 Aqui serão exibidos os destaques da loja de jogos.");
                case '4' -> gerenciarAssinatura();
                case '5' -> lojaMetodo();
                case '6' -> gerenciarAmigos();
                case '7' -> configurarPerfil(loginObjeto);
                default -> JOptionPane.showMessageDialog(null, "❌ Opção inválida! Escolha um número de 1 a 7.");
            }
        } while (op != '8');
    }


    private void gerenciarAssinatura() {
        char op = (JOptionPane.showInputDialog("Digite:\n1 - Assinatura Premium\n2 - Assinatura Ultimate\n0 - Voltar")).charAt(0);
        switch(op) {
            case '1': {

                AssPremil assinaturaPremium = new AssPremil(formasDePagamento);
                assinaturaPremium.assinar();
                break;
            }
            case '2': {
                AssUltimate assinaturaUltimate = new AssUltimate(formasDePagamento);
                assinaturaUltimate.assinar();
                break;
            }
            case '0': {
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                break;
            }
        }
    }
}

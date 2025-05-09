package com.mycompany.vortex;


import javax.swing.JOptionPane;

public class BibliotecaJogos {
    public static void bibliotecaJogos(String[] args) {
        JOptionPane.showMessageDialog(null, "Entrando na biblioteca de jogos:");
        int totalJogo = 5;
        String[] jogos = new String[totalJogo];

        // Atribuindo jogos às posições do vetor
        jogos[0] = "GTA VI";
        jogos[1] = "GOD OF WAR";
        jogos[2] = "TOP GUEAR";
        jogos[3] = "MINECRAFT";
        jogos[4] = "SONIC";
        String listaJogos = "";
        for (int i = 0; i < jogos.length; i++) {
            listaJogos += (i + 1) + ": " + jogos[i] + "\n";

        }
        char opcoesJogo='5';

        while (opcoesJogo=='5') {

            char escolherJogo = (JOptionPane.showInputDialog("Escolha um jogo:\n" + listaJogos).charAt(0));

            opcoesJogo = (JOptionPane.showInputDialog("" +
                    "Opções de Jogo: \n 1 - Exibir detalhes do jogo\n" +
                    "2 - Excluir jogo da biblioteca\n 3 - Favoritar jogo\n" +
                    "4 - Convidar amigo\n 5 - Retornar ao menu anterior\n").charAt(0));
        }
        switch (opcoesJogo) {
            case 1: {
            }
            break;
            case 2: {
            }
            break;
            case 3: {
            }
            break;
            case 4: {
            }
            break;
            case 5: {
            }
            break;
        }
    }
}
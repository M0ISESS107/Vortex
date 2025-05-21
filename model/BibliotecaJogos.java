package com.mycompany.vortex.model;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class BibliotecaJogos {
    public void bibliotecaJogos(Perfil perfil) {
        JOptionPane.showMessageDialog(null, "Entrando na biblioteca de jogos:");


        ArrayList<String> jogos = new ArrayList<>();
        ArrayList<String> descricao = new ArrayList<>();


        jogos.add("GTA VI");
        descricao.add("O jogo acompanha uma dupla criminosa: Jason Duval, que trabalhou para traficantes de drogas locais depois de seu tempo no exército; e Lucia Caminos, a primeira protagonista feminina não opcional da série que foi presa após lutar por sua família em Liberty City.");

        jogos.add("GOD OF WAR 2");
        descricao.add("Após derrotar Ares e conseguir sua vingança, Kratos ascende ao Olimpo e torna-se o novo Deus da Guerra. Mas seus problemas estão só começando, pois ele descobre que é apenas uma peça no jogo dos deuses.");

        jogos.add("LEFT 4 DEAD");
        descricao.add("Left 4 Dead começa na Pensilvânia, após o surto de um vírus letal conhecido como 'Green Flu', que torna os infectados agressivos e descontrolados.");

        jogos.add("MINECRAFT");
        descricao.add("Minecraft é um jogo eletrônico lançado em 2009 que consiste em sobreviver em um mundo formado predominantemente por blocos cúbicos, explorando, construindo e sobrevivendo a diversas ameaças.");

        jogos.add("DRAGON BALL FIGHTZ");
        descricao.add("Dragon Ball FighterZ é um jogo de luta ambientado no universo de Dragon Ball, onde equipes de três personagens se enfrentam em lutas intensas, com um modo história original e recriações de batalhas épicas.");


        ArrayList<String> jogosComprados = Loja.getJogosComprados();
        for (String jogo : jogosComprados) {
            jogos.add(jogo);
            descricao.add("Jogo comprado.");
        }

        char opcoesJogo = '5';

        while (opcoesJogo == '5') {

            StringBuilder listaJogos = new StringBuilder();
            for (int i = 0; i < jogos.size(); i++) {
                listaJogos.append((i + 1)).append(": ").append(jogos.get(i)).append("\n");
            }

            if (listaJogos.length() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum jogo disponível na biblioteca.");
                break;
            }

            String escolhaStr = JOptionPane.showInputDialog("Escolha um jogo:\n" + listaJogos.toString());
            if (escolhaStr == null || escolhaStr.isEmpty()) {
                break;
            }
            char escolherJogo = escolhaStr.charAt(0);
            int indice = escolherJogo - '0' - 1;

            if (indice < 0 || indice >= jogos.size()) {
                JOptionPane.showMessageDialog(null, "Jogo inválido.");
                continue;
            }

            opcoesJogo = JOptionPane.showInputDialog(
                    "Opções de Jogo: \n1 - Exibir detalhes do jogo\n2 - Excluir jogo da biblioteca\n3 - Favoritar jogo\n4 - Convidar amigo\n5 - Retornar ao menu anterior\n").charAt(0);

            switch (opcoesJogo) {
                case '1': {
                    JOptionPane.showMessageDialog(null, "Descrição:\n" + descricao.get(indice));
                    break;
                }
                case '2': {
                    jogos.remove(indice);
                    descricao.remove(indice);
                    JOptionPane.showMessageDialog(null, "Jogo removido com sucesso!");
                    break;
                }
                case '3': {
                    String jogoAtual = jogos.get(indice);
                    if (!jogoAtual.contains("★")) {
                        jogos.set(indice, "★ " + jogoAtual);
                        JOptionPane.showMessageDialog(null, "Jogo marcado como favorito!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Este jogo já está favoritado.");
                    }
                    break;
                }
                case '4': {
                    if (perfil.totalAmigos == 0) {
                        JOptionPane.showMessageDialog(null, "Você não tem nenhum amigo ainda.");
                        break;
                    }
                    StringBuilder listaAmigos = new StringBuilder("Lista de amigos:\n");
                    for (int i = 0; i < perfil.totalAmigos; i++) {
                        if (perfil.amigos[i] != null) {
                            listaAmigos.append("- ").append(perfil.amigos[i]).append("\n");
                        }
                    }
                    String nomeAmigo = JOptionPane.showInputDialog(listaAmigos.toString() + "\nDigite o nome (ou parte do nome) do amigo para convidar:");
                    boolean encontrado = false;
                    for (int i = 0; i < perfil.totalAmigos; i++) {
                        if (perfil.amigos[i] != null && perfil.amigos[i].toLowerCase().contains(nomeAmigo.toLowerCase())) {
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) {
                        JOptionPane.showMessageDialog(null, nomeAmigo + " foi convidado para jogar " + jogos.get(indice) + "!");
                    } else {
                        JOptionPane.showMessageDialog(null, nomeAmigo + " não foi encontrado. Adicione como amigo primeiro ou digite corretamente o nome.");
                    }
                    break;
                }
                case '5': {

                    break;
                }
                default: {
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    opcoesJogo = '5';
                    break;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Encerrando a biblioteca de jogos.");
    }
}

package com.mycompany.vortex.model;

import javax.swing.*;
import java.util.ArrayList;

public class Loja {
    private static ArrayList<String> carrinho = new ArrayList<>();
    private static double totalAPagar = 0;
    private static ArrayList<String> jogosComprados = new ArrayList<>();
    private static ArrayList<String> bibliotecaJogos = new ArrayList<>();

    public static void loja(Perfil perfil, FormasDePagamento formasDePagamento) {
        if (formasDePagamento == null) {
            JOptionPane.showMessageDialog(null, "Erro: Formas de pagamento não inicializado!");
            return;
        }

        String[] nomesDosJogos = {
                "Red Dead Redemption 2  R$ 200,00 ",
                "Elden Ring  R$ 180,00 ",
                "Cuphead  R$ 29,9 ",
                "GTA V  R$ 60,00 ",
                "Battlefield I  R$ 110,8 "
        };

        double[] precosDosJogos = {200.0, 180.0, 29.9, 60.0, 110.8};
        String[] descricoes = {
                "Ambientado no faroeste, aventura e ação",
                "RPG difícil baseado em Dark Souls",
                "Desenho animado com chefões difíceis",
                "Viva uma vida criminosa na cidade grande",
                "Experimente o combate na Primeira Guerra Mundial"
        };

        boolean executando = true;

        while (executando) {
            String menu = "LOJA DE JOGOS \n\n";
            menu += "Escolha uma opção:\n";
            menu += "1. Ver jogos disponíveis\n";
            menu += "2. Ver meu carrinho\n";
            menu += "3. Sair da loja\n";

            String opcao = JOptionPane.showInputDialog(menu);
            if (opcao == null || opcao.equals("3")) {
                executando = false;
                JOptionPane.showMessageDialog(null, "Obrigado por visitar nossa loja!");
                continue;
            }

            if (opcao.equals("1")) {
                StringBuilder lista = new StringBuilder("JOGOS DISPONÍVEIS:\n\n");
                for (int i = 0; i < nomesDosJogos.length; i++) {
                    lista.append(i + 1).append(". ").append(nomesDosJogos[i]);
                    if (jogosComprados.contains(nomesDosJogos[i])) {
                        lista.append(" - 🏆 Já adquirido");
                    }
                    lista.append("\n");
                }

                String escolha = JOptionPane.showInputDialog(lista + "\nDigite o número do jogo:");
                try {
                    int numero = Integer.parseInt(escolha) - 1;
                    if (numero >= 0 && numero < nomesDosJogos.length) {
                        String detalhes = "Sobre o jogo:\n\nNome: " + nomesDosJogos[numero] +
                                "\nPreço: R$" + precosDosJogos[numero] + "\nDescrição: " + descricoes[numero] + "\n\nO que deseja fazer?";
                        String acao = JOptionPane.showInputDialog(detalhes +
                                "\n1. Adicionar ao carrinho" +
                                "\n2. Voltar");

                        if (acao.equals("1")) {
                            carrinho.add(nomesDosJogos[numero]);
                            totalAPagar += precosDosJogos[numero];
                            JOptionPane.showMessageDialog(null, nomesDosJogos[numero] + " foi adicionado ao carrinho!");
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Número inválido! Use apenas os números da lista.");
                }

            } else if (opcao.equals("2")) {
                if (carrinho.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Seu carrinho está vazio!");
                    continue;
                }

                StringBuilder listaCarrinho = new StringBuilder("SEU CARRINHO:\n\n");
                for (String jogo : carrinho) {
                    listaCarrinho.append(jogo).append("\n");
                }
                listaCarrinho.append("\nTotal: R$").append(totalAPagar);

                String opcaoCarrinho = JOptionPane.showInputDialog(listaCarrinho +
                        "\n\n1. Finalizar compra" +
                        "\n2. Voltar");

                if (opcaoCarrinho.equals("1")) {
                    finalizarCompra(perfil, formasDePagamento);
                }
            }
        }
    }

    private static void finalizarCompra(Perfil perfil, FormasDePagamento formasDePagamento) {
        if (formasDePagamento == null) {
            JOptionPane.showMessageDialog(null, "Erro: Formas de pagamento não inicializado!");
            return;
        }

        String opcaoPagamento = JOptionPane.showInputDialog(
                "Escolha uma forma de pagamento:\n1. Cartão\n2. PIX\n3. Boleto");

        switch (opcaoPagamento) {
            case "1" -> {
                if (formasDePagamento.totalCartoes == 0) {
                    JOptionPane.showMessageDialog(null, "Nenhum cartão cadastrado! Vá em Perfil > Formas de pagamento.");
                    return;
                }

                formasDePagamento.verCartoes();
                String cartaoEscolhido = JOptionPane.showInputDialog("Digite o número do cartão que deseja usar:");
                JOptionPane.showMessageDialog(null, "Compra realizada com sucesso com o cartão selecionado!");
            }
            case "2" -> {
                if (formasDePagamento.totalChavesPix == 0) {
                    JOptionPane.showMessageDialog(null, "Nenhuma chave PIX cadastrada! Vá em Perfil > Formas de pagamento.");
                    return;
                }

                formasDePagamento.verPix();
                String chavePixEscolhida = JOptionPane.showInputDialog("Digite o número da chave PIX que deseja usar:");
                JOptionPane.showMessageDialog(null, "Compra realizada com sucesso com a chave PIX selecionada!");
            }
            case "3" -> {
                JOptionPane.showMessageDialog(null, "Boleto será gerado.\nEnviaremos para seu e-mail cadastrado.");
            }
            default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
        }

        marcarJogosComoComprados();
    }

    private static void marcarJogosComoComprados() {
        jogosComprados.addAll(carrinho);
        carrinho.clear();
        totalAPagar = 0;
    }


    public static ArrayList<String> getJogosComprados() {
        return jogosComprados;
    }

    public static ArrayList<String> getBibliotecaJogos() {
        return bibliotecaJogos;
    }
}

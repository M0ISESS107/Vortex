package com.mycompany.vortex.model;
import javax.swing.JOptionPane;

public class AssUltimate extends Assinaturas {
    private FormasDePagamento formasDePagamento;

    public AssUltimate(FormasDePagamento formasDePagamento) {
        this.formasDePagamento = formasDePagamento;
    }

    @Override
    public void assinar() {
        int op = (JOptionPane.showInputDialog("Digite:\n1 - Assinar plano ultimate\n2 - Ver jogos inclusos no plano ultimate\n0 - Assinar mais tarde")).charAt(0);
        switch(op) {
            case '1': {
                finalizarAssinatura();
                break;
              }
                case '2': {
                jogosInclusos();
                break;
            }
            case '0': {
                break;
            }
               default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
        }
    }

    @Override
           public void beneficios() {
        String textoBeneficios = """
                =============================
                  Benefícios de ser ultimate  
                =============================
                * 10% de desconto em qualquer compra
                * Promoções exclusivas
                * Jogos para assinantes
                * Temas e skins exclusivos
                """;
        JOptionPane.showMessageDialog(null, textoBeneficios);
    }

    public void jogosInclusos() {
        String[] jogos = {"GTA VI", "GOD OF WAR 2", "LEFT 4 DEAD", "MINECRAFT", "DRAGON BALL FIGHTZ"};
            String[] descricao = {
                "O jogo acompanha uma dupla criminosa: Jason Duval...\n",
                "Após derrotar Ares, Kratos busca redenção...\n",
                "Left 4 Dead começa na Pensilvânia após o surto...\n",
                "Minecraft é um jogo eletrônico lançado em 2009...\n",
                "Dragon Ball FighterZ reúne os maiores heróis em batalhas épicas...\n"
        };

         boolean continuar = true;
        while (continuar) {
            StringBuilder listaJogos = new StringBuilder("Escolha um jogo:\n");
            for (int i = 0; i < jogos.length; i++) {
                listaJogos.append(i + 1).append(": ").append(jogos[i]).append("\n");
            }
            listaJogos.append("0: Voltar");
            String entrada = JOptionPane.showInputDialog(listaJogos.toString());
            if (entrada == null || entrada.equals("0")) {
                continuar = false;
                break;
             }
            int indice;
              try {
                indice = Integer.parseInt(entrada) - 1;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida.");
                continue;
              }
            if (indice < 0 || indice >= jogos.length) {
                JOptionPane.showMessageDialog(null, "Jogo inválido.");
                continue;
              }
            JOptionPane.showMessageDialog(null, "Descrição:\n" + descricao[indice]);
           }
        }

    private void finalizarAssinatura() {
        if (formasDePagamento == null) {
            JOptionPane.showMessageDialog(null, "Erro: Formas de pagamento não inicializado!");
            return;
        }
        String opcaoPagamento = JOptionPane.showInputDialog("Escolha uma forma de pagamento para assinar:\n1. Cartão\n2. PIX\n3. Boleto");
        switch(opcaoPagamento) {
            case "1": {
                if (formasDePagamento.totalCartoes == 0) {
                    JOptionPane.showMessageDialog(null, "Nenhum cartão cadastrado! Vá em Perfil > Formas de pagamento.");
                    return;
                }
                formasDePagamento.verCartoes();
                String cartaoEscolhido = JOptionPane.showInputDialog("Digite o número do cartão que deseja usar:");
                JOptionPane.showMessageDialog(null, "Assinatura Ultimate realizada com sucesso com o cartão selecionado!");
                break;
               }
               case "2": {
                if (formasDePagamento.totalChavesPix == 0) {
                    JOptionPane.showMessageDialog(null, "Nenhuma chave PIX cadastrada! Vá em Perfil > Formas de pagamento.");
                    return;
                }
                formasDePagamento.verPix();
                String chavePixEscolhida = JOptionPane.showInputDialog("Digite o número da chave PIX que deseja usar:");
                JOptionPane.showMessageDialog(null, "Assinatura Ultimate realizada com sucesso com a chave PIX selecionada!");
                break;
            }
               case "3": {
                JOptionPane.showMessageDialog(null, "Boleto será gerado para assinatura ultimate.\nEnviaremos para seu e-mail cadastrado.");
                break;
            }
               default: {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}

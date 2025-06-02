package com.mycompany.vortex.model;
import javax.swing.JOptionPane;

public class AssPremil extends Assinaturas {
    private FormasDePagamento formasDePagamento;


    public AssPremil(FormasDePagamento formasDePagamento) {
        this.formasDePagamento = formasDePagamento;
    }

    @Override
    public void assinar() {
        int op = (JOptionPane.showInputDialog("Digite:\n1 - Assinar plano premium\n2 - Ver jogos inclusos no plano premium\n0 - Assinar mais tarde")).charAt(0);
        switch (op) {
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
                  Benefícios de ser premium  
                =============================
                * 5% de desconto em qualquer compra
                * Promoções exclusivas
                * Jogos para assinantes 
                * Temas exclusivos
                """;
        JOptionPane.showMessageDialog(null, textoBeneficios);
    }

    public void jogosInclusos() {
        String[] jogos = {"The Witcher 3", "Hollow Knight", "Elden Ring", "Stardew Valley", "Resident Evil 4"};
        String[] descricao = {
                "The Witcher 3 é um RPG de mundo aberto que acompanha Geralt de Rívia em sua busca por sua filha adotiva, Ciri, enfrentando monstros e tomando decisões que afetam o mundo ao seu redor.\n",
                "Hollow Knight é um jogo de ação e aventura em estilo metroidvania, onde você explora um mundo subterrâneo misterioso e cheio de segredos chamado Hallownest.\n",
                "Elden Ring é um RPG de ação em mundo aberto criado pela FromSoftware, que combina exploração com combates desafiadores em um universo sombrio e vasto.\n",
                "Stardew Valley é um jogo de simulação onde você herda uma fazenda, cultiva plantações, cuida de animais e interage com os moradores de uma pequena cidade.\n",
                "Resident Evil 4 é um jogo de terror e ação onde Leon S. Kennedy tenta resgatar a filha do presidente dos EUA em uma vila infestada por criaturas hostis na Europa.\n"
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
                JOptionPane.showMessageDialog(null, "Assinatura Premium realizada com sucesso com o cartão selecionado!");
                break;
            }
               case "2": {
                if (formasDePagamento.totalChavesPix == 0) {
                    JOptionPane.showMessageDialog(null, "Nenhuma chave PIX cadastrada! Vá em Perfil > Formas de pagamento.");
                    return;
                }
                formasDePagamento.verPix();
                String chavePixEscolhida = JOptionPane.showInputDialog("Digite o número da chave PIX que deseja usar:");
                JOptionPane.showMessageDialog(null, "Assinatura Premium realizada com sucesso com a chave PIX selecionada!");
                break;
            }
            case "3": {
                JOptionPane.showMessageDialog(null, "Boleto será gerado para assinatura premium.\nEnviaremos para seu e-mail cadastrado.");
                break;
            }
                    default: {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
             }
        }
        }
  }

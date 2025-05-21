package com.mycompany.vortex.model;

   import javax.swing.JOptionPane;

    public class FormasDePagamento {

    public String[][] cartoes = new String[3][4];
       public int totalCartoes = 0;


     public String[][] chavesPix = new String[3][2];
    public int totalChavesPix = 0;


          public void gerenciarFormasPagamento() {
           while (true) {
            String opcao = JOptionPane.showInputDialog(
                    "=== FORMAS DE PAGAMENTO ===\n" +
                            "1. Gerenciar Cartão\n" +
                            "2. Gerenciar PIX\n" +
                            "3. Boleto\n" +
                            "4. Voltar\n\n" +
                            "Escolha uma opção:");

            if (opcao == null || opcao.equals("4")) break;

            switch (opcao) {
                case "1" -> gerenciarCartao();
                  case "2" -> gerenciarPix();
                case "3" -> JOptionPane.showMessageDialog(null,
                        "Boleto será gerado.\n" +
                                "Enviaremos pro teu e-mail cadastrado.");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }


       public void gerenciarCartao() {
           String opcao = JOptionPane.showInputDialog(
                "=== CARTÕES ===\n" +
                        "1. Cadastrar Cartão\n" +
                        "2. Ver Cartões\n" +
                        "3. Excluir Cartão\n" +
                        "4. Voltar\n\n" +
                        "Escolha uma opção:");

        if (opcao == null || opcao.equals("4")) return;

          switch (opcao) {
            case "1" -> cadastrarCartao();
              case "2" -> verCartoes();
            case "3" -> excluirCartao();
              default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
        }
    }

      public void cadastrarCartao() {
        if (totalCartoes >= 3) {
            JOptionPane.showMessageDialog(null, "Limite de 3 cartões atingido!");
              return;
        }

        String numero = JOptionPane.showInputDialog("Número do Cartão:");
           String nome = JOptionPane.showInputDialog("Nome no Cartão:");
          String vencimento = JOptionPane.showInputDialog("Data de Vencimento (MM/AA):");
        String cvc = JOptionPane.showInputDialog("Código CVC:");

        cartoes[totalCartoes][0] = numero;
            cartoes[totalCartoes][1] = nome;
          cartoes[totalCartoes][2] = vencimento;
           cartoes[totalCartoes][3] = cvc;
        totalCartoes++;

        JOptionPane.showMessageDialog(null, "Cartão cadastrado com sucesso!");
    }

    public void verCartoes() {
        if (totalCartoes == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum cartão cadastrado.");
            return;
        }

        String lista = "=== SEUS CARTÕES ===\n";

        for (int i = 0; i < totalCartoes; i++) {
            char[] numeroCartao = cartoes[i][0].toCharArray();
            String numeroescondido = "****" + numeroCartao[numeroCartao.length - 4]
                    +  numeroCartao[numeroCartao.length - 3]
                    + numeroCartao[numeroCartao.length - 2]
                    + numeroCartao[numeroCartao.length -1];
            lista+= (i + 1) + ". " + cartoes[i][1] + " (" + numeroescondido + ")\n";
        }



        JOptionPane.showMessageDialog(null, lista);
    }

    public void excluirCartao() {
        if (totalCartoes == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum cartão para excluir.");
            return;
        }

        verCartoes();
        String escolha = JOptionPane.showInputDialog("Digite o número do cartão a excluir:");

        int b = Integer.parseInt(escolha) - 1;
        if (b >= 0 && b < totalCartoes) {

            for (int i = b; i < totalCartoes - 1; i++) {
                cartoes[i] = cartoes[i + 1];
            }
            totalCartoes--;
            JOptionPane.showMessageDialog(null, "Cartão excluído!");
        }

    }


    public void gerenciarPix() {
        String opcao = JOptionPane.showInputDialog(
                "=== PIX ===\n" +
                        "1. Cadastrar Chave PIX\n" +
                        "2. Ver Chaves PIX\n" +
                        "3. Excluir Chave PIX\n" +
                        "4. Voltar\n\n" +
                        "Escolha uma opção:");

        if (opcao == null || opcao.equals("4")) return;

        switch (opcao) {
            case "1" -> cadastrarPix();
            case "2" -> verPix();
            case "3" -> excluirPix();
            default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
        }
    }

    public void cadastrarPix() {
        if (totalChavesPix >= 3) {
            JOptionPane.showMessageDialog(null, "Limite de 3 chaves PIX atingido!");
            return;
        }

        String tipo = JOptionPane.showInputDialog("Tipo da Chave (CPF/Email/Telefone):");
        String chave = JOptionPane.showInputDialog("Chave PIX:");

        chavesPix[totalChavesPix][0] = tipo;
        chavesPix[totalChavesPix][1] = chave;
        totalChavesPix++;

        JOptionPane.showMessageDialog(null, "Chave PIX cadastrada!");
    }

    public void verPix() {
        if (totalChavesPix == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma chave PIX cadastrada.");
            return;
        }

        String mensagem = "=== CHAVES PIX ===\n";
        for (int i = 0; i < totalChavesPix; i++) {
            mensagem += (i+1) + ". " + chavesPix[i][0] + ": " + chavesPix[i][1] + "\n";
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }



    public void excluirPix() {
        if (totalChavesPix == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma chave PIX para excluir.");
            return;
        }

        verPix();

        String escolha = JOptionPane.showInputDialog("Digite o número da chave que quer excluir:");


        int numero = Integer.parseInt(escolha) - 1;

        if (numero < 0 || numero >= totalChavesPix) {
            JOptionPane.showMessageDialog(null, "Número inválido!");
            return;
        }


        for (int i = numero; i < totalChavesPix - 1; i++) {
            chavesPix[i] = chavesPix[i + 1];
        }
        totalChavesPix--;
        JOptionPane.showMessageDialog(null, "Chave excluída!");
    }

}
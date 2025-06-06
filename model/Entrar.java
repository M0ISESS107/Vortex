package com.mycompany.vortex.model;

import javax.swing.JOptionPane;

public class Entrar extends Cliente {

    private FormasDePagamento formasDePagamento = new FormasDePagamento();


    public FormasDePagamento getFormasDePagamento() {
        return formasDePagamento;
    }

    public int fazerLogin() {
        double verificador = 1;

        while (verificador == 1) {
            String vlogin = JOptionPane.showInputDialog("Digite o seu Login");
            String vsenha = JOptionPane.showInputDialog("Digite o sua senha");

            if (vlogin.equals(getLogin()) && vsenha.equals(getSenha())) {
                JOptionPane.showMessageDialog(null, "Entrando na conta...");
                verificador = 2;
                int cadastrarPagamento = (JOptionPane.showInputDialog("Digite:\n1-Se deseja cadastrar pagamento \n2-Se deseja avançar")).charAt(0);

        if (cadastrarPagamento == '1') {
            formasDePagamento.gerenciarFormasPagamento();
        }

        return 2;
            } else {
                JOptionPane.showMessageDialog(null, "Senha ou login incorreto");
                verificador = Double.parseDouble(JOptionPane.showInputDialog("Digite: \n1-Para tentar denovo \n2-Para voltar para o menu anterior"));
            }
        }
        return 2;
    }

    public int fazerCadastro() {
        this.nome = JOptionPane.showInputDialog("Digite seu nome:\n");
        this.idade = JOptionPane.showInputDialog("Digite sua idade:\n");
        this.descricaoJogador = JOptionPane.showInputDialog("Digite sua descrição:\n");
        setEmail(JOptionPane.showInputDialog("Digite seu melhor e-mail:\n"));
        setLogin(getEmail());
        setSenha(JOptionPane.showInputDialog("Digite sua senha:\n"));
        JOptionPane.showMessageDialog(null, "Confira seus dados: \nNome: " + getNome() + "\nIdade: " + getIdade() + "\nE-mail: " + getEmail() + "\nSenha: " + getSenha());

        int cadastrarPagamento = (JOptionPane.showInputDialog("Digite:\n1-Se deseja cadastrar pagamento \n2-Se deseja avançar")).charAt(0);

        if (cadastrarPagamento == '1') {
            formasDePagamento.gerenciarFormasPagamento();
        }

        return 2;
    }
}

package com.mycompany.vortex;

import javax.swing.JOptionPane;

public class Entrar {

    private String login = "e-mailTest";
    private String senha = "senhaTeste";
    private String email;
    //variaveis de perfil
    String nome= "nome teste";
    String idade= "1000";
    String descricaoJogador = "Avatar padrão"; // Foto de perfil padrão
    //dados cartão
    private String numeroCartao;
    private String nomeNocartao;
    private int cvc;
    private String dataVencimentoCartao;

    public void setEmail(String email) {
        this.email = email;
    }

    
    

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public void setNomeNocartao(String nomeNocartao) {
        this.nomeNocartao = nomeNocartao;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public void setDataVencimentoCartao(String dataVencimentoCartao) {
        this.dataVencimentoCartao = dataVencimentoCartao;
    }
    

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getIdade() {
        return idade;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getNomeNocartao() {
        return nomeNocartao;
    }

    public int getCvc() {
        return cvc;
    }

    public String getDataVencimentoCartao() {
        return dataVencimentoCartao;
    }
    
    
    

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void fazerLogin() {
        double verificador = 1;

        while (verificador == 1) {

            String vlogin = JOptionPane.showInputDialog("Digite o seu Login");
            String vsenha = JOptionPane.showInputDialog("Digite o sua senha");

            if (vlogin.equals(getLogin()) && vsenha.equals(getSenha())) {
                JOptionPane.showMessageDialog(null, "Entrando na conta...");
                verificador = 2;

            } else {
                JOptionPane.showMessageDialog(null, "Senha ou login incorreto");
                verificador = Double.parseDouble(JOptionPane.showInputDialog("Digite: \n1-Para tentar denovo \n2-Para voltara para o menu anterior"));

            }

        }

    }

    public int fazerCadastro() {
        this.nome = JOptionPane.showInputDialog("Digite seu nome:\n");
        this.idade = JOptionPane.showInputDialog("Digite sua idade:\n");
        this.descricaoJogador = JOptionPane.showInputDialog("Digite sua descrição:\n");
        setEmail(JOptionPane.showInputDialog("Digite seu melhor e-mail:\n"));
        setLogin(getEmail());
        setEmail(JOptionPane.showInputDialog("Digite sua senha:\n"));
        JOptionPane.showMessageDialog(null, "Confira seus dados: \nNome: "+getNome()+"\nIdade: "+getIdade()+"\nE-mail: "+getEmail()+"\nSenha:"+getSenha());
        int cadastrarCartao = (JOptionPane.showInputDialog("Digite:\n1-Se deseja cadastrar cartao \n2-Se deseja avançar")).charAt(0);
        int seguinte=0;
        if(cadastrarCartao==2){seguinte=cadastrarCartao;}
        return seguinte;
        
    }

}

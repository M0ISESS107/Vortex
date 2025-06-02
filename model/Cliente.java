package com.mycompany.vortex.model;

public class Cliente {
    private String login = "e-mailTest";
    private String senha = "senhaTeste";
    private String email;
    // Variáveis de perfil
    String nome = "nome teste";
    String idade = "1000";
    String descricaoJogador = "Avatar padrão";
    public void setEmail(String email) {
        this.email = email;
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
    public String getEmail() {
        return email;
    }




    public String getDescricaoJogador() {
        return descricaoJogador;
    }

    public void setDescricaoJogador(String descricaoJogador) {
        this.descricaoJogador = descricaoJogador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getIdade() {
        return idade;
    }


}

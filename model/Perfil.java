package com.mycompany.vortex.model;

import com.mycompany.vortex.interfaces.perfili;
import com.mycompany.vortex.view.Vortex;
import javax.swing.JOptionPane;

public class Perfil implements perfili {

    String listaDeAmigos;
    String[] amigos = new String[50];
    int totalAmigos = 0;
    BibliotecaJogos biblioteca = new BibliotecaJogos();
    Loja lojaObjeto = new Loja();
    private FormasDePagamento formasDePagamento;


    public Perfil(FormasDePagamento formasDePagamento) {
        this.formasDePagamento = formasDePagamento;
    }

    public void perfil(Entrar loginObjeto, FormasDePagamento formasDePagamento)  {
        this.formasDePagamento = formasDePagamento;

        int opcao = -1;

        while (opcao != 8) {
            String entrada = JOptionPane.showInputDialog(
                    """
                    =============================
                    Perfil da Loja de Jogos  
                    =============================
                    Nome: %s
                    Email: %s
                    Descrição: %s
                    -----------------------------
                    1- Configurar perfil
                    2- Ver biblioteca de jogos
                    3- Gerenciar amigos
                    4- Mostrar jogos favoritos
                    5- Formas de pagamento
                    6- Suporte
                    7- Configuração
                    8- Voltar
                    9- Sair
                    Escolha uma opção:""".formatted(loginObjeto.getNome(), loginObjeto.getEmail(), loginObjeto.getDescricaoJogador()));

            if (entrada == null) {
                return;
            }

            if (!entrada.isEmpty()) {
                opcao = Integer.parseInt(entrada);
            } else {
                JOptionPane.showMessageDialog(null, " Opção inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1 -> configurarPerfil(loginObjeto);
                case 2 -> biblioteca.bibliotecaJogos(this);
                case 3 -> gerenciarAmigos();
                case 4 -> JOptionPane.showMessageDialog(null, " Aqui serão exibidos seus jogos favoritos.");
                case 5 -> formasDePagamento.gerenciarFormasPagamento();
                case 6 -> JOptionPane.showMessageDialog(null, " Suporte ao Cliente\nEmail: VortexSuport@gmail.com\nTelefone: 0800-123-4567");
                case 7 -> configuracoes();
                case 8 -> JOptionPane.showMessageDialog(null, " Saindo do perfil... Até mais!");
                case 9 -> {
                    JOptionPane.showMessageDialog(null, " Saindo da conta...");
                    new Vortex().iniciar(loginObjeto);
return;

                }
                default -> JOptionPane.showMessageDialog(null, " Opção inválida! Escolha um número de 1 a 9.");
            }
        }
    }

    @Override
    public void configurarPerfil(Entrar loginObjeto) {
        String opcao = JOptionPane.showInputDialog("⚙ Configurar Perfil\n\n1. Alterar nome\n2. Alterar descrição\n3. Alterar email\n4. Alterar senha\nEscolha uma opção:");
        if (opcao == null || opcao.isEmpty()) {
            return;
        }

        int escolha = Integer.parseInt(opcao);

        if (escolha == 1) {
            loginObjeto.setNome( JOptionPane.showInputDialog("🖊 Digite um novo nome:"));
        } else if (escolha == 2) {
            loginObjeto.setDescricaoJogador( JOptionPane.showInputDialog(" Digite uma nova descrição:"));
        } else if (escolha == 3) {
            loginObjeto.setEmail(JOptionPane.showInputDialog(" Digite seu novo email:"));
        } else if (escolha == 4) {
            loginObjeto.setSenha(JOptionPane.showInputDialog(" Digite sua nova senha:"));
        } else {
            JOptionPane.showMessageDialog(null, " Opção inválida!");
        }

        JOptionPane.showMessageDialog(null, " Atualização concluída!");
    }

    @Override
    public void gerenciarAmigos() {
        String opcao = JOptionPane.showInputDialog(
                " Gerenciar Amigos\n\n1. Adicionar amigo\n2. Ver lista de amigos\nEscolha uma opção:");

        if (opcao == null || opcao.isEmpty()) {
            return;
        }

        int escolha = Integer.parseInt(opcao);

        if (escolha == 1) {
            if (totalAmigos < amigos.length) {
                String nome = JOptionPane.showInputDialog(" Nome do amigo:");
                String id = JOptionPane.showInputDialog(" ID do amigo:");
                amigos[totalAmigos++] = nome + " (ID: " + id + ")";
                JOptionPane.showMessageDialog(null, " Convite enviado!");
            } else {
                JOptionPane.showMessageDialog(null, " Lista de amigos cheia!");
            }
        } else if (escolha == 2) {
            if (totalAmigos == 0) {
                JOptionPane.showMessageDialog(null, " Você ainda não tem amigos adicionados.");
            } else {
                StringBuilder lista = new StringBuilder(" Lista de Amigos:\n");
                for (int i = 0; i < totalAmigos; i++) {
                    if (amigos[i] != null) {
                        lista.append("- ").append(amigos[i]).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, lista.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, " Opção inválida!");
        }
    }

    @Override
    public void configuracoes() {
        String opcao = JOptionPane.showInputDialog("⚙ Configurações Gerais\n\n1. Alterar idioma\n2. Gerenciar notificações\n3. Restaurar configurações\nEscolha uma opção:");
        if (opcao == null || opcao.isEmpty()) {
            return;
        }

        int escolha = Integer.parseInt(opcao);
        if (escolha == 1) {
            JOptionPane.showMessageDialog(null, " Idioma alterado para: " + JOptionPane.showInputDialog(" Escolha um idioma: (Português, Inglês, Espanhol)"));
        } else if (escolha == 2) {
            JOptionPane.showMessageDialog(null, " Notificações atualizadas!");
        } else if (escolha == 3) {
            JOptionPane.showMessageDialog(null, " Configurações restauradas.");
        } else {
            JOptionPane.showMessageDialog(null, " Opção inválida!");
        }
    }

    @Override
    public void lojaMetodo() {
        lojaObjeto.loja(this, formasDePagamento);
    }

    @Override
    public void mostrarCartoes() {
        formasDePagamento.gerenciarCartao();
    }
}

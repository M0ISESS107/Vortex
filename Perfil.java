package com.mycompany.vortex;

import javax.swing.JOptionPane;

public class Perfil extends Entrar {
    
   // Email padrão
        String[] amigos = new String[50]; // Limite de amigos
        int totalAmigos = 0; // Controla a quantidade de amigos adicionados
        int opcao = 0; // Inicializando a variável para evitar erro
        
    public void perfil(Entrar loginObjeto) {
        
        loginObjeto.getEmail();
       

        do {
            // Exibe o menu formatado corretamente
            String menu = "=============================\n" +
                    "    Perfil da Loja de Jogos  \n" +
                    "=============================\n" +
                    "Nome: " + loginObjeto.getNome() + "\n" +
                    "Email: " + loginObjeto.getEmail() + "\n" +
                    "Descrição: " + loginObjeto.descricaoJogador + "\n" +
                    "-----------------------------\n" +
                    "1- Configurar perfil\n" +
                    "2- Ver biblioteca de jogos\n" +
                    "3- Gerenciar amigos\n" +
                    "4- Mostrar jogos favoritos\n" +
                    "5- Formas de pagamento\n" +
                    "6- Suporte\n" +
                    "7- Configuração\n" +
                    "8- voltar\n" +
                    "9- Sair\n" +
                    "-----------------------------\n" +
                    "Escolha uma opção:";

            String entrada = JOptionPane.showInputDialog(menu);

            // Converte a entrada para um número inteiro
            if (entrada == null) break; // Encerra se o usuário fechar a caixa de diálogo
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "❌ Opção inválida! Digite um número válido.");
                continue;
            }

            switch (opcao) {
                case 1:
                   configurarPerfil(loginObjeto);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "📚 Aqui serão exibidos seus jogos.");
                    break;
                case 3:
                   gerenciarAmigos();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "⭐ Aqui serão exibidos seus jogos favoritos.");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "💳 Aqui serão exibidas as formas de pagamento disponíveis.");
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "📞 Suporte ao Cliente\n\nPara suporte, entre em contato através do email: VortexSuport@gmail.com\nOu ligue para: 0800-123-4567");
                    break;
                case 7:
                        configuracoes();
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Saindo do perfil... Até mais!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "👋 Saindo da conta....");
                    Vortex saindo = new Vortex();
                    String n="";
                    saindo.main(amigos);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "❌ Opção inválida! Escolha um número de 1 a 8.");
            }
        } while (opcao != 8);
    }
    
    
    
    public void configurarPerfil(Entrar loginObjeto){
         String configurar = JOptionPane.showInputDialog("⚙ Configurar Perfil\n\n1. Alterar nome\n2. Alterar foto de perfil\n3. Alterar email\n4. Alterar senha\nEscolha uma opção:");

                    try {
                        int escolha = Integer.parseInt(configurar);
                        switch (escolha) {
                            case 1:
                                loginObjeto.nome = JOptionPane.showInputDialog("🖊 Digite um novo nome de usuário:");
                                JOptionPane.showMessageDialog(null, "✅ Nome atualizado com sucesso!");
                                break;
                            case 2:
                                loginObjeto.descricaoJogador = JOptionPane.showInputDialog("📷 Digite uma nova descrição:");
                                JOptionPane.showMessageDialog(null, "✅ Foto de perfil atualizada!");
                                break;
                            case 3:
                                String e = JOptionPane.showInputDialog("📧 Digite seu novo email:");
                                loginObjeto.setEmail(e);
                                JOptionPane.showMessageDialog(null, "✅ Email atualizado com sucesso!");
                                break;
                            case 4:
                                String s=JOptionPane.showInputDialog("📧 Digite sua nova senha:");
                                loginObjeto.setSenha(s);
                                JOptionPane.showMessageDialog(null, "✅ senha atualizado com sucesso!");
                                 break;
                            default:
                                JOptionPane.showMessageDialog(null, "❌ Opção inválida!");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "❌ Opção inválida! Digite um número válido.");
                    }
    }
    
    
    public void gerenciarAmigos(){
         String acaoAmigo = JOptionPane.showInputDialog("👥 Gerenciar Amigos\n\n1. Adicionar amigo\n2. Ver lista de amigos\nEscolha uma opção:");
                    

                    try {
                        int acao = Integer.parseInt(acaoAmigo);
                        if (acao == 1 && totalAmigos < amigos.length) {
                            amigos[totalAmigos++] = JOptionPane.showInputDialog("📝 Nome do amigo:") +
                                    " (ID: " + JOptionPane.showInputDialog("🔢 ID do amigo:") + ")";
                            JOptionPane.showMessageDialog(null, "✅ Convite enviado com sucesso!");
                        } else if (acao == 2) {
                            StringBuilder listaAmigos = new StringBuilder("👥 Lista de Amigos:\n");
                            if (totalAmigos == 0) listaAmigos.append("Nenhum amigo adicionado ainda.");
                            else for (int i = 0; i < totalAmigos; i++) listaAmigos.append("- ").append(amigos[i]).append("\n");
                            JOptionPane.showMessageDialog(null, listaAmigos.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "❌ Opção inválida ou lista cheia!");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "❌ Opção inválida! Digite um número válido.");
                    }
    } 
    
    
    public void configuracoes(){
        String configMenu = JOptionPane.showInputDialog("⚙ Configurações Gerais\n\n1. Alterar idioma\n2. Gerenciar notificações\n3. Restaurar configurações de fábrica\nEscolha uma opção:");
                    
                    try {
                        int escolhaConfig = Integer.parseInt(configMenu);
                        switch (escolhaConfig) {
                            case 1:
                                String idioma = JOptionPane.showInputDialog("🌍 Escolha um idioma: (Português, Inglês, Espanhol)");
                                JOptionPane.showMessageDialog(null, "✅ Idioma alterado para: " + idioma);
                                break;
                            case 2:
                                String notificacoes = JOptionPane.showInputDialog("🔔 Gerenciar Notificações\n\n1. Ativar notificações\n2. Desativar notificações\nEscolha uma opção:");
                                JOptionPane.showMessageDialog(null, "✅ Configuração de notificações atualizada!");
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "⚠ Todas as configurações foram restauradas para os padrões de fábrica.");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "❌ Opção inválida!");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "❌ Opção inválida! Digite um número válido.");
                    }
    }
}

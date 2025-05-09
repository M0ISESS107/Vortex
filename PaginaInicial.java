package com.mycompany.vortex;

import javax.swing.JOptionPane;
import com.mycompany.vortex.Entrar;

public class PaginaInicial extends Perfil{

    public void paginaInicial(Entrar loginObjeto) {
    String menu = "=============================\n"
                + "        pagina inicial      \n"
                + "=============================\n"
                + "1- Perfil\n"
                + "2- Catalogo de jogos\n"
                + "3- Destaques\n"
                + "4- Assinatura\n"
                + "5- Amigos\n"
                + "6- Configuração\n"
                + "-----------------------------\n"
                + "Escolha uma opção:";
        char op = '1';
      
        do {
            op = (JOptionPane.showInputDialog(menu)).charAt(0);
            switch (op) {
                case '1':
                    perfil(loginObjeto);
                    break;
                 case '2':
                     JOptionPane.showMessageDialog(null, "📚 Aqui serão exibidos seus jogos.");
                    break;
                 case '3':
                     JOptionPane.showMessageDialog(null, "📚 Aqui serão exibidos o destaques da loja de jogos.");
                    break;
                    case '4':
                     JOptionPane.showMessageDialog(null, "📚 Aqui serão exibidos suas assinaturas.");
                    break;
                    case '5':
                     gerenciarAmigos();
                    break;
                    case '6':
                      configurarPerfil(loginObjeto);
                    break;
                   default:
                    JOptionPane.showMessageDialog(null, "❌ Opção inválida! Escolha um número de 1 a 8.");
                    }
        } while (op != '8');

    }
}

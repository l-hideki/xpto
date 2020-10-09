/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopxpto20202.view.acesso;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import backendxpto20202.controle.ControleUsuario;
import backendxpto20202.modelo.bean.Usuario;

/**
 *
 * @author ProfAlexandre
 */
public class login {
    
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

         String login;
         String senha;
         
         login = JOptionPane.showInputDialog("Entre com o Login");
         senha = JOptionPane.showInputDialog("Entre com o Senha");
         Usuario usu = new Usuario(login,senha);
         ControleUsuario contUsu = new ControleUsuario();
         usu = contUsu.valida(usu);
         JOptionPane.showMessageDialog(null, usu.toString());

    }
    
}

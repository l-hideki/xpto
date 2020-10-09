/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopxpto20202.view.usuario;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import backendxpto20202.controle.ControleUsuario;
import backendxpto20202.modelo.bean.Usuario;

/**
 *
 * @author ProfAlexandre
 */
public class inserirUsuario {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

         String login;
         String senha;
         String status;
         String tipo;
         
         login = JOptionPane.showInputDialog("Entre com o Login");
         senha = JOptionPane.showInputDialog("Entre com o Senha");
         status = JOptionPane.showInputDialog("Entre com o Status");
         tipo = JOptionPane.showInputDialog("Entre com o Tipo");

         Usuario usu = new Usuario(0,login,senha,status,tipo);
         ControleUsuario contUsu = new ControleUsuario();
         usu = contUsu.inseri(usu);
         JOptionPane.showMessageDialog(null, usu.toString());

    }

    
}

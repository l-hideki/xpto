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
public class alterarUsuario {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

         int id;   
         String login;
         String senha;
         String status;
         String tipo;
         
         id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID"));
         login = JOptionPane.showInputDialog("Entre com o Login");
         senha = JOptionPane.showInputDialog("Entre com o Senha");
         status = JOptionPane.showInputDialog("Entre com o Status");
         tipo = JOptionPane.showInputDialog("Entre com o Tipo");

         Usuario usu = new Usuario(id,login,senha,status,tipo);
         ControleUsuario contUsu = new ControleUsuario();
         usu = contUsu.altera(usu);
         JOptionPane.showMessageDialog(null, usu.toString());
    }
    
}

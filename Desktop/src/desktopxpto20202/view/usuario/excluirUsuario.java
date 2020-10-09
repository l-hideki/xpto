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
public class excluirUsuario {
    
        public static void main(String[] args) throws SQLException, ClassNotFoundException {

         int id;   
         
         id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID"));

         Usuario usu = new Usuario(id);
         ControleUsuario contUsu = new ControleUsuario();
         usu = contUsu.exclui(usu);
         JOptionPane.showMessageDialog(null, usu.toString());
    }

    
}

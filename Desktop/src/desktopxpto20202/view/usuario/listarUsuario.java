/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopxpto20202.view.usuario;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import backendxpto20202.controle.ControleUsuario;
import backendxpto20202.modelo.bean.Usuario;

/**
 *
 * @author ProfAlexandre
 */
public class listarUsuario {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {     
    
        String login;   
         login = JOptionPane.showInputDialog("Entre com o Login");
         Usuario usu = new Usuario(login,"");
         ControleUsuario contUsu = new ControleUsuario();
         List<Usuario> usus = contUsu.lista(usu);

         for (Usuario usuL : usus) {
            JOptionPane.showMessageDialog(null, usuL.toString());
         }
                 

    }
}

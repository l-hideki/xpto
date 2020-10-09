/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopxpto20202.view.usupes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import backendxpto20202.controle.ControleUsuarioPessoa;
import backendxpto20202.modelo.bean.UsuarioPessoa;

/**
 *
 * @author ProfAlexandre
 */
public class buscarUsuarioPessoa {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

         int id;   
         id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID"));
         UsuarioPessoa usuPes = new UsuarioPessoa(id);
         ControleUsuarioPessoa contUsu = new ControleUsuarioPessoa();
         usuPes = contUsu.busca(usuPes);
         JOptionPane.showMessageDialog(null, usuPes.toString());
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopxpto20202.view.pessoa;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import backendxpto20202.controle.ControlePessoa;
import backendxpto20202.modelo.bean.Pessoa;

/**
 *
 * @author Hideki
 */
public class buscarPessoa {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

         int id;   
         
         id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID"));

         Pessoa pes = new Pessoa(id);
         ControlePessoa contPes = new ControlePessoa();
         pes = contPes.busca(pes);
         JOptionPane.showMessageDialog(null, pes.toString());
    }
    
    
    
    
}

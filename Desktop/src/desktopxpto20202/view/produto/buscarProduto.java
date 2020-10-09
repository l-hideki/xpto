/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopxpto20202.view.produto;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import backendxpto20202.controle.ControleProduto;
import backendxpto20202.modelo.bean.Produto;

/**
 *
 * @author ProfAlexandre
 */
public class buscarProduto {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

         int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID"));
         Produto pro = new Produto(id);
         ControleProduto contPro = new ControleProduto();
         pro = contPro.busca(pro);
         JOptionPane.showMessageDialog(null, pro.toString());
    }

    
}

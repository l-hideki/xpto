/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopxpto20202.view.produto;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import backendxpto20202.controle.ControleProduto;
import backendxpto20202.modelo.bean.Produto;

/**
 *
 * @author ProfAlexandre
 */
public class listarProduto {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {     
    
         String nome = JOptionPane.showInputDialog("Entre com o Nome");
         Produto pro = new Produto(nome);
         ControleProduto contPro = new ControleProduto();
         List<Produto> pros = contPro.lista(pro);

         for (Produto proL : pros) {
            JOptionPane.showMessageDialog(null, proL.toString());
         }
                 

    }
}

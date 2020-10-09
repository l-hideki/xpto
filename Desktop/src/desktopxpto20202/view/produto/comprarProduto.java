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
public class comprarProduto {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
         
         int quantS = 0;
         int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID"));
         int quant = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Quant"));
         ControleProduto contPro = new ControleProduto();

         Produto proE = new Produto(id,quant);
         Produto proS = contPro.busca(proE);
         
         if(proS.getQuant() < proE.getQuant()) {
             JOptionPane.showMessageDialog(null, "Não Posso Comprar");
         } else {
             quantS = (proS.getQuant() - proE.getQuant());
             proS.setQuant(quant);
             proS = contPro.altera(proS);
             JOptionPane.showMessageDialog(null, "Comprei");
         }
         
        JOptionPane.showMessageDialog(null, proS.toString());        
    }
}

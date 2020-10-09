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
public class alterarProduto {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

         int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID"));
         String cod = JOptionPane.showInputDialog("Entre com o Cod");
         String nome = JOptionPane.showInputDialog("Entre com o Nome");
         int valor = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Valor"));
         int quant = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Quant"));

         Produto pro = new Produto(id,cod,nome,valor,quant);
         ControleProduto contPro = new ControleProduto();
         pro = contPro.altera(pro);
         JOptionPane.showMessageDialog(null, pro.toString());


    }
    
}

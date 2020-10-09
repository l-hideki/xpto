/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopxpto20202.view.endereco;

import backendxpto20202.controle.ControlePessoaEndereco;
import backendxpto20202.modelo.bean.PessoaEndereco;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ProfAlexandre
 */
public class listarPessoaEndereco {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {     
    
         String obs = JOptionPane.showInputDialog("Entre com o Observacao");
         PessoaEndereco pesEnd = new PessoaEndereco(obs);
         ControlePessoaEndereco contPesEnd = new ControlePessoaEndereco();
         List<PessoaEndereco> peendss = contPesEnd.lista(pesEnd);

         for (PessoaEndereco peendssL : peendss) {
            JOptionPane.showMessageDialog(null, peendssL.toString());
            JOptionPane.showMessageDialog(null, peendssL.getPes().getNome());
            JOptionPane.showMessageDialog(null, peendssL.getEnd().getCep());
     
         }
                 

    }
}

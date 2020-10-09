/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopxpto20202.view.endereco;

import backendxpto20202.controle.ControlePessoaEndereco;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import backendxpto20202.modelo.bean.PessoaEndereco;

/**
 *
 * @author ProfAlexandre
 */
public class inserirPessoaEndereco {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

         
         int idE = Integer.parseInt(JOptionPane.showInputDialog("Entre com o IdEnd"));
         int idP = Integer.parseInt(JOptionPane.showInputDialog("Entre com o IdPessoa"));
         String obs = JOptionPane.showInputDialog("Entre com o Observacao");

         PessoaEndereco pesend = new PessoaEndereco(0,idE,idP,obs);
         ControlePessoaEndereco contPesEnd = new ControlePessoaEndereco();
         pesend = contPesEnd.inseri(pesend);
         JOptionPane.showMessageDialog(null, pesend.toString());

    }

    
}

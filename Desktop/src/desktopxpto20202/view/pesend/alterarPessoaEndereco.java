/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopxpto20202.view.pesend;

import backendxpto20202.controle.ControlePessoaEndereco;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import backendxpto20202.modelo.bean.PessoaEndereco;

/**
 *
 * @author Hideki
 */
public class alterarPessoaEndereco {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Id"));
        int idE = Integer.parseInt(JOptionPane.showInputDialog("Entre com o IdEnd"));
        int idP = Integer.parseInt(JOptionPane.showInputDialog("Entre com o IdPessoa"));
        String obs = JOptionPane.showInputDialog("Entre com o Observacao");

        PessoaEndereco pesend = new PessoaEndereco(id, idP, idE, obs);
        ControlePessoaEndereco contPesEnd = new ControlePessoaEndereco();
        pesend = contPesEnd.altera(pesend);
        JOptionPane.showMessageDialog(null, pesend.toString());
    }
}

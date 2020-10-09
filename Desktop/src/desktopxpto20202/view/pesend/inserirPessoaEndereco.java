/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopxpto20202.view.pesend;

import backendxpto20202.controle.ControlePessoaEndereco;
import backendxpto20202.modelo.bean.PessoaEndereco;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Hideki
 */
public class inserirPessoaEndereco {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        int idEndereco;
        int idPessoa;
        String observacao;

        idEndereco = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID de Endereco"));
        idPessoa = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID de Pessoa"));
        observacao = JOptionPane.showInputDialog("Entre com a observação de Pessoa Endereco");

        PessoaEndereco pesEnd = new PessoaEndereco(0, idEndereco, idPessoa, observacao);
        ControlePessoaEndereco contPesEnd = new ControlePessoaEndereco();
        pesEnd = contPesEnd.inseri(pesEnd);
        JOptionPane.showMessageDialog(null, pesEnd.toString());
    }

}

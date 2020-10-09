/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopxpto20202.view.pesend;

import backendxpto20202.controle.ControlePessoaEndereco;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import backendxpto20202.controle.ControleUsuarioPessoa;
import backendxpto20202.modelo.bean.PessoaEndereco;
import backendxpto20202.modelo.bean.UsuarioPessoa;

/**
 *
 * @author Hideki
 */
public class listarPessoaEndereco {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String obs;
        obs = JOptionPane.showInputDialog("Entre com a Observação");
        PessoaEndereco pesend = new PessoaEndereco(obs);
        ControlePessoaEndereco contPesEnd = new ControlePessoaEndereco();
        List<PessoaEndereco> pesEnderecos = contPesEnd.lista(pesend);

        for (PessoaEndereco pesEndL : pesEnderecos) {
            JOptionPane.showMessageDialog(null, pesEndL.toString());
        }

    }

}

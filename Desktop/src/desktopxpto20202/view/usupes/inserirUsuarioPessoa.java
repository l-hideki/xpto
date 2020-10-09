/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopxpto20202.view.usupes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import backendxpto20202.controle.ControleUsuarioPessoa;
import backendxpto20202.modelo.bean.UsuarioPessoa;

/**
 *
 * @author Hideki
 */
public class inserirUsuarioPessoa {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        int idUsuario;
        int idPessoa;
        String observacao;

        idUsuario = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID de usuario"));
        idPessoa = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID de Pessoa"));
        observacao = JOptionPane.showInputDialog("Entre com a observação de Usuario Pessoa");

        UsuarioPessoa usuPes = new UsuarioPessoa(0, idUsuario, idPessoa, observacao);
        ControleUsuarioPessoa contUsuPes = new ControleUsuarioPessoa();
        usuPes = contUsuPes.inseri(usuPes);
        JOptionPane.showMessageDialog(null, usuPes.toString());
    }

}

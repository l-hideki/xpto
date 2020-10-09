/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopxpto20202.view.usupes;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import backendxpto20202.controle.ControleUsuarioPessoa;
import backendxpto20202.modelo.bean.UsuarioPessoa;

/**
 *
 * @author Hideki
 */
public class listarUsuarioPessoa {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String login;
        login = JOptionPane.showInputDialog("Entre com a Observação");
        UsuarioPessoa usuPes = new UsuarioPessoa(login);
        ControleUsuarioPessoa contUsuPes = new ControleUsuarioPessoa();
        List<UsuarioPessoa> ususPessoas = contUsuPes.lista(usuPes);

        for (UsuarioPessoa usuPesL : ususPessoas) {
            JOptionPane.showMessageDialog(null, usuPesL.toString());
        }

    }

}

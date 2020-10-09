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
public class alterarUsuarioPessoa {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        int id;
        int idU;
        int idP;
        String obs;

        id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID"));
        idU = Integer.parseInt(JOptionPane.showInputDialog("Entre com o novo ID de Usuário"));
        idP = Integer.parseInt(JOptionPane.showInputDialog("Entre com o novo ID de Pessoa"));
        obs = JOptionPane.showInputDialog("Entre com a nova Observação");

        UsuarioPessoa usuPes = new UsuarioPessoa(id, idU, idP, obs);
        ControleUsuarioPessoa contUsu = new ControleUsuarioPessoa();
        usuPes = contUsu.altera(usuPes);
        JOptionPane.showMessageDialog(null, usuPes.toString());
    }
}

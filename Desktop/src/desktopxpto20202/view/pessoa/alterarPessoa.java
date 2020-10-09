/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopxpto20202.view.pessoa;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import backendxpto20202.controle.ControlePessoa;
import backendxpto20202.modelo.bean.Pessoa;

/**
 *
 * @author Hideki
 */
public class alterarPessoa {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int id;
        String nome;
        String cpf;
        String tipo;
        String email;

        id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID"));
        nome = JOptionPane.showInputDialog("Entre com o nome");
        cpf = JOptionPane.showInputDialog("Entre com o cpf");
        tipo = JOptionPane.showInputDialog("Entre com o tipo");
        email = JOptionPane.showInputDialog("Entre com o email");

        Pessoa pes = new Pessoa(id, nome, cpf, tipo, email);
        ControlePessoa contPes = new ControlePessoa();
        pes = contPes.altera(pes);
        JOptionPane.showMessageDialog(null, pes.toString());
        
        
    }
}

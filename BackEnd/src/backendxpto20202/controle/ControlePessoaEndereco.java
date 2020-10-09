/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendxpto20202.controle;

import backendxpto20202.modelo.bean.Endereco;
import backendxpto20202.modelo.bean.Pessoa;
import backendxpto20202.modelo.bean.PessoaEndereco;
import backendxpto20202.modelo.dao.DaoPessoaEndereco;
import java.sql.SQLException;

/**
 *
 * @author Hideki
 */
public class ControlePessoaEndereco {

    static DaoPessoaEndereco daoPesEnd;
    static ControleEndereco contEnd;
    static ControlePessoa contPes;

    public ControlePessoaEndereco() throws SQLException, ClassNotFoundException {
        daoPesEnd = new DaoPessoaEndereco();
        contEnd = new ControleEndereco();
        contPes = new ControlePessoa();
    }

    public PessoaEndereco busca(PessoaEndereco pesend) throws SQLException {

        // busca UsuarioPessoa por id
        pesend = daoPesEnd.busca(pesend);
        // construi os beans com os id de retorno de usuPes
        Pessoa pes = new Pessoa(pesend.getIdP());
        Endereco end = new Endereco(pesend.getIdE());
        // valorizar os beans de usuario e pessao executando
                // seus controles.
        pesend.setEnd(contEnd.busca(end));
        pesend.setPes(contPes.busca(pes));

        return pesend;
    }

}

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
import java.util.ArrayList;
import java.util.List;

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

    public PessoaEndereco inseri(PessoaEndereco pesend) throws SQLException {
        pesend = daoPesEnd.inseri(pesend);
        Pessoa pes = new Pessoa(pesend.getIdP());
        Endereco end = new Endereco(pesend.getIdE());
        pesend.setPes(contPes.busca(pes));
        pesend.setEnd(contEnd.busca(end));
        return pesend;
    }

    public PessoaEndereco altera(PessoaEndereco pesend) throws SQLException {
        return daoPesEnd.altera(pesend);
    }

    public PessoaEndereco exclui(PessoaEndereco pesend) throws SQLException {
        return daoPesEnd.exclui(pesend);
    }

    public List<PessoaEndereco> lista(PessoaEndereco pesend) throws SQLException, ClassNotFoundException {
        List<PessoaEndereco> pesends = new ArrayList<>();
        pesends = daoPesEnd.lista(pesend);

        for (PessoaEndereco pesendL : pesends) {
            contEnd = new ControleEndereco();
            contPes = new ControlePessoa();

            Pessoa pes = new Pessoa(pesendL.getIdP());
            Endereco end = new Endereco(pesendL.getIdE());

            pesendL.setPes(contPes.busca(pes));
            pesendL.setEnd(contEnd.busca(end));
        }

        return pesends;
    }

}

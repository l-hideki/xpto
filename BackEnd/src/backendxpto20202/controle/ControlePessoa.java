/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendxpto20202.controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import backendxpto20202.modelo.bean.Pessoa;
import backendxpto20202.modelo.dao.DaoPessoa;

/**
 *
 * @author ProfAlexandre
 */
public class ControlePessoa {

    static DaoPessoa daoPes;

    public ControlePessoa() throws SQLException, ClassNotFoundException {
        daoPes = new DaoPessoa();
    }

    public Pessoa busca(Pessoa pes) throws SQLException {
        pes = daoPes.busca(pes);
        return pes;
    }

    public Pessoa inseri(Pessoa pes) throws SQLException {
        pes = daoPes.inseri(pes);
        return pes;
    }

    public Pessoa altera(Pessoa pes) throws SQLException {
        pes = daoPes.altera(pes);
        return pes;
    }

    public Pessoa exclui(Pessoa pes) throws SQLException {
        pes = daoPes.exclui(pes);
        return pes;
    }

    public List<Pessoa> lista(Pessoa pes) throws SQLException {
        List<Pessoa> pess = new ArrayList<>();
        pess = daoPes.lista(pes);
        return pess;
    }

}

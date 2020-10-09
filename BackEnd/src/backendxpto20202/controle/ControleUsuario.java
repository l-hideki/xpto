/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendxpto20202.controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import backendxpto20202.modelo.bean.Usuario;
import backendxpto20202.modelo.bean.UsuarioPessoa;
import backendxpto20202.modelo.dao.DaoUsuario;

/**
 *
 * @author ProfAlexandre
 */
public class ControleUsuario {

    static DaoUsuario daoUsu;

    public ControleUsuario() throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
    }

    public Usuario valida(Usuario usu) throws SQLException {
        usu = daoUsu.valida(usu);
        return usu;
    }

    public Usuario busca(Usuario usu) throws SQLException {
        usu = daoUsu.busca(usu);
        return usu;
    }

    public Usuario inseri(Usuario usu) throws SQLException {
        usu = daoUsu.inseri(usu);
        return usu;
    }

    public Usuario altera(Usuario usu) throws SQLException {
        usu = daoUsu.altera(usu);
        return usu;
    }

    public Usuario exclui(Usuario usu) throws SQLException {
        usu = daoUsu.exclui(usu);
        return usu;
    }

    public List<Usuario> lista(Usuario usu) throws SQLException {
        List<Usuario> usus = new ArrayList<>();
        usus = daoUsu.lista(usu);
        return usus;
    }

}

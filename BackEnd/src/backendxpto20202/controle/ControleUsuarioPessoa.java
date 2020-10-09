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
import backendxpto20202.modelo.bean.Usuario;
import backendxpto20202.modelo.bean.UsuarioPessoa;
import backendxpto20202.modelo.dao.DaoUsuarioPessoa;

/**
 *
 * @author ProfAlexandre
 */
public class ControleUsuarioPessoa {

    static DaoUsuarioPessoa daoUsuPes;
    static ControleUsuario contUsu;
    static ControlePessoa contPes;

    public ControleUsuarioPessoa() throws SQLException, ClassNotFoundException {
        daoUsuPes = new DaoUsuarioPessoa();
        contUsu = new ControleUsuario();
        contPes = new ControlePessoa();
    }

    public UsuarioPessoa busca(UsuarioPessoa usupes) throws SQLException {

        // busca UsuarioPessoa por id
        usupes = daoUsuPes.busca(usupes);
        // construi os beans com os id de retorno de usuPes
        Usuario usu = new Usuario(usupes.getIdU());
        Pessoa pes = new Pessoa(usupes.getIdP());
        // valorizar os beans de usuario e pessao executando
        // seus controles.
        usupes.setUsu(contUsu.busca(usu));
        usupes.setPes(contPes.busca(pes));

        return usupes;
    }

    public UsuarioPessoa inseri(UsuarioPessoa usupes) throws SQLException {
        usupes = daoUsuPes.inseri(usupes);
        Pessoa pes = new Pessoa(usupes.getIdP());
        Usuario usu = new Usuario(usupes.getIdU());
        usupes.setPes(contPes.busca(pes));
        usupes.setUsu(contUsu.busca(usu));
        return usupes;
    }

    public UsuarioPessoa altera(UsuarioPessoa usupes) throws SQLException {
        usupes = daoUsuPes.altera(usupes);
        Pessoa pes = new Pessoa(usupes.getIdP());
        Usuario usu = new Usuario(usupes.getIdU());
        usupes.setPes(contPes.busca(pes));
        usupes.setUsu(contUsu.busca(usu));
        return usupes;
    }

    public UsuarioPessoa exclui(UsuarioPessoa usupes) throws SQLException {
        usupes = daoUsuPes.exclui(usupes);
        return usupes;
    }

    public List<UsuarioPessoa> lista(UsuarioPessoa usupes) throws SQLException {
        List<UsuarioPessoa> usupess = new ArrayList<>();
        List<Usuario> usus = new ArrayList<>();
        List<Pessoa> pess = new ArrayList<>();
        Usuario usu = new Usuario("", "");
        Pessoa pes = new Pessoa("");
        usupess = daoUsuPes.lista(usupes);
        usus = contUsu.lista(usu);
        pess = contPes.lista(pes);

        for (int cont = 0; cont < usupess.size(); cont++) {
            for (int contUsu = 0; contUsu < usus.size(); contUsu++) {
                if (usupess.get(cont).getIdU() == usus.get(contUsu).getId()) {
                    usupess.get(cont).setUsu(usus.get(contUsu));
                    break;
                }
            }
            for (int contPes = 0; contPes < pess.size(); contPes++) {
                if (usupess.get(cont).getIdP() == pess.get(contPes).getId()) {
                    usupess.get(cont).setPes(pess.get(contPes));
                    break;
                }
            }
        }

        return usupess;
    }

}

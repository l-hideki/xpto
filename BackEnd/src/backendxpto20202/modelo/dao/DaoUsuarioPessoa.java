/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendxpto20202.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import backendxpto20202.modelo.bean.Pessoa;
import backendxpto20202.modelo.bean.Usuario;
import backendxpto20202.modelo.bean.UsuarioPessoa;
import backendxpto20202.util.ConexaoDB;

/**
 *
 * @author ProfAlexandre
 */
public class DaoUsuarioPessoa {

    private final Connection c;

    public DaoUsuarioPessoa() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }

    public UsuarioPessoa busca(UsuarioPessoa usupes) throws SQLException {
        String sql = "select * from usuarios_pessoas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, usupes.getId());
        // executa
        ResultSet rs = stmt.executeQuery();
        UsuarioPessoa retorno = null;
        while (rs.next()) {
            // criando o objeto Usuario
            retorno = new UsuarioPessoa(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
        }
        stmt.close();
        c.close();
        return retorno;
    }

    public UsuarioPessoa inseri(UsuarioPessoa usuPes) throws SQLException {
        String sql = "INSERT INTO usuarios_pessoas" + " (idPessoa, idUsuario, observacao)" + "VALUES (?, ?, ?);";
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1, usuPes.getIdP());
        stmt.setInt(2, usuPes.getIdU());
        stmt.setString(3, usuPes.getObs());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();

        if (rs.next()) {
            int id = rs.getInt(1);
            usuPes.setId(id);
        }

        stmt.close();
        c.close();
        return usuPes;
    }

    public UsuarioPessoa altera(UsuarioPessoa usupes) throws SQLException {
        String sql = "UPDATE usuarios_pessoas SET idPessoa = ?, idUsuario = ?, observacao = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, usupes.getIdP());
        stmt.setInt(2, usupes.getIdU());
        stmt.setString(3, usupes.getObs());
        stmt.setInt(4, usupes.getId());

        stmt.execute();
        stmt.close();

        return usupes;
    }

    public UsuarioPessoa exclui(UsuarioPessoa usupes) throws SQLException {
        String sql = "delete from usuarios_pessoas WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, usupes.getId());
        stmt.execute();
        stmt.close();
        c.close();

        return usupes;
    }

    public List<UsuarioPessoa> lista(UsuarioPessoa usupes) throws SQLException {
        List<UsuarioPessoa> ususPess = new ArrayList<>();
        String sql = "select * from usuarios_pessoas where observacao like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1, "%" + usupes.getObs() + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            // criando o objeto UsuarioPessoa
            UsuarioPessoa usuPesSaida = new UsuarioPessoa(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4)
            );
            ususPess.add(usuPesSaida);
        }

        
        
        
        rs.close();
        stmt.close();
        c.close();
 
        return ususPess;
    }
}

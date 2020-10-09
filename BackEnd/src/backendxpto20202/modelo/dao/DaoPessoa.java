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
import backendxpto20202.util.ConexaoDB;

/**
 *
 * @author ProfAlexandre
 */
public class DaoPessoa {

    private final Connection c;

    public DaoPessoa() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }

    public Pessoa busca(Pessoa pes) throws SQLException {
        String sql = "select * from pessoas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, pes.getId());
        // executa
        ResultSet rs = stmt.executeQuery();
        Pessoa retorno = null;
        while (rs.next()) {
            // criando o objeto Usuario
            retorno = new Pessoa(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus
        }
        stmt.close();
        c.close();
        return retorno;
    }

    public Pessoa inseri(Pessoa pes) throws SQLException {
        String sql = "insert into pessoas" + " (nome, cpf, tipo, email)" + " values (?,?,?,?)";

        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, pes.getNome());
        stmt.setString(2, pes.getCpf());
        stmt.setString(3, pes.getTipo());
        stmt.setString(4, pes.getEmail());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            pes.setId(id);
        }

        stmt.close();
        c.close();

        return pes;
    }

    public Pessoa altera(Pessoa pes) throws SQLException {
        String sql = "UPDATE pessoas SET nome = ?, cpf = ?, tipo = ?, email = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setString(1, pes.getNome());
        stmt.setString(2, pes.getCpf());
        stmt.setString(3, pes.getTipo());
        stmt.setString(4, pes.getEmail());
        stmt.setInt(5, pes.getId());

        stmt.execute();
        stmt.close();

        return pes;
    }

    public Pessoa exclui(Pessoa pes) throws SQLException {
        String sql = "delete from pessoas WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, pes.getId());
        stmt.execute();
        stmt.close();
        c.close();

        return pes;
    }

    public List<Pessoa> lista(Pessoa pes) throws SQLException {
        List<Pessoa> pess = new ArrayList<>();

        String sql = "select * from pessoas where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1, "%" + pes.getNome() + "%");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // criando o objeto Pessoa
            Pessoa pesSaida = new Pessoa(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
            );
            pess.add(pesSaida);
        }
        rs.close();
        stmt.close();
        return pess;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendxpto20202.modelo.dao;

import backendxpto20202.modelo.bean.PessoaEndereco;
import backendxpto20202.util.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hideki
 */
public class DaoPessoaEndereco {

    private final Connection c;

    public DaoPessoaEndereco() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }

    public PessoaEndereco busca(PessoaEndereco pesend) throws SQLException {
        String sql = "select * from pessoas_enderecos WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, pesend.getId());
        // executa
        ResultSet rs = stmt.executeQuery();
        PessoaEndereco retorno = null;
        while (rs.next()) {
            // criando o objeto Usuario
            retorno = new PessoaEndereco(
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

    public PessoaEndereco inseri(PessoaEndereco pesend) throws SQLException {
        String sql = "INSERT INTO pessoas_enderecos" + " (idPes, idEnd, observacao)" + "VALUES (?, ?, ?);";
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1, pesend.getIdP());
        stmt.setInt(2, pesend.getIdE());
        stmt.setString(3, pesend.getObs());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();

        if (rs.next()) {
            int id = rs.getInt(1);
            pesend.setId(id);
        }

        stmt.close();
        c.close();
        return pesend;
    }

    public PessoaEndereco altera(PessoaEndereco pesend) throws SQLException {
        String sql = "UPDATE pessoas_enderecos SET idPes = ?, idEnd = ?, observacao = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, pesend.getIdP());
        stmt.setInt(2, pesend.getIdE());
        stmt.setString(3, pesend.getObs());
        stmt.setInt(4, pesend.getId());

        stmt.execute();
        stmt.close();

        return pesend;
    }

    public PessoaEndereco exclui(PessoaEndereco pesend) throws SQLException {
        String sql = "delete from pessoas_enderecos WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, pesend.getId());
        stmt.execute();
        stmt.close();
        c.close();

        return pesend;
    }

    public List<PessoaEndereco> lista(PessoaEndereco pesend) throws SQLException {
        List<PessoaEndereco> pesends = new ArrayList<>();
        String sql = "select * from pessoas_enderecos where observacao like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1, "%" + pesend.getObs() + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            // criando o objeto UsuarioPessoa
            PessoaEndereco pesEndSaida = new PessoaEndereco(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4)
            );
            pesends.add(pesEndSaida);
        }

        rs.close();
        stmt.close();
        c.close();

        return pesends;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendxpto20202.modelo.dao;

import backendxpto20202.modelo.bean.Produto;
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
public class DaoProduto {

    private final Connection c;

    public DaoProduto() throws SQLException, ClassNotFoundException {
        c = new ConexaoDB().getConnection();
    }

    public Produto busca(Produto pro) throws SQLException {
        String sql = "select * from produtos WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, pro.getId());
        // executa
        ResultSet rs = stmt.executeQuery();
        Produto retorno = null;
        while (rs.next()) {
            // criando o objeto Usuario
            retorno = new Produto(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5));
            // adiciona o usu à lista de usus
        }
        stmt.close();
        c.close();
        return retorno;
    }

    public Produto inseri(Produto pro) throws SQLException {
        String sql = "insert into produtos" + " (cod, nome, valor, quant)" + " values (?,?,?,?)";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1, pro.getCod());
        stmt.setString(2, pro.getNome());
        stmt.setInt(3, pro.getValor());
        stmt.setInt(4, pro.getQuant());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            pro.setId(id);
        }
        stmt.close();
        c.close();
        return pro;
    }

    public Produto altera(Produto pro) throws SQLException {
        String sql = "UPDATE produtos SET cod = ?, nome = ?, valor = ?, quant = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, pro.getCod());
        stmt.setString(2, pro.getNome());
        stmt.setInt(3, pro.getValor());
        stmt.setInt(4, pro.getQuant());
        stmt.setInt(5, pro.getId());

        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return pro;

    }

    public Produto exclui(Produto pro) throws SQLException {
        String sql = "delete from produtos WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, pro.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return pro;
    }

    public List<Produto> lista(Produto pro) throws SQLException {
        // usus: array armazena a lista de registros
        List<Produto> pros = new ArrayList<>();

        String sql = "select * from produtos where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, "%" + pro.getNome() + "%");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // criando o objeto Usuario
            Produto proSaida = new Produto(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5)
            );
            // adiciona o usu à lista de usus
            pros.add(proSaida);
        }

        rs.close();
        stmt.close();
        c.close();
        return pros;
    }

}

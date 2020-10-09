/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendxpto20202.controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import backendxpto20202.modelo.bean.Produto;
import backendxpto20202.modelo.dao.DaoProduto;

/**
 *
 * @author ProfAlexandre
 */
public class ControleProduto {
    
    public Produto busca (Produto pro) throws SQLException, ClassNotFoundException {
        DaoProduto daoPro = new DaoProduto();
        pro = daoPro.busca(pro);
        return pro;
    }

    public Produto inseri (Produto pro) throws SQLException, ClassNotFoundException {
        DaoProduto daoPro = new DaoProduto();
        pro = daoPro.inseri(pro);
        return pro;
    }

    public Produto altera (Produto pro) throws SQLException, ClassNotFoundException {
        DaoProduto daoPro = new DaoProduto();
        pro = daoPro.altera(pro);
        return pro;
    }

    public Produto exclui (Produto pro) throws SQLException, ClassNotFoundException {
        DaoProduto daoPro = new DaoProduto();
        pro = daoPro.exclui(pro);
        return pro;
    }

    public List<Produto> lista (Produto pro) throws SQLException, ClassNotFoundException {
        DaoProduto daoPro = new DaoProduto();
        List<Produto> pros = new ArrayList<>();
        pros = daoPro.lista(pro);
        return pros;
    }

    
}

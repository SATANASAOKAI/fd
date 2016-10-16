package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pojo.Produto;

public class DAOProduto {
    
    public List<Produto> consultar(){
        List<Produto> lista= new ArrayList<Produto>();
        try {
            Connection conn = Conexao.get();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM PRODUTO WHERE STATUS='A'");
            ResultSet rs = ps.executeQuery();
            Produto produto;
            DAOCidade daoFK = new DAOCidade();
            while(rs.next()){
                produto = new Produto();
                produto.setId(rs.getInt("ID"));
                produto.setNome(rs.getString("NOME"));
                produto.setPrecoVenda(rs.getDouble("PRECO_V"));
                produto.setEstoque(rs.getInt("ESTOQUE"));
                produto.setStatus(rs.getString("STATUS"));
                produto.setStatus("A");
                lista.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}

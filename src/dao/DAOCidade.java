package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pojo.Cidade;

public class DAOCidade {
    
    public List<Cidade> consultar(){
        List<Cidade> lista= new ArrayList<Cidade>();
        try {
            Connection conn = Conexao.get();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM CIDADE WHERE STATUS='A'");
            ResultSet rs = ps.executeQuery();
            Cidade cidade;
            DAOEstado daoFK = new DAOEstado();
            while(rs.next()){
                cidade = new Cidade();
                cidade.setId(rs.getInt("ID"));
                cidade.setNome(rs.getString("NOME"));
                cidade.setEstado(daoFK.consultar(rs.getInt("ESTADO_ID")));
                lista.add(cidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public Cidade consultar(int id){
        Cidade cidade = null;
        try {
            Connection conn = Conexao.get();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM CIDADE WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            DAOEstado daoFK = new DAOEstado();
            if(rs.next()){
                cidade = new Cidade();
                cidade.setId(rs.getInt("ID"));
                cidade.setNome(rs.getString("NOME"));
                cidade.setEstado(daoFK.consultar(rs.getInt("ESTADO_ID")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cidade;
    }
}

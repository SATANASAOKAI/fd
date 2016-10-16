package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.Estado;

/**
 *
 * @author joao
 */
public class DAOEstado {
    
    public Estado cadastrar(Estado estado){
        try {
            Connection conn = Conexao.get();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO ESTADO (NOME,SIGLA) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, estado.getNome());
            ps.setString(2, estado.getSigla());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
                estado.setId(rs.getInt(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
    }
    
    public boolean excluir(int id){
        try{
            Connection conn = Conexao.get();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM ESTADO WHERE ID = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean alterar(Estado estado){
        try {
            Connection conn = Conexao.get();
            PreparedStatement ps = conn.prepareStatement("UPDATE ESTADO SET NOME=?,SIGLA=? WHERE ID=?");
            ps.setString(1, estado.getNome());
            ps.setString(2, estado.getSigla());
            ps.setInt(3, estado.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Estado> consultar(){
        List<Estado> lista= new ArrayList<Estado>();
        try {
            Connection conn = Conexao.get();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ESTADO");
            ResultSet rs = ps.executeQuery();
            Estado estado;
            while(rs.next()){
                estado = new Estado();
                estado.setId(rs.getInt("ID"));
                estado.setNome(rs.getString("NOME"));
                estado.setSigla(rs.getString("SIGLA"));
                lista.add(estado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public List<Estado> consultar(String valor){
        List<Estado> lista= new ArrayList<Estado>();
        try {
            Connection conn = Conexao.get();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ESTADO WHERE NOME LIKE '%"+valor+"%'");
            ResultSet rs = ps.executeQuery();
            Estado estado;
            while(rs.next()){
                estado = new Estado();
                estado.setId(rs.getInt("ID"));
                estado.setNome(rs.getString("NOME"));
                estado.setSigla(rs.getString("SIGLA"));
                lista.add(estado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public Estado consultar(int id){
        Estado estado = null;
        try {
            Connection conn = Conexao.get();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ESTADO WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                estado = new Estado();
                estado.setId(rs.getInt("ID"));
                estado.setNome(rs.getString("NOME"));
                estado.setSigla(rs.getString("SIGLA"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
    }
}

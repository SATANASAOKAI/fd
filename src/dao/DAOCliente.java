package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pojo.Cidade;
import pojo.Cliente;

public class DAOCliente {
    
    public List<Cliente> consultar(){
        List<Cliente> lista= new ArrayList<Cliente>();
        try {
            Connection conn = Conexao.get();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM CLIENTE WHERE STATUS='A'");
            ResultSet rs = ps.executeQuery();
            Cliente cliente;
            DAOCidade daoFK = new DAOCidade();
            while(rs.next()){
                cliente = new Cliente();
                cliente.setId(rs.getInt("ID"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setDocumento(rs.getString("DOCUMENTO"));
                cliente.setTipo(rs.getString("TIPO"));
                cliente.setStatus("A");
                cliente.setCidade(daoFK.consultar(rs.getInt("CIDADE_ID")));
                lista.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}

package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pojo.Funcionario;

public class DAOFuncionario {
    
    public List<Funcionario> consultar(){
        List<Funcionario> lista= new ArrayList<Funcionario>();
        try {
            Connection conn = Conexao.get();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FUNCIONARIO WHERE STATUS='A'");
            ResultSet rs = ps.executeQuery();
            Funcionario funcionario;
            DAOCidade daoFK = new DAOCidade();
            while(rs.next()){
                funcionario = new Funcionario();
                funcionario.setId(rs.getInt("ID"));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setStatus("A");
                funcionario.setCidade(daoFK.consultar(rs.getInt("CIDADE_ID")));
                lista.add(funcionario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}

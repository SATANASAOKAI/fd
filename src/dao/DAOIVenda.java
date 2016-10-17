/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import pojo.IVenda;

/**
 *
 * @author Aluno
 */
public class DAOIVenda {
    //private Produtos ptroduto
    //private Venda venda;
    //private int quantidade
    
    public void cadastrar(IVenda ivenda){
        try{
           Connection conn = Conexao.get();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO IVENDA (PRODUTO_ID,VENDA_ID,QUANTIDADE) VALUES (?,?,?)");
            ps.setInt(1, ivenda.getProduto().getId());
            ps.setInt(2, ivenda.getVenda().getId());
            ps.setInt(3,ivenda.getQuantidade());
            ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
}
            
       


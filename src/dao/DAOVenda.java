/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import static java.awt.PageAttributes.MediaType.STATEMENT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import pojo.IVenda;
import pojo.Venda;

/**
 *
 * @author Aluno
 */
public class DAOVenda {
     public void cadastrar(Venda venda){
         try{
             Connection conn= Conexao.get();
             PreparedStatement ps= conn.prepareStatement("INSERT INTO VENDA(FUNCIONARIO_ID,CLIENTE_ID",Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1,venda.getFuncionario().getId());
             ps.setInt(2,venda.getCliente().getId());
             ps.executeQuery();
             ResultSet rs=ps.getGeneratedKeys();
             //int idVendas= rs.next() ? rs.getInt(1) : 0;
             
             int idVendas=0;
             if(rs.next())
                 idVendas=rs.getInt(1);
             //Objeto responsável por salvar o ítem
             DAOIVenda daoIV=new DAOIVenda();
             for(IVenda iv: venda.getItens()){
                 iv.getVenda().setId(idVendas);
                 //nessa parte serve para gerar o ID da venda  que só pode ser gerado na hora da efetuação da mesma.
               daoIV.cadastrar(iv);
               
                 
             }
             
         }catch(Exception e){
             e.printStackTrace();
         }
     }
}

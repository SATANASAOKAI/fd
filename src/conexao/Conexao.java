/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author joao
 */
public class Conexao {
    
    public static Connection conexao;
    
    public static Connection get(){
        try{
            if(conexao==null)
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","");
        }catch(Exception e){
            System.out.println("deu erro de conexao porque não implementamos");
        }
        return conexao;
    }
}

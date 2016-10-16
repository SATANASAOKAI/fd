package teste;

import dao.DAOProduto;
import java.util.Scanner;
import pojo.Produto;

public class TesteProduto {
    
    static DAOProduto dao = new DAOProduto();
    static Scanner ler = new Scanner(System.in);
    
    public static void testeConsultar() {
        try {
            for (Produto p : dao.consultar()) {
                System.out.println(p.getNome());
            }
        } catch (Exception e) {
            System.out.println("deu errado!!!" + e);
        }
    }
    
    public static void main(String[] args) {
        testeConsultar();
    }
    
}

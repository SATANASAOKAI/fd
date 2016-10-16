package teste;

import dao.DAOCidade;
import java.util.Scanner;
import pojo.Cidade;

public class TesteCidade {
    
    static DAOCidade dao = new DAOCidade();
    static Scanner ler = new Scanner(System.in);
    
    public static void testeConsultar() {
        try {
            for (Cidade c : dao.consultar()) {
                System.out.println(c.getNome());
            }
        } catch (Exception e) {
            System.out.println("deu errado!!!" + e);
        }
    }
    
    public static void main(String[] args) {
        testeConsultar();
    }
    
}

package teste;

import dao.DAOFuncionario;
import java.util.Scanner;
import pojo.Funcionario;

public class TesteFuncionario {
    
    static DAOFuncionario dao = new DAOFuncionario();
    static Scanner ler = new Scanner(System.in);
    
    public static void testeConsultar() {
        try {
            for (Funcionario f : dao.consultar()) {
                System.out.println(f.getNome());
            }
        } catch (Exception e) {
            System.out.println("deu errado!!!" + e);
        }
    }
    
    public static void main(String[] args) {
        testeConsultar();
    }
    
}

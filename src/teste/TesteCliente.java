package teste;

import dao.DAOCliente;
import java.util.Scanner;
import pojo.Cliente;

public class TesteCliente {
    
    static DAOCliente dao = new DAOCliente();
    static Scanner ler = new Scanner(System.in);
    
    public static void testeConsultar() {
        try {
            for (Cliente c : dao.consultar()) {
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

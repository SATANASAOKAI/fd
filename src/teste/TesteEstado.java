package teste;

import pojo.Estado;
import dao.DAOEstado;
import java.util.Scanner;

public class TesteEstado {

    static DAOEstado dao = new DAOEstado();
    static Scanner ler = new Scanner(System.in);

    public static void testeInserir() {
        try {
            Estado estado = new Estado();
            System.out.println("digite nome:");
            estado.setNome(ler.next());
            System.out.println("digite sigla:");
            estado.setSigla(ler.next());
            dao.cadastrar(estado);
            System.out.println("cadastro efetuado com sucesso");
        } catch (Exception e) {
            System.out.println("deu errado!!!" + e);
        }
    }

    public static void testeAlterar() {
        try {
            System.out.println("digite id do estado para alterar:");
            Estado estado = dao.consultar(ler.nextInt());
            if (null == estado) {
                System.out.println("estado não existe");
            } else {
                System.out.println("digite novo nome:");
                estado.setNome(ler.next());
                System.out.println("digite nova sigla:");
                estado.setSigla(ler.next());
                dao.cadastrar(estado);
                System.out.println("alterado sucesso");
            }
        } catch (Exception e) {
            System.out.println("deu errado!!!" + e);
        }
    }

    public static void testeExcluir() {
        try {
            System.out.println("digite id do estado para excluir:");
            Estado estado = dao.consultar(ler.nextInt());
            if (null == estado) {
                System.out.println("estado não existe");
            } else {
                dao.excluir(ler.nextInt());
                System.out.println("alterado sucesso");
            }
        } catch (Exception e) {
            System.out.println("deu errado!!!" + e);
        }
    }

    public static void testeConsultarUm() {
        try {
            System.out.println("digite id:");
            Estado estado = dao.consultar(ler.nextInt());
            System.out.println("consulta deu certo → nome:" + estado.getNome());
        } catch (Exception e) {
            System.out.println("deu errado!!!" + e);
        }
    }

    public static void testeConsultarLike() {
        try {
            System.out.println("digite uma letra:");
            for (Estado e : dao.consultar(ler.next())) {
                System.out.println(e.getNome());
            }
        } catch (Exception e) {
            System.out.println("deu errado!!!" + e);
        }
    }

    public static void testeConsultar() {
        try {
            for (Estado e : dao.consultar()) {
                System.out.println(e.getNome());
            }
        } catch (Exception e) {
            System.out.println("deu errado!!!" + e);
        }
    }

    public static void main(String args[]) {
        
        int opcao = 0;
        do {
            System.err.println("Escolha uma operação: 1. Inserir, 2. Alterar, 3.Excluir, 4. Consultar Um, 5 Consultar Like, 6 Consultar todos, digite 7 para sair");
            opcao = ler.nextInt();
            switch (opcao) {
                case 1:
                    testeInserir();
                    break;
                case 2:
                    testeAlterar();
                    break;
                case 3:
                    testeExcluir();
                    break;
                case 4:
                    testeConsultarUm();
                    break;
                case 5:
                    testeConsultarLike();
                    break;
                case 6:
                    testeConsultar();
                    break;
            }
        }while (opcao < 7);
    }
}

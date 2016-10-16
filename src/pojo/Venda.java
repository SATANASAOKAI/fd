package pojo;

import java.util.Date;
import java.util.List;

public class Venda {
    private int id;
    private Date data;
    private Funcionario funcionario;
    private Cliente cliente;
    private List<IVenda> itens;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<IVenda> getItens() {
        return itens;
    }

    public void setItens(List<IVenda> itens) {
        this.itens = itens;
    }
}

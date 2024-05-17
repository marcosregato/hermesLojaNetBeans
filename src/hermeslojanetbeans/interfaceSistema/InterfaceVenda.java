package hermeslojanetbeans.interfaceSistema;

import hermeslojanetbeans.model.Venda;

import java.util.List;

public interface InterfaceVenda {

    public void salvar(Venda venda);
    public void delete(String value);
    public void update(Venda venda);
    public List<Venda> listar();

    public Venda buscar(String value);
}

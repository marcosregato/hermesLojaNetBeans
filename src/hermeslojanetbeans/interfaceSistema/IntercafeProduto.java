package hermeslojanetbeans.interfaceSistema;

import hermeslojanetbeans.model.Produto;

import java.util.List;

public interface IntercafeProduto {

    public void salvar(Produto produto);
    public void delete(int value);
    public void update(Produto produto);
    public List<Produto> listar();

    public List<Produto> buscar(String value);
}

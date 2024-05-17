package hermeslojanetbeans.interfaceSistema;

import hermeslojanetbeans.model.FluxoCaixa;

import java.util.List;

public interface InterfaceFluxoCaixa {

    public void salvar(FluxoCaixa fluxo);
    public void delete(String value);
    public void update(FluxoCaixa fluxo);
    public List<FluxoCaixa> listar();

    public FluxoCaixa buscar(String value);
}

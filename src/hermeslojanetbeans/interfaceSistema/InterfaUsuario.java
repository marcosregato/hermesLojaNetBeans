package hermeslojanetbeans.interfaceSistema;

import hermeslojanetbeans.model.Usuario;

import java.util.List;

public interface InterfaUsuario {

    public void salvar(Usuario usuario);
    public void delete(String value);
    public void update(Usuario usuario);
    public List<Usuario> listar();

    public List<Usuario> buscar(String value);
}

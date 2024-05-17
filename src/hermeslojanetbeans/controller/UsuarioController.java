package hermeslojanetbeans.controller;

import hermeslojanetbeans.dao.UsuarioDao;
import hermeslojanetbeans.model.Usuario;
import javax.swing.JOptionPane;

public class UsuarioController {

    UsuarioDao dao = new UsuarioDao();

    String login =null;
    String senha =null;

    public void actionBtSalvar(Usuario usuario) {

        try {
            if(usuario != null){
                dao.salvar(usuario);
            }
                
        }catch (Exception e){
            System.out.println(">>>>> " + e.getMessage());
        }
    }

    public void actionBtExcluir(String value) {

        try {
         dao.delete(value);
        }catch (Exception e){
            System.out.println(">>>>> " + e.getMessage());
        }
    }
    
    public void actionBtEditar(Usuario usuario) {

        try {
            dao.update(usuario);
        }catch (Exception e){
            System.out.println(">>>>> " + e.getMessage());
        }
    }

    public void acessarSistema(String text, String text1) {
    }
    
    public String verificarCnpjCpfCadastrado(String cnpjCpf){
        String valor = null;
        Usuario usuario = new Usuario();
        try {
            if(cnpjCpf != null){
                return dao.veirificarSeCpfCjpjExiste(cnpjCpf);
                //return valor; 
            }else{
                 JOptionPane.showMessageDialog(null, "O número CPF ou CNPJ já cadastro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(">>>>> " + e.getMessage());
        }
        return null;
    }
}

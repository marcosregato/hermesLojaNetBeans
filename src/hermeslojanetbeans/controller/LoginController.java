package hermeslojanetbeans.controller;


import hermeslojanetbeans.dao.UsuarioDao;
import hermeslojanetbeans.model.Usuario;

public class LoginController {

    UsuarioController  usuarioController;
    UsuarioDao dao = new UsuarioDao();


    public void actionBtAcessar(Usuario usuario) {
        try {

            if(usuario != null){
                dao.acessoSistema(usuario);
            }

        }catch (Exception e){
            System.out.println(">>>>> " + e.getMessage());
        }
    }


    private void pegaValoresDosCampos(Usuario usuario) {

//        if(txtEstamapa.getText().length() == 0 ){
//            txtEstamapa.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
//            new animatefx.animation.Shake(txtEstamapa).play();
//        }

        //usuario.setLogin(txtLogin.getText());
        //usuario.setSenha(txtSenha.getText());

    }
}

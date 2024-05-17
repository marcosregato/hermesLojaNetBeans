package hermeslojanetbeans.dao;

import hermeslojanetbeans.controller.ProdutoController;
import hermeslojanetbeans.interfaceSistema.InterfaUsuario;
import hermeslojanetbeans.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class UsuarioDao implements InterfaUsuario {

    private Connection conn;
    private static final Logger logger = Logger.getLogger(UsuarioDao.class.getName());

    public UsuarioDao()  {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void salvar(Usuario usuario) {

        try {
            logger.info("SALVAR USUARIO DAO");
            
            String query ="INSERT INTO usuario(nome, endereco, telefone, cnpj_cpf, tipo_usuario)VALUES(?,?,?,?,?)";

            try (PreparedStatement stm = conn.prepareStatement(query)) {

                stm.setString(1, usuario.getNome());
                stm.setString(2, usuario.getEndereco());
                stm.setString(3, usuario.getTelefone());
                stm.setString(4, usuario.getCnpj_cpf());
                stm.setString(5, usuario.getTipoUsuario());

                stm.executeUpdate();
                stm.close();
            }
            //conn.close();

        }catch (SQLException e){
            System.err.println("ERROR SALVANDO USUARIO");
            logger.error("ERROR SALVAR USUARIO DAO");
            System.exit(0);
        }
    }

    @Override
    public void delete(String value) {

        try {
            logger.error("DELETE USUARIO DAO");
            
            String query = "delete from usuario where cnpj_cpf = ?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, value);

            stm.executeUpdate();
            stm.close();

        }catch (SQLException e){
            System.err.println("ERROR APAGANDO USUARIO COM VALUE => " + value);
            logger.error("ERROR DELETE USUARIO DAO");
            System.exit(0);
        }
    }

    @Override
    public void update(Usuario usuario) {

        try {
            logger.info("UPDATE USUARIO DAO");
            
            String query = "UPDATE usuario SET nome = ?, endereco = ?, telefone = ?, cnpj_cpf = ?, tipo_usuario = ? WHERE cnpj_cpf = ?";
            
            try (PreparedStatement stm = conn.prepareStatement(query)) {
                stm.setString(1, usuario.getNome());
                stm.setString(2, usuario.getEndereco());
                stm.setString(3, usuario.getTelefone());
                stm.setString(4, usuario.getCnpj_cpf());
                stm.setString(5, usuario.getTipoUsuario());
                stm.setString(6, usuario.getCnpj_cpf());
                stm.executeUpdate();
                
                int rowsAffected = stm.executeUpdate();
                stm.close();
            }
            //conn.close();

        }catch (Exception ex){
            ex.printStackTrace();
            System.err.println("UPDATE USUARIO DAO " + usuario.getCnpj_cpf());
            logger.error("ERROR UPDATE USUARIO DAO");
            System.exit(0);
        }
    }

    @Override
    public List<Usuario> listar() {
        try {
            logger.info("LISTA USUARIO DAO");
            
            ArrayList<Usuario> lista = new ArrayList<>();
            String query = "select nome,endereco,telefone,cnpj_cpf,tipo_usuario from usuario";

            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs =  stm.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setNome(rs.getString("nome"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setCnpj_cpf(rs.getString("cnpj_cpf"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));

                lista.add(usuario);
            }

            rs.close();
            stm.close();
            conn.close();

            return lista;

        }catch (SQLException e){
            System.err.println("ERROR BUSCANDO TODAS OS USUARIO.");
            logger.error("ERROR LISTAR USUARIO DAO");
            System.exit(0);
        }
        return null;
    }

  
    @Override
    public List<Usuario> buscar(String value) {
        try {
            logger.info("BUSCA USUARIO DAO");
            
            ArrayList<Usuario> lista = new ArrayList<>();
            String query = "select nome,endereco,telefone,cnpj_cpf,tipo_usuario from usuario where cnpj_cpf = '"+value+"'";

            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs =  stm.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setNome(rs.getString("nome"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setCnpj_cpf(rs.getString("cnpj_cpf"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));

                lista.add(usuario);
            }

            rs.close();
            stm.close();
            //conn.close();
            return lista;

        }catch (SQLException e){
            System.err.println("ERROR BUSCANDO CONTA COM VALUE => " + value);
            logger.error("ERROR BUSCAR USUARIO DAO");
            System.exit(0);
        }
        return null;
    }
    
    
    public void acessoSistema(Usuario usuario){
        
        try {
            
            logger.info("ACESSO AO SISTEMA USUARIO DAO");
            
            String query = "select nome,endereco,telefone,cnpj_cpf,tipo_usuario from usuario where telefone = ?";
            PreparedStatement stm = conn.prepareStatement(query);
            //stm.setString(1, value);
            ResultSet rs =  stm.executeQuery();
            rs.next();

            usuario.setNome(rs.getString("nome"));
            usuario.setEndereco(rs.getString("endereco"));
            usuario.setTelefone(rs.getString("telefone"));
            usuario.setCnpj_cpf(rs.getString("cnpj_cpf"));
            usuario.setTipoUsuario(rs.getString("tipo_usuario"));

            stm.close();
            //conn.close();
            
        } catch (SQLException e){
            System.err.println("ERROR LOGIN ");
            logger.error("ERROR ACESSO AO SISTEMA USUARIO DAO");
            System.exit(0);
        }
    }
    
    
    public String veirificarSeCpfCjpjExiste(String valor){
       try{
           logger.info("CPF OU CNPJ JÁ EXISTE USUARIO DAO");
           
           String query = "SELECT cnpj_cpf FROM usuario WHERE cnpj_cpf = '"+valor+"'";
           PreparedStatement stm = conn.prepareStatement(query);
           stm.setString(1, valor);
           ResultSet rs = stm.executeQuery();
           
           if(rs.next()){
               return rs.getString(1);
               //usuario.setCnpj_cpf(rs.getString("cnpj_cpf"));;
           }
           
       }catch(SQLException e ){
           e.printStackTrace();
           System.err.println("ERROR veirificarSeCpfCjpjExiste DAO ");
           logger.error("ERROR CPF OU CNPJ JÁ EXISTE USUARIO DAO");
       }
    return null;
    }
}

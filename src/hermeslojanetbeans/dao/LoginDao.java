package hermeslojanetbeans.dao;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

    private Connection conn;

    public LoginDao() throws SQLException {
        conn = ConnectionFactory.getConnection();
    }

    public void getUsuarioLogado(String login, String senha){

        //Login login;

        try {

            String query = "select * from usuario where = ? and ";



            PreparedStatement stm = conn.prepareStatement(query);
           // stm.setString(1, value);
            ResultSet rs =  stm.executeQuery();
            rs.next();

           /* produto.setEstilo(rs.getString("estilo"));
            produto.setTamanho(rs.getString("tamanho"));
            produto.setEstampa(rs.getString("estampa"));
            produto.setCor(rs.getString("cor"));
            produto.setModelo(rs.getString("modelo"));
            produto.setQuantidade(rs.getInt("quantidade"));*/

            stm.close();

        }catch (SQLException e){
            System.err.println("ERROR BUSCANDO CONTA COM VALOR => ");
            System.exit(0);
        }

        //return produto;
        //return produto;

    }
}

package hermeslojanetbeans.dao;

import hermeslojanetbeans.controller.ProdutoController;
import hermeslojanetbeans.interfaceSistema.IntercafeProduto;
import hermeslojanetbeans.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDao implements IntercafeProduto {
    
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ProdutoDao.class.getName());

    Connection conn;

    public ProdutoDao() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void salvar(Produto produto) {
        try {
            String query ="INSERT INTO produto( estilo, tamanho, estampa, cor, modelo,quantidade,codigo, descricao)VALUES(?,?,?,?,?,?,?,?)";

            try (PreparedStatement stm = conn.prepareStatement(query)) {

                stm.setString(1, produto.getEstilo());
                stm.setString(2, produto.getTamanho());
                stm.setString(3, produto.getEstampa());
                stm.setString(4, produto.getCor());
                stm.setString(5, produto.getModelo());
                stm.setInt(6, produto.getQuantidade());
                stm.setInt(7, produto.getCodigo());
                stm.setString(8, produto.getDescricao());
                stm.executeUpdate();

                stm.close();
            }
            //conn.close();

        }catch (SQLException e){
            System.err.println("ERROR SALVANDO PRODUTO");
            System.exit(0);
        }
    }

    
    @Override
    public void delete(int value) {
        try {
            String query = "delete from produto where codigo = ?";
            
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, value);
            stm.executeUpdate();
            //stm.close();
            

        }catch (SQLException ex){
            ex.printStackTrace();
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
        
    }

    @Override
    public void update(Produto roupa) {
        try {
            String query = "UPDATE produto set  codigo = ?, estilo = ?, tamanho = ?, estampa = ?,cor = ?,modelo = ?,quantidade = ?, descricao = ? where codigo = ?";
            PreparedStatement stm = conn.prepareStatement(query);

            stm.setInt(1, roupa.getCodigo());
            stm.setString(2, roupa.getEstilo());
            stm.setString(3, roupa.getTamanho());
            stm.setString(4, roupa.getEstampa());
            stm.setString(5, roupa.getCor());
            stm.setString(6, roupa.getModelo());
            stm.setInt(7, roupa.getQuantidade());
            stm.setString(8, roupa.getDescricao());
            stm.setInt(9, roupa.getCodigo());

            stm.executeUpdate();
            stm.close();
            //conn.close();

        }catch (SQLException ex){
            ex.printStackTrace();
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }

    @Override
    public List<Produto> listar() {
        try {
            ArrayList<Produto> lista = new ArrayList<>();

            String query = "select codigo, estilo, tamanho, estampa, cor, modelo, quantidade, descricao from produto";

            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs =  stm.executeQuery();
            while (rs.next()){
                Produto produto = new Produto();

                produto.setCodigo(rs.getInt("codigo"));
                produto.setEstilo(rs.getString("estilo"));
                produto.setTamanho(rs.getString("tamanho"));
                produto.setEstampa(rs.getString("estampa"));
                produto.setCor(rs.getString("cor"));
                produto.setModelo(rs.getString("modelo"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setDescricao(rs.getString("descricao"));
                lista.add(produto);
            }

            rs.close();
            stm.close();

            return lista;

        }catch (SQLException e){
            System.err.println("ERROR BUSCANDO TODAS OS PRODUTOS.");
            System.exit(0);
        }

        return null;
    }

   
    public List<Produto> buscar(String value) {

        
        try {
            List<Produto> lista = new ArrayList<>();
            String query = "select codigo,estilo, tamanho, estampa, cor, modelo, quantidade,  descricao from produto where codigo = "+Integer.valueOf(value)+"";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs =  stm.executeQuery();
           
             while (rs.next()){
                Produto produto = new Produto();
                
                produto.setCodigo(rs.getInt("codigo"));
                produto.setEstilo(rs.getString("estilo"));
                produto.setTamanho(rs.getString("tamanho"));
                produto.setEstampa(rs.getString("estampa"));
                produto.setCor(rs.getString("cor"));
                produto.setModelo(rs.getString("modelo"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setDescricao(rs.getString("descricao"));
                lista.add(produto);

            };

            rs.close();
            stm.close();
            return lista;

        }catch (SQLException e){
            System.err.println("ERROR BUSCANDO CONTA COM VALOR => " + value);
            System.exit(0);
        }
        return null;
    }

    public List<Produto> getBuscarProdutoDescicao(String value){
        try {

            ArrayList<Produto> lista = new ArrayList<>();
            String query = "select estilo, tamanho, estampa, cor, modelo, quantidade, codigo, descricao from produto where descricao LIKE '%"+value+"%'";

            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs =  stm.executeQuery();
            while (rs.next()){
                Produto produto = new Produto();

                produto.setEstilo(rs.getString("estilo"));
                produto.setTamanho(rs.getString("tamanho"));
                produto.setEstampa(rs.getString("estampa"));
                produto.setCor(rs.getString("cor"));
                produto.setModelo(rs.getString("modelo"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setCodigo(rs.getInt("codigo"));
                produto.setDescricao(rs.getString("descricao"));
                lista.add(produto);
            }

            rs.close();
            stm.close();

            return lista;

        }catch (SQLException e){
            System.err.println("ERROR BUSCANDO CONTA COM VALOR => " + value);
            System.exit(0);
        }
        return null;
    }

    public List<Produto> getBuscarProdutoModelo(String value){

        try {
            
            ArrayList<Produto> lista = new ArrayList<>();

            String query = "select estilo, tamanho, estampa, cor, modelo, quantidade, codigo, descricao from produto where modelo LIKE '%"+value+"%'";

            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs =  stm.executeQuery();
            while (rs.next()){
                Produto produto = new Produto();

                produto.setEstilo(rs.getString("estilo"));
                produto.setTamanho(rs.getString("tamanho"));
                produto.setEstampa(rs.getString("estampa"));
                produto.setCor(rs.getString("cor"));
                produto.setModelo(rs.getString("modelo"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setCodigo(rs.getInt("codigo"));
                produto.setDescricao(rs.getString("descricao"));
                lista.add(produto);
            }

            rs.close();
            stm.close();

            return lista;


        }catch (SQLException e){
            System.err.println("ERROR BUSCANDO CONTA COM VALOR => " + value);
            System.exit(0);
        }
        return null;

    }

    public List<Produto> getBuscarProdutoDescricaoModelo(String desc, String model){

        try {
            logger.info("BUSCANDO PRODUTO DESCRICAO MODELO");
            
            ArrayList<Produto> lista = new ArrayList<>();
            String query = "select estilo, tamanho, estampa, cor, modelo, quantidade, codigo, descricao from produto where modelo LIKE '%"+desc+"%' and descricao  LIKE '%"+model+"%'";

            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs =  stm.executeQuery();
            while (rs.next()){
                Produto produto = new Produto();

                produto.setEstilo(rs.getString("estilo"));
                produto.setTamanho(rs.getString("tamanho"));
                produto.setEstampa(rs.getString("estampa"));
                produto.setCor(rs.getString("cor"));
                produto.setModelo(rs.getString("modelo"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setCodigo(rs.getInt("codigo"));
                produto.setDescricao(rs.getString("descricao"));
                lista.add(produto);
            }

            rs.close();
            stm.close();

            return lista;

        }catch (SQLException e){
            System.err.println("ERROR BUSCANDO CONTA COM VALOR => " + desc + " = " + model);
            logger.error("ERROR BUSCANDO PRODUTO DESCRICAO MODELO");
            System.exit(0);
        }
        return null;

    }

  /*  public int getQuanntidadeProduto(String value){
        Roupa roupa = null;
        try {

            String query = "select quantidade from produto where estampa = ?";

            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, value);
            ResultSet rs =  stm.executeQuery();
            rs.next();

            roupa.setQuantidade(rs.getInt("quantidade"));

            stm.close();

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("ERROR PEGAR QUANTIDADE ROUPA NO BANCO VALOR => " + value);
            System.exit(0);
        }
        return roupa;


    }
*/

}

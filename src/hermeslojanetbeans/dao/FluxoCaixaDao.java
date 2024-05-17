package hermeslojanetbeans.dao;

import hermeslojanetbeans.interfaceSistema.InterfaceFluxoCaixa;
import hermeslojanetbeans.model.FluxoCaixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FluxoCaixaDao implements InterfaceFluxoCaixa {

    private Connection conn;

    public FluxoCaixaDao() {
        conn = ConnectionFactory.getConnection();
    }

    /**
     *
     * @param fluxo
     */
    @Override
    public void salvar(FluxoCaixa fluxo) {
        try {
            String query ="INSERT INTO fluxo_caixa(descricao,tipo,valor,data_movimento)VALUES(?,?,?,?)";

            try (PreparedStatement stm = conn.prepareStatement(query)) {
                stm.setString(1, fluxo.getTipo());
                stm.setString(2, fluxo.getValor());
                stm.setString(3, fluxo.getData());
                stm.setString(4, fluxo.getDescricao());

                stm.executeUpdate();

//                stm.close();
            }
            //conn.close();

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("ERROR SALVANDO FLUXO CAIXA");
            System.exit(0);
        }

    }

    @Override
    public void delete(String value) {
        try {
            String query = "delete from fluxo_caixa where estampa = ?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, value);
            stm.executeUpdate();
            stm.close();

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("ERROR DELETE FLUXO CAIXA");
            System.exit(0);
        }

    }

    @Override
    public void update(FluxoCaixa fluxo) {
        try {
            String query = "UPDATE fluxo_caixa set descricao = ?, data_movimento = ?, tipo = ?, valor = ? where id = ?";
            PreparedStatement stm = conn.prepareStatement(query);

            stm.setString(1, fluxo.getDescricao());
            stm.setString(2, fluxo.getData());
            stm.setString(3, fluxo.getTipo());
            stm.setString(4, fluxo.getValor());
            
            stm.executeUpdate();
            stm.close();

        }catch (SQLException e){
            System.err.println("ERROR UPDATE FLUXO CAIXA");
            System.exit(0);
        }

    }

    @Override
    public List<FluxoCaixa> listar() {
        try {
            ArrayList<FluxoCaixa> lista = new ArrayList<>();
            String query = "select descricao, tipo, data_movimento, valor from fluxo_caixa";

            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs =  stm.executeQuery();
            while (rs.next()){
                FluxoCaixa fluxoCaixa = new FluxoCaixa();
                fluxoCaixa.setValor(rs.getString("descricao"));
                fluxoCaixa.setDescricao(rs.getString("tipo"));
                fluxoCaixa.setTipo(rs.getString("data_movimento"));
                fluxoCaixa.setData(rs.getString("valor"));
                
                
                lista.add(fluxoCaixa);
            }

            rs.close();
            stm.close();

            return lista;

        }catch (SQLException e){
            System.err.println("ERROR LISTA FLUXO CAIXA");
            System.exit(0);
        }
        return null;
    }

    @Override
    public FluxoCaixa buscar(String value) {
        try {
            FluxoCaixa fluxoCaixa = null;

            String query = "select tipo, data_movimento,descricao, valor from fluxo_caixa where estampa = ?";

            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, value);
            ResultSet rs =  stm.executeQuery();
            rs.next();

            fluxoCaixa.setDescricao(rs.getString("descricao"));
            fluxoCaixa.setTipo(rs.getString("tipo"));
            fluxoCaixa.setValor(rs.getString("valor"));
            fluxoCaixa.setData(rs.getString("data_movimento"));

            stm.close();

        }catch (SQLException e){
            System.err.println("ERROR BUSCAR FLUXO CAIXA");
            System.exit(0);
        }
        return null;
    }

    public void getSomaValorPorMes(String dataInicio, String dataFim){
        try {

            String query ="select sum(valor) from fluxo_caixa where data BETWEEN '"+dataInicio+"' and '"+dataFim+"' ";
            PreparedStatement stm = conn.prepareStatement(query);

        }catch (SQLException e){
            System.err.println("ERROR SOMA DO VALOR POR MES FLUXO CAIXA");
            System.exit(0);
        }
    }
    
    public List<FluxoCaixa> buscarEntraSaida(String entradaSaida){
        
        try {
            List<FluxoCaixa> lista = new ArrayList<>();
            String query ="select descricao, tipo, data_movimento, valor from fluxo_caixa where tipo = '"+entradaSaida+"' ";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs =  stm.executeQuery();
           
            while (rs.next()){
                FluxoCaixa fluxoCaixa = new FluxoCaixa();
                fluxoCaixa.setValor(rs.getString("descricao"));
                fluxoCaixa.setDescricao(rs.getString("tipo"));
                fluxoCaixa.setTipo(rs.getString("data_movimento"));
                fluxoCaixa.setData(rs.getString("valor"));
                lista.add(fluxoCaixa);

            };

            rs.close();
            stm.close();
            return lista;
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("ERROR SOMA DO VALOR POR MES FLUXO CAIXA");
            System.exit(0);
        }
        
        return null;
    }
    
    public List<FluxoCaixa> buscarEntraSaidaData(String entradaSaida, String dataInicio, String dataFim){
         try {
            List<FluxoCaixa> lista = new ArrayList<>();
            String query ="select descricao, tipo, data_movimento, valor where data BETWEEN '"+dataInicio+"' and '"+dataFim+"' and tipo= '"+entradaSaida+"'";
             
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs =  stm.executeQuery();
           
            while (rs.next()){
                FluxoCaixa fluxoCaixa = new FluxoCaixa();
                
                fluxoCaixa.setValor(rs.getString("descricao"));
                fluxoCaixa.setDescricao(rs.getString("tipo"));
                fluxoCaixa.setTipo(rs.getString("data_movimento"));
                fluxoCaixa.setData(rs.getString("valor"));
                lista.add(fluxoCaixa);

            };

            rs.close();
            stm.close();
            return lista;
            
        } catch (SQLException e) {
            System.err.println("ERROR SOMA DO VALOR POR MES FLUXO CAIXA");
            System.exit(0);
        }
        return null;
        
    }
    
    //public List<FluxoCaixa> buscarData(Date dataInicio, Date dataFim){
    
    
    public List<FluxoCaixa> buscarData(String dataInicio, String dataFim){
         try {
             
            List<FluxoCaixa> lista = new ArrayList<>();
            String query ="SELECT descricao, tipo, data_movimento, valor from fluxo_caixa WHERE descricao BETWEEN '"+dataInicio+"' AND '"+dataFim+"'";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs =  stm.executeQuery();
           
            while (rs.next()){
                FluxoCaixa fluxoCaixa = new FluxoCaixa();
                
                fluxoCaixa.setValor(rs.getString("descricao"));
                fluxoCaixa.setDescricao(rs.getString("tipo"));
                fluxoCaixa.setTipo(rs.getString("data_movimento"));
                fluxoCaixa.setData(rs.getString("valor"));
                lista.add(fluxoCaixa);

            };

            rs.close();
            stm.close();
            return lista;
            
        } catch (SQLException e) {
            System.err.println("ERROR SOMA DO VALOR POR MES FLUXO CAIXA");
            System.exit(0);
        }
        return null;
    }
}

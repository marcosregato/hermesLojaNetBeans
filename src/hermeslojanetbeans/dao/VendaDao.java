package hermeslojanetbeans.dao;

import hermeslojanetbeans.interfaceSistema.InterfaceVenda;
import hermeslojanetbeans.model.Usuario;
import hermeslojanetbeans.model.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDao implements InterfaceVenda {

    private Connection conn;

    public VendaDao()  {
        conn = ConnectionFactory.getConnection();
    }


    @Override
    public void salvar(Venda venda) {

        try {
            String query ="INSERT INTO venda_produto(pagamento, quantidade)VALUES(?,?)";

            try (PreparedStatement stm = conn.prepareStatement(query)) {

                stm.setString(1, venda.getTipoPagamento());
                stm.setInt(2, venda.getQuantidada());

                stm.executeUpdate();

                stm.close();
            }
            //conn.close();

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("ERROR SALVANDO VENDA");
            System.exit(0);
        }

    }

    @Override
    public void delete(String value) {

        try {
            String query = "delete from venda_produto where telefone = ?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, value);

            stm.executeUpdate();
            stm.close();
            //conn.close();

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("ERROR APAGANDO VENDA COM VALUE => " + value);
            System.exit(0);
        }

    }

    @Override
    public void update(Venda venda) {

        try {
            String query = "UPDATE venda_produto set pagamento = ?, quantidada = ? where telefone = ?";
            PreparedStatement stm = conn.prepareStatement(query);

            stm.setString(1, venda.getTipoPagamento());
            stm.setInt(2, venda.getQuantidada());
            stm.executeUpdate();

            stm.close();
            //conn.close();

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("ERROR ATUALIZANDO VENDA COM ID " + venda.getTipoPagamento());
            System.exit(0);
        }

    }

    @Override
    public List<Venda> listar() {
        try {
            ArrayList<Venda> lista = new ArrayList<>();

            String query = "select * from venda_produto";

            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs =  stm.executeQuery();
            while (rs.next()){
                Venda venda = new Venda();

                venda.setId(rs.getInt("id"));
                venda.setTipoPagamento(rs.getString("pagamento"));
                venda.setQuantidada(rs.getInt("quantidade"));
                lista.add(venda);

            }

            rs.close();
            stm.close();
            //conn.close();

            return lista;

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("ERROR BUSCANDO TODAS OS VENDA.");
            System.exit(0);
        }

        return null;
    }

    @Override
    public Venda buscar(String value) {
        Venda venda = null;
        try {

            String query = "select pagamento, quantidade from venda where telefone = ?";

            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, value);
            ResultSet rs =  stm.executeQuery();
            rs.next();

            venda.setTipoPagamento(rs.getString("tipo_pagamenti"));
            venda.setQuantidada(rs.getInt("quantidade"));

            stm.close();
            //conn.close();

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("ERROR BUSCANDO CONTA COM VALUE => " + value);
            System.exit(0);
        }
        return venda;
    }
}

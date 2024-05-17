package hermeslojanetbeans.controller;

import hermeslojanetbeans.dao.FluxoCaixaDao;
import hermeslojanetbeans.model.FluxoCaixa;

public class FluxoCaixaController {

    FluxoCaixaDao dao = new FluxoCaixaDao();

    public void actionBtSalvar(FluxoCaixa fluxo) {
        try {
            if(fluxo != null){
                dao.salvar(fluxo);
            }
                
            
                 
        }catch (Exception e ){
            e.printStackTrace();
            //System.err.println("ERRO >>> " + e.getMessage());
        }
    }

    public void actionBtExcluir(String estampa) {
        try {
            dao.delete(estampa);
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    void actionBtEditar(FluxoCaixa fluxo) {
        try {
            dao.update(fluxo);
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public void listar() {

        try {
            /*colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
            colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
            colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
            colData.setCellValueFactory(new PropertyValueFactory<>("data"));
            tabelaFluxoCaixa.refresh();*/

        }catch (Exception e){
            System.out.println(">>>>> " + e.getMessage());
        }
    }

    void getLinhaTabela() {

        /*FluxoCaixa fluxoCaixa = tabelaFluxoCaixa.getSelectionModel().getSelectedItem();
        colDescricao.setText(String.valueOf(fluxoCaixa.getId()));
        colTipo.setText(fluxoCaixa.getTipo());
        colValor.setText(fluxoCaixa.getValor());
        colData.setText(fluxoCaixa.getData());*/

    }
    
    public void buscarInfo(String tipo){
        try {
             dao.buscarEntraSaida(tipo);
        } catch (Exception e) {
        }
    }
    
    public void buscarInfo(String dataInicio, String dataFim){
        try {
         dao.buscarData(dataInicio,dataFim);
         } catch (Exception e) {
        }
    }
    
    public void buscarInfo(String tipo, String dataInicio, String dataFim){
        try {
         dao.buscarEntraSaidaData(tipo,dataInicio,dataFim);
         } catch (Exception e) {
        }
    }
}


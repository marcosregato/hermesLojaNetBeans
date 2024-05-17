package hermeslojanetbeans.controller;

import hermeslojanetbeans.dao.VendaDao;

import hermeslojanetbeans.model.Venda;

import java.net.URL;
import java.util.ResourceBundle;

public class VendaController {

    


    VendaDao dao = new VendaDao();

    
    void actionBtVender() {

        Venda venda = new Venda();
        pegaValoresDosCampos(venda);
        dao.salvar(venda);
        limpar();

    }

    void actionBtCancelar() {

    }

    public void initialize(URL location, ResourceBundle resources) {
      //  comboTipoPagamento.getItems().addAll("Dèbito", "Crédito");
    }

    public void limpar() {
        //txtQuantidadeVenda.clear();
        //comboTipoPagamento.valueProperty().set(null);
    }


    private void pegaValoresDosCampos(Venda venda) {

//        if(txtEstamapa.getText().length() == 0 ){
//            txtEstamapa.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
//            new animatefx.animation.Shake(txtEstamapa).play();
//        }


        //venda.setTipoPagamento(comboTipoPagamento.getValue());
        //venda.setQuantidada(Integer.valueOf(txtQuantidadeVenda.getText()));
       // roupa.setEstampa(txtEstamapa.getText());
    }
}

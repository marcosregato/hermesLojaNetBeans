package hermeslojanetbeans.controller;

//import dao.RoupaDao;
import hermeslojanetbeans.dao.ProdutoDao;

import hermeslojanetbeans.model.Produto;
import java.util.List;
import org.apache.log4j.Logger;


public class ProdutoController  {
    
    private static final Logger logger = Logger.getLogger(ProdutoController.class.getName());

    ProdutoDao dao = new ProdutoDao();

    public void actionBtSalvar(Produto produto) {
        try{ 
            dao.salvar(produto);
        }catch (Exception e){
            System.out.println(">>>>> " + e.getMessage());
        }
    }
    
    public void actionBtExcluir(int valor) {

        try {
            
            dao.delete(valor);
         
        }catch (NumberFormatException e){
            System.out.println(">>>>> " + e.getMessage());
        }
    }
    
    public void actionBtEditar(Produto produto) {

        try {
            dao.update(produto);
          
        }catch (Exception e){
            System.out.println(">>>>> " + e.getMessage());
        }
    }
    
    public void getValueCheckBox(){
//        if(checkBoxSim.isSelected()){
//            txtEstampa.setDisable(false);
//        }
           // txtEstamapa.setDisable(true);
    }

    public void actionByFechar() {
       // P5ane.exit();
    }

    public void actionBtVender() {
        // P5ane.exit();
        //HelloApplication.changeScreen("venda");
    }

    public void actionBtPesquisar() {

        
    }

    
    public List<Produto> buscar(String value) {

        try {
            if (value != null){
               return dao.buscar(value);
            }
        }catch (Exception e){
            System.out.println(">>>>> " + e.getMessage());
        }
        return null;
    }

}

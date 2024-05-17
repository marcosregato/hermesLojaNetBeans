/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hermeslojanetbeans.util;

import javax.swing.JOptionPane;

/**
 *
 * @author marcos
 */
public class MensagemAlerta {
    
    ValidarCampo validar = new ValidarCampo();
    
    public void msgCpfCnpjErrado(String tipo, String nome){
        if((tipo.equals("Usuário")) & (validar.isCpf(tipo) != false)){
            JOptionPane.showMessageDialog(null, "Uh-oh!", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
    }
    
}

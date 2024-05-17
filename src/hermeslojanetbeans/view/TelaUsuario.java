/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hermeslojanetbeans.view;

import hermeslojanetbeans.controller.UsuarioController;
import hermeslojanetbeans.dao.UsuarioDao;
import hermeslojanetbeans.model.Usuario;
import hermeslojanetbeans.util.ValidarCampo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcos
 */
public class TelaUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaUsuario
     */
    public TelaUsuario() {
        initComponents();
        comboTipoUsuario.setSelectedIndex(0);
        listar();
    }
    
    UsuarioController controller = new UsuarioController();
    Usuario usuario = new Usuario();
    ValidarCampo validar = new ValidarCampo();
  
    
    private void pegaValoresDosCampos(Usuario usuario) {
        usuario.setNome(txtNome.getText());
        usuario.setEndereco(txtEndereco.getText());
        usuario.setTelefone(txtTelefone.getText());
        usuario.setCnpj_cpf(txtCpnj_Cpf.getText());
        usuario.setTipoUsuario(comboTipoUsuario.getSelectedItem().toString());
            
    }
    
    
    public void limpar() {

        txtNome.setText("");
        txtEndereco.setText("");
        txtCpnj_Cpf.setText("");
        txtTelefone.setText("");
        comboTipoUsuario.setSelectedIndex(0);
    }
    
    public void listar(){
        
        UsuarioDao dao = new UsuarioDao();
        
        DefaultTableModel  model = (DefaultTableModel) tabelaUsuario.getModel();
        model.setRowCount(0);
        tabelaUsuario.setModel(model);
        List<Usuario> lista = dao.listar();
        Object[] objeto = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getNome();
            objeto[1] = lista.get(i).getEndereco();
            objeto[2] = lista.get(i).getTelefone();
            objeto[3] = lista.get(i).getTipoUsuario();
            objeto[4] = lista.get(i).getCnpj_cpf();
            
            model.addRow(objeto);
        }
        tabelaUsuario.setRowHeight(35);
        tabelaUsuario.setRowMargin(10);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        txtCpnj_Cpf = new javax.swing.JTextField();
        comboTipoUsuario = new javax.swing.JComboBox<>();
        txtEndereco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        msgAlerta = new javax.swing.JLabel();
        msgAlerta1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuario = new javax.swing.JTable();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        txtPesqCnpjCpf = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });

        txtCpnj_Cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpnj_CpfActionPerformed(evt);
            }
        });

        comboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------", "Usuário", "Fornecedor" }));
        comboTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome :");

        jLabel2.setText("Tipo de Uusário :");

        jLabel3.setText("Telefone :");

        jLabel4.setText("CNPJ / CPF :");

        jLabel5.setText("Endereço :");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ######-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        msgAlerta.setForeground(new java.awt.Color(255, 0, 51));

        msgAlerta1.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(msgAlerta1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(373, 373, 373))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(msgAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCpnj_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(comboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(txtCpnj_Cpf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msgAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(msgAlerta1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEndereco))
                .addContainerGap())
        );

        tabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Endereço", "Telefone", "Tipo de Usuário", "CNPJ / CPF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaUsuario);
        if (tabelaUsuario.getColumnModel().getColumnCount() > 0) {
            tabelaUsuario.getColumnModel().getColumn(0).setResizable(false);
            tabelaUsuario.getColumnModel().getColumn(1).setResizable(false);
            tabelaUsuario.getColumnModel().getColumn(2).setResizable(false);
            tabelaUsuario.getColumnModel().getColumn(3).setResizable(false);
            tabelaUsuario.getColumnModel().getColumn(4).setResizable(false);
        }

        btEditar.setText("EDITAR");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("EXCLUIR");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btSalvar.setText("SALVAR");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btFechar.setText("FECHAR");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        txtPesqCnpjCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesqCnpjCpfActionPerformed(evt);
            }
        });

        btPesquisar.setText("PESQUISAR");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        jLabel6.setText("Pesquisar :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFechar)
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesqCnpjCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPesquisar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPesqCnpjCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditar)
                    .addComponent(btExcluir)
                    .addComponent(btSalvar)
                    .addComponent(btFechar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCpnj_CpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpnj_CpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpnj_CpfActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:
        int numeroIndexCombo = comboTipoUsuario.getSelectedIndex();
        if((validar.selectItemComboBox(numeroIndexCombo) != false) ||
           (comboTipoUsuario.getSelectedItem().toString().equals("Usuário")) ||
           (validar.validarCpjCnpj(txtCpnj_Cpf.getText()).equals("CPF"))){
           // if((comboTipoUsuario.getSelectedItem().toString().equals("Usuário"))&(validar.validarCpjCnpj(txtCpnj_Cpf.getText()).equals("CPF"))){
                
                    pegaValoresDosCampos(usuario);
                    controller.actionBtSalvar(usuario);
                    limpar();
                    listar();
             //  }
            
        }else if((validar.selectItemComboBox(numeroIndexCombo) != false) ||
           (comboTipoUsuario.getSelectedItem().toString().equals("Usuário")) ||
           (validar.validarCpjCnpj(txtCpnj_Cpf.getText()).equals("CPF"))){
            //if(((comboTipoUsuario.getSelectedItem().toString().equals("Fornecedor"))&(validar.validarCpjCnpj(txtCpnj_Cpf.getText()).equals("CNPJ")))){
                    pegaValoresDosCampos(usuario);
                    controller.actionBtSalvar(usuario);
                    limpar();
                    listar();
                //} 
            
        }else{
            JOptionPane.showMessageDialog(null, "O número CPF ou CNPJ está errado", "Error", JOptionPane.ERROR_MESSAGE);
        }
   
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        DefaultTableModel  model = (DefaultTableModel) tabelaUsuario.getModel();
         int row = tabelaUsuario.getSelectedRow();
         
         System.out.println(">>> " +tabelaUsuario.getValueAt(row, 4));
         
         controller.actionBtExcluir(tabelaUsuario.getValueAt(row, 4).toString().trim());
         listar();
         limpar();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void tabelaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaUsuarioMouseClicked
        // TODO add your handling code here:
        int linhaTabela = tabelaUsuario.getSelectedRow();
        DefaultTableModel  model = (DefaultTableModel) tabelaUsuario.getModel();
        txtNome.setText(model.getValueAt(linhaTabela, 0).toString());
        txtEndereco.setText(model.getValueAt(linhaTabela, 1).toString());
        txtTelefone.setText(model.getValueAt(linhaTabela, 2).toString());
        //comboTipoUsuario.getEditor().setItem(model.getValueAt(linhaTabela, 3).toString());
        
        String comboTipo = model.getValueAt(linhaTabela, 3).toString();
        for(int x=0; x < comboTipoUsuario.getItemCount(); x++){
            if(comboTipoUsuario.getItemAt(x).toString().equalsIgnoreCase(comboTipo)){
                comboTipoUsuario.setSelectedIndex(x);
                
            }
        }
        
        txtCpnj_Cpf.setText(model.getValueAt(linhaTabela, 4).toString());
    }//GEN-LAST:event_tabelaUsuarioMouseClicked

    private void comboTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoUsuarioActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // TODO add your handling code here:
         pegaValoresDosCampos(usuario);
         controller.actionBtEditar(usuario);
         limpar();
         listar();
        
    }//GEN-LAST:event_btEditarActionPerformed

    private void txtPesqCnpjCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesqCnpjCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesqCnpjCpfActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        // TODO add your handling code here:
        try {
            
            if(txtPesqCnpjCpf.getText()!= null){
                 UsuarioDao dao = new UsuarioDao();
        
            DefaultTableModel  model = (DefaultTableModel) tabelaUsuario.getModel();
            model.setRowCount(0);
             tabelaUsuario.setModel(model);
            List<Usuario> lista = dao.buscar(txtPesqCnpjCpf.getText());
            Object[] objeto = new Object[8];
            for (int i = 0; i < lista.size(); i++) {
                objeto[0] = lista.get(i).getNome();
                objeto[1] = lista.get(i).getEndereco();
                objeto[2] = lista.get(i).getTelefone();
                objeto[3] = lista.get(i).getTipoUsuario();
                objeto[4] = lista.get(i).getCnpj_cpf();
                
                model.addRow(objeto);
            }
            tabelaUsuario.setRowHeight(35);
            tabelaUsuario.setRowMargin(10);
                
            }else{
                listar();
            }
            
            
        
        } catch (Exception e) {
            System.err.println("ERRO >> "+ e.getMessage());
           
    }
        
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> comboTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel msgAlerta;
    private javax.swing.JLabel msgAlerta1;
    private javax.swing.JTable tabelaUsuario;
    private javax.swing.JTextField txtCpnj_Cpf;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesqCnpjCpf;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}

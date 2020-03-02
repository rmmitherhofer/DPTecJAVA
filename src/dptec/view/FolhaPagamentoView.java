
package dptec.view;

import Metodos.ValidaMes;
import dptec.controller.PagamentoController;
import dptec.model.FuncionarioModel;
import dptec.model.PagamentoModel;
import dptec.model.UsuarioModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FolhaPagamentoView extends javax.swing.JFrame {
    private int cduser;

    
    public FolhaPagamentoView() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void Load(FuncionarioModel fm){
            Calendar cal = Calendar.getInstance();
            lblNome.setText(fm.getNmfuncionario());
            lblMatricula.setText(String.valueOf(fm.getCdmatricula()));
            cmbAno.setSelectedItem(String.valueOf(cal.get(Calendar.YEAR)));
            ValidaMes vm = new ValidaMes(); 
            cmbMes.setSelectedItem(vm.MesNum(Integer.parseInt(String.valueOf(cal.get(Calendar.MONTH) + 1))));
    }
    
    public void loadUser(int cduser){
        this.cduser = cduser;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitColaborador = new javax.swing.JLabel();
        cmbAno = new javax.swing.JComboBox<>();
        cmbMes = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagamento = new javax.swing.JTable();
        lblMatricula = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consulta Folha de Pagamento");
        setResizable(false);

        lblTitColaborador.setText("Pagamentos do Colaborador:");

        cmbAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Ano", "2015", "2016", "2017", "2018", "2019" }));
        cmbAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAnoActionPerformed(evt);
            }
        });

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Mês", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        cmbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMesActionPerformed(evt);
            }
        });

        tblPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Tipo de Folha", "Competencia", "Data de Pagamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPagamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPagamento);

        lblMatricula.setText("matricula");

        lblNome.setText("nome");

        lblAno.setText("Ano: ");

        lblMes.setText("Mes");

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/voltar2.png"))); // NOI18N
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lblTitColaborador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMatricula)
                                .addGap(18, 18, 18)
                                .addComponent(lblNome))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(lblAno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(lblMes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 615, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitColaborador)
                    .addComponent(lblNome)
                    .addComponent(lblMatricula))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAno)
                    .addComponent(lblMes)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesActionPerformed
        if (cmbAno.getSelectedItem().equals("Selecione o Ano")){
            JOptionPane.showMessageDialog(null,"Selecione o Ano para Consulta");
            cmbAno.requestFocus();
        }else{ 
            PagamentoController pc = new PagamentoController(
                                                            Integer.parseInt(lblMatricula.getText())
                                                            ,Integer.parseInt(cmbAno.getSelectedItem().toString())
                                                            ,cmbMes.getSelectedItem().toString()                                            
                                                            );

            DefaultTableModel dtmPag = (DefaultTableModel) tblPagamento.getModel();
            dtmPag.setNumRows(0);

            List<PagamentoModel> listaPagamento = new ArrayList<PagamentoModel>();
            listaPagamento = pc.getlistaPagamento(
                                Integer.parseInt(lblMatricula.getText())
                                ,Integer.parseInt(cmbAno.getSelectedItem().toString())
                                ,cmbMes.getSelectedItem().toString()
                                ,null
                                );
            try{
            if (listaPagamento.size() > 0) {        
                for (PagamentoModel pml: listaPagamento){
                    dtmPag.addRow(new Object[]{
                    pml.getCdpagamento(),
                    pml.getDscategoria(),
                    pml.getDscompetencia(),
                    pml.getDtpagamento(),
                    });
                }
            }
            }catch(Exception e){
               //JOptionPane.showMessageDialog(null,"Demonstrativo de Pagamento ainda não está disponível. Folha de pagamento em processamento."); 
            }
        }
    }//GEN-LAST:event_cmbMesActionPerformed

    private void tblPagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPagamentoMouseClicked
        int i = tblPagamento.getSelectedRow();
        int cdpagamento = (Integer.parseInt(tblPagamento.getValueAt(i, 0).toString()));
        String categoria = (tblPagamento.getValueAt(i, 1).toString());
                
        DetalPagamentoView dpv = new DetalPagamentoView();
        dpv.Load(Integer.parseInt(lblMatricula.getText()), Integer.parseInt(cmbAno.getSelectedItem().toString()), cmbMes.getSelectedItem().toString(), cdpagamento, categoria, cduser);
        dpv.setVisible(true);        
    }//GEN-LAST:event_tblPagamentoMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void cmbAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAnoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FolhaPagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FolhaPagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FolhaPagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FolhaPagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FolhaPagamentoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbAno;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTitColaborador;
    private javax.swing.JTable tblPagamento;
    // End of variables declaration//GEN-END:variables
}

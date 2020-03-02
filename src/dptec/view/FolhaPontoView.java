
package dptec.view;

import Metodos.ValidaMes;
import dptec.controller.FolhaPontoController;
import dptec.dao.FolhaPontoDao;
import dptec.model.FolhaPontoModel;
import dptec.model.FuncionarioModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FolhaPontoView extends javax.swing.JFrame {
    private int cduser;
    public FolhaPontoView() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void Load(FuncionarioModel fm){
        Calendar cal = Calendar.getInstance();
        lbldsMatricula.setText(String.valueOf(fm.getCdmatricula()));
        lbldsNome.setText(fm.getNmfuncionario());
        lbldsCPF.setText(fm.getNocpf());
        
        ValidaMes vm = new ValidaMes();
        cmbAno.setSelectedItem(String.valueOf(cal.get(Calendar.YEAR))); 
        cmbMes.setSelectedItem(vm.MesNum(Integer.parseInt(String.valueOf(cal.get(Calendar.MONTH) + 1))));               
        
        FolhaPontoModel fpm = new FolhaPontoModel();
        fpm.setCdmatricula(Integer.parseInt(lbldsMatricula.getText().replace(".", ""). replace(",","". replace("-", "")).trim()));
        FolhaPontoDao fpd = new FolhaPontoDao();
        List<FolhaPontoModel> listaPontoCabecalho = new ArrayList<FolhaPontoModel>();
        listaPontoCabecalho = fpd.getListaPonto(fpm);
            if (listaPontoCabecalho.size() > 0) {
                for(FolhaPontoModel fLocal : listaPontoCabecalho){            
                    lblCompentenciaInicio.setText(fLocal.getDscompetencia());
                    lbldsStatus.setText(fLocal.getDsstatus());
                    lblSaldoHoras.setText(fLocal.getHrsaldo());                   
                }
            }
    }
    
    public void loadUser(int cduser){
        this.cduser = cduser;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPonto = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        cmbAno = new javax.swing.JComboBox<>();
        cmbMes = new javax.swing.JComboBox<>();
        lblMatricula = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCompentencia = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lbldsSaldoHoras = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lbldsMatricula = new javax.swing.JLabel();
        lbldsNome = new javax.swing.JLabel();
        lblCompentenciaInicio = new javax.swing.JLabel();
        lblSaldoHoras = new javax.swing.JLabel();
        lbldsCPF = new javax.swing.JLabel();
        lbldsStatus = new javax.swing.JLabel();
        btnMarcaPonto = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Folha de Ponto");
        setResizable(false);

        tblPonto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Dia", "Entrada", "Almoço", "Almoço Retorno", "Saida", "Marcação Entrada", "Marcação Almoço", "Marcação Retorno Almoço", "Marcação Saida", "Somatoria Horas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPonto);

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

        lblMatricula.setText("Matricula");

        lblNome.setText("Nome");

        lblCompentencia.setText("Competencia");

        lblStatus.setText("Status");

        lbldsSaldoHoras.setText("Saldo Horas");

        lblCPF.setText("CPF");

        lbldsNome.setText("name");

        lblCompentenciaInicio.setText("  /  /    ");

        lblSaldoHoras.setText("00:00");

        lbldsCPF.setText("   .   .   -  ");

        lbldsStatus.setText("Status");

        btnMarcaPonto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/OK.png"))); // NOI18N
        btnMarcaPonto.setText("Marcar Ponto");
        btnMarcaPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcaPontoActionPerformed(evt);
            }
        });

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/voltar2.png"))); // NOI18N
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMatricula)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbldsMatricula)
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldsNome)
                            .addComponent(lblNome)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCompentencia)
                        .addGap(22, 22, 22)
                        .addComponent(lblCompentenciaInicio)
                        .addGap(147, 147, 147)
                        .addComponent(lblStatus)
                        .addGap(18, 18, 18)
                        .addComponent(lbldsStatus)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(cmbAno, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMarcaPonto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFechar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldsCPF)
                            .addComponent(lblCPF)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbldsSaldoHoras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSaldoHoras)))
                        .addGap(266, 266, 266))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNome)
                        .addComponent(lblCPF)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldsMatricula)
                    .addComponent(lbldsNome)
                    .addComponent(lbldsCPF))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompentencia)
                    .addComponent(lblCompentenciaInicio)
                    .addComponent(lblStatus)
                    .addComponent(lbldsStatus)
                    .addComponent(lbldsSaldoHoras)
                    .addComponent(lblSaldoHoras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMarcaPonto)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMarcaPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcaPontoActionPerformed
        Calendar cal = Calendar.getInstance();
        String mes = null;
        int ano = 0;
        mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
        ano = cal.get(Calendar.YEAR);
        
        ValidaMes vm = new ValidaMes();
        mes = vm.MesNum(Integer.parseInt(mes));
       
        cmbMes.setSelectedItem(mes);
        cmbAno.setSelectedItem(String.valueOf(ano));              
        
        FolhaPontoController fpc = new FolhaPontoController(
                                                            mes
                                                            ,ano
                                                            ,Integer.parseInt(lbldsMatricula.getText())
                                                            ,null
                                                            ,0
                                                            );
            
        JOptionPane.showMessageDialog(null,fpc.MarcaPonto());           
            
        DefaultTableModel dtmPonto = (DefaultTableModel) tblPonto.getModel();
        dtmPonto.setNumRows(0);   
            
        List<FolhaPontoModel> listaRelPonto = new ArrayList<FolhaPontoModel>();
        listaRelPonto = fpc.getRelatorioPonto();
            if(listaRelPonto.size() > 0){
                for (FolhaPontoModel fpml: listaRelPonto){
                    dtmPonto.addRow(new Object[]{
                        fpml.getData(),
                        fpml.getDia(),
                        fpml.getHoraentradaref(),  
                        fpml.getHoraalmocoref(),  
                        fpml.getHoraretornoalmocoref(),
                        fpml.getHorasaida(),  
                        fpml.getMarcentrada(),
                        fpml.getMarcalmoco(),
                        fpml.getMarcretornalmoco(),  
                        fpml.getMarcsaida(), 
                        fpml.getHradicional(),  
                    });                     
                }                
            }                
            
            List<FolhaPontoModel> listaPontoCabecalho = new ArrayList<FolhaPontoModel>();
            listaPontoCabecalho = fpc.getListPonto();
            if (listaPontoCabecalho.size() > 0) {
                    for(FolhaPontoModel fLocal : listaPontoCabecalho){            
                        lblCompentenciaInicio.setText(fLocal.getDscompetencia());
                        lbldsStatus.setText(fLocal.getDsstatus());
                        lblSaldoHoras.setText(fLocal.getHrsaldo());

                    }
                }
    }//GEN-LAST:event_btnMarcaPontoActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void cmbAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnoActionPerformed
        
    }//GEN-LAST:event_cmbAnoActionPerformed

    private void cmbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesActionPerformed
        if (cmbAno.getSelectedItem().equals("Selecione o Ano")){
            JOptionPane.showMessageDialog(null,"Selecione o Ano para Consulta");
            cmbAno.requestFocus();
        }else{       
            FolhaPontoController fpc = new FolhaPontoController(
                                                                cmbMes.getSelectedItem().toString()
                                                                ,Integer.parseInt(cmbAno.getSelectedItem().toString())
                                                                ,Integer.parseInt(lbldsMatricula.getText())
                                                                ,null
                                                                ,0
                                                                );           
            DefaultTableModel dtmPonto = (DefaultTableModel) tblPonto.getModel();
            dtmPonto.setNumRows(0);  
            List<FolhaPontoModel> listaRelatorioPonto = new ArrayList<FolhaPontoModel>();
            listaRelatorioPonto = fpc.getRelatorioPonto();
            if (listaRelatorioPonto!= null){
                if(listaRelatorioPonto.size() > 0){
                    for (FolhaPontoModel lrpm: listaRelatorioPonto){
                       dtmPonto.addRow(new Object[]{
                        lrpm.getData(),
                        lrpm.getDia(),
                        lrpm.getHoraentradaref(),  
                        lrpm.getHoraalmocoref(),  
                        lrpm.getHoraretornoalmocoref(),
                        lrpm.getHorasaida(),  
                        lrpm.getMarcentrada(),
                        lrpm.getMarcalmoco(),
                        lrpm.getMarcretornalmoco(),  
                        lrpm.getMarcsaida(), 
                        lrpm.getHradicional(),  
                        });                     
                    }                
                }                
            
                List<FolhaPontoModel> listaCPonto = new ArrayList<FolhaPontoModel>();
                listaCPonto = fpc.getListPonto();
            
                if (listaCPonto.size() > 0) {
                    for(FolhaPontoModel lcp : listaCPonto){            
                        lblCompentenciaInicio.setText(lcp.getDscompetencia());
                        lbldsStatus.setText(lcp.getDsstatus());
                        lblSaldoHoras.setText(lcp.getHrsaldo());
                    }
                }
            }            
        }  
    }//GEN-LAST:event_cmbMesActionPerformed

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
            java.util.logging.Logger.getLogger(FolhaPontoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FolhaPontoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FolhaPontoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FolhaPontoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FolhaPontoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnMarcaPonto;
    private javax.swing.JComboBox<String> cmbAno;
    private javax.swing.JComboBox<String> cmbMes;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCompentencia;
    private javax.swing.JLabel lblCompentenciaInicio;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSaldoHoras;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lbldsCPF;
    private javax.swing.JLabel lbldsMatricula;
    private javax.swing.JLabel lbldsNome;
    private javax.swing.JLabel lbldsSaldoHoras;
    private javax.swing.JLabel lbldsStatus;
    private javax.swing.JTable tblPonto;
    // End of variables declaration//GEN-END:variables
}

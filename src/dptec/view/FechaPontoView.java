package dptec.view;

import Metodos.ValidaMes;
import dptec.dao.FolhaPontoDao;
import dptec.model.FolhaPontoModel;
import dptec.controller.FolhaPontoController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FechaPontoView extends javax.swing.JFrame {

    private int cduser;

    public FechaPontoView() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void Load(int cduser) {
        this.cduser = cduser;
        Calendar cal = Calendar.getInstance();
        cmbAno.setSelectedItem(String.valueOf(cal.get(Calendar.YEAR)));
        cmbStatus.setSelectedItem("Em Aberto");
        ValidaMes vm = new ValidaMes();
        cmbMes.setSelectedItem(vm.MesNum(Integer.parseInt(String.valueOf(cal.get(Calendar.MONTH)))));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaPonto = new javax.swing.JTable();
        btnFechaPonto = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        lbldscFechamentoPonto = new javax.swing.JLabel();
        cmbAno = new javax.swing.JComboBox<>();
        cmbMes = new javax.swing.JComboBox<>();
        cmbStatus = new javax.swing.JComboBox<>();
        lbldscAno = new javax.swing.JLabel();
        lbldscMes = new javax.swing.JLabel();
        lbldscStatus = new javax.swing.JLabel();
        lbldscFechamentoPonto1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Fechamento de Folha de Ponto");
        setResizable(false);

        tblListaPonto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Matricula", "Funcionário", "Função", "Setor", "Competência", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaPonto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaPontoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListaPonto);

        btnFechaPonto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/OK.png"))); // NOI18N
        btnFechaPonto.setText("Fechamento em Lote");
        btnFechaPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechaPontoActionPerformed(evt);
            }
        });

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/voltar2.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        lbldscFechamentoPonto.setText("Fechamento de Ponto");

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

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Em Aberto", "Em Analise", "Pendente de Aprovação", "Fechado" }));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        lbldscAno.setText("Ano");

        lbldscMes.setText("Mês");

        lbldscStatus.setText("Status");
        lbldscStatus.setToolTipText("");

        lbldscFechamentoPonto1.setText("Selecione o Registro do Funcionario que deseja realizar o Fechamento de Ponto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldscFechamentoPonto1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFechaPonto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVoltar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbldscFechamentoPonto)
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldscAno)
                            .addComponent(cmbAno, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldscMes)
                            .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldscStatus)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldscFechamentoPonto)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbldscAno)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbldscMes)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbldscStatus)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbldscFechamentoPonto1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechaPonto)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesActionPerformed
        if (cmbAno.getSelectedItem().equals("Selecione o Ano")) {
            JOptionPane.showMessageDialog(null, "Selecione o Ano para Consulta");
            cmbAno.requestFocus();
        } else if (cmbStatus.getSelectedItem().equals("Selecionar")) {
            JOptionPane.showMessageDialog(null, "Selecione o Ano para Consulta");
            cmbStatus.requestFocus();
        } else {
            FolhaPontoController fpc = new FolhaPontoController(
                    cmbMes.getSelectedItem().toString(),
                    Integer.parseInt(cmbAno.getSelectedItem().toString()),
                    0,
                    cmbStatus.getSelectedItem().toString(),
                    0
            );

            DefaultTableModel dtmPonto = (DefaultTableModel) tblListaPonto.getModel();
            dtmPonto.setNumRows(0);

            try {
                List<FolhaPontoModel> listaPonto = new ArrayList<FolhaPontoModel>();
                listaPonto = fpc.getListPonto();
                if (listaPonto.size() > 0) {
                    for (FolhaPontoModel lpm : listaPonto) {
                        dtmPonto.addRow(new Object[]{
                            lpm.getCdponto(),
                            lpm.getCdmatricula(),
                            lpm.getNmfuncionario(),
                            lpm.getDscargo(),
                            lpm.getDsdepartamento(),
                            lpm.getDscompetencia(),
                            lpm.getDsstatus()
                        });
                    }
                }
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null,"Não Existe Registro de Ponto Para Fechamento");
            }
        }
    }//GEN-LAST:event_cmbMesActionPerformed

    private void btnFechaPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechaPontoActionPerformed
        if (cmbAno.getSelectedItem().equals("Selecione o Ano")) {
            JOptionPane.showMessageDialog(null, "Selecione o Ano para Consulta");
            cmbAno.requestFocus();
        } else if (!cmbStatus.getSelectedItem().equals("Em Aberto")) {
            JOptionPane.showMessageDialog(null, "Só é possivel efetuar Fechamento de Ponto com Status Em Aberto");
            cmbStatus.requestFocus();
        } else {

            FolhaPontoController fpc = new FolhaPontoController(
                    cmbMes.getSelectedItem().toString(),
                    Integer.parseInt(cmbAno.getSelectedItem().toString()),
                    0,
                    cmbStatus.getSelectedItem().toString(),
                    0
            );
            int quant, i;
            String msg = null;
            quant = fpc.quantPonto();
            if (quant == 0) {
                msg = "Não Existe pontos a serem fechados";
            }
            for (i = 0; i < quant; i++) {
                do {
                    msg = null;
                    int cdponto = (Integer.parseInt(tblListaPonto.getValueAt(i, 0).toString()));
                    int matricula = (Integer.parseInt(tblListaPonto.getValueAt(i, 1).toString()));

                    FolhaPontoController fpcfechamento = new FolhaPontoController(
                            cmbMes.getSelectedItem().toString(),
                            Integer.parseInt(cmbAno.getSelectedItem().toString()),
                            matricula,
                            cmbStatus.getSelectedItem().toString(),
                            cdponto
                    );
                    msg = fpcfechamento.getFechaPontoLote();
                } while (msg == "Registros Atualizados com Sucesso");

            }

            if (msg.equals("Registros Atualizados com Sucesso")) {
                cmbStatus.setSelectedItem("Fechado");
            }
            cmbMes.setSelectedItem(cmbMes.getSelectedItem());
            JOptionPane.showMessageDialog(null, msg);
        }
    }//GEN-LAST:event_btnFechaPontoActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        if (!cmbStatus.equals("Selecionar")) {
            cmbMes.setSelectedItem(cmbMes.getSelectedItem());
        }
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void cmbAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnoActionPerformed
    }//GEN-LAST:event_cmbAnoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void tblListaPontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaPontoMouseClicked
        if (cmbAno.getSelectedItem().equals("Selecione o Ano")) {
            JOptionPane.showMessageDialog(null, "Selecione o Ano para Consulta");
            cmbAno.requestFocus();
        } else if (!cmbStatus.getSelectedItem().equals("Em Aberto")) {
            JOptionPane.showMessageDialog(null, "Só é possivel efetuar Fechamento de Ponto com Status Em Aberto");
            cmbStatus.requestFocus();
        } else {
            int i = tblListaPonto.getSelectedRow();
            int cdponto = (Integer.parseInt(tblListaPonto.getValueAt(i, 0).toString()));
            int matricula = (Integer.parseInt(tblListaPonto.getValueAt(i, 1).toString()));
            String msg = null;
            FolhaPontoController fpcfechamento = new FolhaPontoController(
                    cmbMes.getSelectedItem().toString(),
                    Integer.parseInt(cmbAno.getSelectedItem().toString()),
                    matricula,
                    cmbStatus.getSelectedItem().toString(),
                    cdponto
            );
            msg = fpcfechamento.getFechaPontoLote();

            if (msg.equals("Registros Atualizados com Sucesso")) {
                cmbStatus.setSelectedItem("Fechado");
            }
            cmbMes.setSelectedItem(cmbMes.getSelectedItem());
            JOptionPane.showMessageDialog(null, msg);
        }
    }//GEN-LAST:event_tblListaPontoMouseClicked

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
            java.util.logging.Logger.getLogger(FechaPontoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FechaPontoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FechaPontoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FechaPontoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FechaPontoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechaPonto;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbAno;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbldscAno;
    private javax.swing.JLabel lbldscFechamentoPonto;
    private javax.swing.JLabel lbldscFechamentoPonto1;
    private javax.swing.JLabel lbldscMes;
    private javax.swing.JLabel lbldscStatus;
    private javax.swing.JTable tblListaPonto;
    // End of variables declaration//GEN-END:variables
}

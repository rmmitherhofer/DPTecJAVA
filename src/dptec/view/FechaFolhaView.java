package dptec.view;

import Metodos.ValidaMes;
import dptec.controller.FolhaPagamentoController;
import dptec.model.FuncionarioModel;
import dptec.model.PagamentoModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FechaFolhaView extends javax.swing.JFrame {

    private int cduser;

    public FechaFolhaView() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void Load(int cduser) {
        this.cduser = cduser;
        Calendar cal = Calendar.getInstance();
        cmbAno.setSelectedItem(String.valueOf(cal.get(Calendar.YEAR)));
        cmbStatus.setSelectedItem("Ativo");
        ValidaMes vm = new ValidaMes();
        cmbMes.setSelectedItem(vm.MesNum(Integer.parseInt(String.valueOf(cal.get(Calendar.MONTH) + 1))));
        fechaQuinzena();
    }

    public void fechaQuinzena() {
        FolhaPagamentoController fpcfechamento = new FolhaPagamentoController(
                cmbMes.getSelectedItem().toString(),
                Integer.parseInt(cmbAno.getSelectedItem().toString()),
                0,
                cmbStatus.getSelectedItem().toString(),
                0
        );
        fpcfechamento.getFechaFolha();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaFolha = new javax.swing.JTable();
        lbldscFechamentoPonto1 = new javax.swing.JLabel();
        btnFechaFolha = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        lbldscFechamentoFolha = new javax.swing.JLabel();
        cmbAno = new javax.swing.JComboBox<>();
        cmbMes = new javax.swing.JComboBox<>();
        cmbStatus = new javax.swing.JComboBox<>();
        lbldscAno = new javax.swing.JLabel();
        lbldscMes = new javax.swing.JLabel();
        lbldscStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Fechamento de Folha de Pagamento");
        setResizable(false);

        tblListaFolha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Categoria", "Matricula", "Funcionário", "Função", "Setor", "Competência", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaFolha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaFolhaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListaFolha);

        lbldscFechamentoPonto1.setText("Selecione o Registro do Funcionario que deseja realizar o Fechamento da Folha");

        btnFechaFolha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/OK.png"))); // NOI18N
        btnFechaFolha.setText("Fechamento em Lote");
        btnFechaFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechaFolhaActionPerformed(evt);
            }
        });

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/voltar2.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        lbldscFechamentoFolha.setText("Fechamento de Folha de Pagamento");

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

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Ativo", "Desligado", "Inativo", "Férias" }));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        lbldscAno.setText("Ano");

        lbldscMes.setText("Mês");

        lbldscStatus.setText("Status Colaborador");
        lbldscStatus.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldscFechamentoPonto1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFechaFolha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVoltar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbldscFechamentoFolha)
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
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldscFechamentoFolha)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbldscFechamentoPonto1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFechaFolha)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblListaFolhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaFolhaMouseClicked
        if (cmbAno.getSelectedItem().equals("Selecione o Ano")) {
            JOptionPane.showMessageDialog(null, "Selecione o Ano para Consulta");
            cmbAno.requestFocus();
        } else if (!cmbStatus.getSelectedItem().equals("Ativo")) {
            JOptionPane.showMessageDialog(null, "Só é possivel efetuar Fechamento de Folha de Colaboradores ATIVOS");
            cmbStatus.requestFocus();
        } else {
            int i = tblListaFolha.getSelectedRow();
            int matricula = (Integer.parseInt(tblListaFolha.getValueAt(i, 2).toString()));
            String msg = null;
            FolhaPagamentoController fpcfechamento = new FolhaPagamentoController(
                    cmbMes.getSelectedItem().toString(),
                    Integer.parseInt(cmbAno.getSelectedItem().toString()),
                    matricula,
                    cmbStatus.getSelectedItem().toString(),
                    0
            );
            msg = fpcfechamento.getFechaFolha();

            if (msg.equals("Fechamento Mensal efetuado com sucesso!")) {
                cmbStatus.setSelectedItem("Fechado");
            }
            cmbMes.setSelectedItem(cmbMes.getSelectedItem());
            JOptionPane.showMessageDialog(null, msg);
        }
    }//GEN-LAST:event_tblListaFolhaMouseClicked

    private void btnFechaFolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechaFolhaActionPerformed
        if (cmbAno.getSelectedItem().equals("Selecione o Ano")) {
            JOptionPane.showMessageDialog(null, "Selecione o Ano para Consulta");
            cmbAno.requestFocus();
        } else if (!cmbStatus.getSelectedItem().equals("Ativo")) {
            JOptionPane.showMessageDialog(null, "Só é possivel efetuar Fechamento de Folha de Colaboradores ATIVOS");
            cmbStatus.requestFocus();
        } else {

            FolhaPagamentoController fpc = new FolhaPagamentoController(
                    cmbMes.getSelectedItem().toString(),
                    Integer.parseInt(cmbAno.getSelectedItem().toString()),
                    0,
                    cmbStatus.getSelectedItem().toString(),
                    0
            );
            int quant, i;
            String msg = null;
            quant = fpc.quantPag();
            if (quant == 0) {
                msg = "Não Existe Pagamentos a serem fechados";
            }
            for (i = 0; i < quant; i++) {
                do {
                    msg = null;
                    int cdpag = (Integer.parseInt(tblListaFolha.getValueAt(i, 0).toString()));
                    int matricula = (Integer.parseInt(tblListaFolha.getValueAt(i, 2).toString()));

                    FolhaPagamentoController fpcfechamento = new FolhaPagamentoController(
                            cmbMes.getSelectedItem().toString(),
                            Integer.parseInt(cmbAno.getSelectedItem().toString()),
                            matricula,
                            cmbStatus.getSelectedItem().toString(),
                            cdpag
                    );
                    msg = fpcfechamento.getFechaFolha();
                } while (msg == "Fechamento Mensal efetuado com sucesso!");

            }

            if (msg.equals("Fechamento Mensal efetuado com sucesso!")) {
                cmbStatus.setSelectedItem("Fechado");
            }
            cmbMes.setSelectedItem(cmbMes.getSelectedItem());
            JOptionPane.showMessageDialog(null, msg);
        }
    }//GEN-LAST:event_btnFechaFolhaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void cmbAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnoActionPerformed

    }//GEN-LAST:event_cmbAnoActionPerformed

    private void cmbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesActionPerformed
        if (cmbAno.getSelectedItem().equals("Selecione o Ano")) {
            JOptionPane.showMessageDialog(null, "Selecione o Ano para Consulta");
            cmbAno.requestFocus();
        } else if (cmbStatus.getSelectedItem().equals("Selecionar")) {
            JOptionPane.showMessageDialog(null, "Selecione o Status para Consulta");
            cmbStatus.requestFocus();
        } else {

            FolhaPagamentoController fpc = new FolhaPagamentoController(
                    cmbMes.getSelectedItem().toString(),
                    Integer.parseInt(cmbAno.getSelectedItem().toString()),
                    0,
                    cmbStatus.getSelectedItem().toString(),
                    0
            );

            DefaultTableModel dtmFolha = (DefaultTableModel) tblListaFolha.getModel();
            dtmFolha.setNumRows(0);

            List<PagamentoModel> listaPagamento = new ArrayList<PagamentoModel>();
            listaPagamento = fpc.listaPagamento();
            try {
                for (PagamentoModel lpm : listaPagamento) {
                    dtmFolha.addRow(new Object[]{
                        lpm.getCdpagamento(),
                        lpm.getDscategoria(),
                        lpm.getCdmatricula(),
                        lpm.getNmfuncionario(),
                        lpm.getDscargo(),
                        lpm.getDsdepartamento(),
                        lpm.getDtreferencia(),
                        lpm.getStatuspag(),
                        lpm.getDsstatus(),
                        lpm.getDtpagamento(),
                        lpm.getVltotalvencido(),
                        lpm.getVldesconto(),
                        lpm.getVlliquido()
                    });
                }
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_cmbMesActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        if (!cmbStatus.equals("Selecionar")) {
            cmbMes.setSelectedItem(cmbMes.getSelectedItem());
        }
    }//GEN-LAST:event_cmbStatusActionPerformed

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
            java.util.logging.Logger.getLogger(FechaFolhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FechaFolhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FechaFolhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FechaFolhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FechaFolhaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechaFolha;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbAno;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbldscAno;
    private javax.swing.JLabel lbldscFechamentoFolha;
    private javax.swing.JLabel lbldscFechamentoPonto1;
    private javax.swing.JLabel lbldscMes;
    private javax.swing.JLabel lbldscStatus;
    private javax.swing.JTable tblListaFolha;
    // End of variables declaration//GEN-END:variables
}

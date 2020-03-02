package dptec.view;

import dptec.controller.PagamentoController;
import dptec.dao.PagamentoDao;
import dptec.model.PagamentoModel;
import dptec.model.DetalPagamentoModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DetalPagamentoView extends javax.swing.JFrame {

    public DetalPagamentoView() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void Load(int cdmatricula, int ano, String mes, int cdpagamento, String categoria, int cduser){
        PagamentoController pc = new PagamentoController(
                                                        cdmatricula
                                                        ,ano
                                                        ,mes
                                                        );
        List<PagamentoModel> listaPagamento = new ArrayList<PagamentoModel>();
        listaPagamento = pc.getlistaPagamento(cdmatricula, ano, mes, categoria);
        try{
            if (listaPagamento.size() > 0) {        
                for (PagamentoModel pml: listaPagamento){
                    lblNmEmpresa.setText(pml.getNmrazaosocial());
                    lblCNPJ.setText(pml.getNocnpj());
                    lblMatricula.setText(String.valueOf(pml.getCdmatricula()));
                    lblNomeFunc.setText(pml.getNmfuncionario());
                    lblCargo.setText(pml.getDscargo());
                    lblCdDepartamento.setText(String.valueOf(pml.getCddepartamento() + " - "));
                    lblDsDepartamento.setText(pml.getDsdepartamento());
                    lblCentroCusto.setText(pml.getCdccusto());
                    lblCdbanco.setText(String.valueOf(pml.getCdbanco()+ " - "));
                    lblNmBanco.setText(pml.getNmbanco());
                    lblAgencia.setText(String.valueOf(pml.getNoagencia()));
                    lblConta.setText(pml.getNoconta() + " - ");
                    lblDigito.setText(String.valueOf(pml.getNodigito()));
                    lblSalario.setText("R$" + pml.getVlsalario());
                    lblDtReferencia.setText(pml.getDtreferencia());
                    lblDtPagamento.setText(pml.getDtpagamento());
                    lblVencimento.setText(String.valueOf("R$" + pml.getVltotalvencido()));
                    lblDesconto.setText(String.valueOf("R$" + pml.getVldesconto()));
                    lblLiquido.setText(String.valueOf("R$" + pml.getVlliquido()));
                }
            }            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRO ao listar Cabeçalho " + e.getMessage());
        }
        
        DefaultTableModel dtmDPag = (DefaultTableModel) tblDetalhamento.getModel();
        dtmDPag.setNumRows(0);
        
        List<DetalPagamentoModel> listaDPagamento = new ArrayList<DetalPagamentoModel>();
        listaDPagamento = pc.getDetalPagamento(cdpagamento, ano, mes);
        try{
            if(listaDPagamento.size() > 0){
                for (DetalPagamentoModel dpml: listaDPagamento){
                    dtmDPag.addRow(new Object[]{
                        dpml.getCdproduto(),
                        dpml.getDsproduto(),
                        dpml.getQuantidade(),
                        dpml.getVlvencimento(),
                        dpml.getVldesconto(),
                    });
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRO ao listar Detalhamento " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbldemonstrativo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalhamento = new javax.swing.JTable();
        btnImprimi = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbldscConta = new javax.swing.JLabel();
        lbldscSalario = new javax.swing.JLabel();
        lbldscReferencia = new javax.swing.JLabel();
        lblCentroCusto = new javax.swing.JLabel();
        lblCdbanco = new javax.swing.JLabel();
        lblNmBanco = new javax.swing.JLabel();
        lbldscempresa = new javax.swing.JLabel();
        lblAgencia = new javax.swing.JLabel();
        lbldscCNPJ = new javax.swing.JLabel();
        lblConta = new javax.swing.JLabel();
        lbldscMatricula = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        lbldscNome = new javax.swing.JLabel();
        lblDigito = new javax.swing.JLabel();
        lbldscCargo = new javax.swing.JLabel();
        lbldscCdDepartamento = new javax.swing.JLabel();
        lblNmEmpresa = new javax.swing.JLabel();
        lblCNPJ = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        lblNomeFunc = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblCdDepartamento = new javax.swing.JLabel();
        lblDsDepartamento = new javax.swing.JLabel();
        lbldscCCusto = new javax.swing.JLabel();
        lbldscCdBanco = new javax.swing.JLabel();
        lbldscAgencia = new javax.swing.JLabel();
        lblDtReferencia = new javax.swing.JLabel();
        lbldscpagamento = new javax.swing.JLabel();
        lblDtPagamento = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblDesconto = new javax.swing.JLabel();
        lblLiquido = new javax.swing.JLabel();
        lbldscVencimento = new javax.swing.JLabel();
        lbldscDesconto = new javax.swing.JLabel();
        lbldscLiquido = new javax.swing.JLabel();
        lblVencimento = new javax.swing.JLabel();
        lbldsctotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Detalhamento de Pagamento");
        setResizable(false);

        lbldemonstrativo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldemonstrativo.setText("Demonstrativo de Pagamento");

        tblDetalhamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Conta", "Quantidade", "Vencimentos", "Descontos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
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
        jScrollPane1.setViewportView(tblDetalhamento);

        btnImprimi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Imprimir.png"))); // NOI18N
        btnImprimi.setToolTipText("");
        btnImprimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimiActionPerformed(evt);
            }
        });

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/voltar2.png"))); // NOI18N
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        lbldscConta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldscConta.setText("Conta");

        lbldscSalario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldscSalario.setText("Salário");

        lbldscReferencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldscReferencia.setText("Referência");

        lblCentroCusto.setText("C.R.");

        lblCdbanco.setText("Banco");

        lblNmBanco.setText("Banco");

        lbldscempresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldscempresa.setText("Empresa");

        lblAgencia.setText("Agencia");

        lbldscCNPJ.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldscCNPJ.setText("CNPJ");

        lblConta.setText("Conta");

        lbldscMatricula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldscMatricula.setText("Matricula");

        lblSalario.setText("Salário");

        lbldscNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldscNome.setText("Nome");

        lblDigito.setText("Conta");

        lbldscCargo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldscCargo.setText("Função");

        lbldscCdDepartamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldscCdDepartamento.setText("Departamento");

        lblNmEmpresa.setText("Empresa");

        lblCNPJ.setText("CNPJ");

        lblMatricula.setText("Matricula");

        lblNomeFunc.setText("Nome");

        lblCargo.setText("Função");

        lblCdDepartamento.setText("Departamento");

        lblDsDepartamento.setText("Departamento");

        lbldscCCusto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldscCCusto.setText("C.R.");

        lbldscCdBanco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldscCdBanco.setText("Banco");

        lbldscAgencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldscAgencia.setText("Agencia");

        lblDtReferencia.setText("00/00/0000");

        lbldscpagamento.setText("Data de Pagamento: ");

        lblDtPagamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDtPagamento.setText("00/00/0000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbldscpagamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDtPagamento)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldscempresa)
                            .addComponent(lblNmEmpresa)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbldscCCusto)
                                    .addComponent(lblCentroCusto))
                                .addGap(127, 127, 127)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbldscCdBanco)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblCdbanco)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNmBanco))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbldscMatricula)
                                    .addComponent(lblMatricula))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbldscNome)
                                    .addComponent(lblNomeFunc))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldscCargo)
                            .addComponent(lblCargo)
                            .addComponent(lbldscAgencia)
                            .addComponent(lblCNPJ)
                            .addComponent(lbldscCNPJ)
                            .addComponent(lblAgencia))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblConta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDigito)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSalario))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbldscConta)
                                .addGap(164, 164, 164)
                                .addComponent(lbldscSalario)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbldscCdDepartamento)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblCdDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDsDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDtReferencia)
                                    .addComponent(lbldscReferencia))))
                        .addGap(118, 118, 118))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldscempresa)
                    .addComponent(lbldscCNPJ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNmEmpresa)
                    .addComponent(lblCNPJ))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbldscCdDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCdDepartamento)
                            .addComponent(lblDsDepartamento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbldscReferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDtReferencia))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbldscMatricula)
                            .addComponent(lbldscNome)
                            .addComponent(lbldscCargo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMatricula)
                            .addComponent(lblNomeFunc)
                            .addComponent(lblCargo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbldscCCusto)
                            .addComponent(lbldscCdBanco)
                            .addComponent(lbldscAgencia)
                            .addComponent(lbldscConta)
                            .addComponent(lbldscSalario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCentroCusto)
                            .addComponent(lblCdbanco)
                            .addComponent(lblNmBanco)
                            .addComponent(lblAgencia)
                            .addComponent(lblConta)
                            .addComponent(lblSalario)
                            .addComponent(lblDigito))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldscpagamento)
                    .addComponent(lblDtPagamento))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblDesconto.setText("Descontos");

        lblLiquido.setText("Líquido");

        lbldscVencimento.setText("Vencimentos");

        lbldscDesconto.setText("Descontos");

        lbldscLiquido.setText("Líquido");

        lblVencimento.setText("Vencimentos");

        lbldsctotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbldsctotal.setText("Totais");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(lbldsctotal)
                .addGap(184, 184, 184)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldscVencimento)
                    .addComponent(lblVencimento))
                .addGap(182, 182, 182)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldscDesconto)
                    .addComponent(lblDesconto))
                .addGap(143, 143, 143)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldscLiquido)
                    .addComponent(lblLiquido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldscVencimento)
                    .addComponent(lbldscDesconto)
                    .addComponent(lbldscLiquido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVencimento)
                    .addComponent(lblDesconto)
                    .addComponent(lblLiquido))
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbldsctotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(502, 502, 502)
                        .addComponent(lbldemonstrativo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(160, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnImprimi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVoltar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbldemonstrativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnImprimi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnImprimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimiActionPerformed
        JOptionPane.showMessageDialog(null,"Documento enviado para Impressão");
    }//GEN-LAST:event_btnImprimiActionPerformed

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
            java.util.logging.Logger.getLogger(DetalPagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalPagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalPagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalPagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalPagamentoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimi;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgencia;
    private javax.swing.JLabel lblCNPJ;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCdDepartamento;
    private javax.swing.JLabel lblCdbanco;
    private javax.swing.JLabel lblCentroCusto;
    private javax.swing.JLabel lblConta;
    private javax.swing.JLabel lblDesconto;
    private javax.swing.JLabel lblDigito;
    private javax.swing.JLabel lblDsDepartamento;
    private javax.swing.JLabel lblDtPagamento;
    private javax.swing.JLabel lblDtReferencia;
    private javax.swing.JLabel lblLiquido;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNmBanco;
    private javax.swing.JLabel lblNmEmpresa;
    private javax.swing.JLabel lblNomeFunc;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblVencimento;
    private javax.swing.JLabel lbldemonstrativo;
    private javax.swing.JLabel lbldscAgencia;
    private javax.swing.JLabel lbldscCCusto;
    private javax.swing.JLabel lbldscCNPJ;
    private javax.swing.JLabel lbldscCargo;
    private javax.swing.JLabel lbldscCdBanco;
    private javax.swing.JLabel lbldscCdDepartamento;
    private javax.swing.JLabel lbldscConta;
    private javax.swing.JLabel lbldscDesconto;
    private javax.swing.JLabel lbldscLiquido;
    private javax.swing.JLabel lbldscMatricula;
    private javax.swing.JLabel lbldscNome;
    private javax.swing.JLabel lbldscReferencia;
    private javax.swing.JLabel lbldscSalario;
    private javax.swing.JLabel lbldscVencimento;
    private javax.swing.JLabel lbldscempresa;
    private javax.swing.JLabel lbldscpagamento;
    private javax.swing.JLabel lbldsctotal;
    private javax.swing.JTable tblDetalhamento;
    // End of variables declaration//GEN-END:variables
}

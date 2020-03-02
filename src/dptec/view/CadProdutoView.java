package dptec.view;

import Metodos.TrataCaracteres;
import dptec.controller.ProdutoController;
import dptec.model.ProdutoModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CadProdutoView extends javax.swing.JFrame {

    private int cduser;

    public CadProdutoView() {
        initComponents();
        setLocationRelativeTo(null);
        txtDescricao.setDocument(new TrataCaracteres(70, "aA0-zZ9"));
        txtCodigo.setDocument(new TrataCaracteres(4, "[aA-zZ]"));        
        txtVlFixo.setDocument(new TrataCaracteres(10, "[aA-zZ]"));
        txtPorcentagem.setDocument(new TrataCaracteres(5, "[aA-zZ]"));
        txtCodigoBusca.setDocument(new TrataCaracteres(4, "[aA-zZ]"));
        txtDescricaoBusca.setDocument(new TrataCaracteres(70, "aA0-zZ9"));     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpProduto = new javax.swing.JTabbedPane();
        pnlProduto = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        txtVlFixo = new javax.swing.JTextField();
        txtPorcentagem = new javax.swing.JTextField();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbStatus = new javax.swing.JComboBox<>();
        btnAlterar = new javax.swing.JButton();
        lblDsProduto = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        lblVlProduto = new javax.swing.JLabel();
        lblPcProd = new javax.swing.JLabel();
        Categoria = new javax.swing.JLabel();
        lblCdProduto = new javax.swing.JLabel();
        btnConsulta = new javax.swing.JButton();
        pnlConsultaProd = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        lblCdProduto1 = new javax.swing.JLabel();
        txtCodigoBusca = new javax.swing.JTextField();
        lblStatus1 = new javax.swing.JLabel();
        cmbCatBusca = new javax.swing.JComboBox<>();
        Categoria1 = new javax.swing.JLabel();
        cmbStatusBusca = new javax.swing.JComboBox<>();
        txtDescricaoBusca = new javax.swing.JTextField();
        lblDsProduto1 = new javax.swing.JLabel();
        btnVoltarBusca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        lblStatus.setText("Status");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Beneficio", "Beneficio Dependente", "Distribuição de Lucros", "Adiantamento Quinzenal", "Mensal", "Contribuição Obrigatória" }));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Ativo", "Inativo" }));

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Alterar.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        lblDsProduto.setText("Descrição");

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/voltar2.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        lblVlProduto.setText("Valor Fixo");

        lblPcProd.setText("Porcentagem");

        Categoria.setText("Categoria");

        lblCdProduto.setText("Codigo");

        btnConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Buscar.png"))); // NOI18N
        btnConsulta.setText("Consultar");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProdutoLayout = new javax.swing.GroupLayout(pnlProduto);
        pnlProduto.setLayout(pnlProdutoLayout);
        pnlProdutoLayout.setHorizontalGroup(
            pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProdutoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDsProduto)
                    .addGroup(pnlProdutoLayout.createSequentialGroup()
                        .addGroup(pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCdProduto))
                        .addGap(60, 60, 60)
                        .addGroup(pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus))
                        .addGap(68, 68, 68)
                        .addGroup(pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Categoria)
                            .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlProdutoLayout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsulta))
                    .addGroup(pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlProdutoLayout.createSequentialGroup()
                            .addGroup(pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtVlFixo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblVlProduto))
                            .addGap(116, 116, 116)
                            .addGroup(pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPcProd)))
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlProdutoLayout.setVerticalGroup(
            pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProdutoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlProdutoLayout.createSequentialGroup()
                        .addComponent(lblCdProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlProdutoLayout.createSequentialGroup()
                        .addComponent(lblStatus)
                        .addGap(4, 4, 4)
                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlProdutoLayout.createSequentialGroup()
                        .addComponent(Categoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDsProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVlProduto)
                    .addComponent(lblPcProd, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVlFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar)
                    .addComponent(btnAlterar)
                    .addComponent(btnConsulta))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        tpProduto.addTab("Produto", pnlProduto);

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descricao", "Valor Fixo", "Procentagem", "Categoria", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduto);

        lblCdProduto1.setText("Codigo");

        txtCodigoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoBuscaActionPerformed(evt);
            }
        });

        lblStatus1.setText("Status");

        cmbCatBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Beneficio", "Beneficio Dependente", "Distribuição de Lucros", "Adiantamento Quinzenal", "Mensal", "Contribuição Obrigatória" }));
        cmbCatBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCatBuscaActionPerformed(evt);
            }
        });

        Categoria1.setText("Categoria");

        cmbStatusBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Ativo", "Inativo" }));
        cmbStatusBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusBuscaActionPerformed(evt);
            }
        });

        txtDescricaoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoBuscaActionPerformed(evt);
            }
        });

        lblDsProduto1.setText("Descrição");

        btnVoltarBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/voltar2.png"))); // NOI18N
        btnVoltarBusca.setText("Voltar");
        btnVoltarBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarBuscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConsultaProdLayout = new javax.swing.GroupLayout(pnlConsultaProd);
        pnlConsultaProd.setLayout(pnlConsultaProdLayout);
        pnlConsultaProdLayout.setHorizontalGroup(
            pnlConsultaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultaProdLayout.createSequentialGroup()
                .addGroup(pnlConsultaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConsultaProdLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
                    .addGroup(pnlConsultaProdLayout.createSequentialGroup()
                        .addGroup(pnlConsultaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlConsultaProdLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(pnlConsultaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDsProduto1)
                                    .addComponent(txtDescricaoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlConsultaProdLayout.createSequentialGroup()
                                        .addGroup(pnlConsultaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCodigoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblCdProduto1))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlConsultaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblStatus1)
                                            .addComponent(cmbStatusBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(68, 68, 68)
                                        .addGroup(pnlConsultaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbCatBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Categoria1)))))
                            .addGroup(pnlConsultaProdLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnVoltarBusca)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlConsultaProdLayout.setVerticalGroup(
            pnlConsultaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConsultaProdLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlConsultaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlConsultaProdLayout.createSequentialGroup()
                        .addComponent(lblCdProduto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlConsultaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbStatusBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlConsultaProdLayout.createSequentialGroup()
                        .addComponent(lblStatus1)
                        .addGap(24, 24, 24))
                    .addGroup(pnlConsultaProdLayout.createSequentialGroup()
                        .addComponent(Categoria1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCatBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDsProduto1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricaoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVoltarBusca)
                .addContainerGap())
        );

        tpProduto.addTab("Consultar", pnlConsultaProd);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tpProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tpProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void load(int cduser) {
        this.cduser = cduser;
        tpProduto.remove(pnlConsultaProd);
        btnAlterar.setEnabled(false);
        txtCodigo.setEnabled(false);
        btnSalvar.setEnabled(true);
        DefaultTableModel dtmProd = (DefaultTableModel) tblProduto.getModel();
        dtmProd.setNumRows(0);
    }

    private void loadProd() {
        if ("".equals(txtCodigoBusca.getText())) {
            txtCodigoBusca.setText("0");
        }
        ProdutoController pc = new ProdutoController(
                Integer.parseInt(txtCodigoBusca.getText().trim()), //private int cdproduto;
                txtDescricaoBusca.getText().trim(),//private String dsproduto;
                cmbStatusBusca.getSelectedItem().toString(),//private String dsstatus;
                cmbCatBusca.getSelectedItem().toString(),//private String dscategoria;
                0,//private float vlproduto;
                0,//private float pcproduto;
                cduser,//private int cduser;
                "B"//private String op;
        );

        DefaultTableModel dtmProd = (DefaultTableModel) tblProduto.getModel();
        dtmProd.setNumRows(0);
        List<ProdutoModel> listProd = new ArrayList<ProdutoModel>();
        try {
            listProd = pc.listProduto();
            for (ProdutoModel gProd : listProd) {
                dtmProd.addRow(new Object[]{
                    gProd.getCdproduto(),
                    gProd.getDsproduto(),
                    gProd.getVlproduto(),
                    gProd.getPcproduto(),
                    gProd.getDscategoria(),
                    gProd.getIcativo()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.fillInStackTrace());
        }
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        ProdutoController pc = new ProdutoController(
                0, //private int cdproduto;
                txtDescricao.getText().trim(),//private String dsproduto;
                cmbStatus.getSelectedItem().toString(),//private String dsstatus;
                cmbCategoria.getSelectedItem().toString(),//private String dscategoria;
                Float.parseFloat(txtVlFixo.getText().replace(",", ".").trim()),//private float vlproduto;
                Float.parseFloat(txtPorcentagem.getText().replace(",", ".").replace("%","").trim()),//private float pcproduto;
                cduser,//private int cduser;
                "I"//private String op;
        );
        String msg = null;
        msg = pc.dmlProduto();
        if (msg != null) {
            JOptionPane.showMessageDialog(null, msg);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        ProdutoController pc = new ProdutoController(
                Integer.parseInt(txtCodigo.getText().trim()), //private int cdproduto;
                txtDescricao.getText().trim(),//private String dsproduto;
                cmbStatus.getSelectedItem().toString(),//private String dsstatus;
                cmbCategoria.getSelectedItem().toString(),//private String dscategoria;
                Float.parseFloat(txtVlFixo.getText().replace(",", ".").replace("$", "").replace("R", "").trim()),//private float vlproduto;
                Float.parseFloat(txtPorcentagem.getText().replace(",", ".").replace("%","").trim()),//private float pcproduto;
                cduser,//private int cduser;
                "U"//private String op;
        );
        String msg = null;
        msg = pc.dmlProduto();
        if (msg != null) {
            JOptionPane.showMessageDialog(null, msg);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtCodigoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBuscaActionPerformed
        loadProd();
    }//GEN-LAST:event_txtCodigoBuscaActionPerformed

    private void txtDescricaoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoBuscaActionPerformed
        loadProd();
    }//GEN-LAST:event_txtDescricaoBuscaActionPerformed

    private void tblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMouseClicked
        int i = tblProduto.getSelectedRow();

        //Se i for < 0 é porque a tbl esta desabilitada significa que o funcionario nao esta ativo
        if (i >= 0) {
            txtCodigo.setText(tblProduto.getValueAt(i, 0).toString().trim());
            txtDescricao.setText(tblProduto.getValueAt(i, 1).toString().trim());            
            txtVlFixo.setText(tblProduto.getValueAt(i, 2).toString().replace(".", ",").trim());
            float vlporc = Float.parseFloat(tblProduto.getValueAt(i, 3).toString());
            txtPorcentagem.setText(String.valueOf((vlporc * 100) + "%"));
            cmbCategoria.setSelectedItem(tblProduto.getValueAt(i, 4).toString().trim());
            if ("1".equals(tblProduto.getValueAt(i, 5).toString().trim())) {
                cmbStatus.setSelectedItem("Ativo");
            } else {
                cmbStatus.setSelectedItem("Inativo");
            }

            tpProduto.add(pnlProduto, "Alterar Produto", 0);
            tpProduto.remove(pnlConsultaProd);
            tpProduto.setSelectedIndex(0);
            txtCodigo.setEnabled(false);
            btnSalvar.setEnabled(false);
            btnAlterar.setEnabled(true);
        }
    }//GEN-LAST:event_tblProdutoMouseClicked

    private void cmbCatBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCatBuscaActionPerformed
        loadProd();
    }//GEN-LAST:event_cmbCatBuscaActionPerformed

    private void cmbStatusBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusBuscaActionPerformed
        loadProd();
    }//GEN-LAST:event_cmbStatusBuscaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        tpProduto.add(pnlConsultaProd, "Consultar Produto", 0);
        tpProduto.remove(pnlProduto);
        tpProduto.setSelectedIndex(0);
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnVoltarBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarBuscaActionPerformed
        tpProduto.add(pnlProduto, "Cadastrar Produto", 0);
        tpProduto.remove(pnlConsultaProd);
        tpProduto.setSelectedIndex(0);
    }//GEN-LAST:event_btnVoltarBuscaActionPerformed

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
            java.util.logging.Logger.getLogger(CadProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadProdutoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Categoria;
    private javax.swing.JLabel Categoria1;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltarBusca;
    private javax.swing.JComboBox<String> cmbCatBusca;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JComboBox<String> cmbStatusBusca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCdProduto;
    private javax.swing.JLabel lblCdProduto1;
    private javax.swing.JLabel lblDsProduto;
    private javax.swing.JLabel lblDsProduto1;
    private javax.swing.JLabel lblPcProd;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatus1;
    private javax.swing.JLabel lblVlProduto;
    private javax.swing.JPanel pnlConsultaProd;
    private javax.swing.JPanel pnlProduto;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTabbedPane tpProduto;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoBusca;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtDescricaoBusca;
    private javax.swing.JTextField txtPorcentagem;
    private javax.swing.JTextField txtVlFixo;
    // End of variables declaration//GEN-END:variables
}

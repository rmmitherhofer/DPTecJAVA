package dptec.view;

import Metodos.Config;
import dptec.dao.FuncionarioDao3;
import dptec.dao.UsuarioDao;
import dptec.model.FuncionarioModel;
import dptec.model.PerfilModel;
import dptec.model.UsuarioModel;
import dptec.view.FolhaPontoView;
import dptec.view.FolhaPagamentoView;
import dptec.view.FechaPontoView;
import dptec.view.FechaFolhaView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MasterView extends javax.swing.JFrame {

    private int cduser;

    public MasterView() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void Load(UsuarioModel um) {
        this.cduser = um.getCdusuario();
        //lblcdUser.setText(String.valueOf(um.getCdusuario()));
        lblcdMatricula.setText(String.valueOf(um.getCdmatricula()));
        lblNome.setText(um.getNmusuario());
    }

    public void Perfil() {
        btnFolhaPonto.setEnabled(false);
        btnHolerit.setEnabled(false);
        btnMeuCad.setEnabled(false);
        btnMeuBen.setEnabled(false);
        MenuFunc.setVisible(false);
        MenuArquivo.setVisible(false);
        MenuTools.setVisible(false);
        MIOpLogoff.setVisible(false);
        MIFechaPonto.setVisible(false);
        MIFechaFolha.setVisible(false);
        MIFCad.setVisible(false);
        MenuProduto.setVisible(false);
        MICadProd.setVisible(false);
        Config c = new Config();
        List<PerfilModel> groupPerfil = new ArrayList<PerfilModel>();
        groupPerfil = c.validaPerfil(cduser);
        for (PerfilModel gp : groupPerfil) {
            if (gp.getCdperfil() == 2) {
                btnFolhaPonto.setEnabled(true);
            }
            if (gp.getCdperfil() == 3) {
                btnHolerit.setEnabled(true);
            }
            if (gp.getCdperfil() == 4) {
                btnMeuCad.setEnabled(true);
            }
            if (gp.getCdperfil() == 5) {
                btnMeuBen.setEnabled(true);
            }
            if (gp.getCdperfil() == 6) {
                MenuFunc.setVisible(true);
            }
            if (gp.getCdperfil() == 7) {
                MenuArquivo.setVisible(true);
            }
            if (gp.getCdperfil() == 8) {
                MIOpLogoff.setVisible(true);
            }
            if (gp.getCdperfil() == 9) {
                MenuFunc.setVisible(true);
            }
            if (gp.getCdperfil() == 10) {
                MIFCad.setVisible(true);
            }
            if (gp.getCdperfil() == 11) {
                MenuTools.setVisible(true);
            }
            if (gp.getCdperfil() == 12) {
                MIFechaPonto.setVisible(true);
            }
            if (gp.getCdperfil() == 13) {
                MIFechaFolha.setVisible(true);
            }
            if (gp.getCdperfil() == 14) {
                MenuProduto.setVisible(true);
            }
            if (gp.getCdperfil() == 15) {
                MICadProd.setVisible(true);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlConsultas = new javax.swing.JPanel();
        btnFolhaPonto = new javax.swing.JButton();
        btnHolerit = new javax.swing.JButton();
        btnMeuCad = new javax.swing.JButton();
        btnMeuBen = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        lblcdMatricula = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        MenuArquivo = new javax.swing.JMenu();
        MIOpLogoff = new javax.swing.JMenuItem();
        MenuFunc = new javax.swing.JMenu();
        MIFCad = new javax.swing.JMenuItem();
        MenuTools = new javax.swing.JMenu();
        MIFechaPonto = new javax.swing.JMenuItem();
        MIFechaFolha = new javax.swing.JMenuItem();
        MenuProduto = new javax.swing.JMenu();
        MICadProd = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DP TEC @ UNI9 Consult");
        setLocation(new java.awt.Point(150, 50));
        setResizable(false);

        btnFolhaPonto.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnFolhaPonto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Folha_De_Ponto.png"))); // NOI18N
        btnFolhaPonto.setText("\n\n\n\n\n\nFolha de Ponto");
        btnFolhaPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFolhaPontoActionPerformed(evt);
            }
        });

        btnHolerit.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnHolerit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Olerit.png"))); // NOI18N
        btnHolerit.setText("Holerite");
        btnHolerit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoleritActionPerformed(evt);
            }
        });

        btnMeuCad.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnMeuCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Dado_Cadastral.png"))); // NOI18N
        btnMeuCad.setText("Meu Cadastro");
        btnMeuCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeuCadActionPerformed(evt);
            }
        });

        btnMeuBen.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnMeuBen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/beneficio.png"))); // NOI18N
        btnMeuBen.setText("Meus Beneficios");
        btnMeuBen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeuBenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConsultasLayout = new javax.swing.GroupLayout(pnlConsultas);
        pnlConsultas.setLayout(pnlConsultasLayout);
        pnlConsultasLayout.setHorizontalGroup(
            pnlConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultasLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pnlConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMeuBen, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlConsultasLayout.createSequentialGroup()
                        .addComponent(btnFolhaPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHolerit, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnMeuCad, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        pnlConsultasLayout.setVerticalGroup(
            pnlConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultasLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFolhaPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHolerit, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMeuCad, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnMeuBen, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        lblNome.setText("NomeUser");

        lblcdMatricula.setText("MatriculaUser");

        MenuArquivo.setText("Arquivo");

        MIOpLogoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Sair.png"))); // NOI18N
        MIOpLogoff.setToolTipText("");
        MIOpLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIOpLogoffActionPerformed(evt);
            }
        });
        MenuArquivo.add(MIOpLogoff);

        Menu.add(MenuArquivo);

        MenuFunc.setText("Funcionário");

        MIFCad.setText("Cadastrar");
        MIFCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIFCadActionPerformed(evt);
            }
        });
        MenuFunc.add(MIFCad);

        Menu.add(MenuFunc);

        MenuTools.setText("Ferramentas");

        MIFechaPonto.setText("Fechar Ponto");
        MIFechaPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIFechaPontoActionPerformed(evt);
            }
        });
        MenuTools.add(MIFechaPonto);

        MIFechaFolha.setText("Fechar Folha");
        MIFechaFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIFechaFolhaActionPerformed(evt);
            }
        });
        MenuTools.add(MIFechaFolha);

        Menu.add(MenuTools);

        MenuProduto.setText("Produto");

        MICadProd.setText("Cadastrar");
        MICadProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MICadProdActionPerformed(evt);
            }
        });
        MenuProduto.add(MICadProd);

        Menu.add(MenuProduto);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblcdMatricula)
                .addGap(18, 18, 18)
                .addComponent(lblNome)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblcdMatricula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MIFCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIFCadActionPerformed
        try {
            CadFuncionarioView cadfuncionario = new CadFuncionarioView();
            //int cduser = Integer.parseInt(lblcdUser.getText());
            cadfuncionario.Load(cduser);
            cadfuncionario.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.fillInStackTrace());
        }
    }//GEN-LAST:event_MIFCadActionPerformed

    private void MIOpLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIOpLogoffActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MIOpLogoffActionPerformed

    private void btnFolhaPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFolhaPontoActionPerformed
        UsuarioModel um = new UsuarioModel();
        FolhaPontoView folhaponto = new FolhaPontoView();
        um.setCdusuario(cduser);
        UsuarioDao ud = new UsuarioDao();
        List<UsuarioModel> listaUsuario = new ArrayList<UsuarioModel>();
        listaUsuario = ud.getListaUsuario(um);
        if (listaUsuario.size() > 0) {
            for (UsuarioModel fLocal : listaUsuario) {
                FuncionarioModel fm = new FuncionarioModel();
                fm.setCdmatricula(fLocal.getCdmatricula());
                FuncionarioDao3 fd = new FuncionarioDao3();
                List<FuncionarioModel> listaFunc = new ArrayList<FuncionarioModel>();
                listaFunc = fd.loadMatricFun(fm);
                for (FuncionarioModel fml : listaFunc) {
                    fm.setCdmatricula(fml.getCdmatricula());
                    fm.setNmfuncionario(fml.getNmfuncionario());
                    fm.setNocpf(fml.getNocpf());
                }
                if (listaFunc.size() > 0) {
                    folhaponto.loadUser(cduser);
                    folhaponto.Load(fm);
                    folhaponto.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Seu Usuario nao esta vinculado a uma matricula para gerar folha de ponto");
                }
            }
        }


    }//GEN-LAST:event_btnFolhaPontoActionPerformed

    private void btnHoleritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoleritActionPerformed
        UsuarioModel um = new UsuarioModel();
        FolhaPagamentoView fpagamento = new FolhaPagamentoView();
        um.setCdusuario(cduser);
        UsuarioDao ud = new UsuarioDao();
        List<UsuarioModel> listaUsuario = new ArrayList<UsuarioModel>();
        listaUsuario = ud.getListaUsuario(um);
        if (listaUsuario.size() > 0) {
            for (UsuarioModel lu : listaUsuario) {
                FuncionarioModel fm = new FuncionarioModel();
                fm.setCdmatricula(lu.getCdmatricula());
                FuncionarioDao3 fd = new FuncionarioDao3();
                List<FuncionarioModel> listaFunc = new ArrayList<FuncionarioModel>();
                listaFunc = fd.loadMatricFun(fm);
                for (FuncionarioModel fml : listaFunc) {
                    fm.setCdmatricula(fml.getCdmatricula());
                    fm.setNmfuncionario(fml.getNmfuncionario());
                    fm.setNocpf(fml.getNocpf());
                }
                fpagamento.loadUser(cduser);
                fpagamento.Load(fm);
                fpagamento.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnHoleritActionPerformed

    private void MIFechaPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIFechaPontoActionPerformed
        FechaPontoView fpv = new FechaPontoView();
        fpv.Load(cduser);
        fpv.setVisible(true);
    }//GEN-LAST:event_MIFechaPontoActionPerformed

    private void MIFechaFolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIFechaFolhaActionPerformed
        FechaFolhaView ffv = new FechaFolhaView();
        ffv.Load(cduser);
        ffv.setVisible(true);
    }//GEN-LAST:event_MIFechaFolhaActionPerformed

    private void btnMeuCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeuCadActionPerformed
        JOptionPane.showMessageDialog(null, "Funcionalidade ainda não esta disponivel. Obrigado pela Compreesão");
    }//GEN-LAST:event_btnMeuCadActionPerformed

    private void btnMeuBenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeuBenActionPerformed
        JOptionPane.showMessageDialog(null, "Funcionalidade ainda não esta disponivel. Obrigado pela Compreesão");
    }//GEN-LAST:event_btnMeuBenActionPerformed

    private void MICadProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MICadProdActionPerformed
        CadProdutoView cp = new CadProdutoView();
        cp.load(cduser);
        cp.setVisible(true);
    }//GEN-LAST:event_MICadProdActionPerformed

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
            java.util.logging.Logger.getLogger(MasterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MICadProd;
    private javax.swing.JMenuItem MIFCad;
    private javax.swing.JMenuItem MIFechaFolha;
    private javax.swing.JMenuItem MIFechaPonto;
    private javax.swing.JMenuItem MIOpLogoff;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu MenuArquivo;
    private javax.swing.JMenu MenuFunc;
    private javax.swing.JMenu MenuProduto;
    private javax.swing.JMenu MenuTools;
    private javax.swing.JButton btnFolhaPonto;
    private javax.swing.JButton btnHolerit;
    private javax.swing.JButton btnMeuBen;
    private javax.swing.JButton btnMeuCad;
    public javax.swing.JLabel lblNome;
    public javax.swing.JLabel lblcdMatricula;
    private javax.swing.JPanel pnlConsultas;
    // End of variables declaration//GEN-END:variables
}

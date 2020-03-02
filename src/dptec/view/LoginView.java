package dptec.view;

import Metodos.Config;
import dptec.view.MasterView;
import dptec.controller.UsuarioController;
import dptec.dao.UsuarioDao;
import dptec.model.UsuarioModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Metodos.TrataCaracteres;
import dptec.model.PerfilModel;

public class LoginView extends javax.swing.JFrame {

    public LoginView() {
        initComponents();
        setLocationRelativeTo(null);
        txtLogin.setDocument(new TrataCaracteres(20, "[0-9]"));
        pswSenha.setDocument(new TrataCaracteres(12, "aA0-zZ9"));
    }

    public int Perfil(int cduser) {
        Config c = new Config();
        int p = 0;
        List<PerfilModel> groupPerfil = new ArrayList<PerfilModel>();
        groupPerfil = c.validaPerfil(cduser);
        for (PerfilModel gp : groupPerfil) {
            if (gp.getCdperfil() == 1) {
                p = gp.getCdperfil();
            }
        }
        return p;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        pswSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        lblSenha = new javax.swing.JLabel();
        lblTItulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login DPTec");
        setLocation(new java.awt.Point(500, 100));
        setResizable(false);

        lblLogin.setText("Login");

        pswSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pswSenhaFocusGained(evt);
            }
        });
        pswSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswSenhaActionPerformed(evt);
            }
        });

        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/OK.png"))); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        lblSenha.setText("Senha");

        lblTItulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/DPtec2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTItulo, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLogin, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(lblSenha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pswSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblTItulo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnEntrar)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        try {
            String msg = null;
            UsuarioController usercontrol = new UsuarioController(
                    txtLogin.getText(),
                    String.valueOf(pswSenha.getPassword())
            );
            msg = usercontrol.validaUser();

            if ("Informe o Login".equals(msg)) {
                JOptionPane.showMessageDialog(null, msg);
                txtLogin.requestFocus();
            } else if ("Informe a Senha".equals(msg)) {
                JOptionPane.showMessageDialog(null, msg);
                pswSenha.requestFocus();
            } else if ("Senha Inválida!".equals(msg)) {
                JOptionPane.showMessageDialog(null, msg);
                pswSenha.requestFocus();
            } else if ("Usuario não encontrado".equals(msg)) {
                JOptionPane.showMessageDialog(null, msg);
                txtLogin.requestFocus();
            } else if ("Conta Inativa, Contate o Administrador".equals(msg)) {
                JOptionPane.showMessageDialog(null, msg);
            } else {
                MasterView cldefault = new MasterView();
                UsuarioModel um = new UsuarioModel();
                um.setCdusuario(Integer.parseInt(msg));
                UsuarioDao ud = new UsuarioDao();
                List<UsuarioModel> listaUser = new ArrayList<UsuarioModel>();
                listaUser = ud.getListaUsuario(um);
                int p = 0;
                for (UsuarioModel uml : listaUser) {
                    um.setCdmatricula(uml.getCdmatricula());
                    um.setCdusuario(uml.getCdusuario());
                    um.setDslogin(uml.getDslogin());
                    um.setNmusuario(uml.getNmusuario());
                    p = Perfil(uml.getCdusuario());
                }
                if (p != 0) {
                    cldefault.Load(um);
                    cldefault.Perfil();
                    cldefault.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Você não Possui Perfis de Acesso");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getStackTrace());
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void pswSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswSenhaActionPerformed
        btnEntrar.doClick();
    }//GEN-LAST:event_pswSenhaActionPerformed

    private void pswSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pswSenhaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_pswSenhaFocusGained

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTItulo;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JTextField txtLogin;
    // End of variables declaration//GEN-END:variables
}

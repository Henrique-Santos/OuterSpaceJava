package telas;

import javax.swing.JOptionPane;


/**
 *
 * @author gabriel_a_ramos
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pLogin = new javax.swing.JPanel();
        pSenha = new javax.swing.JPasswordField();
        lSenha = new javax.swing.JLabel();
        FUsuario = new javax.swing.JTextField();
        lUsuario = new javax.swing.JLabel();
        Llogin = new javax.swing.JLabel();
        bEntra = new javax.swing.JButton();
        bEsquecisenha = new javax.swing.JButton();
        bCriarconta = new javax.swing.JButton();
        Limagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Login");
        setPreferredSize(new java.awt.Dimension(330, 400));
        setResizable(false);

        pLogin.setPreferredSize(new java.awt.Dimension(300, 400));
        pLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pSenhaKeyPressed(evt);
            }
        });
        pLogin.add(pSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 150, -1));

        lSenha.setForeground(new java.awt.Color(255, 255, 255));
        lSenha.setText("Senha");
        pLogin.add(lSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 50, -1));

        FUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FUsuarioKeyPressed(evt);
            }
        });
        pLogin.add(FUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 150, -1));

        lUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lUsuario.setText("Usuário");
        pLogin.add(lUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 50, -1));

        Llogin.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        Llogin.setForeground(new java.awt.Color(0, 204, 204));
        Llogin.setText("Login");
        pLogin.add(Llogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        bEntra.setText("Entrar");
        bEntra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEntraActionPerformed(evt);
            }
        });
        pLogin.add(bEntra, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 150, -1));

        bEsquecisenha.setText("Esqueci minha senha");
        bEsquecisenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEsquecisenhaActionPerformed(evt);
            }
        });
        pLogin.add(bEsquecisenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        bCriarconta.setText("Criar Conta");
        bCriarconta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCriarcontaActionPerformed(evt);
            }
        });
        pLogin.add(bCriarconta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 150, -1));

        Limagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgTela/space.jpeg"))); // NOI18N
        Limagem.setPreferredSize(new java.awt.Dimension(300, 400));
        pLogin.add(Limagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bEntraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEntraActionPerformed
       String senhaString = new String(pSenha.getPassword());
       Usuarios u  = new Usuarios();
       if (u.login(FUsuario.getText(), senhaString)) {
           pSenha.setText("");
           FUsuario.setText("");           
           bEntra.requestFocus();
           //JOptionPane.showMessageDialog(null, "AUTENTICADO");
           Principal prin = new Principal();
           prin.show();
       } else {
           pSenha.setText("");
           pSenha.requestFocus();           
           JOptionPane.showMessageDialog(null, "NÃO AUTENTICADO");              
       }
        
    }//GEN-LAST:event_bEntraActionPerformed

    private void bEsquecisenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEsquecisenhaActionPerformed
        //chamada de tela
        AuxConta conta = new AuxConta();
        conta.iniciar("Pesquecisenha");
    }//GEN-LAST:event_bEsquecisenhaActionPerformed

    private void bCriarcontaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCriarcontaActionPerformed
        //chamada de tela
        AuxConta conta = new AuxConta();
        conta.iniciar("Pcadastro");
    }//GEN-LAST:event_bCriarcontaActionPerformed

    private void FUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FUsuarioKeyPressed
        if (evt.getKeyCode() == 10)           
            pSenha.requestFocus();
       // uteis.Uteis.pulaVoltaCampos(evt);
    }//GEN-LAST:event_FUsuarioKeyPressed

    private void pSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pSenhaKeyPressed
        getRootPane().setDefaultButton(bEntra);
    }//GEN-LAST:event_pSenhaKeyPressed
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FUsuario;
    private javax.swing.JLabel Limagem;
    private javax.swing.JLabel Llogin;
    private javax.swing.JButton bCriarconta;
    private javax.swing.JButton bEntra;
    private javax.swing.JButton bEsquecisenha;
    private javax.swing.JLabel lSenha;
    private javax.swing.JLabel lUsuario;
    private javax.swing.JPanel pLogin;
    private javax.swing.JPasswordField pSenha;
    // End of variables declaration//GEN-END:variables
}

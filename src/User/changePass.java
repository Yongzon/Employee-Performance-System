/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package User;

import Error.ErrorPage;
import Startup.loginform;
import config.Session;
import config.dbConnector;
import config.passHash;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Chris
 */
public class changePass extends javax.swing.JFrame {

    /** Creates new form employeeDashboard */
    public changePass() {
        initComponents();
    }
    
    Color bodycolor = new Color(0,204,204);
    Color nav = new  Color(0,153,204);
    Color bodycolor1 = new Color(255,51,51);
    Color nav1 = new  Color(255,102,102);

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userpanel = new javax.swing.JPanel();
        cl = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        changePass = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        newpass = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        cp = new javax.swing.JPasswordField();
        olps = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userpanel.setBackground(new java.awt.Color(241, 242, 247));
        userpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cl.setBackground(new java.awt.Color(255, 51, 51));
        cl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clMouseExited(evt);
            }
        });
        cl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Clear");
        cl.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 20));

        userpanel.add(cl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 180, 40));

        changePass.setBackground(new java.awt.Color(0, 204, 204));
        changePass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        changePass.setEnabled(false);
        changePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changePassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changePassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changePassMouseExited(evt);
            }
        });
        changePass.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Change Pass");
        changePass.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 20));

        userpanel.add(changePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 180, 40));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setText("New Password");
        userpanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 100, 30));

        newpass.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        newpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newpass.setBorder(null);
        newpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpassActionPerformed(evt);
            }
        });
        userpanel.add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 220, 44));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel11.setText("Confirm Password");
        userpanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 120, 30));

        cp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cp.setBorder(null);
        cp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpActionPerformed(evt);
            }
        });
        userpanel.add(cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 450, 44));

        olps.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        olps.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        olps.setBorder(null);
        olps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                olpsActionPerformed(evt);
            }
        });
        userpanel.add(olps, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 220, 44));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pen.png"))); // NOI18N
        userpanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Account Information");
        userpanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 200, 40));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/turn-left_10977010.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        userpanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel14.setText("Type Old Password");
        userpanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 120, 30));

        getContentPane().add(userpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session sess = Session.getInstance();
       if(sess.getUid() == 0){
            ErrorPage ep = new ErrorPage();
            ep.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowActivated

    private void clMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clMouseClicked

        String password1 = new String(newpass.getPassword());
        String cpassword = new String(cp.getPassword());

        newpass.setText("");
        cp.setText("");
    }//GEN-LAST:event_clMouseClicked

    private void clMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clMouseEntered
        cl.setBackground(nav1);
    }//GEN-LAST:event_clMouseEntered

    private void clMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clMouseExited
        cl.setBackground(bodycolor1);
    }//GEN-LAST:event_clMouseExited

    private void changePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePassMouseClicked
        String oldpass = new String(olps.getPassword());
        String password1 = new String(newpass.getPassword());
        String cpassword = new String(cp.getPassword());
        dbConnector dbc = new dbConnector();
        Session sess = Session.getInstance();

        if (oldpass.isEmpty() || password1.isEmpty() || cpassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (newpass.getText().length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long");
            newpass.setText("");
        } else {
            try {
                String query = "SELECT u_password, u_questions FROM tbl_admin WHERE u_id = " + sess.getUid() + ";";
                ResultSet rs = dbc.getData(query);

                if (rs.next()) {
                    String storedQuestion = rs.getString("u_questions");

                    if (storedQuestion == null || storedQuestion.equalsIgnoreCase("No stored security questions") || storedQuestion.trim().isEmpty()) {
                        int security = JOptionPane.showConfirmDialog(this, "No security question found. Add one now?", "Security Question", JOptionPane.YES_NO_OPTION);

                        if (security == JOptionPane.YES_OPTION) {
                            String question1 = "";
                            String answer1 = "";

                            while (true) {
                                question1 = JOptionPane.showInputDialog(this, "Enter your Security Question:");

                                if (question1 == null || question1.trim().isEmpty()) {
                                    JOptionPane.showMessageDialog(this, "Security question cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    break;
                                }
                            }

                            while (true) {
                                answer1 = JOptionPane.showInputDialog(this, "Enter your Answer:");

                                if (answer1 == null || answer1.trim().isEmpty()) {
                                    JOptionPane.showMessageDialog(this, "Security answer cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    break;
                                }
                            }

                            String updateQuery = "UPDATE tbl_admin SET u_questions = '" + question1 + "', u_answers = '" + answer1 + "' WHERE u_id = '" + sess.getUid() + "'";
                            dbc.InsertData(updateQuery);

                            JOptionPane.showMessageDialog(this, "Security Question Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            return;
                        }
                    }

                    String oldbpass = rs.getString("u_password");
                    String oldhash = passHash.hashPassword(olps.getText());
                    String npass = passHash.hashPassword(newpass.getText());
                    String cpass = passHash.hashPassword(cp.getText());

                    if (oldbpass.equals(oldhash)) {
                        if (oldbpass.equals(npass)) {
                            JOptionPane.showMessageDialog(null, "Old Password and New Password cannot be the same!");
                            newpass.setText("");
                            cp.setText("");
                        } else if (!newpass.getText().equals(cp.getText())) {
                            JOptionPane.showMessageDialog(null, "Passwords do not match");
                            newpass.setText("");
                            cp.setText("");
                        } else {
                            dbc.updateData("UPDATE tbl_admin SET u_password = '" + npass + "', u_cpassword = '" + cpass + "' WHERE u_id = '" + sess.getUid() + "'");
                            JOptionPane.showMessageDialog(null, "Password Changed Successfully!");

                            loginform lf = new loginform();
                            lf.setVisible(true);
                            this.dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Old Password is Incorrect!");
                        olps.setText("");
                    }
                }
            } catch (SQLException | NoSuchAlgorithmException ex) {
                System.out.println("" + ex);
            }
        }


    }//GEN-LAST:event_changePassMouseClicked

    private void changePassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePassMouseEntered
        changePass.setBackground(nav);
    }//GEN-LAST:event_changePassMouseEntered

    private void changePassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePassMouseExited
        changePass.setBackground(bodycolor);
    }//GEN-LAST:event_changePassMouseExited

    private void newpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newpassActionPerformed

    private void cpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpActionPerformed

    private void olpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_olpsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_olpsActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       userDetails ud = new userDetails();
       ud.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel changePass;
    private javax.swing.JPanel cl;
    private javax.swing.JPasswordField cp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField newpass;
    private javax.swing.JPasswordField olps;
    private javax.swing.JPanel userpanel;
    // End of variables declaration//GEN-END:variables

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Error.ErrorPage;
import config.Session;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Chris
 */
public class viewTask3 extends javax.swing.JFrame {

    /**
     * Creates new form createUserForm
     */
    public viewTask3() {
        initComponents();
    }
    
        private String readFileContent(String path) throws IOException {
        if (path == null) {
            throw new IOException("Null file path");
        }

        
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            char[] buffer = new char[8192];
            int charsRead;
            while ((charsRead = reader.read(buffer)) != -1) {
                content.append(buffer, 0, charsRead);
                
                if (content.length() > 10_000_000) { 
                    content.append("\n[... file truncated due to size ...]");
                    break;
                }
            }
        }
        return content.toString();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tn = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        dd = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        td = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pl = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        eval = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        doc = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(241, 242, 247));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("View Task");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 200, 40));

        status.setEditable(false);
        status.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        status.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        status.setBorder(null);
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel3.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 160, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Task Status");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 100, 30));

        tn.setEditable(false);
        tn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tn.setBorder(null);
        tn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnActionPerformed(evt);
            }
        });
        jPanel3.add(tn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 220, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Deadline");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 100, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Task Name");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/audit_10815328 (2).png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Task Description");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 100, 30));

        jPanel2.setBackground(new java.awt.Color(1, 216, 218));
        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 30));

        dd.setEnabled(false);
        jPanel3.add(dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 220, 40));

        td.setEditable(false);
        td.setColumns(20);
        td.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        td.setRows(5);
        jScrollPane1.setViewportView(td);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 220, 190));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/turn-left_10977010.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Priority Level");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 100, 30));

        pl.setEditable(false);
        pl.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        pl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pl.setBorder(null);
        pl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plActionPerformed(evt);
            }
        });
        jPanel3.add(pl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 140, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Evaluation Status");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 110, 30));

        eval.setEditable(false);
        eval.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        eval.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eval.setBorder(null);
        eval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evalActionPerformed(evt);
            }
        });
        jPanel3.add(eval, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 140, 40));

        doc.setEditable(false);
        doc.setColumns(20);
        doc.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        doc.setRows(5);
        jScrollPane2.setViewportView(doc);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 230, 190));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Document File");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 100, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void tnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    Session sess = Session.getInstance();
        if(sess.getUid() == 0){
            ErrorPage ep = new ErrorPage();
            ep.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowActivated

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        assignedTask at = new assignedTask();
        at.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void plActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plActionPerformed

    private void evalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_evalActionPerformed

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
            java.util.logging.Logger.getLogger(viewTask3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewTask3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewTask3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewTask3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
      

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewTask3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.toedter.calendar.JDateChooser dd;
    public javax.swing.JTextArea doc;
    public javax.swing.JTextField eval;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField pl;
    public javax.swing.JTextField status;
    public javax.swing.JTextArea td;
    public javax.swing.JTextField tn;
    // End of variables declaration//GEN-END:variables
}

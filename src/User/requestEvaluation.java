/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Error.ErrorPage;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Chris
 */
public class requestEvaluation extends javax.swing.JFrame {

    /**
     * Creates new form createUserForm
     */
    public requestEvaluation() {
        initComponents();
    }

    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;

    public int fileExistenceChecker(String path) {
        if (path == null || path.trim().isEmpty()) {
            return 0;
        }

        File file = new File(path);
        String fileName = file.getName();

        Path filePath = Paths.get("src/userDocuments", fileName);
        return Files.exists(filePath) ? 1 : 0;
    }

    public static String getFileInfo(String filePath) {
        if (filePath == null || filePath.trim().isEmpty()) {
            return "No file selected";
        }

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return "File not found";
            }

            String fileName = file.getName();
            long fileSize = file.length();
            String fileType = Files.probeContentType(file.toPath());

            return String.format("File Information:\nName: %s\nSize: %s\nType: %s", 
            fileName, 
            formatFileSize(fileSize),
            fileType != null ? fileType : "Unknown");
        } catch (IOException ex) {
            System.err.println("Error reading file info: " + ex.getMessage());
            return "Error reading file information";
        }
    }

    private static String formatFileSize(long bytes) {
        if (bytes < 1024) return bytes + " bytes";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        String pre = "KMGTPE".charAt(exp-1) + "B";
        return String.format("%.1f %s", bytes / Math.pow(1024, exp), pre);
    }

    public JTextArea createTextPreview(String filePath, int maxLines) {
        if (filePath == null) {
            return null;
        }

        try {
            String contentType = Files.probeContentType(Paths.get(filePath));
            if (contentType == null || !contentType.startsWith("text/")) {
                return null;
            }

            JTextArea previewArea = new JTextArea();
            previewArea.setEditable(false);
            previewArea.setLineWrap(true);
            previewArea.setWrapStyleWord(true);

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                int lineCount = 0;
                StringBuilder content = new StringBuilder();

                while ((line = reader.readLine()) != null && lineCount < maxLines) {
                    content.append(line).append("\n");
                    lineCount++;
                }

                previewArea.setText(content.toString());
                return previewArea;
            }
        } catch (IOException ex) {
            System.err.println("Error creating text preview: " + ex.getMessage());
            return null;
        }
    }

    public boolean documentUpdater(String existingFilePath, String newFilePath) {
        if (existingFilePath == null || newFilePath == null) {
            return false;
        }

        File existingFile = new File(existingFilePath);
        if (!existingFile.exists()) {
            return false;
        }

        try {
            Path destination = Paths.get("src/userDocuments", new File(newFilePath).getName());
            Files.copy(Paths.get(newFilePath), destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Document updated successfully.");
            return true;
        } catch (IOException e) {
            System.err.println("Error updating document: " + e.getMessage());
            return false;
        }
    }

    public boolean uploadDocument(String sourcePath) {
        if (sourcePath == null || sourcePath.trim().isEmpty()) {
            return false;
        }

        try {
            File sourceFile = new File(sourcePath);
            if (!sourceFile.exists()) {
                return false;
            }

            
            Path dirPath = Paths.get("src/userDocuments");
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            Path destination = dirPath.resolve(sourceFile.getName());
            Files.copy(sourceFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            System.err.println("Error uploading document: " + e.getMessage());
            return false;
        }
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
    
    Color bodycolor = new Color(0,204,204);
    Color nav = new  Color(0,153,204);
    Color bodycolor1 = new Color(255,51,51);
    Color nav1 = new  Color(255,102,102);
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        save = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cnl = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        dd = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        docs = new javax.swing.JTextArea();
        remove = new javax.swing.JButton();
        upload = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        tn = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

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
        jLabel8.setText("Request Evaluation");
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
        jPanel3.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 230, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Task Status");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 100, 30));

        tid.setEditable(false);
        tid.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tid.setBorder(null);
        tid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidActionPerformed(evt);
            }
        });
        jPanel3.add(tid, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 220, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Upload file here");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 100, 30));

        save.setBackground(new java.awt.Color(0, 204, 204));
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveMouseExited(evt);
            }
        });
        save.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Request");
        save.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 20));

        jPanel3.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 570, 180, 40));

        cnl.setBackground(new java.awt.Color(255, 51, 51));
        cnl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cnl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cnlMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cnlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cnlMouseExited(evt);
            }
        });
        cnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Cancel");
        cnl.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 20));

        jPanel3.add(cnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 180, 40));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Task ID");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 100, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clipboard_1355683.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        jPanel2.setBackground(new java.awt.Color(1, 216, 218));
        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 30));

        dd.setEnabled(false);
        dd.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jPanel3.add(dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 220, 30));

        docs.setColumns(20);
        docs.setRows(5);
        jScrollPane1.setViewportView(docs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 360, 210));

        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel3.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 90, 30));

        upload.setText("Select");
        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });
        jPanel3.add(upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 90, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Deadline");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 100, 30));

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

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("Task Name");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void tidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidActionPerformed

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
    String files = docs.getText();

    if (files.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Upload File field must not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
    }else{
        try {
            if (selectedFile == null || !selectedFile.exists()) {
                JOptionPane.showMessageDialog(this, "No valid file selected!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Path destPath = Paths.get(destination);
            Files.createDirectories(destPath.getParent());

            dbConnector db = new dbConnector();

            db.updateData ("UPDATE tbl_task SET t_file = '"+destination+"', t_evalstatus = 'Pending' WHERE t_id = '"+tid.getText()+"'" ); 
                Files.copy(selectedFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(this, "File uploaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                evaluationTasks ct = new evaluationTasks();
                ct.setVisible(true);
                this.dispose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "File operation failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_saveMouseClicked

    private void saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseEntered
        save.setBackground(nav);
    }//GEN-LAST:event_saveMouseEntered

    private void saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseExited
        save.setBackground(bodycolor);
    }//GEN-LAST:event_saveMouseExited

    private void cnlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cnlMouseClicked
        evaluationTasks ct = new evaluationTasks();
        ct.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cnlMouseClicked

    private void cnlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cnlMouseEntered
        cnl.setBackground(nav1);
    }//GEN-LAST:event_cnlMouseEntered

    private void cnlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cnlMouseExited
       cnl.setBackground(bodycolor1);
    }//GEN-LAST:event_cnlMouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    Session sess = Session.getInstance();
        if(sess.getUid() == 0){
            ErrorPage ep = new ErrorPage();
            ep.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowActivated

    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadActionPerformed
    JFileChooser fileChooser = new JFileChooser();

    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
        "Documents & Text Files", 
        "txt", "pdf", "doc", "docx", "xls", "xlsx", "ppt", "pptx", "rtf", "odt"
    ));

    fileChooser.setDialogTitle("Select Document to Upload");

    int returnValue = fileChooser.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
        selectedFile = fileChooser.getSelectedFile();
        if (selectedFile == null) {
            JOptionPane.showMessageDialog(null, "No file selected", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        path = selectedFile.getAbsolutePath();
        destination = "src/userDocuments/" + selectedFile.getName();

        try {
            if (fileExistenceChecker(path) == 1) {
                int option = JOptionPane.showConfirmDialog(
                    null, 
                    "File already exists. Overwrite?", 
                    "File Exists", 
                    JOptionPane.YES_NO_OPTION
                );

                if (option != JOptionPane.YES_OPTION) {
                    destination = "";
                    path = "";
                    return;
                }
            }

            docs.setText("");
            docs.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

            String contentType = Files.probeContentType(selectedFile.toPath());
            if (contentType != null && contentType.startsWith("text/")) {
                try {
                    String content = readFileContent(path);
                    docs.setText(content);
                } catch (IOException ex) {
                    docs.setText("Error reading file content: " + ex.getMessage());
                    throw ex;
                }
            } else {
                String fileInfo = getFileInfo(path);
                docs.setText(fileInfo);
            }
            
            docs.setLineWrap(true);
            docs.setWrapStyleWord(true);
            docs.setCaretPosition(0);
            docs.setEditable(false);
            upload.setEnabled(false);
            remove.setEnabled(true);

        } catch (Exception ex) {
            String errorMsg = "Error processing file: " + ex.getMessage();
            docs.setText(errorMsg);
            JOptionPane.showMessageDialog(
                null, 
                errorMsg, 
                "File Error", 
                JOptionPane.ERROR_MESSAGE
            );
            System.err.println("File Error: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_uploadActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
    int confirm = JOptionPane.showConfirmDialog(
        null, 
        "Are you sure you want to clear the current document?", 
        "Confirm Removal", 
        JOptionPane.YES_NO_OPTION
    );
    
    if (confirm == JOptionPane.YES_OPTION) {
        docs.setText("");
        destination = "";
        path = "";
        selectedFile = null;
        upload.setEnabled(true);
        remove.setEnabled(false);
    }
    }//GEN-LAST:event_removeActionPerformed

    private void tnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnActionPerformed

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
            java.util.logging.Logger.getLogger(requestEvaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(requestEvaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(requestEvaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(requestEvaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new requestEvaluation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cnl;
    public com.toedter.calendar.JDateChooser dd;
    private javax.swing.JTextArea docs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton remove;
    public javax.swing.JPanel save;
    public javax.swing.JTextField status;
    public javax.swing.JTextField tid;
    public javax.swing.JTextField tn;
    private javax.swing.JButton upload;
    // End of variables declaration//GEN-END:variables
}

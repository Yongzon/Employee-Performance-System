/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Error.ErrorPage;
import config.Session;
import config.dbConnector;
import config.passHash;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Chris
 */
public class editEvaluatorForm extends javax.swing.JFrame {

    /**
     * Creates new form createUserForm
     */
    public editEvaluatorForm() {
        initComponents();
    }
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    public String answer = "No stored security answers";
    public String question = "No stored security questions";

    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();

        Path filePath = Paths.get("src/userImages", fileName);
        boolean fileExists = Files.exists(filePath);

        if (fileExists) {
            return 1;
        } else {
            return 0;
        }

    }
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
    try {
        // Read the image file
        File imageFile = new File(imagePath);
        BufferedImage image = ImageIO.read(imageFile);

        // Get the original width and height of the image
        int originalWidth = image.getWidth();
        int originalHeight = image.getHeight();

        // Calculate the new height based on the desired width and the aspect ratio
        int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);

        return newHeight;
    } catch (IOException ex) {
        System.out.println("No image found!");
    }

    return -1;
    }
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
    
    public void imageUpdater(String existingFilePath, String newFilePath){
    File existingFile = new File(existingFilePath);
    if (existingFile.exists()) {
        String parentDirectory = existingFile.getParent();
        File newFile = new File(newFilePath);
        String newFileName = newFile.getName();
        File updatedFile = new File(parentDirectory, newFileName);
        existingFile.delete();
        try {
            Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image updated successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while updating the image: "+e);
        }
    } else {
        try{
            Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
            System.out.println("Error on update!");
        }
    }
   }
    
//    public static String email, usern;
//    public boolean duplicateCheck(){
//        dbConnector db = new dbConnector();
//        
//        try{
//            String query = "SELECT * FROM tbl_admin WHERE u_username = '" + un.getText() + "' OR u_email = '" + position.getText() + "'";
//            ResultSet resultSet = db.getData(query);
//            if(resultSet.next()){
//                email = resultSet.getString("u_email");
//                if(email.equals(position.getText())){
//                    JOptionPane.showMessageDialog(null, "Email is Already used");
//                    position.setText("");
//                }
//                usern = resultSet.getString("u_username");
//                if(usern.equals(un.getText())){
//                    JOptionPane.showMessageDialog(null, "Username is Already in used");
//                    un.setText("");
//                }
//                return true;
//            }else{
//                return false;
//            }
//        }catch(SQLException ex){
//            System.out.println(""+ex);
//            return false;
//        }
//    }
    
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

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ln = new javax.swing.JTextField();
        position = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        department = new javax.swing.JComboBox<>();
        crt = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cnl = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        rm = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        select = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        emp = new javax.swing.JComboBox<>();
        em1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(241, 242, 247));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Position");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 100, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Edit Evaluator");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 200, 40));

        ln.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ln.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ln.setBorder(null);
        ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnActionPerformed(evt);
            }
        });
        jPanel3.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 220, 44));

        position.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        position.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        position.setBorder(null);
        position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionActionPerformed(evt);
            }
        });
        jPanel3.add(position, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 220, 44));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Upload Your Profile Photo");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 310, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Select Department");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 110, 30));

        fn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fn.setBorder(null);
        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        jPanel3.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 220, 44));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Email");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 100, 30));

        department.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        department.setBorder(null);
        department.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentActionPerformed(evt);
            }
        });
        jPanel3.add(department, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 220, 44));

        crt.setBackground(new java.awt.Color(0, 204, 204));
        crt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crtMouseExited(evt);
            }
        });
        crt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Update");
        crt.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 20));

        jPanel3.add(crt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 180, 40));

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

        jPanel3.add(cnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 180, 40));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Fist Name");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 100, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pen.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 310, 320));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 330, 340));

        rm.setBackground(new java.awt.Color(255, 51, 51));
        rm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rmMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rmMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rmMouseExited(evt);
            }
        });
        rm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Remove");
        rm.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jPanel3.add(rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 150, 40));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Last Name");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 100, 30));

        select.setBackground(new java.awt.Color(0, 204, 204));
        select.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectMouseExited(evt);
            }
        });
        select.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Select");
        select.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, 20));

        jPanel3.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 490, 150, 40));

        jPanel2.setBackground(new java.awt.Color(1, 216, 218));
        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 20));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Selected Evaluator");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 110, 30));

        emp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        emp.setBorder(null);
        emp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        emp.setEnabled(false);
        emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empActionPerformed(evt);
            }
        });
        jPanel3.add(emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 220, 44));

        em1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        em1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        em1.setBorder(null);
        em1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                em1ActionPerformed(evt);
            }
        });
        jPanel3.add(em1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 220, 44));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnActionPerformed

    private void positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departmentActionPerformed

    private void crtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crtMouseClicked
//        String firstname = fn.getText();
//        String lastname = ln.getText();
//        String email1 = position.getText();
//        String username1 = un.getText();
//        String password1 = new String(position.getPassword());
//        String cpassword = new String(cp.getPassword());
//        
//        if (firstname.isEmpty() && lastname.isEmpty() && email1.isEmpty() && username1.isEmpty() && password1.isEmpty() && cpassword.isEmpty()){
//            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
//        }else if(password1.length() < 8){
//            JOptionPane.showMessageDialog(this, "Password must be atleast 8 characters!", "Error", JOptionPane.ERROR_MESSAGE);
//        }else if(position.getText().length() < 8){
//            JOptionPane.showMessageDialog(null, "Password must be atleast 8 characters long");
//            position.setText("");
//        }else if(duplicateCheck()){
//            System.out.println("Duplicate Exist");
//        }else if(!position.getText().equals(cp.getText())){
//            JOptionPane.showMessageDialog(null, "Password not Matches");
//        }else{
//            dbConnector db = new dbConnector();
//            try{
//                String pass = passHash.hashPassword(position.getText());
//                String pass2 = passHash.hashPassword(cp.getText());
//            
//            if(db.InsertData("INSERT INTO tbl_admin (u_fname, u_lname, u_email, u_type, u_username, u_status, u_image, u_questions, u_answers, u_password, u_cpassword)"  
//            + "VALUES ('"+fn.getText()+"', '"+ln.getText()+"', '"+position.getText()+"', '"+role.getSelectedItem()+"', '"+un.getText()+"', '"+department.getSelectedItem()+"', '"+destination+"' ,'"+question+"' ,'"+answer+"', '"+pass+"' ,'"+pass2+"')") == 1){
//            try{
//                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
//                Session sess = Session.getInstance();
//                db.logActivity(sess.getUid(), "Create a user: " + un.getText());
//                JOptionPane.showMessageDialog(this, "Account Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
//                userTable ut = new userTable();
//                ut.setVisible(true);
//                this.dispose();
//            }catch(IOException ex){
//                System.out.println("Insert Image Error:"+ex);
//                }
//            }else{
//                JOptionPane.showMessageDialog(null, "Connection Error");
//            }
//            }catch(NoSuchAlgorithmException ex){
//            System.out.println(""+ex);
//            }
//        }
    }//GEN-LAST:event_crtMouseClicked

    private void crtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crtMouseEntered
        crt.setBackground(nav);
    }//GEN-LAST:event_crtMouseEntered

    private void crtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crtMouseExited
        crt.setBackground(bodycolor);
    }//GEN-LAST:event_crtMouseExited

    private void cnlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cnlMouseClicked
        evaluatorForm ef = new evaluatorForm();
        ef.setVisible(true);
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

    private void selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/userImages/" + selectedFile.getName();
                path  = selectedFile.getAbsolutePath();

                if(FileExistenceChecker(path) == 1){
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    destination = "";
                    path="";
                }else{
                    image.setIcon(ResizeImage(path, null, image));
//                    select.setVisible(true);
//                    rm.setVisible(false);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_selectMouseClicked

    private void selectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseEntered
        select.setBackground(nav);
    }//GEN-LAST:event_selectMouseEntered

    private void selectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseExited
        select.setBackground(bodycolor);
    }//GEN-LAST:event_selectMouseExited

    private void rmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rmMouseClicked
        image.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_rmMouseClicked

    private void rmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rmMouseEntered
        rm.setBackground(nav1);
    }//GEN-LAST:event_rmMouseEntered

    private void rmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rmMouseExited
        rm.setBackground(bodycolor1);
    }//GEN-LAST:event_rmMouseExited

    private void empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empActionPerformed

    private void em1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_em1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_em1ActionPerformed

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
            java.util.logging.Logger.getLogger(editEvaluatorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editEvaluatorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editEvaluatorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editEvaluatorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new editEvaluatorForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cnl;
    public javax.swing.JPanel crt;
    public javax.swing.JComboBox<String> department;
    public javax.swing.JTextField em1;
    public javax.swing.JComboBox<String> emp;
    public javax.swing.JTextField fn;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JTextField ln;
    public javax.swing.JTextField position;
    private javax.swing.JPanel rm;
    private javax.swing.JPanel select;
    // End of variables declaration//GEN-END:variables
}

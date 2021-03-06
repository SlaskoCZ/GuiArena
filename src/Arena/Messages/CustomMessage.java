/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arena.Messages;

import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

/**
 *
 * @author Petr
 */
public class CustomMessage extends javax.swing.JDialog {

    /**
     * Creates new form CustomMessage
     *
     * @param title title of window
     * @param message message displayed to user in customMessageTextFieldArea
     */
    public CustomMessage(java.awt.Frame parent, boolean modal, String title, String message) {
        super(parent, modal);
        this.getContentPane().setBackground(Color.lightGray);
        initComponents();
        this.setTitle(title);
        this.setLocationRelativeTo(parent);
        customMessageTextFieldArea.setText(message);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customMessageButtonOK = new javax.swing.JButton();
        customMessageTextField = new javax.swing.JScrollPane();
        customMessageTextFieldArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setUndecorated(true);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        customMessageButtonOK.setText("OK");
        customMessageButtonOK.setPreferredSize(new java.awt.Dimension(50, 25));
        customMessageButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customMessageButtonOKActionPerformed(evt);
            }
        });

        customMessageTextField.setBorder(null);

        customMessageTextFieldArea.setEditable(false);
        customMessageTextFieldArea.setBackground(java.awt.SystemColor.control);
        customMessageTextFieldArea.setColumns(3);
        customMessageTextFieldArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customMessageTextFieldArea.setLineWrap(true);
        customMessageTextFieldArea.setRows(3);
        customMessageTextFieldArea.setWrapStyleWord(true);
        customMessageTextFieldArea.setAutoscrolls(false);
        customMessageTextFieldArea.setBorder(null);
        customMessageTextFieldArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        customMessageTextFieldArea.setMargin(new java.awt.Insets(0, 0, 0, 0));
        customMessageTextFieldArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                customMessageTextFieldAreaMousePressed(evt);
            }
        });
        customMessageTextFieldArea.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                customMessageTextFieldAreaMouseDragged(evt);
            }
        });
        customMessageTextField.setViewportView(customMessageTextFieldArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customMessageTextField)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(customMessageButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customMessageTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customMessageButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customMessageButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customMessageButtonOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_customMessageButtonOKActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
    }//GEN-LAST:event_formMouseDragged

    private void customMessageTextFieldAreaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customMessageTextFieldAreaMousePressed
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_customMessageTextFieldAreaMousePressed

    private void customMessageTextFieldAreaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customMessageTextFieldAreaMouseDragged
        this.setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
    }//GEN-LAST:event_customMessageTextFieldAreaMouseDragged

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
            java.util.logging.Logger.getLogger(CustomMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CustomMessage dialog = new CustomMessage(new javax.swing.JFrame(), true, "", "");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    private int posX = 0;
    private int posY = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton customMessageButtonOK;
    private javax.swing.JScrollPane customMessageTextField;
    private javax.swing.JTextArea customMessageTextFieldArea;
    // End of variables declaration//GEN-END:variables
}

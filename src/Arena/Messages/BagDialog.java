/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arena.Messages;

import Metods.Hero;
import Metods.Shop;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Petr
 */
public class BagDialog extends javax.swing.JDialog {

    /**
     * Creates new form BagDialog
     */
    public BagDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        bagDialogList.setModel(Metods.Hero.inventory());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bagDialogPopupMenu = new javax.swing.JPopupMenu();
        bagDialogPopupMenuWear = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bagDialogPopupMenuDestroy = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        bagDialogPopupMenuInfo = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        bagDialogList = new javax.swing.JList();
        bagDialogButtonBack = new javax.swing.JButton();

        bagDialogPopupMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bagDialogPopupMenuMousePressed(evt);
            }
        });

        bagDialogPopupMenuWear.setText("Wear Item");
        bagDialogPopupMenuWear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bagDialogPopupMenuWearActionPerformed(evt);
            }
        });
        bagDialogPopupMenu.add(bagDialogPopupMenuWear);
        bagDialogPopupMenu.add(jSeparator1);

        bagDialogPopupMenuDestroy.setText("Destroy Item");
        bagDialogPopupMenuDestroy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bagDialogPopupMenuDestroyActionPerformed(evt);
            }
        });
        bagDialogPopupMenu.add(bagDialogPopupMenuDestroy);
        bagDialogPopupMenu.add(jSeparator2);

        bagDialogPopupMenuInfo.setText("Info about Item");
        bagDialogPopupMenuInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bagDialogPopupMenuInfoActionPerformed(evt);
            }
        });
        bagDialogPopupMenu.add(bagDialogPopupMenuInfo);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(524, 300));
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setMaximumSize(new java.awt.Dimension(258, 278));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(258, 25));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(258, 25));

        bagDialogList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bagDialogList.setName(""); // NOI18N
        bagDialogList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bagDialogListMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(bagDialogList);

        bagDialogButtonBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bagDialogButtonBack.setText("Back to main menu");
        bagDialogButtonBack.setPreferredSize(new java.awt.Dimension(80, 40));
        bagDialogButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bagDialogButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bagDialogButtonBack, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(bagDialogButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bagDialogButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagDialogButtonBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_bagDialogButtonBackActionPerformed

    private void bagDialogPopupMenuInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagDialogPopupMenuInfoActionPerformed

    }//GEN-LAST:event_bagDialogPopupMenuInfoActionPerformed

    private void bagDialogPopupMenuWearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagDialogPopupMenuWearActionPerformed
        Hero.addCharacterItems(bagDialogList.getSelectedIndex());
        Shop.deleteInventorySlotAndSort(bagDialogList.getSelectedIndex());
        bagDialogList.setModel(Metods.Hero.inventory());
    }//GEN-LAST:event_bagDialogPopupMenuWearActionPerformed

    private void bagDialogPopupMenuDestroyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagDialogPopupMenuDestroyActionPerformed
        Shop.deleteInventorySlotAndSort(bagDialogList.getSelectedIndex());
        bagDialogList.setModel(Metods.Hero.inventory());
    }//GEN-LAST:event_bagDialogPopupMenuDestroyActionPerformed

    private void bagDialogListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bagDialogListMousePressed
        bagDialogPopupMenu.setVisible(false);
        System.out.println(evt.getButton());
        if (evt.getButton() == 3) {
            System.out.println("MENU");
            bagDialogPopupMenu.setLocation(evt.getXOnScreen(), evt.getYOnScreen());
            JList list = (JList) evt.getSource();
            int row = list.locationToIndex(evt.getPoint());
            list.setSelectedIndex(row);
            if (list.getSelectedIndex() == -1) {
                bagDialogPopupMenuDestroy.setEnabled(false);
                bagDialogPopupMenuInfo.setEnabled(false);
                bagDialogPopupMenuWear.setEnabled(false);
            } else {
                bagDialogPopupMenuDestroy.setEnabled(true);
                bagDialogPopupMenuInfo.setEnabled(true);
                bagDialogPopupMenuWear.setEnabled(true);
            }
            bagDialogPopupMenu.setVisible(true);
        }
    }//GEN-LAST:event_bagDialogListMousePressed

    private void bagDialogPopupMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bagDialogPopupMenuMousePressed
        bagDialogPopupMenu.setVisible(false);
        if (evt.getButton() == MouseEvent.BUTTON2) {
            System.out.println("Rightclick !");
            JList list = (JList) evt.getSource();
            int row = list.locationToIndex(evt.getPoint());
            list.setSelectedIndex(row);
            if (list.getSelectedIndex() == -1) {
                bagDialogPopupMenuDestroy.setEnabled(false);
                bagDialogPopupMenuInfo.setEnabled(false);
                bagDialogPopupMenuWear.setEnabled(false);
            } else {
                bagDialogPopupMenuDestroy.setEnabled(true);
                bagDialogPopupMenuInfo.setEnabled(true);
                bagDialogPopupMenuWear.setEnabled(true);
            }
        }
    }//GEN-LAST:event_bagDialogPopupMenuMousePressed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
       bagDialogPopupMenu.setVisible(false);
    }//GEN-LAST:event_formWindowLostFocus

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
            java.util.logging.Logger.getLogger(BagDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BagDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BagDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BagDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BagDialog dialog = new BagDialog(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bagDialogButtonBack;
    private javax.swing.JList bagDialogList;
    private javax.swing.JPopupMenu bagDialogPopupMenu;
    private javax.swing.JMenuItem bagDialogPopupMenuDestroy;
    private javax.swing.JMenuItem bagDialogPopupMenuInfo;
    private javax.swing.JMenuItem bagDialogPopupMenuWear;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables
}

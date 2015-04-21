/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arena.Messages;

import javax.swing.JLabel;

/**
 *
 * @author Petr
 */
public class StatDialog extends javax.swing.JDialog {

    /**
     * Creates new form StatDialog
     */
    public StatDialog(java.awt.Frame parent, boolean modal, int index) {
        super(parent, modal);
        String[] stats = Metods.HeroStats.getInventoryStats(index);
        initComponents();
        setItemStatsLabelNameStat(stats[0]);
        setItemStatsLabelSTRStat(stats[1]);
        setItemStatsLabelDEXStat(stats[2]);
        setItemStatsLabelINTStat(stats[3]);
        setItemStatsLabelVITStat(stats[4]);
        setItemStatsLabelDMGStat(stats[5]);
        setItemStatsLabelDefStat(stats[6]);
        setItemStatsLabelPriceStat(stats[8]);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemStatsPanel = new javax.swing.JPanel();
        itemStatsLabelName = new javax.swing.JLabel();
        itemStatsLabelSTR = new javax.swing.JLabel();
        itemStatsLabelDEX = new javax.swing.JLabel();
        itemStatsLabelVIT = new javax.swing.JLabel();
        itemStatsLabelINT = new javax.swing.JLabel();
        statDialogButtonOK = new javax.swing.JButton();
        itemStatsLabelNameStat = new javax.swing.JLabel();
        itemStatsLabelSTRStat = new javax.swing.JLabel();
        itemStatsLabelDEXStat = new javax.swing.JLabel();
        itemStatsLabelVITStat = new javax.swing.JLabel();
        itemStatsLabelINTStat = new javax.swing.JLabel();
        itemStatsItemStats = new javax.swing.JLabel();
        itemStatsLabelDMG = new javax.swing.JLabel();
        itemStatsLabelDEF = new javax.swing.JLabel();
        itemStatsLabelPrice = new javax.swing.JLabel();
        itemStatsLabelDMGStat = new javax.swing.JLabel();
        itemStatsLabelDefStat = new javax.swing.JLabel();
        itemStatsLabelPriceStat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        itemStatsPanel.setBackground(new java.awt.Color(204, 204, 204));
        itemStatsPanel.setMaximumSize(new java.awt.Dimension(213, 350));
        itemStatsPanel.setPreferredSize(new java.awt.Dimension(213, 380));

        itemStatsLabelName.setText("Name:");

        itemStatsLabelSTR.setText("STR:");

        itemStatsLabelDEX.setText("DEX:");

        itemStatsLabelVIT.setText("VIT:");

        itemStatsLabelINT.setText("INT:");

        statDialogButtonOK.setText("OK");
        statDialogButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statDialogButtonOKActionPerformed(evt);
            }
        });

        itemStatsLabelNameStat.setText("Argus Pyrrhus");
        itemStatsLabelNameStat.setMaximumSize(new java.awt.Dimension(130, 10));
        itemStatsLabelNameStat.setName(""); // NOI18N
        itemStatsLabelNameStat.setPreferredSize(new java.awt.Dimension(120, 15));

        itemStatsLabelSTRStat.setMaximumSize(new java.awt.Dimension(130, 10));
        itemStatsLabelSTRStat.setName(""); // NOI18N
        itemStatsLabelSTRStat.setPreferredSize(new java.awt.Dimension(120, 15));

        itemStatsLabelDEXStat.setMaximumSize(new java.awt.Dimension(130, 10));
        itemStatsLabelDEXStat.setName(""); // NOI18N
        itemStatsLabelDEXStat.setPreferredSize(new java.awt.Dimension(120, 15));

        itemStatsLabelVITStat.setMaximumSize(new java.awt.Dimension(130, 10));
        itemStatsLabelVITStat.setName(""); // NOI18N
        itemStatsLabelVITStat.setPreferredSize(new java.awt.Dimension(120, 15));

        itemStatsLabelINTStat.setMaximumSize(new java.awt.Dimension(130, 10));
        itemStatsLabelINTStat.setName(""); // NOI18N
        itemStatsLabelINTStat.setPreferredSize(new java.awt.Dimension(120, 15));

        itemStatsItemStats.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        itemStatsItemStats.setText("Item Stats");
        itemStatsItemStats.setPreferredSize(new java.awt.Dimension(130, 15));

        itemStatsLabelDMG.setText("DMG:");

        itemStatsLabelDEF.setText("DEF:");

        itemStatsLabelPrice.setText("Sell price:");

        itemStatsLabelDMGStat.setMaximumSize(new java.awt.Dimension(130, 10));
        itemStatsLabelDMGStat.setName(""); // NOI18N
        itemStatsLabelDMGStat.setPreferredSize(new java.awt.Dimension(120, 15));

        itemStatsLabelDefStat.setMaximumSize(new java.awt.Dimension(130, 10));
        itemStatsLabelDefStat.setName(""); // NOI18N
        itemStatsLabelDefStat.setPreferredSize(new java.awt.Dimension(120, 15));

        itemStatsLabelPriceStat.setMaximumSize(new java.awt.Dimension(130, 10));
        itemStatsLabelPriceStat.setName(""); // NOI18N
        itemStatsLabelPriceStat.setPreferredSize(new java.awt.Dimension(120, 15));

        javax.swing.GroupLayout itemStatsPanelLayout = new javax.swing.GroupLayout(itemStatsPanel);
        itemStatsPanel.setLayout(itemStatsPanelLayout);
        itemStatsPanelLayout.setHorizontalGroup(
            itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemStatsPanelLayout.createSequentialGroup()
                .addGroup(itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemStatsPanelLayout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addGroup(itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(itemStatsPanelLayout.createSequentialGroup()
                                .addComponent(itemStatsLabelDMG)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemStatsLabelDMGStat, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(itemStatsPanelLayout.createSequentialGroup()
                                .addComponent(itemStatsLabelDEF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemStatsLabelDefStat, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(itemStatsPanelLayout.createSequentialGroup()
                                .addGroup(itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(itemStatsPanelLayout.createSequentialGroup()
                                        .addComponent(itemStatsLabelName)
                                        .addGap(32, 32, 32)
                                        .addComponent(itemStatsLabelNameStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(itemStatsPanelLayout.createSequentialGroup()
                                        .addGroup(itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(itemStatsLabelSTR)
                                            .addComponent(itemStatsLabelDEX)
                                            .addComponent(itemStatsLabelVIT)
                                            .addComponent(itemStatsLabelINT))
                                        .addGap(40, 40, 40)
                                        .addGroup(itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(itemStatsLabelVITStat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(itemStatsLabelDEXStat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(itemStatsLabelSTRStat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(itemStatsLabelINTStat, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(itemStatsPanelLayout.createSequentialGroup()
                                        .addComponent(itemStatsLabelPrice)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(itemStatsLabelPriceStat, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemStatsPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemStatsPanelLayout.createSequentialGroup()
                                .addComponent(statDialogButtonOK)
                                .addGap(73, 73, 73))
                            .addComponent(itemStatsItemStats, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        itemStatsPanelLayout.setVerticalGroup(
            itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemStatsPanelLayout.createSequentialGroup()
                .addComponent(itemStatsItemStats, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemStatsLabelName)
                    .addComponent(itemStatsLabelNameStat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemStatsLabelSTR)
                    .addComponent(itemStatsLabelSTRStat, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemStatsLabelDEX)
                    .addComponent(itemStatsLabelDEXStat, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemStatsLabelVIT)
                    .addComponent(itemStatsLabelVITStat, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(itemStatsLabelINT)
                    .addComponent(itemStatsLabelINTStat, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemStatsLabelDMG)
                    .addComponent(itemStatsLabelDMGStat, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemStatsLabelDEF)
                    .addComponent(itemStatsLabelDefStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(itemStatsLabelPrice)
                    .addComponent(itemStatsLabelPriceStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(statDialogButtonOK))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemStatsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(itemStatsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void statDialogButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statDialogButtonOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_statDialogButtonOKActionPerformed

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
            java.util.logging.Logger.getLogger(StatDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StatDialog dialog = new StatDialog(new javax.swing.JFrame(), true, 0);
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
    //<editor-fold defaultstate="collapsed" desc=" Variables ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel itemStatsItemStats;
    private javax.swing.JLabel itemStatsLabelDEF;
    private javax.swing.JLabel itemStatsLabelDEX;
    public static javax.swing.JLabel itemStatsLabelDEXStat;
    private javax.swing.JLabel itemStatsLabelDMG;
    public static javax.swing.JLabel itemStatsLabelDMGStat;
    public static javax.swing.JLabel itemStatsLabelDefStat;
    private javax.swing.JLabel itemStatsLabelINT;
    public static javax.swing.JLabel itemStatsLabelINTStat;
    private javax.swing.JLabel itemStatsLabelName;
    public static javax.swing.JLabel itemStatsLabelNameStat;
    private javax.swing.JLabel itemStatsLabelPrice;
    public static javax.swing.JLabel itemStatsLabelPriceStat;
    private javax.swing.JLabel itemStatsLabelSTR;
    public static javax.swing.JLabel itemStatsLabelSTRStat;
    private javax.swing.JLabel itemStatsLabelVIT;
    public static javax.swing.JLabel itemStatsLabelVITStat;
    private javax.swing.JPanel itemStatsPanel;
    private javax.swing.JButton statDialogButtonOK;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Gettings and Settings ">

    public static void setItemStatsLabelDEXStat(String text) {
        StatDialog.itemStatsLabelDEXStat.setText(text);
    }

    public static void setItemStatsLabelDMGStat(String text) {
        StatDialog.itemStatsLabelDMGStat.setText(text);
    }

    public static void setItemStatsLabelDefStat(String text) {
        StatDialog.itemStatsLabelDefStat.setText(text);
    }

    public static void setItemStatsLabelINTStat(String text) {
        StatDialog.itemStatsLabelINTStat.setText(text);
    }

    public static void setItemStatsLabelNameStat(String text) {
        StatDialog.itemStatsLabelNameStat.setText(text);
    }

    public static void setItemStatsLabelPriceStat(String text) {
        StatDialog.itemStatsLabelPriceStat.setText(text);
    }

    public static void setItemStatsLabelSTRStat(String text) {
        StatDialog.itemStatsLabelSTRStat.setText(text);
    }

    public static void setItemStatsLabelVITStat(String text) {
        StatDialog.itemStatsLabelVITStat.setText(text);
    }
        //</editor-fold>
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arena.Messages;

import Metods.Stats;

/**
 *
 * @author Petr
 */
public class EnemyStatsDialog extends javax.swing.JDialog {

    //@todo make stats for more enemies (probably buttons to change enemy numbers)
    public EnemyStatsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadStats(enemyStats);
        if (Arena.MainClass.getEnemyNumber()<2){
            enemyStatsDialogButtonNext.setEnabled(false);
        } else {
            enemyStatsDialogButtonNext.setEnabled(true);
        }
    }

    private void loadStats(int enemyNumber) {
        Stats stats = new Stats();
        String[] rawStats = stats.enemy(enemyNumber);
        changableStatsName.setText(rawStats[0]);
        changableStatsHP.setText(rawStats[5]);
        changableStatsMP.setText(rawStats[6]);
        changableStatsSTR.setText(rawStats[1]);
        changableStatsDEX.setText(rawStats[2]);
        changableStatsINT.setText(rawStats[3]);
        changableStatsVIT.setText(rawStats[4]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enemyStatsName = new javax.swing.JLabel();
        enemyStatsHP = new javax.swing.JLabel();
        enemyStatsMP = new javax.swing.JLabel();
        enemyStatsSTR = new javax.swing.JLabel();
        enemyStatsDEX = new javax.swing.JLabel();
        enemyStatsINT = new javax.swing.JLabel();
        enemyStatsVIT = new javax.swing.JLabel();
        changableStatsName = new javax.swing.JLabel();
        changableStatsHP = new javax.swing.JLabel();
        changableStatsMP = new javax.swing.JLabel();
        changableStatsSTR = new javax.swing.JLabel();
        changableStatsDEX = new javax.swing.JLabel();
        changableStatsINT = new javax.swing.JLabel();
        changableStatsVIT = new javax.swing.JLabel();
        enemyStatsEnemyStats = new javax.swing.JLabel();
        enemyStatsButtonBack = new javax.swing.JButton();
        enemyStatsDialogButtonPrev = new javax.swing.JButton();
        enemyStatsDialogButtonNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stats");

        enemyStatsName.setText("Name:");

        enemyStatsHP.setText("Hp:");

        enemyStatsMP.setText("MP:");

        enemyStatsSTR.setText("STR:");

        enemyStatsDEX.setText("DEX:");

        enemyStatsINT.setText("INT:");

        enemyStatsVIT.setText("VIT:");

        changableStatsName.setText("jLabel8");

        changableStatsHP.setText("jLabel9");

        changableStatsMP.setText("jLabel10");

        changableStatsSTR.setText("jLabel11");

        changableStatsDEX.setText("jLabel12");

        changableStatsINT.setText("jLabel13");

        changableStatsVIT.setText("jLabel14");

        enemyStatsEnemyStats.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enemyStatsEnemyStats.setText("Enemy Stats");

        enemyStatsButtonBack.setText("OK");
        enemyStatsButtonBack.setPreferredSize(new java.awt.Dimension(50, 25));
        enemyStatsButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enemyStatsButtonBackActionPerformed(evt);
            }
        });

        enemyStatsDialogButtonPrev.setText("Prev");
        enemyStatsDialogButtonPrev.setPreferredSize(new java.awt.Dimension(60, 25));
        enemyStatsDialogButtonPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enemyStatsDialogButtonPrevActionPerformed(evt);
            }
        });

        enemyStatsDialogButtonNext.setText("Next");
        enemyStatsDialogButtonNext.setPreferredSize(new java.awt.Dimension(60, 25));
        enemyStatsDialogButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enemyStatsDialogButtonNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(enemyStatsEnemyStats))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(enemyStatsButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(enemyStatsVIT)
                                    .addComponent(enemyStatsINT)
                                    .addComponent(enemyStatsDEX)
                                    .addComponent(enemyStatsSTR)
                                    .addComponent(enemyStatsMP)
                                    .addComponent(enemyStatsHP)
                                    .addComponent(enemyStatsName))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(changableStatsName)
                                    .addComponent(changableStatsHP)
                                    .addComponent(changableStatsMP)
                                    .addComponent(changableStatsSTR)
                                    .addComponent(changableStatsDEX)
                                    .addComponent(changableStatsINT)
                                    .addComponent(changableStatsVIT)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(enemyStatsDialogButtonPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enemyStatsDialogButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enemyStatsEnemyStats)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enemyStatsDialogButtonPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enemyStatsDialogButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(changableStatsName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changableStatsHP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changableStatsMP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changableStatsSTR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changableStatsDEX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changableStatsINT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changableStatsVIT))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enemyStatsName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enemyStatsHP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enemyStatsMP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enemyStatsSTR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enemyStatsDEX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enemyStatsINT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enemyStatsVIT)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enemyStatsButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        enemyStatsDialogButtonPrev.setEnabled(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enemyStatsButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enemyStatsButtonBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_enemyStatsButtonBackActionPerformed

    private void enemyStatsDialogButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enemyStatsDialogButtonNextActionPerformed

        if (enemyStats < Arena.MainClass.getEnemyNumber()) {
            enemyStats++;
            loadStats(enemyStats);
            enemyStatsDialogButtonPrev.setEnabled(true);
        } else {

        }
        if (enemyStats == Arena.MainClass.getEnemyNumber() - 1) {
            enemyStatsDialogButtonNext.setEnabled(false);

        }
    }//GEN-LAST:event_enemyStatsDialogButtonNextActionPerformed

    private void enemyStatsDialogButtonPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enemyStatsDialogButtonPrevActionPerformed
        if ((enemyStats - 1) >= 0) {
            enemyStats--;
            loadStats(enemyStats);
            enemyStatsDialogButtonNext.setEnabled(true);
        } else {
            System.out.println("Cant do that !");
        }
        if (enemyStats == 0){
            enemyStatsDialogButtonPrev.setEnabled(false);
        }
    }//GEN-LAST:event_enemyStatsDialogButtonPrevActionPerformed

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
            java.util.logging.Logger.getLogger(EnemyStatsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnemyStatsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnemyStatsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnemyStatsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EnemyStatsDialog dialog = new EnemyStatsDialog(new javax.swing.JFrame(), true);
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
    private int enemyStats = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel changableStatsDEX;
    private javax.swing.JLabel changableStatsHP;
    private javax.swing.JLabel changableStatsINT;
    private javax.swing.JLabel changableStatsMP;
    private javax.swing.JLabel changableStatsName;
    private javax.swing.JLabel changableStatsSTR;
    private javax.swing.JLabel changableStatsVIT;
    private javax.swing.JButton enemyStatsButtonBack;
    private javax.swing.JLabel enemyStatsDEX;
    private javax.swing.JButton enemyStatsDialogButtonNext;
    private javax.swing.JButton enemyStatsDialogButtonPrev;
    private javax.swing.JLabel enemyStatsEnemyStats;
    private javax.swing.JLabel enemyStatsHP;
    private javax.swing.JLabel enemyStatsINT;
    private javax.swing.JLabel enemyStatsMP;
    private javax.swing.JLabel enemyStatsName;
    private javax.swing.JLabel enemyStatsSTR;
    private javax.swing.JLabel enemyStatsVIT;
    // End of variables declaration//GEN-END:variables
}

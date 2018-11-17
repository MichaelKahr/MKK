package GUI;

import BL.Item;
import BL.PlayerModel;
import BL.PlayerRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author mikeykahr
 */
public class MkkGUI extends javax.swing.JFrame {

    public static PlayerModel model = new PlayerModel();
    private final DefaultListModel lmodel = new DefaultListModel();
    private int selectedRow;
    private int[] selectedRows;
    /**
     * Creates new form MkkGUI
     */
    public MkkGUI() {
        initComponents();
        jtOut.setModel(model);
        jtOut.setDefaultRenderer(Object.class, new PlayerRenderer());
        jtOut.setShowGrid(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmFight = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmAddPlayer = new javax.swing.JMenuItem();
        jmAddItem = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtOut = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        taItems = new javax.swing.JTextArea();

        jmFight.setText("Fight");
        jmFight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmFightActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmFight);

        jMenu1.setText("Add");

        jmAddPlayer.setText("Add Player");
        jmAddPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAddPlayerActionPerformed(evt);
            }
        });
        jMenu1.add(jmAddPlayer);

        jmAddItem.setText("Add item");
        jmAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAddItemActionPerformed(evt);
            }
        });
        jMenu1.add(jmAddItem);

        jPopupMenu1.add(jMenu1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setComponentPopupMenu(jPopupMenu1);

        jtOut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtOut.setComponentPopupMenu(jPopupMenu1);
        jtOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtOutMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtOut);

        taItems.setColumns(20);
        taItems.setRows(5);
        jScrollPane3.setViewportView(taItems);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmAddPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAddPlayerActionPerformed
        PlayerDlg dialog = new PlayerDlg(this, true);
        dialog.setVisible(true);
        if(dialog.isOk()){
            model.add(dialog.getP());
        }
    }//GEN-LAST:event_jmAddPlayerActionPerformed

    private void jmFightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmFightActionPerformed
        if(selectedRows.length!=2){
            JOptionPane.showMessageDialog(null, "Please select 2 Players!");
        }
        else{
            model.fight(model.getPlayers().get(selectedRows[0]), model.getPlayers().get(selectedRows[1]));
        }
    }//GEN-LAST:event_jmFightActionPerformed

    private void jtOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtOutMouseClicked
        selectedRow = jtOut.getSelectedRow();
        selectedRows = jtOut.getSelectedRows();
        for (Item i : model.getPlayers().get(selectedRow).getItems()) {
            taItems.append(i.toString()+"\n");
        }
        System.out.println(model.getPlayers().get(selectedRow).getItems().toString());
    }//GEN-LAST:event_jtOutMouseClicked

    private void jmAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAddItemActionPerformed
        ItemDlg dialog = new ItemDlg(this, true);
        dialog.setVisible(true);
        if(dialog.isOk()){
            model.getPlayers().get(selectedRow).addItem(dialog.getI());
        }
    }//GEN-LAST:event_jmAddItemActionPerformed

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
            java.util.logging.Logger.getLogger(MkkGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MkkGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MkkGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MkkGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MkkGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem jmAddItem;
    private javax.swing.JMenuItem jmAddPlayer;
    private javax.swing.JMenuItem jmFight;
    private javax.swing.JTable jtOut;
    private javax.swing.JTextArea taItems;
    // End of variables declaration//GEN-END:variables
}

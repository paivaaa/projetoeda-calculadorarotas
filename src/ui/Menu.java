/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tiago Paiva e Mário Bonacho
 */
package ui;

import java.awt.Color;

public class Menu extends javax.swing.JFrame {
    
    CalcularRotas calcularRotas;
    Historico historico;
     Pesquisa pesquisa;

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        
        setTitle("Calculadora de rotas");
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        
        calcularRotas = new CalcularRotas(this);
        historico = new Historico(this);
        pesquisa = new Pesquisa(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DownPanel = new javax.swing.JPanel();
        btnCalcularRotas = new javax.swing.JButton();
        btnPesquisarCidades = new javax.swing.JButton();
        btnHistorico = new javax.swing.JButton();
        UpPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DownPanel.setBackground(new java.awt.Color(255, 255, 255));
        DownPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCalcularRotas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCalcularRotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/map-icon.png"))); // NOI18N
        btnCalcularRotas.setText("Calcular rotas");
        btnCalcularRotas.setFocusable(false);
        btnCalcularRotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularRotasActionPerformed(evt);
            }
        });
        DownPanel.add(btnCalcularRotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 230, 40));

        btnPesquisarCidades.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPesquisarCidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/search-icon.png"))); // NOI18N
        btnPesquisarCidades.setText("Pesquisar");
        btnPesquisarCidades.setFocusable(false);
        btnPesquisarCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarCidadesActionPerformed(evt);
            }
        });
        DownPanel.add(btnPesquisarCidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 230, 40));

        btnHistorico.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/history-icon.png"))); // NOI18N
        btnHistorico.setText("Histórico Rotas");
        btnHistorico.setFocusable(false);
        btnHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoActionPerformed(evt);
            }
        });
        DownPanel.add(btnHistorico, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 230, 40));

        getContentPane().add(DownPanel, java.awt.BorderLayout.CENTER);

        UpPanel.setBackground(new java.awt.Color(255, 255, 255));

        logo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/logo.png"))); // NOI18N

        javax.swing.GroupLayout UpPanelLayout = new javax.swing.GroupLayout(UpPanel);
        UpPanel.setLayout(UpPanelLayout);
        UpPanelLayout.setHorizontalGroup(
            UpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpPanelLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(logo)
                .addContainerGap(144, Short.MAX_VALUE))
        );
        UpPanelLayout.setVerticalGroup(
            UpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(UpPanel, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 25));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularRotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularRotasActionPerformed
        // TODO add your handling code here:
        calcularRotas.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnCalcularRotasActionPerformed

    private void btnPesquisarCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarCidadesActionPerformed
        // TODO add your handling code here:
        pesquisa.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnPesquisarCidadesActionPerformed

    private void btnHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoActionPerformed
        // TODO add your handling code here:
        historico.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnHistoricoActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DownPanel;
    private javax.swing.JPanel UpPanel;
    private javax.swing.JButton btnCalcularRotas;
    private javax.swing.JButton btnHistorico;
    private javax.swing.JButton btnPesquisarCidades;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}

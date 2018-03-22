package br.trabalho1.frontend;

import br.trabalho1.backend.WordAnalyser;
import br.trabalho1.backend.WordType;
import br.trabalho1.utils.NumberedBorder;
import java.util.Map;
import javax.swing.ScrollPaneConstants;

/**
 * Classe que representa a parte gráfica do programa.
 *
 * @author Alan Boaventura
 */
public class Main extends javax.swing.JFrame {

    /**
     * Frame/tela principal da aplicação.
     */
    private static final Main FRAME_PRINCIPAL = new Main();

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraDeRolagemInput = new javax.swing.JScrollPane(inputTextArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        inputTextArea = new javax.swing.JTextArea();
        barraDeRolagemOuput = new javax.swing.JScrollPane(inputTextArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outputTextArea = new javax.swing.JTextArea();
        btnAnalisar = new javax.swing.JButton();
        btnEquipe = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(870, 670));
        setResizable(false);
        setSize(new java.awt.Dimension(870, 670));

        inputTextArea.setBorder(new NumberedBorder());
        inputTextArea.setColumns(20);
        inputTextArea.setRows(5);
        barraDeRolagemInput.setViewportView(inputTextArea);

        outputTextArea.setEditable(false);
        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        barraDeRolagemOuput.setViewportView(outputTextArea);

        btnAnalisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/trabalho1/icons/start-icon.png"))); // NOI18N
        btnAnalisar.setText("Analisar");
        btnAnalisar.setFocusPainted(false);
        btnAnalisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisarActionPerformed(evt);
            }
        });

        btnEquipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/trabalho1/icons/team-icon.png"))); // NOI18N
        btnEquipe.setText("Equipe");
        btnEquipe.setFocusPainted(false);
        btnEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipeActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/trabalho1/icons/scissor-icon.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpar.setFocusPainted(false);
        btnLimpar.setMaximumSize(new java.awt.Dimension(99, 39));
        btnLimpar.setMinimumSize(new java.awt.Dimension(99, 39));
        btnLimpar.setPreferredSize(new java.awt.Dimension(99, 39));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraDeRolagemInput)
            .addComponent(barraDeRolagemOuput)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnAnalisar, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEquipe, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(barraDeRolagemInput, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnalisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraDeRolagemOuput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // Limpa as duas áreas de texto do programa        
        inputTextArea.setText("");
        outputTextArea.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipeActionPerformed
        outputTextArea.setText("FURB\nSistemas de Informação 2018/1\n\nEquipe de desenvolvimento:\n\nAlan Boaventura\nBryan Leite\nCélio Júnior");
    }//GEN-LAST:event_btnEquipeActionPerformed

    private void btnAnalisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisarActionPerformed
        String text = inputTextArea.getText();

        Map<WordType, Integer> wordCountMap;

        try {
            wordCountMap = WordAnalyser.analyseText(text);
        } catch (IllegalArgumentException e) {
            outputTextArea.setText(e.getMessage());
            return;
        }

        outputTextArea.setText( //
                String.format("Dados analisados:\n\nMotor: %s\nAno: %s\nValor: %s\nKM: %s\nCombustível: %s", //
                wordCountMap.get(WordType.MOTOR), wordCountMap.get(WordType.ANO), wordCountMap.get(WordType.VALOR), wordCountMap.get(WordType.KM), wordCountMap.get(WordType.COMBUSTIVEL)));
    }//GEN-LAST:event_btnAnalisarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            FRAME_PRINCIPAL.setVisible(true);
            FRAME_PRINCIPAL.setLocationRelativeTo(null); // Faz o frame iniciar no centro da tela.
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane barraDeRolagemInput;
    private javax.swing.JScrollPane barraDeRolagemOuput;
    private javax.swing.JButton btnAnalisar;
    private javax.swing.JButton btnEquipe;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JTextArea outputTextArea;
    // End of variables declaration//GEN-END:variables
}

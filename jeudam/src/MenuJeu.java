
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Br!ght
 */
public class MenuJeu extends javax.swing.JPanel {

    /**
     * Creates new form MenuJeu
     */
    public MenuJeu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbPause = new javax.swing.JButton();
        jbRecommencer = new javax.swing.JButton();
        jbSauvegarder = new javax.swing.JButton();
        jbRetourAccueil = new javax.swing.JButton();
        jlTourNoir = new javax.swing.JLabel();
        jlTourBlanc = new javax.swing.JLabel();
        jlTimer = new javax.swing.JLabel();

        jbPause.setText("Pause");
        jbPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPauseActionPerformed(evt);
            }
        });

        jbRecommencer.setText("Recommencer");
        jbRecommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRecommencerActionPerformed(evt);
            }
        });

        jbSauvegarder.setText("Sauvegarder partie");
        jbSauvegarder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSauvegarderActionPerformed(evt);
            }
        });

        jbRetourAccueil.setText("Retourner à l'accueil");
        jbRetourAccueil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRetourAccueilActionPerformed(evt);
            }
        });

        jlTourNoir.setText("Tour du noir");
        jlTourNoir.setEnabled(false);

        jlTourBlanc.setText("Tour du blanc");

        jlTimer.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jlTimer.setText("00:10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbRetourAccueil, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(jbRecommencer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSauvegarder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlTourBlanc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlTourNoir)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbPause)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSauvegarder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbRecommencer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbRetourAccueil)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTourBlanc)
                    .addComponent(jlTourNoir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlTimer)
                .addContainerGap(119, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbRetourAccueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRetourAccueilActionPerformed
        getParent().setVisible(false);
        Jeu.pause.setMessage("");
        Lanceur.f.add(new Accueil());
    }//GEN-LAST:event_jbRetourAccueilActionPerformed

    private void jbPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPauseActionPerformed
        if(!Jeu.pause.getMessage().equals("Victoire des blancs") && !Jeu.pause.getMessage().equals("Victoire des noirs")) {
            Jeu.plateau.setVisible(!Jeu.plateau.isVisible());
            Jeu.pause.setMessage("Pause");
            Jeu.pause.setVisible(!Jeu.pause.isVisible());
            if(jbPause.getText().equals("Pause")) {
                jbPause.setText("Reprendre");
                Plateau.timer.stop();
            }
            else {
                jbPause.setText("Pause");
                Plateau.timer.start();
            }
        }
    }//GEN-LAST:event_jbPauseActionPerformed

    private void jbRecommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRecommencerActionPerformed
        getParent().setVisible(false);
        Lanceur.f.add(new Jeu());
        Jeu.pause.setMessage("");
        changerTour(false);
    }//GEN-LAST:event_jbRecommencerActionPerformed

    private void jbSauvegarderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSauvegarderActionPerformed
        Plateau.timer.stop();
        LoadSave save =new LoadSave();
        try {
            save.save(Jeu.plateau);
        } catch (IOException ex) {
            Logger.getLogger(MenuJeu.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Sauvegarde effectuée.");
        Plateau.timer.start();
    }//GEN-LAST:event_jbSauvegarderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbPause;
    private javax.swing.JButton jbRecommencer;
    private javax.swing.JButton jbRetourAccueil;
    private javax.swing.JButton jbSauvegarder;
    private javax.swing.JLabel jlTimer;
    private javax.swing.JLabel jlTourBlanc;
    private javax.swing.JLabel jlTourNoir;
    // End of variables declaration//GEN-END:variables

    void changerTour(boolean tourNoir) {
        jlTourBlanc.setEnabled(!tourNoir);
        jlTourNoir.setEnabled(tourNoir);
    }
    public javax.swing.JLabel getJlTimer()
    {
        return jlTimer;
    }
}
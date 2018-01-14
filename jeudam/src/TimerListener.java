
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbissari
 */
public class TimerListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Plateau.timerCount--;
        Jeu.menu.getJlTimer().setText("00:"+(Plateau.timerCount>=10?Plateau.timerCount:"0"+Plateau.timerCount));
        if(Plateau.timerCount == 0) {
            int i = 0, nbBlanc = 0, nbNoir = 0;
            while (i<Jeu.plateau.getTAILLE()*Jeu.plateau.getTAILLE()){
                if(Jeu.plateau.getCase(i).getComponentCount()!=0){
                    Pion p=(Pion)Jeu.plateau.getCase(i).getComponent(0);
                    if(p.getCouleur()==Couleur.BLANC)
                        nbBlanc++;
                    else
                        nbNoir++;
                }
                i++;
            }
            
            String message = "";
            if((nbNoir < nbBlanc)||((nbNoir==nbBlanc)&&(Jeu.plateau.isTourNoir())))
                message = "Victoire des blancs";
            else
                message = "Victoire des noirs";
                
            Jeu.plateau.setVisible(false);
            Jeu.pause.setMessage(message);
            Jeu.pause.setVisible(true);
            Plateau.timer.stop();
        }
    }
    
}

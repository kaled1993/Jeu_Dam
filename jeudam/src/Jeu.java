
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Br!ght
 */
public class Jeu extends JPanel {
    
    public static Plateau plateau;
    public static MenuJeu menu = new MenuJeu();
    public static Pause pause = new Pause();
    
    public Jeu() {
        
        setLayout(new BorderLayout());
        plateau = new Plateau(Lanceur.taillePlateau);
        add(plateau, BorderLayout.CENTER);
        add(menu, BorderLayout.LINE_END);
        pause.setVisible(false);
        add(pause, BorderLayout.LINE_START);
        
    }
    
     public Jeu(String s) throws FileNotFoundException {
       
        setLayout(new BorderLayout());
        plateau = new Plateau(s);
        add(plateau, BorderLayout.CENTER);
        add(menu, BorderLayout.LINE_END);
        pause.setVisible(false);
        add(pause, BorderLayout.LINE_START);
        
    }
    
}

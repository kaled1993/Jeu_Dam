import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;


public class Lanceur {

    public static JFrame f = new JFrame();
    
    public static int taillePlateau = 9;
    
    public static int waitTimeLimit = 15;
    
    public static int themeIndex = 0;
    public static Theme theme = new Theme("normal");
            
	public static void main(String[] args) {
		
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Lanceur.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            f.setSize(850, 650);
            f.setResizable(false);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(new Accueil());
            f.setVisible(true);

	}

}

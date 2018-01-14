import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class Case extends JPanel {
	
	
	
	private Couleur couleur;
	private boolean selectionnee;
        private BufferedImage image;

	public Case(Couleur couleur){
		setLayout(new GridLayout(1,0));
		this.couleur=couleur;
		initCouleur();
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public boolean isSelectionnee() {
		return selectionnee;
	}
        public void setSelectionnee(boolean selectionnee,Color c) {
		this.selectionnee = selectionnee;
		if(selectionnee){
                        image = Plateau.imageCaseOption;
			setBackground(c);
			setForeground(Color.LIGHT_GRAY);
		}
		else {
			initCouleur();
		}
	}
         public void setSelectionnee(boolean selectionnee) {
		this.selectionnee = selectionnee;
		if(selectionnee){
			setBackground(Color.BLUE);
			setForeground(Color.LIGHT_GRAY);
		}
		else {
			initCouleur();
		}
	}
	
	
	private void initCouleur(){
                switch (couleur) {
                    case BLANC :
                        setBackground(Color.WHITE);
                        image = Plateau.imageCaseWhite;
                        break;
                    case NOIR :
                        setBackground(Color.GRAY);
                        image = Plateau.imageCaseBlack;
                        break;
                }/*
		switch(couleur){
		case BLANC :
			setBackground(Color.WHITE);
			setForeground(new Color(200, 200, 200));
			{
                            try {
                                image = ImageIO.read(getClass().getResource("/images/casew.png"));
                            } catch (IOException ex) {
                                Logger.getLogger(Pion.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
			break;
		case NOIR :
			setBackground(Color.GRAY);
			setForeground(new Color(20, 20, 20));
                        {
                            try {
                                image = ImageIO.read(getClass().getResource("/images/caseb.png"));
                            } catch (IOException ex) {
                                Logger.getLogger(Pion.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
			break;
		}*/
	}
	
	@Override
	public void paintComponent(Graphics g){
		/*
                Paint paint;
		Graphics2D g2d;
		if (g instanceof Graphics2D) {
			g2d = (Graphics2D) g;
		}
		else {
			System.out.println("Error");
			return;
		}
		paint = new GradientPaint(0,0, getBackground(), getWidth(), getHeight(), getForeground());
		g2d.setPaint(paint);
		g.fillRect(0, 0, getWidth(), getHeight());
                */
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
}

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class Pion extends JPanel {

	private Couleur couleur;
	private boolean monte;
        private boolean reine;
        private boolean block ;
        private boolean selected ;
        private BufferedImage image;
        
	public Pion(Couleur couleur, boolean monte) {
		this.monte=monte;
		this.couleur = couleur;
                this.block=false ;
                this.selected=false ;
                reine = false ;
		setOpaque(false);  
                switch (couleur) {
                case BLANC :
                    image = Plateau.imagePionWhite;
                    break;
                case NOIR :
                    image = Plateau.imagePionBlack;
                    break;
                }
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
            g.fillOval(5, 5, getWidth()-10, getHeight()-10);
            */
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

	public Couleur getCouleur() {
            return couleur;
	}

	public boolean isMonte() {
            return monte;
	}

	public void setMonte(boolean monte) {
	
            this.monte = monte;
                
	}
        public boolean isReine() {
            return reine;
	}

	public void setReine() {
            this.reine = true;  
            switch (couleur) {
            case BLANC :
                image = Plateau.imageQweenWhite;
                break;
            case NOIR :
                image = Plateau.imageQweenBlack;
                break;
            }
            repaint();
	}
        public void setBlock(boolean b) {
            this.block = b;
	}
        public boolean isBlock() {
            return block;
	}
        public void setSelected(boolean b) {
            this.selected = b;
            if(b) {   
                switch (couleur) {
                case BLANC :
                    if(reine) image = Plateau.imageQweenWhiteSel;
                    else image = Plateau.imagePionWhiteSel;
                    break;
                case NOIR :
                    if(reine) image = Plateau.imageQweenBlackSel;
                    else image = Plateau.imagePionBlackSel;
                    break;
                }
            }
            else {  
                switch (couleur) {
                case BLANC :
                    if(reine) image = Plateau.imageQweenWhite;
                    else image = Plateau.imagePionWhite;
                    break;
                case NOIR :
                    if(reine) image = Plateau.imageQweenBlack;
                    else image = Plateau.imagePionBlack;
                    break;
                }
            }
            repaint();
	}
        public boolean isSelected() {
            return selected;
	}
}


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Plateau extends JPanel {

    private int TAILLE;

    private Case caseActive;

    private boolean tourNoir;
    
    public static Timer timer = new Timer(1000, new TimerListener());
    public static int timerCount;
    
    public static Pion pionUnselected;
    
    public static BufferedImage
            imageCaseBlack,
            imageCaseWhite, 
            imageCaseOption, 
            imagePionBlack, 
            imagePionWhite,
            imageQweenWhite,
            imageQweenBlack,
            imageQweenWhiteSel,
            imageQweenBlackSel,
            imagePionBlackSel,
            imagePionWhiteSel
            ;

    public Plateau(int taille) {
        
        try {  
            imageCaseBlack = ImageIO.read(getClass().getResource(Lanceur.theme.getImageCaseBlack()));
            imageCaseWhite = ImageIO.read(getClass().getResource(Lanceur.theme.getImageCaseWhite()));
            imageCaseOption = ImageIO.read(getClass().getResource(Lanceur.theme.getImageCaseOption()));
            imagePionBlack = ImageIO.read(getClass().getResource(Lanceur.theme.getImagePionBlack()));
            imagePionWhite = ImageIO.read(getClass().getResource(Lanceur.theme.getImagePionWhite()));
            imageQweenWhite = ImageIO.read(getClass().getResource(Lanceur.theme.getImageQweenWhite()));
            imageQweenBlack = ImageIO.read(getClass().getResource(Lanceur.theme.getImageQweenBlack()));
            imageQweenWhiteSel = ImageIO.read(getClass().getResource(Lanceur.theme.getImageQweenWhiteSel()));
            imageQweenBlackSel = ImageIO.read(getClass().getResource(Lanceur.theme.getImageQweenBlackSel()));
            imagePionBlackSel = ImageIO.read(getClass().getResource(Lanceur.theme.getImagePionBlackSel()));
            imagePionWhiteSel = ImageIO.read(getClass().getResource(Lanceur.theme.getImagePionWhiteSel()));
        }
        catch (IOException ex) {
            Logger.getLogger(Pion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TAILLE = taille;
        tourNoir = false;
        setLayout(new GridLayout(TAILLE , TAILLE));
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                if ((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) {
                    ajouterCase(Couleur.NOIR);
                } else {
                    ajouterCase(Couleur.BLANC);
                }
            }
        }
        init();
    }
    
    public Plateau(String s) {
        
        try {  
            imageCaseBlack = ImageIO.read(getClass().getResource(Lanceur.theme.getImageCaseBlack()));
            imageCaseWhite = ImageIO.read(getClass().getResource(Lanceur.theme.getImageCaseWhite()));
            imageCaseOption = ImageIO.read(getClass().getResource(Lanceur.theme.getImageCaseOption()));
            imagePionBlack = ImageIO.read(getClass().getResource(Lanceur.theme.getImagePionBlack()));
            imagePionWhite = ImageIO.read(getClass().getResource(Lanceur.theme.getImagePionWhite()));
            imageQweenWhite = ImageIO.read(getClass().getResource(Lanceur.theme.getImageQweenWhite()));
            imageQweenBlack = ImageIO.read(getClass().getResource(Lanceur.theme.getImageQweenBlack()));
            imageQweenWhiteSel = ImageIO.read(getClass().getResource(Lanceur.theme.getImageQweenWhiteSel()));
            imageQweenBlackSel = ImageIO.read(getClass().getResource(Lanceur.theme.getImageQweenBlackSel()));
            imagePionBlackSel = ImageIO.read(getClass().getResource(Lanceur.theme.getImagePionBlackSel()));
            imagePionWhiteSel = ImageIO.read(getClass().getResource(Lanceur.theme.getImagePionWhiteSel()));
        }
        catch (IOException ex) {
            Logger.getLogger(Pion.class.getName()).log(Level.SEVERE, null, ex);
        }
             TAILLE = 0;
        while (TAILLE*TAILLE!=s.length()-1) 
            TAILLE++ ;
        System.out.println(TAILLE);
        if(s.charAt(0)=='0')
        tourNoir = false;
        else
        tourNoir=true ;
        setLayout(new GridLayout(TAILLE , TAILLE));
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                if ((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) {
                    ajouterCase(Couleur.NOIR);
                } else {
                    ajouterCase(Couleur.BLANC);
                }
            }
        }
       
        for (int j = 1; j < TAILLE*TAILLE; j += 1) {
            System.out.println(s.charAt(j-1));
            if(s.charAt(j)=='2'){
            System.out.println("noir");
          
            getCase(j-1).add(creerPion(Couleur.NOIR, false));
            
            }
            else if (s.charAt(j)=='1'){
            System.out.println("blanc");
           
            getCase(j-1).add(creerPion(Couleur.BLANC, true));
           
            } 
        }
        
    }

    private void ajouterCase(Couleur couleur) {
        Case case1 = new Case(couleur);
        case1.addMouseListener(new ListenerCase(case1, this));
        add(case1);
    }

    private Pion creerPion(Couleur couleur, boolean monte) {
        Pion pion = new Pion(couleur, monte);
        pion.addMouseListener(new ListenerPion(pion, this));
        return pion;
    }

    private void init() {
        for (int j = 0; j < TAILLE * 3; j += 2) {
            getCase(j).add(creerPion(Couleur.NOIR, false));
            getCase(TAILLE * TAILLE - j - 1).add(creerPion(Couleur.BLANC, true));
        }
        timerCount = Lanceur.waitTimeLimit;
        Jeu.menu.getJlTimer().setText("00:"+(Plateau.timerCount>=10?Plateau.timerCount:"0"+Plateau.timerCount));
        timer.start();
    }

    public Case getCase(int i, int j) {
        return (Case) getComponent(j + i * TAILLE);
    }

    public Case getCase(int i) {
        return (Case) getComponent(i);
    }

    public void afficherPossibilites(Pion p) {
        if ((p.getCouleur().equals(Couleur.NOIR) && tourNoir) || (p.getCouleur().equals(Couleur.BLANC) && !tourNoir)) {
            int i = 0;
            int j = 0;
            for (int k = 0; k < TAILLE * TAILLE; k++) {
                getCase(k).setSelectionnee(false);
                if (getCase(k).getComponentCount() != 0 && getCase(k).getComponent(0).equals(p)) {
                    caseActive = getCase(k);
                    i = k / TAILLE;
                    j = k % TAILLE;

                }
            }
            if(!selectionnerCases2(i, j, p.getCouleur()))
            selectionnerCases1(i, j, p.getCouleur());
        }
    }
    
    public boolean selectionnerCases3(int i, int j, Couleur couleur){
        boolean Obligatoir = false ;    
        int i1=i,j1=j;Color c=Color.BLUE;int dec=1  ;
                    while (i1-1>=0 && j1-1>=0 ){
                        if( getCase(i1-1, j1-1).getComponentCount()==0){
				getCase(i1-1, j1-1).setSelectionnee(true,c);
                                dec=1;
                        }else
                          if(getCase(i1-2, j1-2).getComponentCount()==0 && !((Pion)(getCase(i1-1, j1-1).getComponent(0))).getCouleur().equals(couleur)){
                           c=Color.RED;dec=2;
                            Obligatoir = true ;
                            getCase(i1-2, j1-2).setSelectionnee(true,c);
                        }else {
                         i1=0;}
			
                  
                        i1-=dec;j1-=dec;
                    }
                    i1=i;j1=j;c=Color.BLUE;dec=1 ;
                    while (i1-1>=0 && j1+1<TAILLE  ){
                        if(getCase(i1-1, j1+1).getComponentCount()==0){
				getCase(i1-1, j1+1).setSelectionnee(true,c);
                                
			}else
                         if(getCase(i1-2, j1+2).getComponentCount()==0 && !((Pion)(getCase(i1-1, j1+1).getComponent(0))).getCouleur().equals(couleur)){
                           c=Color.RED;dec=2;
                             Obligatoir = true ;
                          
                            getCase(i1-2, j1+2).setSelectionnee(true,c);
                         
                          }else {
                         j1=TAILLE;}
			
                     
                         i1-=dec;j1+=dec;
                    }
                    i1=i;j1=j;c=Color.BLUE;dec=1 ;
                    while (i1+1<TAILLE && j1+1<TAILLE ){
                        if(getCase(i1+1, j1+1).getComponentCount()==0){
				getCase(i1+1, j1+1).setSelectionnee(true,c);
                                
			}else    
                        if(getCase(i1+2, j1+2).getComponentCount()==0 && !((Pion)(getCase(i1+1, j1+1).getComponent(0))).getCouleur().equals(couleur)){
                           c=Color.RED;dec=2;
                            
                             Obligatoir = true ;
                            getCase(i1+2, j1+2).setSelectionnee(true,c);
                           
                         }else {
                         i1=TAILLE;}
			
                 
                         i1+=dec;j1+=dec;
                    }

                    i1=i;j1=j;c=Color.BLUE;dec=1 ;
                    while (i1+1<TAILLE && j1-1>=0 ){
                        if(getCase(i1+1, j1-1).getComponentCount()==0){
				getCase(i1+1, j1-1).setSelectionnee(true,c);
			}else
                         if(getCase(i1+2, j1-2).getComponentCount()==0 && !((Pion)(getCase(i1+1, j1-1).getComponent(0))).getCouleur().equals(couleur)){
                             c=Color.RED;dec=2;
                           Obligatoir = true ;
                            getCase(i1+2, j1-2).setSelectionnee(true,c);
                        }else {
                         i1=TAILLE;}
			
                       
                         i1+=dec;j1-=dec;
			}
            
        return Obligatoir ; }
     public void selectionnerCases1(int i, int j, Couleur couleur) {
        Pion pion = (Pion) (getCase(i, j).getComponent(0));
        if(!pion.isReine()){
            if (pion.isMonte()) {
                
                if(i - 1 >= 0 && j - 1 >= 0 && getCase(i - 1, j - 1).getComponentCount() == 0 ) 
                {getCase(i - 1, j - 1).setSelectionnee(true, Color.BLUE);
                }
                
                 if(i - 1 >= 0 && j + 1 < TAILLE && getCase(i - 1, j + 1).getComponentCount() == 0 ) 
                { getCase(i - 1, j + 1).setSelectionnee(true, Color.BLUE);
                } 
                 
            } else {
                
                  if (i + 1 < TAILLE && j - 1 >= 0 && getCase(i + 1, j - 1).getComponentCount() == 0) 
                { getCase(i + 1, j - 1).setSelectionnee(true, Color.BLUE);
                }
               
                if (i + 1 < TAILLE && j + 1 < TAILLE && getCase(i + 1, j + 1).getComponentCount() == 0 ) 
                { getCase(i + 1, j + 1).setSelectionnee(true, Color.BLUE);
                }
             
            }
              
              
            }else{
            selectionnerCases3(i, j, couleur);
        }
     }
    public boolean selectionnerCases2(int i, int j, Couleur couleur) {
        Pion pion = (Pion) (getCase(i, j).getComponent(0));
        boolean Obligatoir=false ;
        if(!pion.isReine()){
            if (pion.isMonte()) {
                 if(i - 2 >= 0 && j - 2 >= 0 && getCase(i - 2, j - 2).getComponentCount() == 0 && getCase(i - 1, j - 1).getComponentCount()!=0&& !((Pion) (getCase(i - 1, j - 1).getComponent(0))).getCouleur().equals(couleur)) 
                 {  getCase(i - 2, j - 2).setSelectionnee(true, Color.RED);Obligatoir=true;}
                 
                if(i - 2 >= 0 && j + 2 < TAILLE && getCase(i - 2, j + 2).getComponentCount() == 0 && getCase(i - 1, j + 1).getComponentCount()!=0&& !((Pion) (getCase(i - 1, j + 1).getComponent(0))).getCouleur().equals(couleur)) 
                {  getCase(i - 2, j + 2).setSelectionnee(true, Color.RED);Obligatoir=true;}
                  
                 if(i + 2 < TAILLE && j + 2 < TAILLE && getCase(i + 2, j + 2).getComponentCount() == 0 && getCase(i + 1, j + 1).getComponentCount()!=0 && !((Pion) (getCase(i + 1, j + 1).getComponent(0))).getCouleur().equals(couleur)) 
                 { getCase(i + 2, j + 2).setSelectionnee(true, Color.RED);Obligatoir=true;}
                    
                if(i + 2 < TAILLE && j - 2 >= 0 && getCase(i + 2, j - 2).getComponentCount() == 0 && getCase(i + 1, j - 1).getComponentCount()!=0&& !((Pion) (getCase(i + 1, j - 1).getComponent(0))).getCouleur().equals(couleur)) 
                {getCase(i + 2, j - 2).setSelectionnee(true, Color.RED);Obligatoir=true ;}
           
            } else {
                 if (i - 2 >= 0 && j - 2 >= 0 && getCase(i - 2, j - 2).getComponentCount() == 0 && getCase(i - 1, j - 1).getComponentCount()!=0&& !((Pion) (getCase(i - 1, j - 1).getComponent(0))).getCouleur().equals(couleur)) {
                    getCase(i - 2, j - 2).setSelectionnee(true, Color.RED);Obligatoir=true;
                }
                if (i - 2 >= 0 && j + 2 < TAILLE && getCase(i - 2, j + 2).getComponentCount() == 0 && getCase(i - 1, j + 1).getComponentCount()!=0&& !((Pion) (getCase(i - 1, j + 1).getComponent(0))).getCouleur().equals(couleur)) {
                    getCase(i - 2, j + 2).setSelectionnee(true, Color.RED);Obligatoir=true;
                }
                  if (i + 2 < TAILLE && j + 2 < TAILLE && getCase(i + 2, j + 2).getComponentCount() == 0 && getCase(i + 1, j + 1).getComponentCount()!=0&& !((Pion) (getCase(i + 1, j + 1).getComponent(0))).getCouleur().equals(couleur)) 
                   { getCase(i + 2, j + 2).setSelectionnee(true, Color.RED);Obligatoir=true;}
                  
                  if (i + 2 < TAILLE && j - 2 >= 0 && getCase(i + 2, j - 2).getComponentCount() == 0 && getCase(i + 1, j - 1).getComponentCount()!=0&& !((Pion) (getCase(i + 1, j - 1).getComponent(0))).getCouleur().equals(couleur)) 
                {  getCase(i + 2, j - 2).setSelectionnee(true, Color.RED);Obligatoir=true;}
            }
        }else{
             Obligatoir=  selectionnerCases3(i, j, couleur);    }
  
    return Obligatoir ;}
      
    

    public void deplacer(Case case1) {
        case1.add(caseActive.getComponent(0));
        Pion p ;
        Pion p1;
        boolean b=false ;
        for (int k = 0; k < TAILLE * TAILLE; k++) {
            getCase(k).setSelectionnee(false);
        }
         p = (Pion) (case1.getComponent(0));
     
         int c=Cible(getLigne(case1),getColonne(case1),getLigne(caseActive),getColonne(caseActive));
         if(c!=-1){
            getCase(c).removeAll();
            getCase(c).validate();
            getCase(c).repaint();
            if(selectionnerCases2(getLigne(case1),getColonne(case1),p.getCouleur())){
                b=true ;
             
             for (int x = 0; x < TAILLE*TAILLE; x++) {
                 System.out.print(x);
                 if(this.getCase(x).getComponentCount()!=0){
                  p1 = (Pion) (this.getCase(x).getComponent(0));
                  if(!p1.isSelected())
                      p1.setBlock(true);}
             }
             
            }
          
        }
         if(!b){
            tourNoir = !tourNoir;
            timerCount = Lanceur.waitTimeLimit;
            Jeu.menu.getJlTimer().setText("00:"+(Plateau.timerCount>=10?Plateau.timerCount:"0"+Plateau.timerCount));
            Jeu.menu.changerTour(tourNoir);
         for (int x = 0; x < TAILLE*TAILLE; x++) {
                
                 if(this.getCase(x).getComponentCount()!=0){
                  p1 = (Pion) (this.getCase(x).getComponent(0));
                      p1.setSelected(false);
                      p1.setBlock(false);}
             }}
       
        caseActive.removeAll();
        caseActive.repaint();
        caseActive = null;
        case1.repaint();
       
       
        
        if (!p.isReine()) {
            if (getLigne(case1) == 0) {
                if(p.getCouleur()==Couleur.BLANC)
                p.setReine();
                p.setMonte(false);

            }
            if (getLigne(case1) == TAILLE - 1) {
                if(p.getCouleur()==Couleur.NOIR)
                p.setReine();
                p.setMonte(true);

            }
        }
        if(verification())
            System.out.println("Game Over");
    }

    private int getLigne(Case case1) {
        int res = 0;
        for (int i = 0; i < TAILLE * TAILLE; i += 2) {
            if (getCase(i).equals(case1)) {
                res = i / TAILLE;
            }
        }
        return res;
    }

    private int getColonne(Case case1) {
        int res = 0;
        for (int i = 0; i < TAILLE * TAILLE; i += 2) {
            if (getCase(i).equals(case1)) {
                res = i % TAILLE;
            }
        }
        return res;
    }
    private int Cible(int x1,int y1,int x2,int y2){
        Pion p=null ;
        boolean cible=false;
        
        int a=x2,b=y2,k1=1,k2=1 ; 
        System.out.println(a);
        System.out.println(b);
        if(Math.abs((a-1)-x1)<Math.abs(x2-x1)){
        k1=-1;
        }
         if(Math.abs((b-1)-y1)<Math.abs(y2-y1)){
        k2=-1;
        }
          System.out.println(k1);
           System.out.println(k2);
           if(k1==1&&k2==1){
           }
           if(k1==1&&k2==-1){
           }
           if(k1==-1&&k2==1){
           }
           if(k1==-1&&k2==-1){
           }
        while (a+k1>=0 && a+k1<=TAILLE&&b+k2>=0&&b+k2<=TAILLE&&!cible){
            a=a+k1;b=b+k2;
            if(getCase(a, b).getComponentCount()!=0)
            cible=true;
            System.out.println("a=");
            System.out.println(a);
            System.out.println("b=");
            System.out.println(b);
        }
        if(a!=x1&&b!=y1){
            System.out.println((a*TAILLE)+b);

    return ((a*(TAILLE))+b) ;}
        else 
        { System.out.println("-1");
            return -1 ;}
    }
  
private boolean verification ()
{
    int i =0 ;boolean VBlanc=false,VNoir=false;Pion p ;
    while (i<TAILLE*TAILLE&&(!VBlanc||!VNoir)){
        if(getCase(i).getComponentCount()!=0){
            p=(Pion)getCase(i).getComponent(0);
            if(p.getCouleur()==Couleur.BLANC)
                VBlanc=true ;
            else
                VNoir=true ;
        }
        i++;
    }
    if(i>=TAILLE*TAILLE){
        timer.stop();
        String message = "";
        if(VBlanc==false) message = "Victoire des noirs";
        if(VNoir==false)  message = "Victoire des blancs";
        Jeu.plateau.setVisible(false);
        Jeu.pause.setMessage(message);
        Jeu.pause.setVisible(true);
    }
    return (i==TAILLE*TAILLE);
}

    public boolean isTourNoir() {
        return tourNoir;
    }

    public void setTourNoir(boolean tourNoir) {
        this.tourNoir = tourNoir;
    }

    public int getTAILLE() {
        return TAILLE;
    }

}



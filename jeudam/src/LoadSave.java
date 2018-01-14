
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khaled
 */
public class LoadSave {
    
    public void save(Plateau plateau) throws IOException{
   
        BufferedWriter output = null;
        try {
            File file;
            file = new File("SaveGame.txt");
            output = new BufferedWriter(new FileWriter(file));
            Pion pion ; 
            if(plateau.isTourNoir())
                output.write("0");
            else
                output.write("1");
            for(int i=0;i<plateau.getTAILLE()*plateau.getTAILLE();i++){
                if(plateau.getCase(i).getComponentCount()!=0){
                 pion= (Pion) (plateau.getCase(i).getComponent(0));
                 if(pion.isReine()){
                     if(pion.getCouleur().equals(Couleur.BLANC))
                         output.write("3");
                     else
                         output.write("4");
                 }else
                 { if(pion.getCouleur().equals(Couleur.BLANC))
                         output.write("1");
                     else
                         output.write("2");
                 }
                
                }else
                {output.write("0");
                }
            }
            
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
          if ( output != null ) {
            output.close();
          }
        }
    }
    
    public String load() throws FileNotFoundException 
    {   String s="" ;
         File file= new File("SaveGame.txt") ;
         if(file.exists()){
              Scanner sc = new Scanner(file);
              
            while(sc.hasNextLine()){
            s=s+sc.nextLine();}
         }else
            {
                 System.out.println("fichier n existe pas");   }
        return s;
           
        
    }
}

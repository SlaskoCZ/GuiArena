/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metods;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveAndLoad {
    public static void save(int fileNumber){     
        File file = new File(Utilities.getPathToSave()+"\\"+fileNumber);
        try {
            if (file.exists()){
              file.createNewFile();  
            }
            
        } catch (IOException ex) {
            Logger.getLogger(SaveAndLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}

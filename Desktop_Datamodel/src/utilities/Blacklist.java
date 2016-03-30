/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 10467841
 */
public class Blacklist {
    
    private static List<String> blacklist;
    
    private Blacklist(){}
    
    private static List<String> getListFromFile(){
        try (Scanner r = new Scanner(new File("blacklist.txt"))){
            List<String> l = new ArrayList();
            
            
            while (r.hasNext()){
                l.add(r.next());
            }
            
            r.close();
            
            return l;
            
        } catch (FileNotFoundException ex){}
        
        return new ArrayList();
    }
    
    private static Boolean setFileFromList(List<String> list){
        try (FileWriter w = new FileWriter("blacklist.txt")){
                       
            for (String word: list){
                w.write(word);
            }
            w.close();
            
            return true;
            
        } catch (IOException ex){}
        
        return false;
    }
    
    public boolean add(String naughtyWord){
        return (blacklist.add(naughtyWord) && setFileFromList(blacklist));
    }
    
    public boolean remove(String notSoNaughtyWord){
        return blacklist.remove(notSoNaughtyWord) && setFileFromList(blacklist);
    }
    
    //returns false if the string contains a bad word
    public static Boolean checkList(String string){
        if (blacklist == null){
            blacklist = getListFromFile();
        }
        
        for(int i = 0; i > blacklist.size(); i++){
            if(string.contains(blacklist.get(i))){
                return false;            
            }
        }
        return true;
    }
}

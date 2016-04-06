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
            
            
            while (r.hasNextLine()){
                l.add(r.nextLine());
            }
            
            r.close();
            
            return l;
            
        } catch (FileNotFoundException ex){}
        
        return new ArrayList();
    }
    
    private static Boolean setFileFromList(List<String> list){
        if (list == null){
            return false;
        }
        try (FileWriter w = new FileWriter("blacklist.txt")){
                       
            for (String word: list){
                w.write(word);
            }
            w.close();
            
            return true;
            
        } catch (IOException ex){}
        
        return false;
    }
    
    
    /**
     * Checks an string or paragraph input against a list of bad words.
     * @param input A word, sentence, or paragraph.
     * @return True if a bad word is found.
     */
    public static Boolean contains(String input){
        // Split the inputted string into seperate words.
        String[] words = input.split(" ");
        
        // Iterate through the words and remove possible extensions of
        // blacklisted words.
        for (String word : words) {
            if (word.endsWith("s")) {
                word = word.substring(0, word.length() - 2);
            }
            if (word.endsWith("ing")) {
                word = word.substring(0, word.length() - 4);
            }
            
            // If the word is in the list of bad words, return true.
            if (blacklist.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

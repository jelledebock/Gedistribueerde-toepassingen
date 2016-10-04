/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jelle De Bock
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader reader;
        System.out.println("Enter a line of text please: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        DictService service = new DictService();
        DictServiceSoap soap_service = service.getDictServiceSoap();
        
        try {
            String line;
            line = reader.readLine();
            
             String[] words = line.split(" ");
        
            for(String word : words){
                System.out.println(word+"-->");     
                ArrayOfDictionaryWord suggestions = soap_service.match(word, "lev");
                List<DictionaryWord> list_suggestion = suggestions.getDictionaryWord();
                
                for(DictionaryWord dict_word : list_suggestion){
                    System.out.print(dict_word.getWord()+" ");
                }
                System.out.print("\n");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
}

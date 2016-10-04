/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testequationservice;

import be.ugent.src.EquationWS;
import be.ugent.src.EquationWS_Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jelle
 */
public class TestEquationService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Please enter a quadratic equations:\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a,b,c;
        try{
            System.out.println("Enter a: ");
            a = Integer.parseInt(reader.readLine());
            System.out.println("Enter b: ");
            b = Integer.parseInt(reader.readLine());
            System.out.println("Enter c: ");
            c = Integer.parseInt(reader.readLine());
                    
            EquationWS_Service service = new EquationWS_Service();
            EquationWS port = service.getEquationWSPort();
                    
            List<Double> solution = port.solveQuadratic(a,b,c);
                    
            for(double answer : solution){
                   System.out.println("Solution : "+answer+"\n");
            }                   
        } catch (IOException ex) {
            Logger.getLogger(TestEquationService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TestEquationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}

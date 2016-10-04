/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.src;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author jelle
 */
@WebService(serviceName = "EquationWS")
@Stateless()
public class EquationWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "solveQuadratic")
    @SuppressWarnings("empty-statement")
    public double[] solveQuadratic(@WebParam(name = "a") int a, @WebParam(name = "b") int b, @WebParam(name = "c") int c) {
        int discriminant = b*b-4*a*c;
        double[] solutions={};
        
        if(discriminant>0){
            double solution[] = {(-b+Math.sqrt(discriminant))/(2*a),(-b-Math.sqrt(discriminant))/(2*a)};
            solutions = solution;
        }
        else if(discriminant==0){
            double solution[] = {-b/(2*a)};
            solutions = solution;
        }
        
        return solutions;
    }
}

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
import javax.jws.HandlerChain;

/**
 *
 * @author jelle
 */
@WebService(serviceName = "EquationWS")
@Stateless()
@HandlerChain(file = "EquationWS_handler.xml")
public class EquationWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "solveQuadratic")
    @SuppressWarnings("empty-statement")
    public double[] solveQuadratic(@WebParam(name = "c0") int a, @WebParam(name = "c1") int b, @WebParam(name = "c2") int c) {
        if(a==0)
            throw new IllegalArgumentException("Cannot be 0.");
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

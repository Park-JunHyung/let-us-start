package com.riotgames.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * Calculator application
 */
public class CalcApp {
	
    public double calc(String[] tokens) {
        double firstOperand;
        double secondOperand;
        try {
            firstOperand = Double.parseDouble(tokens[0]);
            if (tokens.length > 2) 
            {
                Vector<Double> v = new Vector<>();
                v.add(firstOperand);
                int i = 0;
                
                while (i +2 < tokens.length)
                {
                    try 
                    {
                        secondOperand = Double.parseDouble(tokens[i + 2]);
                        final Operator operator = Operator.findOperator(tokens[i+1]);
                        v.add(operator.evaluate(v.lastElement(), secondOperand));
                        
                    }
                    catch (NumberFormatException e) {  return -1; }
                    
                    i = i + 2;
                }
                
                return v.lastElement();
                
            } else 
            {   
            	return firstOperand;
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Wrong input");
            return -1;
        }
    }

    public static void main( String[] args ) {
        final CalcApp app = new CalcApp();
        final StringBuilder outputs = new StringBuilder();
        Arrays.asList(args).forEach(value -> outputs.append(value + " "));
        System.out.print( "Addition of values: " + outputs + " = ");
        System.out.println(app.calc(args));
    }
}

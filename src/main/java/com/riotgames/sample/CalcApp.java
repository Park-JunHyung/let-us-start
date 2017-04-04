package com.riotgames.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Calculator application
 */
public class CalcApp {
	
	private ArrayList<String> li ;
	
	public double calc3(String[] tokens) {
       
        li = new ArrayList<String>();
        li.addAll( Arrays.asList(tokens) );
       

        while(li.size()>2){
        	if(li.get(0).equals("(")||li.get(2).equals("("))
        	{
        		if(li.get(0).equals("("))
        		{
        			li.remove(0);
        			li.add(0, bracket(0) );
        		}else if(li.get(2).equals("("))
        		{
        			li.remove(2);
        			li.add(2, bracket(2) );
        		}
        	}else
        	{       		
        		String[] token=new String[3];
        		token[0]=li.remove(0);
        		token[1]=li.remove(0);
        		token[2]=li.remove(0);	        		
        		li.add(0, String.valueOf(calc2(token)) );
        	}
        }
        return Double.parseDouble(li.get(0));
    } 
	public String bracket(int index){
		
		while(li.size()>2){
			if(li.get(0).equals("(")||li.get(2).equals("("))
			{
				if(li.get(0).equals("("))
        		{
        			li.remove(0);
        			li.add(0, bracket(0) );
        		}else if(li.get(2).equals("("))
        		{
        			li.remove(2);
        			li.add(2, bracket(2) );
        		}
        	}else if(li.get(0).equals(")")||li.get(2).equals(")"))
        	{
        		if(li.get(0).equals("("))
        		{
        			li.remove(0);
        			li.add(0, String.valueOf(bracket(0)) );
        		}
        	}else
        	{       		
        		String[] token=new String[3];
        		token[0]=li.remove(0);
        		token[1]=li.remove(0);
        		token[2]=li.remove(0);	        		
        		li.add(0, String.valueOf(calc2(token)) );
        	}
        }
        return li.get(0);
	}
	
	
    public double calc2(String[] tokens) {
        final double firstOperand;
        final double secondOperand;
        firstOperand = Double.parseDouble(tokens[0]);
        if (tokens.length > 2) {
            secondOperand = Double.parseDouble(tokens[2]);
        } else {
            secondOperand = Double.parseDouble(tokens[1]);
        }
        final Operator operator = Operator.findOperator(tokens[1]);

        return operator.evaluate(firstOperand, secondOperand);

    }

    public static void main( String[] args ) {
        final CalcApp app = new CalcApp();
        final StringBuilder outputs = new StringBuilder();
        Arrays.asList(args).forEach(value -> outputs.append(value + " "));
        System.out.print( "Addition of values: " + outputs + " = ");
        System.out.println(app.calc3(args));
    }
}

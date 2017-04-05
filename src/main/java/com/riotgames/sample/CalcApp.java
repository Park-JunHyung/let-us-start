package com.riotgames.sample;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Calculator application
 */

public class CalcApp  {

	private ArrayList<String> li ;
	private String oB = "(";
	private String cB = ")";

	public double calc3 (String[] tokens) throws Exception {


        li = new ArrayList<>();
        li.addAll( Arrays.asList(tokens) );


        while(li.size()>2){
        	if(li.get(0).equals(oB)||li.get(2).equals(oB))
        	{
        		if(li.get(0).equals(oB))
        		{
        			li.remove(0);
        			bracket(0);
        		}else if(li.get(2).equals(oB))
        		{
        			li.remove(2);
        			bracket(2);
        		}
        	}else
        	{
        		String[] token=new String[3];
        		token[0]=li.remove(0);
        		token[1]=li.remove(0);
        		token[2]=li.remove(0);
        		li.add(0, String.valueOf(calc(token)) );
        	}
        }
        return Double.parseDouble(li.get(0));
    }
	public void bracket(int index) throws Exception {

		int i=index;

		while((i+1)<li.size()){
			//여는 괄호
			//TO DO Array bug fix
			if(li.get(i+1).equals(cB))
        	{
        		if(li.get(i+1).equals(cB))
        		{
        			li.remove(i+1);
        			return ;
        		}
        	}
			// 닫는 괄호
			else if(li.get(i).equals(oB)||li.get(i+2).equals(oB))
			{
				if(li.get(i).equals(oB))
        		{
        			li.remove(i);
        			bracket(i);
        		}else if(li.get(i+2).equals(oB))
        		{
        			li.remove(i+2);
        			bracket(i+2);
        		}
        	}
			else
        	{
        		String[] token=new String[3];
        		token[0]=li.remove(i);
        		token[1]=li.remove(i);
        		token[2]=li.remove(i);
        		li.add(i, String.valueOf(calc(token)) );
        	}
        }
        return ;
	}


    public double calc(String[] tokens) throws Exception {
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
    	try{
    		final CalcApp app = new CalcApp();
    		final StringBuilder outputs = new StringBuilder();
    		Arrays.asList(args).forEach(value -> outputs.append(value + " "));
    		System.out.print( "Addition of values: " + outputs + " = ");
    		System.out.println(app.calc3(args));
    	}catch(Exception e){
    		System.err.println("Error");
    	}

    }
}

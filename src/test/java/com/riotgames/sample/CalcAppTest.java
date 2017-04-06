package com.riotgames.sample;

import junit.framework.TestCase;

/**
 * Unit test for simple CalcApp.
 */
public class CalcAppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalcAppTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    
    /**
     * Rigourous Test :-)
     * @throws Exception 
     */
    public void testApp() throws Exception
    {
    	String[] args1 = new String[] {"24","/","(","7","+","5",")","-","(","3","x","6",")"};
    	String[] args2 = new String[] {"(","30","/","3","x","(","4","-","1",")",")"};
    	String[] args3 = new String[] {"(","1", "-", "(","(","7","x","(","5","-","3",")",")","x","(","3","x","6","-","3",")",")",")","/","5"};
    	String[] args4 = new String[] {"^"};
    	String[] args5 = new String[] {""};
    	CalcApp.main(args1);
    	CalcApp.main(args2);
    	CalcApp.main(args3);	
    	CalcApp.main(args4);
    	CalcApp.main(args5);
    }
}

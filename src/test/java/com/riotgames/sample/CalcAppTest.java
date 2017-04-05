package com.riotgames.sample;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
    /*
    public static Test suite()
    {

        return new TestSuite( CalcApp.class );
    }*/

    /**
     * Rigourous Test :-)
     * @throws Exception 
     */
    public void testApp() throws Exception
    {
    	String[] args = new String[] {"24","/","(","7","+","5",")","-","(","3","x","6",")"};
    	CalcApp.main(args);
        
    }
}

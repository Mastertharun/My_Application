package com.example.myapplication;

import junit.framework.TestCase;
public class CalculatorTest extends TestCase {
    Calculator calculator;

    protected void setUp() throws Exception{
        super.setUp();
        calculator=new Calculator();
    }

    public void testAdd(){
        int expected=30;
        int actual=calculator.add(10,20);
        assertEquals(expected,actual);
    }
    public void testMul(){
        int exp=40;
        int act = calculator.mul(10,4);
        assertEquals(exp,act);
    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}


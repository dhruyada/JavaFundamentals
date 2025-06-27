package com.dhruyada.service.java.junit5;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();
        int actual = calculator.add(2,3);
        assertEquals(6, actual);
    }
}

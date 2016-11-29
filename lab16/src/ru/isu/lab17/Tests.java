package ru.isu.lab17;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static ru.isu.lab17.Recursion.*;

/**
 * @author Vladimir Ulyanov
 */
public class Tests {

    @Test
    public void testFactorial() {
        assertEquals(1, factorial(0));
        assertEquals(120, factorial(5));
        assertEquals(6, factorial(3));
    }

    @Test
    public void testFibonachi() {
        assertEquals(0, fibonachi(0));
        assertEquals(1, fibonachi(1));
        assertEquals(8, fibonachi(6));
        assertEquals(21, fibonachi(8));
    }

    @Test
    public void testGCD() {
        assertEquals(7, gcd(14, 21));
        assertEquals(5, gcd(15, 20));
        assertEquals(15, gcd(30, 45));
    }

    @Test
    public void testSum() {
        assertEquals(6, sum(1, 3));
        assertEquals(54, sum(2, 10));
        assertEquals(0, sum(9, 5));
        assertEquals(180, sum(5, 19));
    }

    @Test
    public void testPascal() {
        // Например, pascal(0,2)=1, pascal(1,2)=2 и pascal(1,3)=3.
        assertEquals(1, pascal(0, 2));
        assertEquals(2, pascal(1, 2));
        assertEquals(3, pascal(1, 3));
    }

    @Test
    public void testCountChange() {
        assertEquals(3, countChange(4, Arrays.asList(new Integer[]{1, 2})));
        assertEquals(6, countChange(10, Arrays.asList(new Integer[]{1, 2})));
        assertEquals(2156, countChange(100, Arrays.asList(new Integer[]{1, 2, 5, 10})));
    }
}

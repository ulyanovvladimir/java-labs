package ru.isu.lab7;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Vladimir Ulyanov
 */
public class Tests {

    @Test
    public void testPolindromWord(){
        assertTrue(Main.polindrom("abba"));
        assertTrue(Main.polindrom("комок"));
        assertFalse(Main.polindrom("замок"));
    }

    @Test
    public void testPolindroms(){
        Set<String> ret = Main.polindroms("комок грязи полетел в замок");
        assertTrue(ret.contains("комок"));
        assertTrue(ret.contains("в"));
        assertEquals(2, ret.size());
    }

    @Test
    public void testNumbers(){
        assertTrue(Main.allEven("4268"));
        assertTrue(Main.allEven("240"));
        assertTrue(Main.allEven("800800"));
        assertTrue(Main.allEven("666"));
        assertTrue(Main.allEven("86420"));
        assertFalse(Main.allEven("241"));
    }
}

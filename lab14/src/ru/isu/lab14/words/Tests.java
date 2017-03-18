package ru.isu.lab14.words;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static ru.isu.lab14.words.Words.*;

/**
 * @author Vladimir Ulyanov
 * Набор тестов для класса Words
 */

public class Tests {

    @Test
    public void testWithoutDefis(){
        List<String> list = Arrays.asList(new String[]{"слово", "не", "воробей","ха-ха"});
        List<String> real = withoutDefis(list);
        assertFalse(real.contains("ха-ха"));
        assertTrue(real.contains("слово"));
        assertTrue(real.contains("воробей"));
        assertTrue(real.contains("не"));
        assertEquals(3, real.size());
    }

    @Test
    public void testComparator(){
        List<String> list = Arrays.asList(new String[]{"слово", "не", "воробей","ха-ха"});
        list.sort(lengthComparator());
        assertTrue(list.indexOf("ха-ха")> list.indexOf("воробей"));
        assertTrue(list.indexOf("не")> list.indexOf("воробей"));
        assertTrue(list.indexOf("не")> list.indexOf("ха-ха"));
    }

    @Test
    public void testTop(){
        List<String> list = Words.readDictionary();
        List<String> t = top(list);
        assertTrue(t.size()==TOP_SIZE);
        assertTrue(list.containsAll(t));
        for (int i = 0; i < TOP_SIZE; i++) {
            assertTrue(t.get(i).equals(list.get(i)));
        }
    }

    @Test
    public void testContains(){
        assertTrue(contains(frequency("приключение"), frequency("ключ")));
        assertTrue(contains(frequency("комод"),frequency("дом") ));
        assertTrue(contains(frequency("комод"),frequency("комод") ));
        assertFalse(contains(frequency("комод"),frequency("комодо") ));
    }

    @Test
    public void testMinus(){
        List<String> list = Arrays.asList(new String[]{"слово", "не", "воробей","ха-ха"});
        List<String> sub =  Arrays.asList(new String[]{"слово", "не", "воробей"});
        List<String> real = minus(list,sub);

        assertEquals(1, real.size());
        assertTrue(real.contains("ха-ха"));
    }

    @Test
    public void testCount(){
        assertEquals(16, countWord(10, "собака"));
        assertEquals(23, countWord(20, "дом"));
    }
}

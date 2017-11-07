package ru.isu.labs.files;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Тесты
 */
public class Tests {

    private static final String FILE = "zdf-win.txt";

    @Test
    public void testReadFile(){
        {
            String s = Main.readFile(FILE, "windows-1251");
            assertTrue("Успешно загружает словарь слов", s.startsWith("-де"));
            assertTrue(s.contains("йод"));
            assertTrue(s.contains("\n"));
        }
        {
            String s = Main.readFile(FILE,"UTF-8");
            assertFalse(s.startsWith("-де"));
        }
    }

    @Test
    public void testIsWord(){
        assertFalse(Main.isWord("-де"));
        assertFalse(Main.isWord("дефис-дефис"));
        assertFalse(Main.isWord("есть пробел"));
        assertFalse(Main.isWord("Мир, труд, май, и другие запятые"));
        assertFalse(Main.isWord("один; два; три; точки с запятой"));
        assertFalse(Main.isWord("Аптека. Улица. Фонарь. Точка"));
        assertTrue(Main.isWord("волк"));
        assertTrue(Main.isWord("мир"));
        assertTrue(Main.isWord("дом"));
    }

    @Test
    public void testStartsWith(){
        int n = Main.wordsStartsWith("лев");
        assertEquals("22 льва", 22, n);
        n = Main.wordsStartsWith("попугай");
        assertEquals("4 попугая", 4, n);
        assertEquals("10 мемов", 10, Main.wordsStartsWith("мем"));
    }

    @Test
    public void testContains(){
        int n = Main.wordsContains("лев");
        assertEquals("336 львов", 336, n);
        n = Main.wordsContains("поп");
        assertEquals("233 поп", 233, n);
        assertEquals("305 миров", 305, Main.wordsContains("мир"));
    }

    @Test
    public void testContWordsBySize(){
        assertEquals("10 букв", 12544, Main.countWordBySize(10));
        assertEquals("13 букв", 5487, Main.countWordBySize(13));
        assertEquals("16 букв", 1409, Main.countWordBySize(16));
        assertEquals("19 букв", 265, Main.countWordBySize(19));
        assertEquals("22 буквы", 28, Main.countWordBySize(22));
    }

}

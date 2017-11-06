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
            String s = Main.readFile(FILE, "UTF-8");
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
        assertFalse(Main.isWord("дом"));


    }
}

package ru.isu.labs.files;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Тесты
 */
public class Tests {

    private static final String FILE = "zdf-win.txt";

    @Test
    public void testReadFile(){
        {
            String s = Main.readFile(FILE,"win-1251");
            assertTrue("Успешно загружает словарь слов", s.startsWith("-де"));
            assertTrue(s.contains("йод"));
            assertTrue(s.contains("\n"));
        }
        {
            String s = Main.readFile(FILE,"UTF-8");
            assertFalse(s.startsWith("-де"));
        }

    }



}

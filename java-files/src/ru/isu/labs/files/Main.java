package ru.isu.labs.files;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int BUFFER_SIZE=5000;
        BufferedReader reader = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("c:\\windows\\win.ini"));
            InputStreamReader streamReader = new InputStreamReader(fileInputStream, "windows-1251"); // UTF-8
            reader = new BufferedReader(streamReader, BUFFER_SIZE);
            while (true) {
                //далее делаем что-то со строкой, например выводим на экран
                String line = reader.readLine();
                if (line == null) break;
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            // файл не найден
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            //Не верная кодировка, кодировка не найдена
            throw new RuntimeException("Кодировка не найдена", e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Считывает файл в кодировке UTF-8 и выводит его на экран.
     * @param path путь до файла
     * @throws IOException в случае, если файл не найден, либо произошла проблема
     * при чтении файла.
     *
     */
    public static void printFileUTF(String path) throws IOException{
        //TODO
    }

    /**
     *
     * @param path путь до файла
     * @param encoding кодировка
     * @return содержимое файла в виде строки
     */
    public static String readFile(String path, String encoding){
        //TODO
        return null;
    }


    /**
     * Проверяет, является ли строка словом. Строка не должна содержать пробелы, символ дефиса, точки и точки с запятой.
     * @param s строка
     * @return
     */
    public static boolean isWord(String s){
        //TODO
        return true;
    }

    /**
     * Вывод слов русского языка, начинающихся со словосочетания, переданного параметром.
     * Функция не должна быть чувствительна к регистру.
     * @param begining начало слова
     * @return возвращает количество строк, удовлетворяющих условием поиска.
     */
    public static int wordsStartsWith(String begining){
        //TODO
        return 0;
    }

    /**
     * Вывод слов русского языка, содержащих в любом месте слова часть, переданную параметром part
     * @param part часть слова
     * @return количество слов, удовлетворяющих критерию
     */
    public static int wordsContains(String  part){
        //TODO
        return 0;
    }

    /**
     * Подсчитывает количество слов русского языка, состоящих из указанного количества букв
     * @param size
     * @return
     */
    public static int countWordBySize(int size){
        //TODO
        return 0;
    }
}

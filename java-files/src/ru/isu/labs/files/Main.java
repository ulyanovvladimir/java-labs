package ru.isu.labs.files;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	    // write your code here
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

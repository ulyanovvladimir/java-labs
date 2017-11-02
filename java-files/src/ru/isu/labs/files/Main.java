package ru.isu.labs.files;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	    // write your code here
    }

    /**
     * Считывает файл в кодировке UTF-8 и выводит его на экран.
     * @param path
     * @throws IOException в случае, если файл не найден, либо произошла проблема
     * при чтении файла.
     *
     */
    public void printFileUTF(String path) throws IOException{
        //TODO
    }

    /**
     *
     * @param path
     * @param encoding
     * @return
     */
    public String readFile(String path, String encoding){
        //TODO
        return null;
    }


    /**
     * Проверяет, является ли строка словом. Строка не должна содержать пробелы, символ дефиса, точки и точки с запятой.
     * @param s
     * @return
     */
    public boolean isWord(String s){
        //TODO
        return true;
    }

    /**
     * Вывод слов русского языка, начинающихся со словосочетания, переданного параметром.
     * Функция не должна быть чувствительна к регистру.
     * @param begining начало слова
     * @return возвращает количество строк, удовлетворяющих условием поиска.
     */
    public int wordsStartsWith(String path, String begining){
        //TODO
        return 0;
    }

    /**
     * Вывод слов русского языка, содержащих в любом месте слова часть, переданную параметром part
     * @param part часть слова
     * @return количество слов, удовлетворяющих критерию
     */
    public int wordsContains(String  part){
        //TODO
        return 0;
    }

    /**
     * Подсчитывает количество слов русского языка, состоящих из указанного количества букв
     * @param size
     * @return
     */
    public int countWordBySize(int size){
        //TODO
        return 0;
    }
}

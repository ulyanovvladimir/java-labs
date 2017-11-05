package ru.isu.lab15;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

import static java.lang.System.in;

public class Words {


    /**
     * выводит список на экран, вспомогательный метод для отладки, например.
     * @param list список для вывода на консоль
     */
    static void print(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * Загрузить список слов из словаря
     * @return Список строк, содержащихся в файле словаря
     */
    public static List<String> readDictionary() {
        List<String> ret = new ArrayList<>();

        try {
            //открываем поток для чтения файла
            InputStream inputStream = new FileInputStream("zdf-win.txt");
            //считываем файл как текст в кодировке Win-1251
            InputStreamReader isReader = new InputStreamReader(inputStream, "windows-1251");
            //буферезируем для построчного чтения
            BufferedReader reader = new BufferedReader(isReader);


            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                ret.add(s.trim());
            }

        } catch (FileNotFoundException fe) {
            System.err.println("Файл словаря не найден");
            fe.printStackTrace();
            throw new RuntimeException(fe);
        } catch (IOException e) {
            System.err.println("Произошла ошибка при чтении файла словаря");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            return ret;
        }
    }


    /**
     * Возвращает отфильтрованный набор слов, не содержащих дефисы
     * @param dictionary исходный список слов с дефисами
     * @return результирующий список слов без дефисов
     */
    public static List<String> withoutDefis(final List<String> dictionary) {
        List<String> ret = new ArrayList<>();
        for (String word : dictionary) {
            if(!word.contains("-")) ret.add(word);
        }
        return ret;
    }


    public static List<String> mnemonics(String number, List<String> dic){
        List<String> ret = new ArrayList<>();
        for (String word : dic) {

        }


        return ret;
    }

    public static void main(String[] args) {
        //считываем словарь из текстового файла и получаем список всех слов, содержащихся в исходном словаре
        List<String> dictionary = readDictionary();
        //TODO получаем список слов без дефисов
        // Подсказка:воспользовавшись методом withoutDefis
        List<String> dic = withoutDefis(dictionary);

        List<String> list = mnemonics("79025788879", dic);
        print(list);
    }
}

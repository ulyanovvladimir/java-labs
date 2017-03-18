package ru.isu.lab14.words;

import java.io.*;
import java.util.*;
import java.util.List;

import static java.lang.System.in;

public class Words {

    public static final int TOP_SIZE = 50;
    public static final int MAX_ERRORS = 10;

    /**
     * Выводит список на экран, вспомогательный метод для отладки, например.
     *
     * @param list список для вывода на консоль
     */
    static void print(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * Загружает список слов из файла словаря
     *
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
     *
     * @param dictionary исходный список слов с дефисами
     * @return результирующий список слов без дефисов
     */
    public static List<String> withoutDefis(final List<String> dictionary) {
        List<String> ret = new ArrayList<>();
        //TODO выбрать из словаря те слова, которые не содержат символ дефиса. Добавить их в результирующий список ret


        return ret;
    }

    /**
     * Данный компаратор должен сравнивать строки по длине. Сначала более длинные строки, затем более короткие.
     * <p>
     * Компаратор - способ сравнения двух объектов, интерфейс содержащий метод compare.
     * <p>
     * Пусть a и b длины строк o1 и o2. Тогда метод compare
     * возвращает отрицательное число, если a>b
     * возвращает положительное число, если a<b
     * возвращает 0 если a равно b
     *
     * @return число со знаком для сравнения
     */
    public static Comparator<String> lengthComparator() {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //TODO реализовать функцию сравнения двух слов по длине
                return 0;
            }
        };
    }

    /**
     * Возвращает первые TOP_SIZE элементов списка list
     *
     * @param list исходный список
     * @return список длины TOP_SIZE или меньше, в случае, если исходный список содержит менее TOP_SIZE элементов
     */
    public static List<String> top(List<String> list) {
        //TODO реализовать возврат первых TOP_SIZE элементов списка
        return Collections.emptyList();
    }


    /**
     * Возвращает частоту встречания каждого символа в слове word
     *
     * @param word слово
     * @return пары Символ-Количество встречания каждого символа в слове
     * Данный метод представлен для ознакомления, он реализован за Вас.
     */

    public static Map<Character, Integer> frequency(String word) {
        Map<Character, Integer> ret = new HashMap<>();
        for (char c : word.toCharArray()) {
            int count = ret.getOrDefault(c, 0);
            ret.put(c, count + 1);
        }
        return ret;
    }

    /**
     * Проверяет можно ли составить маленькое слово из большого на основе их частотных показателей
     *
     * @param big   - частотные показатели большого слова
     * @param small - частотные показатели маленького слова
     * @return истина в случае, если из букв большого можно составить маленькое слово. Иначе возвращает ложь.
     */
    public static boolean contains(Map<Character, Integer> big, Map<Character, Integer> small) {

        //TODO реализовать функцию, проверяющую, можно ли из большого слова составить маленькое слово
        //TODO для каждого ключа-буквы из маленького слова сравнить сколько раз встречается эта буква в большом слове
        //TODO в случае, если в большом слове эта буква встречается меньше, чем в маленьком, то маленькое слово нельзя составить из этого большого: возвращаем false
        //TODO если мы пробежали все буквы и не нашли проблем, то возвращаем true
        return true;
    }

    /**
     * Теоретико множественная разность. Принадлежит А и не принадлежит Б.
     *
     * @param list исходный большой список
     * @param sub  вычитаемый список
     * @return List - sub: список строк, входящих в List, но не входящих в sub
     */
    public static List<String> minus(List<String> list, List<String> sub) {
        //TODO реализовать теоретико-множественную разность
        //TODO ПОДСКАЗКА: по определению, слово должно ПРИНАДЛЕЖАТЬ list, но не ПРИНАДЛЕЖАТЬ sub.
        //TODO Воспользуйтесь методом contains класса List, чтобы проверить, что список содержит элемент

        return Collections.emptyList();
    }

    /**
     * Возвращает измененный общий счет, после учета нового слова. К текущему счету добавляется количество букв нового слова
     *
     * @param oldCount текущий счет (старый, предыдущий)
     * @param userWord слово, количество букв которого нужно прибавить к счету
     * @return новый счет, равный сумме текущего счета и количества букв в слове
     */
    public static int countWord(final int oldCount, final String userWord) {
        //Слово ДОМ длины 3. Ваш общий счет равен 25
        //длина слова
        int wordLength = 0; //TODO
        //новый счет
        int newCount = 0; //TODO
        System.out.printf("Слово %s длины %d. Ваш общий счет равен %d\n", userWord, wordLength, newCount);
        return newCount;
    }

    public static void main(String[] args) {
        //считываем словарь из текстового файла и получаем список всех слов, содержащихся в исходном словаре
        List<String> dictionary = readDictionary();
        // получаем список слов без дефисов
        // Подсказка:воспользовавшись методом withoutDefis
        List<String> dic = withoutDefis(dictionary);

        //получаем компаратор для сравнения строк по длине
        // Подсказка: воспользоваться функцией lengthComparator
        Comparator<String> c = lengthComparator();
        dic.sort(c);

        //Фильтруем первые несколько слов максимальной длины,
        // Замечание: необходимо исопльовать константу TOP_SIZE. Обратите внимание на метод subList
        List<String> top = top(dic);

        //случайное слово из топа - оно будет словом из которого все будут собирать слова
        Random rand = new Random();
        String longWord = top.get(rand.nextInt(50));
        //Множество слов, которые можно построить из этого длинного слова
        List<String> validDic = validWords(longWord, dic);

        /*
         * Организовываем игру. Будем предлагать пользователю ввести слово. Затем компьютер вводит слово. По очереди.
          * Необходимо запоминать введенные слова и подсчитывать количество очков, набранных компьютером и пользователем
          * На каждом ходу пользователю разрешается MAX_ERORS ошибок. Если 10 раз ввел слово, которого нет в словаре, игра останавливается.
         */
        System.out.println("ИГРА НАЧИНАЕТСЯ!");
        System.out.println(longWord.toUpperCase());
        List<String> usedWords = new ArrayList<>();
        int userErrors = 0;
        int userCount = 0;
        int compCount = 0;
        while (userErrors < MAX_ERRORS) {
            Scanner sc = new Scanner(in);
            System.out.println("Ваш ход. Введите слово: ");
            String userWord = sc.nextLine().trim();

            if (!validDic.contains(userWord)) {
                userErrors++;
                System.out.printf("Такого слова нет (в словаре)! У вас осталось %d попыток\n", 10 - userErrors);
                continue;
            } else if (usedWords.contains(userWord)) {
                userErrors++;
                System.out.printf("Такое слово уже было! У вас осталось %d попыток\n", 10 - userErrors);
                continue;
            } else {
                //Слово правильное
                //Вносим слово в список использованных слов
                usedWords.add(userWord);
                //Подсчитываем результат
                userCount = countWord(userCount, userWord);
            }
            //Компьютер делает ход. Выбираем слово из словаря
            //строим список оставшихся слов
            List<String> rest = minus(validDic, usedWords);
            if (rest.isEmpty()) {
                System.out.println("КОНЕЦ ИГРЫ! ВЫ ВЫИГРАЛИ!");
                return;
            }
            String compWord = rest.get(rand.nextInt(rest.size()));
            usedWords.add(compWord);
            System.out.println("Компьютер составил слово: " + compWord);
            compCount = countWord(compCount, compWord);
        }
        //10 попыток вышли. Вы проиграли
        System.out.printf("У вас не осталось больше попыток. Вы проиграли. Текущий счет (Вы : Компьютер) равен %d : %d  \n",
                userCount, compCount);
    }


    /**
     * Получает список слов словаря, которые можно собрать из букв данного длинного слова
     *
     * @param longWord длинное слово, из букв которого нужно собирать слова
     * @param dic      словарь слов в виде списка строк
     * @return список слов, которые можно собрать из букв слова longWord
     */
    public static List<String> validWords(final String longWord, final List<String> dic) {
        List<String> ret = new ArrayList<String>();
        Map<Character, Integer> maxFreq = frequency(longWord);
        for (String word : dic) {
            if (contains(maxFreq, frequency(word))) {
                ret.add(word);
            }
        }
        return ret;
    }


}

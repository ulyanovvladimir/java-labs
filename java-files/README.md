# Чтение файлов

Существует множество способов чтения файлов в Java. Главное, о чем необходимо помнить при чтении текстового файла:
1. кодировка;
2. обработка исключений.

На данном уровне знаний в области языков программирования я рекомендую пользоваться вам чтением файлов на основе потоков либо сканером. Пример:
```java
\\Самый простой пример на базе сканнера
try {
    Scanner scanner = new Scanner(new File("c:\\windows\\win.ini"), "UTF-8");
    //Scanner scanner = new Scanner(new File("c:\\windows\\win.ini"), "windows-1251");
    while (scanner.hasNext()) {
        //считываем строку
        String line = scanner.nextLine();
        //далее делаем что-то со строкой, например выводим на экран
        System.out.println(line);
    }
} catch (FileNotFoundException e) {
    // файл не найден
    e.printStackTrace();
} catch (IllegalArgumentException e){
    //Не верная кодировка, кодировка не найдена
    throw new RuntimeException("Кодировка не найдена", e);
}
```

Пример посложнее на базе потоков и буферизированного чтения
```java
final int BUFFER_SIZE=5000;
BufferedReader reader = null;
try {
    FileInputStream fileInputStream = new FileInputStream(new File("c:\\windows\\win.ini"));
    InputStreamReader streamReader = new InputStreamReader(fileInputStream, "UTF-8");
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
```
Пример на базе потоков и библиотеки nio2
```java
try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(
                new FileInputStream(FILE_NAME), StandardCharsets.UTF_8))){
    //открыли файл в кодировке UTF-8 и теперь будем читать его построчно
    String line;
    while ((line = reader.readLine()) != null) {
        //далее делаем что-то со строкой, например выводим на экран
        System.out.println(line);
    }
} catch (IOException e) {
    // журнализируем ошибку, обрабатываем или прокидываем наверх
    e.printStackTrace();
} 
```

Когда вы узнаете, что такое параметрический полиморфизм, типизированные коллекции, списки и т.п., т.н. generics,
вы сможете использовать следующий код для чтения файла построчно:

```java
List<String> lines = Files.readAllLines(Paths.get(FILE_NAME), StandardCharsets.UTF_8);
for(String line: lines){
    System.out.println(line);
}
```

Когда же вы изучите стримы и функциональное программирование, то можете использовать для чтения файлов следующий код
```java
Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8).forEach(System.out::println);
```

# Тесты
В классе [Tests](src/ru/isu/labs/files/Tests.java) находится текущий набор тестов для проверки корректности Вашей работы.
Запустить их можно создав конфигурацию `JUnit`, либо запустить тесты по правой кнопке мыши, выбрав в контекстном меню пункт `Run`.
По мере реализации методов по инструкциям перезапускайте тесты, чтобы убедиться, что соответствующие тесты проходят и вы все делаете верно.
В будущем количество тестов может быть увеличено. Рекомендуется перед отправкой работы обновить тесты из репозитория.

# Задания и инструкции
Вам необходимо реализовать ряд функций, использующих чтение файлов в классе [Main](src/ru/isu/labs/files/Main.java)

Места, необходимые для реализации помечены аннотацией
```java
//TODO <Инструкции>
```

Сперва вам необходимо реализовать печать файла в кодировке UTF-8
Для этого реализуйте функцию
```java
/**
 * Считывает файл в кодировке UTF-8 и выводит его на экран.
 * @param path
 * @throws IOException в случае, если файл не найден, либо произошла проблема
 * при чтении файла.
 *
 */
public static void printFileUTF(String path) throws IOException{
    //TODO
}
```
Она должна сначала проверять существует ли такой файл и кидать исключение, если он не существует.
Затем должна открывать на входной поток InputStream, который можно прочитать с помощью Reader или Scanner
После этого файл можно считывать построчно и выводить на экран.

Затем вам необходимо реализовать функцию readFile, которая принимает в качестве параметра
путь до файла и кодировку. В отличие от функции printFileUTF, она не должна производить вывод на экран,
а только возвращать считанный файл в виде строки.
```java
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
```

Затем перепишите реализацию функции printFileUTF через вызов функции readFile

Реализуйте функцию isWord для проверки является ли строка словом.


```java
    /**
     * Проверяет, является ли строка словом. Строка не должна содержать пробелы, символ дефиса, точки и запятой.
     * @param s строка
     * @return
     */
    public static boolean isWord(String s){
        //TODO
        return true;
    }
```
По нашим условиям строка не должна содержать пробелы, символ дефиса, точки и запятой.
Например, следующие строки не являются словами:

-де

-нибудь

раз, два, три.

> Подсказка: при реализации может потребоваться использовать методы класса String, такие как contains или indexOf

```java
String s = "политика";
//проверяет есть ли в строке s подстрока "тик".
boolean b = s.contains("тик"); // true
// ищет первое вхождение подстроки "тик" и возвращает индекс первого символа подстроки. Если не находит, возвращает -1.
int index = s.indexOf("тик"); // 4
```

Реализуйте функцию wordStartsWith, которая выводит слова, начинающиеся с указанного префикса.
```java
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
```
Например
```java
wordsStartsWith("вел");
```
должно выводить на экран такие слова как "великий", "велосипед", но не должно выводить слово "увеличение".

> Примечание: для этого воспользуйтесь методом String.startsWith(String s)

```java
"велосипед".startsWith("вел");  //true
"увеличение".startsWith("вел");  //false
```

Реализуйте функцию wordsContains
```java
    /**
     * Вывод слов русского языка, содержащих в любом месте слова часть, переданную параметром part
     * @param part часть слова
     * @return количество слов, удовлетворяющих критерию
     */
    public static int wordsContains(String  part){
        //TODO
        return 0;
    }
```
Она выводит слова русского языка, содержащих в любом месте слова часть, переданную параметром part.

Реализуйте функцию countWordBySize. Она подсчитывает сколько слов в словаре имеют определенное количество букв.
```java
   /**
     * Подсчитывает количество слов русского языка, состоящих из указанного количества букв
     * @param size
     * @return
     */
    public static int countWordBySize(int size){
        //TODO
        return 0;
    }
```

Например, чтобы вычислить, сколько слов имеют 8 букв надо выполнить:
```java
int wordsCount = countWordBySize(8);
```

>Примечание: для решения задачи может потребоваться использовать функцию String.length(), которая возвращает длину строки

```java
int wordLength = "молоко".length(); // 6
```


# Запуск
Когда все функции работают правильно, а все тесты проходят, загрузите архив с проектом в качестве отчета.
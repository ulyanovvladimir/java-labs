package labs.lab3.v30;

import java.util.Scanner;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        // Задание 1
        fTable(0, 3, 0.1);

        //Задание 2.
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число m ");
        int m = Integer.valueOf(sc.nextLine());
        System.out.printf("Значение суммы ряда для m=%d равно %f\n", m, sum(m));

        // Задание 3.
        System.out.print("Введите число m ");
        m = Integer.valueOf(sc.nextLine());
        System.out.printf("Значение произведения ряда для m=%d равно %f\n", m, product(m));

        // Задание 4.
        System.out.print("Введите число n ");
        int n = Integer.valueOf(sc.nextLine());
        System.out.printf("5*%d! равно %d\n", n, factorialFive (n));
    }


    /**
     * Выводит таблицу значений функции f(x)
     *
     * @param xMin минимальное значение x, левая граница интервалла
     * @param xMax максимальное значение x, правая граница интервалла
     * @param step шаг
     */

    public static void fTable(final double xMin, final double xMax, final double step) {
        int count = (int) round((xMax - xMin) / step);
        System.out.printf("x\t\t\tf(x)\n");
        for (int i = 0; i <= count; i++) {
            // Пояснение: переменная x нужна только в цикле, поэтому объявляем ее локально
            double x = xMin + step * i;
            //Вычисляем f(x) и выводим в табличной форме в два столбца.
            System.out.printf("%f\t%f\n", x, f(x));
        }
    }

    /**
     * Возвращает значение f(x) для построения таблицы значения функции
     *
     * @param x аргумент функции
     * @return значение функции
     */
    public static double f(double x) {
        return log(1 + 2 * pow(E, -pow(x, 2))) * 3 / (pow(x, 2) + 4);
    }

    /**
     * Задание 2. Программа вычисляет значение суммы. В качестве аргумента верхний предел индексов суммы, равный m
     *
     * @param m максимальный индекс ряда
     * @return сумма ряда
     */
    public static double sum(int m) {
        double sum = 0.0;
        for (int j = 1; j <= m; j++) {
            sum += tan(pow(j, 3)) / (j + 5.0);
        }
        return sum;
    }

    /**
     * Задание 3. Вычисление произведения ряда
     *
     * @param m последний индекс элемента ряда, участвующий в произведении
     * @return результат произведения элементов ряда
     */
    public static double product(int m) {
        double ret = 1.0;
        for (int i = 1; i <= m; i++) {
            ret *= 2 + cos(pow(i, 2));
        }
        return ret;
    }

    /**
     * Факториал числа с помощью циклов
     *
     * @param n число
     * @return факториал числа n
     */
    private static long factorial(int n) {
        long ret = 1;
        for (int i = 1; i <= n; i++) {
            ret *= i;
        }
        return ret;
    }

    /**
     * Упятеренный факториал числа
     *
     * @param n число
     * @return упятеренный факториал числа n
     */

    public static long factorialFive(int n) {
        return 5 * factorial(n);
    }

}

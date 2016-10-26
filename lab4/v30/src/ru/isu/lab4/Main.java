package ru.isu.lab4;

import static java.lang.Math.*;

/**
 * @author Vladimir Ulyanov
 *         Lab 4.
 *         <p>
 *         V. 30
 */
public class Main {

    public static void main(String[] args) {

    }

    /**
     * Задание 1.
     * @param x1 - первый элемент последовательности
     * @param x2 - второй элемент последовательности
     * @param x3 - третий элемент последовательности
     * @param m - количество элементов последовательности, размерность массива
     * @return массив, который начинается с указанных элементов, а остальные расчитываются по формуле.
     */
    public static double[] x(final double x1, final double x2, final double x3, int m) {
        if (m < 3) throw new IllegalArgumentException("Не допустимое значение, длина не может быть меньше 3");
        double[] ret = new double[m];
        ret[0] = x1;
        ret[1] = x2;
        ret[2] = x3;

        for (int i = 3; i < m; i++) {
            ret[i] = pow(cos(ret[i-2]), 2.0) + cos(ret[i-1]) + ret[i-3];
        }

        return ret;
    }

    /**
     * Задание 2.
     * @param a - массив a
     * @param b - массив b
     * @return результат по формуле
     */
    public static double s(final double[] a, final double[] b){
        //проверка недопустимых значений
        if (a.length != b.length) throw new IllegalArgumentException("Массивы a и b должны быть одинаковой длины");

        double firstSum = 0;
        for (int i = 0; i < a.length; i++) {
            firstSum +=a[i] * pow(b[i], 3);
        }

        double secondSum = 0;
        for (double bi : b) {
            secondSum += log(abs(bi));
        }

        return sin(firstSum) / cos(secondSum);

    }

    public static int[] sort(final int[] arr){
        //копируем массив в наш локальный массив ret, который будем сортировать.
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr[i];
        }

        //пузырьковая сортировка

        while(true){
            boolean changed = false;
            for (int i = 0; i < ret.length - 1; i++) {
                if(ret[i] > ret[i+1]) {
                    //не отсортировано.
                    changed = true;
                    ret[i] = ret[i+1] + ret[i];
                    ret[i+1] = ret[i]- ret[i+1];
                    ret[i]= ret[i]-ret[i+1];
                    break;
                }
            }
            if (!changed) break;
        }
        return ret;
    }

}

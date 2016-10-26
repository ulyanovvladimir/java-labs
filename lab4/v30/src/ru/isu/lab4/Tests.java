package ru.isu.lab4;

import org.junit.Test;

import java.util.Arrays;

import static java.lang.Math.E;
import static java.lang.Math.PI;
import static org.junit.Assert.assertEquals;

/**
 * @author Vladimir Ulyanov
 */
public class Tests {
    //константа для указания точности сравнения чисел с плавающей точкой в тестах
    final static double EPS = 0.00001;

    @Test
    public void testXZeros() {
        double[] arr = Main.x(0, 0, 0, 4);
        //сравниваем отдельный элемент полученного массива
        assertEquals("За нулями идет двойка", 2.0, arr[3], EPS);
        //а тут используем наш вспомогательный метод для сравнения двух массивов целиком, описан в конце класса
        assertArraysEquals(new double[]{0, 0, 0, 2.0}, arr);
    }

    @Test
    public void testXPi() {
        double[] arr = Main.x(PI, PI / 2, PI / 2, 4);
        assertEquals("За pi, pi/2, pi/2 идет pi", PI, arr[3], EPS);
    }


    @Test
    public void testSZerosAndE() {
        //b - вектор заполненный константами E.
        double[] b = new double[10];
        for (int i = 0; i < b.length; i++) {
            b[i] = E;
        }
        //a - вектор заполненный нулями
        double[] a = new double[10];
        assertEquals("Если в а нули, то итог 0", 0, Main.s(a, b), EPS);
    }

    @Test
    public void testSE() {
        double[] b = new double[10];
        for (int i = 0; i < b.length; i++) {
            b[i] = E;
        }
        double[] a = new double[10];
        for (int i = 0; i < a.length; i++) {
            b[i] = E;
        }

        assertEquals("Все е приводят к нулю", 0.0, Main.s(a, b), EPS);
    }


    @Test
    public void testSort(){
        int[] unsorted = new int[]{1, 3, 5, 0, 2, 4};

        int[] tested = Main.sort(unsorted);
        int[] correct = new int[]{0,1,2,3,4,5};
        for (int i = 0; i < tested.length; i++) {
            assertEquals(correct[i], tested[i]);
        }
    }


    /**
     * Функция для сравнения двух массивов целиком.
     * Если хотя бы одна пара элементов не совпадет, тест провален.
     * Массивы должны быть одинаковой длины.
     *
     * @param a массив 1
     * @param b массив 2
     */
    private static void assertArraysEquals(double[] a, double b[]) {
        assertEquals(a.length, b.length);
        for (int i = 0; i < a.length; i++) {
            assertEquals(a[i], b[i], EPS);
        }
    }



}

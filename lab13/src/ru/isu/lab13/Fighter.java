package ru.isu.lab13;

import java.util.Random;

/**
 *
 */
public class Fighter {
    //===============================Эта часть содержит поля, конструкторы и методы, которые уже реализованы ===================================
    /**
     * Генератор псевдо-случайных чисел. Для надежности должен быть один и везде дальше использоваться.
     */
    protected static Random rand = new Random();
    private final String name;


    protected int health;
    /**
     * Минимальный удар
     */
    protected final int hitMIN;
    /**
     * Максимальный удар
     */
    protected final int hitMAX;

    protected final double hitSuccess;

    /**
     * Конструктор создания объекта класса Fighter. Задаются все параметры.
     * @param health
     * @param hitMIN
     * @param hitMAX
     * @param hitSuccess
     */
    public Fighter(String name, int health, int hitMIN, int hitMAX, double hitSuccess) {
        if (hitMIN <= 0) throw new IllegalArgumentException("Минимальный урон должен быть больше нуля");
        this.hitMIN = hitMIN;
        if (hitMAX < hitMIN) throw new IllegalArgumentException("Максимальный урон должен быть больше либо равен минимальному");
        this.hitMAX = hitMAX;
        if (hitSuccess< 0 || hitSuccess > 1.0) throw new IllegalArgumentException("Вероятность нанесения удара должна быть в интервалле [0..1]");
        this.hitSuccess = hitSuccess;
        if (health <=0) throw new IllegalArgumentException("Запас здоровья должен быть больше нуля");
        this.health = health;

        this.name = name;
    }

    /**
     * Возвращает количество здоровья бойца.
     * @return
     */
    public int getHealth(){
        return health;
    }

    @Override
    public String toString() {
        return name+" ["+health+"]";
    }

    /**
     * Возвращает псевдо-случайное число между min и max, включительно.
     *
     * @param min Минимальное значение
     * @param max Максимальное значение.  Должно быть больше min
     * @return Целое число между min и max включительно.
     * @see java.util.Random#nextInt(int)
     */
    public static int randInt(int min, int max) {
        // nextInt обычно не включает верхнуюю границу, поэтому добавляем 1 чтобы граница была включена.
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    //==============================Эти методы нужно реализовать =====================================================

    /**
     * Проверяет живой ли еще боец. Боец жив, если здоровье больше нуля.
     * @return истина, в случае, если боец жив, иначе возвращает ложь.
     */
    public boolean isAlive(){
        //TODO Реализовать проверку запаса жизни бойца.
        return false;
    }

    /**
     * Получение урона. Уменьшает здоровье на величину полученного урона.
     * @param taken величина полученного урона
     */
    public void takeHit(int taken){
        //TODO обработать получение урона. Вычесть полученный урон из здоровья.

    }

    /**
     * Возвращает количество нанесенного удара в интервалле от hitMIN До hitMAX. Возвращает 0 в случае промаха
     * @return
     */
    public int getHit(){
        //TODO Рассчитать вероятность нанесения удара (возможен промах) в зависимости от hitSuccess
        //Подсказка: использовать метод Random#nextDouble()
        double p = 0.0;

        //Подсказка: если вероятность "p", случайное число в [0..1] меньше, чем наша вероятность успеха, то удар наносится. Иначе возвращаем 0 в качестве промаха


        //TODO Сделать расчет случайного числа в интервалле от hitMIN до hitMAX
        //Подсказка: использовать метод randInt
        return 0;
    }

}

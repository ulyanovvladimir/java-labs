package ru.isu.lab13;

import org.junit.Before;

public class Duel {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        Fighter kligan;
        Fighter joefry;
        Fighter robStark;
        Fighter stanis;
        Fighter johnSnow;
        joefry = new Fighter("Джофри Баратеон", 20, 1, 5, 0.5);
        robStark = new Fighter("Роб Старк", 200, 30, 50, 0.75);
        stanis = new Fighter("Станис Баратеон", 200, 20, 40, 0.9);
        kligan = new Fighter("Сандор Клиган", 500, 100, 200, 0.3);
        johnSnow = new Fighter("Джон Сноу", 2000, 30, 50, 0.9);

        Fighter[] fighters = new Fighter[]{joefry, robStark, stanis, kligan, johnSnow};

        //Случайным образом выбираем первого бойца.
        int fighter1 = joefry.randInt(0, fighters.length - 1);
        //Второго бойца выбираем случайно, но он должен не совпасть с выбранным уже бойцом.
        int fighter2 = fighter1;
        while (fighter2 == fighter1) {
            fighter2 = joefry.randInt(0, fighters.length - 1);
        }

        Fighter f1 = fighters[fighter1];
        Fighter f2 = fighters[fighter2];
        System.out.println("На арену выходит " + f1);
        System.out.println("Его соперником в этом поединке будет " + f2);
        Thread.sleep(2000);

        //Удары наносятся одновременно
        while (f1.isAlive() && f2.isAlive()) {
            int f1Hit = f1.getHit();

            int f2Hit = f2.getHit();
            if (0 == f1Hit) System.out.println(f1 + "промахивается"); else System.out.println(f1 + "наносит урон "+f1Hit);
            if (0 == f2Hit) System.out.println(f2 + "промахивается"); else System.out.println(f2 + "наносит урон "+f2Hit);
            f1.takeHit(f2Hit);
            f2.takeHit(f1Hit);


            Thread.sleep(1500);
        }

        if (f1.isAlive()) System.out.println("Победил "+ f1); else System.out.println("Победил "+ f2);

    }
}

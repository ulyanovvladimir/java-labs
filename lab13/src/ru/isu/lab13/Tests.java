package ru.isu.lab13;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Vladimir Ulyanov
 */
public class Tests {
    Fighter kligan;
    Fighter joefry;
    Fighter robStark;
    Fighter stanis;
    Fighter johnSnow;
    Fighter mozila;

    @Before
    public void createFighters() {
        joefry = new Fighter("Joefry Barateon",20, 1, 5, 0.0);
        robStark = new Fighter("Rob Stark",200, 30, 50, 0.75);
        stanis = new Fighter("Stanis Barateon", 200, 20, 40, 0.9);
        kligan = new Fighter("Sandor Kligan", 500, 100, 200, 0.3);
        johnSnow = new Fighter("John Snow", 2000, 30, 50, 1.0);

    }


    @Test
    public void testAlive() {
        assertTrue(joefry.isAlive());
        assertTrue(kligan.isAlive());
        assertTrue(stanis.isAlive());
        assertTrue(johnSnow.isAlive());
    }

    @Test
    public void testTakeHit(){
        joefry.takeHit(50);
        assertEquals(-30, joefry.getHealth());
        robStark.takeHit(50);
        assertEquals(150, robStark.getHealth());
        stanis.takeHit(50);
        assertEquals(150, stanis.getHealth());
        johnSnow.takeHit(1000);
        assertEquals(1000,johnSnow.getHealth());
    }

    @Test
    public void testSurvived() {
        joefry.takeHit(50);
        assertFalse(joefry.isAlive());
        robStark.takeHit(50);
        assertTrue(robStark.isAlive());
        stanis.takeHit(50);
        assertTrue(stanis.isAlive());
        johnSnow.takeHit(1000);
        assertTrue(johnSnow.isAlive());
        johnSnow.takeHit(1500);
        assertFalse(johnSnow.isAlive());
    }

    @Test
    public void testGetHit(){
        for (int i=0; i<1000; i++) assertTrue(joefry.getHit()==0);
        for (int i=0; i<1000; i++) assertTrue(johnSnow.getHit()>0);
        {
            int fail = 0;
            int success = 0;
            for (int i = 0; i < 100000; i++) {
                int hit = robStark.getHit();
                if (hit == 0) {
                    fail++;
                } else {
                    success++;
                    assertTrue(hit >= 30 && hit <= 50);
                }
            }
            assertTrue("Что-то не то с вероятностью урона. Успехов должно быть больше, чем промахов", success > fail);
        }


        {
            int fail = 0;
            int success = 0;
            for (int i = 0; i < 100000; i++) {
                int hit = kligan.getHit();
                if (hit == 0) {
                    fail++;
                } else {
                    assertTrue(hit >= 100 && hit <= 200);
                    success++;
                }
            }

            assertTrue("Что-то не то с вероятностью урона. Успехов должно быть меньше, чем промахов", success < fail);
        }

    }

}

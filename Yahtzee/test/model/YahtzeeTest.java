/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Test;

/**
 *
 * @author Michel
 */
public class YahtzeeTest {

    /**
     * Test of putAsides method, of class Yahtzee.
     */
    @Test(expected = RuntimeException.class)
    public void testPutAsides() throws YahtzeeException {
        System.out.println("putAsides");
        int index = 15;
        DiceBucket bucket = new DiceBucket();
        Yahtzee instance = new Yahtzee();
        instance.putAsides(index);
    }

}

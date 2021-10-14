package model;

import java.util.Random;

/**
 * This class is the dices game.
 *
 * @author g48962 Nguyen Khanh-Michel.
 */
public class Dice {

    private int value;

    /**
     * This is the constructor of Dice and it is initialized at 6.
     */
    public Dice() {
        this.value = 6;
    }

    /**
     * This is the getter of value.
     *
     * @return value.
     */
    public int getValue() {
        return value;
    }

    /**
     * This method throws the dice randomly between 1 and 6.
     *
     */
    public void roll() {
        Random random = new Random();
        this.value = random.nextInt(5) + 1;
        //System.out.println(value);
    }

}

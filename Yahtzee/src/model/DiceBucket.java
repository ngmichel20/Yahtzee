package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the dice bucket of the game.
 *
 * @author g48962 Nguyen Khanh-Michel.
 */
public class DiceBucket {

    private List<Dice> actives;
    private List<Dice> asides;

    /**
     * This is the constructor of DiceBucket. It initializes the dices's list
     * and put the 5 dices to the list of actives dices.
     */
    public DiceBucket() {
        actives = new ArrayList<>();
        asides = new ArrayList<>();
        Dice dice = new Dice();
        for (int i = 0; i < 5; i++) {
            actives.add(dice);
        }
    }

    /**
     * This is the the getter of actives.
     *
     * @return a list of dices.
     */
    public List<Dice> getActives() {
        /*for (Dice active : actives) {
            System.out.println(active.getValue());
        }*/
        return actives;
    }

    /**
     * This is the getter of asides.
     *
     * @return a list of dices.
     */
    public List<Dice> getAsides() {
        return asides;
    }

    /**
     * This method allows to throw all the dices that are actives.
     */
    public void roll() { 
        for (Dice active : actives) {
            active.roll();
            System.out.println(active.getValue());
        }
        System.out.println("");
        for (Dice active : actives) {
            System.out.println(active.getValue());//tester
        }
        
    }

    /**
     * This method put aside the dice with the index given in parameter.
     *
     * @param index
     */
    public void putAside(int index) {
        this.asides.add(actives.get(index));
    }

    /**
     * This method put aside all the dices that are actives.
     */
    public void putAllAside() {
        for (Dice active : actives) {
            this.asides.add(active);
        }
    }

    /**
     * This method counts the amount of dices aside with an certain value.
     *
     * @param value is an int.
     * @return the number of dices put aside.
     */
    public int getNbAsides(int value) {
        int nbDicesAsides = 0;
        for (int i = 0; i < this.asides.size(); i++) {
            //icicici
            nbDicesAsides++;

        }
        return nbDicesAsides;
    }

    /**
     * This method returns number dices that are still in the game.
     *
     * @return the number of dices that are still actives in the game.
     */
    public int getNbActives() {
        return actives.size();
    }

    /**
     * This metod shows if it still has dices in the game.
     *
     * @return true if it is empty.
     */
    public boolean isEmpty() {
        boolean isEmpty = true;
        if (!actives.isEmpty()) {
            isEmpty = false;
        }
        return isEmpty;
    }
}

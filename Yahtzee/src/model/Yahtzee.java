package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the game with all the game's rules.
 *
 * @author g48962 Nguyen Khanh-Michel.
 */
public class Yahtzee {

    private DiceBucket bucket;
    private int nbMoves;

    /**
     * This is the constructor of Yahtzee.
     */
    public Yahtzee() {
        this.bucket = new DiceBucket();
        this.nbMoves = 0;
    }

    public DiceBucket getBucket() {
        return bucket;
    }

    /**
     * This method allows to know when the game is over.
     *
     * @return false if the game is not over.
     */
    public boolean isOver() {
        boolean isOver = false;
        if (this.nbMoves > 3) {
            isOver = true;
        }
        return isOver;
    }

    /**
     * This method throws the dices that are still actives.
     */
    public void roll() {
        bucket.roll();
       /* List<Dice> diceBucket = bucket.getActives();
        for (Dice dice : diceBucket) {
            dice.roll();
        }*/
//        for (DiceBucket diceBucket : diceBucket1) {
//            dice1.roll();
//        }
        this.nbMoves++;
    }

    /**
     * This method put aside the index's dice given in the parameter.
     *
     * @param index is an int.
     * @throws model.YahtzeeException
     */
    public void putAsides(int index) throws YahtzeeException {
        if (index < 0 || index > bucket.getNbActives()) {
            throw new YahtzeeException("erreur");
        }
        List<Dice> dicesActives = bucket.getActives();
        List<Dice> dicesAsides = bucket.getAsides();
        dicesAsides.add(dicesActives.get(index));
        dicesActives.remove(index);
    }

    /**
     * This method put all aside the dices that are actives.
     */
    public void putAllAside() {
        List<Dice> dicesActives = bucket.getActives();
        List<Dice> dicesAsides = bucket.getAsides();
        for (Dice active : dicesActives) {
            dicesAsides.add(active);
        }
    }

    /**
     * This method allows to knows the number of moves done.
     *
     * @return nbMoves the number of moves done.
     */
    public int getNbMoves() {
        int nbMoves = 0;
        nbMoves = nbMoves + this.nbMoves;
        return nbMoves;
    }

    /**
     * This method calculates all the dices put aside by the player to give his
     * final score.
     *
     * @return score the player's score.
     */
    public int getScore() {
        int score = 0;
        List<Dice> dicesAsides = new ArrayList<>();
        for (Dice dicesAside : dicesAsides) {
            score = score + dicesAside.getValue();
        }
        return score;
    }

}

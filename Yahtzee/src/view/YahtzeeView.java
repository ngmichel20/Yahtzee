package view;

import java.util.List;
import java.util.Scanner;
import model.Dice;
import model.DiceBucket;
import model.Yahtzee;
import model.YahtzeeException;

/**
 * This is the view of Yahtzee.
 *
 * @author g48962 Nguyen Khanh-Michel.
 */
public class YahtzeeView {

    private Scanner in;
    private Yahtzee game;

    public YahtzeeView(Yahtzee game) {
        this.in = new Scanner(System.in);
        this.game = game;
    }

    /**
     * This method displays the rounds of the game.
     */
    public void displayRound() {
        System.out.println("---------------------------------------------------"
                + "---------");
        System.out.println("        Tour numéro " + (game.getNbMoves() + 1)
                + " sur 3");
        System.out.println("---------------------------------------------------"
                + "---------");
    }

    public void displayBucket(List<Dice> listDices) {
        for (Dice active : listDices) {
            //System.out.println(listDices.get(1).getValue());
            System.out.print(active.getValue() + "  ");
        }
        System.out.println("");
    }

    /**
     * This method displays the score of the game.
     */
    public void displayScore() {
        System.out.println("Le score est actuellement de " + game.getScore());
        System.out.println();
        List<Dice> listDices = game.getBucket().getActives();
        System.out.print("dé en jeu : ");
         for (int i = 0 ; i<listDices.size();i++) {
            //System.out.println(listDices.get(1).getValue());
            System.out.print(listDices.get(3).getValue() + "  ");
            
        }
        //displayBucket(listDices);
        listDices = game.getBucket().getAsides();
        System.out.print("dé mis de côté : ");
        displayBucket(listDices);
    }

    /**
     * This method asks to the player if he wants to put aside a dice or not.
     *
     * @return true if the player wants to put aside a dice.
     */
    public boolean askPlayerPutDiceAside() throws YahtzeeException {
        boolean putAside = true;
        System.out.println("Souhtaitez-vous mettre un dé de côté ?");
        String answer = in.next();
        while (!answer.equals("Oui") && !answer.equals("oui")
                && !answer.equals("Non") && !answer.equals("non")) {
            System.out.println("Veuillez entrer oui ou non,"
                    + " voulez-vous mettre un dé de côté ?");
            answer = in.next();
            if (answer.equals("Oui") || answer.equals("oui")) {
                enterDiceNbToPutAside();
                putAside = true;
            } else if (answer.equals("Non") || answer.equals("non")) {
                putAside = false;
            }
        }
        return putAside;
    }

    /**
     * This method allows to the player to enter the index of the dice he wants
     * to put aside.
     */
    public void enterDiceNbToPutAside() throws YahtzeeException {
        System.out.println("Entrez le numéro du dé que vous voulez conserver "
                + "entre 1 et 5 :");
        int answer = in.nextInt();
        game.putAsides(answer);
    }

}

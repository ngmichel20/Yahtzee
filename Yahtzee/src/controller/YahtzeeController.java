package controller;

import java.util.List;
import model.Dice;
import model.DiceBucket;
import model.Yahtzee;
import model.YahtzeeException;
import view.YahtzeeView;

/**
 *
 * @author Michel
 */
public class YahtzeeController {

    private Yahtzee game;
    private YahtzeeView view;

    public YahtzeeController(Yahtzee game, YahtzeeView view) {
        this.game = game;
        this.view = view;
    }

    public void startGame() throws YahtzeeException {
        //List<DiceBucket> dicesActives = (List<DiceBucket>) new DiceBucket();
        view.displayRound();
        game.roll();
        view.displayScore();
        view.askPlayerPutDiceAside();
        while (view.askPlayerPutDiceAside() == true) {
            view.askPlayerPutDiceAside();
        }
    }
}

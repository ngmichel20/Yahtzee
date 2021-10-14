package main;

import controller.YahtzeeController;
import model.Yahtzee;
import model.YahtzeeException;
import view.YahtzeeView;

/**
 *
 * @author Michel
 */
public class YahtzeeMain {
    
    public static void main(String[] args) {
        Yahtzee game = new Yahtzee();
        YahtzeeView view = new YahtzeeView(game);
        YahtzeeController controller = new YahtzeeController(game, view);
        try{
            controller.startGame();
        }catch (YahtzeeException ex){
            System.out.println(ex.getMessage());
        }
    }
}

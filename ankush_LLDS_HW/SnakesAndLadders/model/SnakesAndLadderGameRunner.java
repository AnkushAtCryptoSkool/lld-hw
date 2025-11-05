package designpatterns.ankush_LLDS_HW.SnakesAndLadders.model;

import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.strategy.BoardSettingEasy;
import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.strategy.DefaultTurnStrategy;
import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.strategy.DefaultWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class SnakesAndLadderGameRunner {
    public static void main(String[] args) {
        List<Player> players = List.of(new Player(1,0),new Player(2,0));
        Dice dice = new Dice();
        Board board = new Board(1,36,new BoardSettingEasy());
        Game game = new Game(players,dice,board,new DefaultTurnStrategy(),new DefaultWinningStrategy());
        game.start();
    }
}

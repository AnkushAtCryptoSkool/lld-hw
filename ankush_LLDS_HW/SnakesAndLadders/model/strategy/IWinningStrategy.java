package designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.strategy;

import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.Board;
import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.Player;

public interface IWinningStrategy {
    public boolean checkWinner(Board board, Player player);
}

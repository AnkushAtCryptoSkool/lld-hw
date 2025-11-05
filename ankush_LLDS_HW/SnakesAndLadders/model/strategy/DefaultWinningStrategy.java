package designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.strategy;

import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.Board;
import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.Player;

public class DefaultWinningStrategy implements IWinningStrategy{
    @Override
    public boolean checkWinner(Board board, Player player) {
        return player.getPosition() == board.getCellList().size();
    }
}

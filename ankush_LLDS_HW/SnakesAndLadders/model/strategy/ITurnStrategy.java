package designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.strategy;

import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.Player;

import java.util.List;

public interface ITurnStrategy {
   public Player getNextPlayer(List<Player> players);
}

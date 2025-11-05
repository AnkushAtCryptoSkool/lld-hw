package designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.strategy;

import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DefaultTurnStrategy implements ITurnStrategy{

    private Queue<Player> playerQueue;

    public DefaultTurnStrategy() {
        this.playerQueue = new LinkedList<>();
    }

    @Override
    public Player getNextPlayer(List<Player> players) {
        if(playerQueue.isEmpty())
        playerQueue.addAll(players);

        Player player = playerQueue.poll();
        playerQueue.add(player);
        return player;
    }
}

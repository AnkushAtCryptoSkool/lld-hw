package designpatterns.ankush_LLDS_HW.SnakesAndLadders.model;

import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.strategy.ITurnStrategy;
import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.strategy.IWinningStrategy;

import java.util.List;

public class Game {
    List<Player> players;
    Dice dice;
    Board board;
    ITurnStrategy turnStrategy;
    IWinningStrategy winningStrategy;

    public Game(List<Player> players, Dice dice, Board board, ITurnStrategy turnStrategy, IWinningStrategy winningStrategy) {
        this.players = players;
        this.dice = dice;
        this.board = board;
        this.turnStrategy = turnStrategy;
        this.winningStrategy = winningStrategy;
        if(board != null) {
            board.generateBoard();
        }else {
            throw new RuntimeException("Board not initalized,  create board first");
        }
    }

    public void  start(){
        System.out.println("-------------Starting Game ----------");
        board.printBoard();
        System.out.println("------------------");
        boolean winnerFound = false;
        while (winnerFound == false){
            // Player get
            Player player = turnStrategy.getNextPlayer(players);
            System.out.println("Player : " + player.getId() + "Current position -> " + player.getPosition());
            System.out.println("Player : " + player.getId() + "Rolls Dice");
             int move = player.rollDice(dice);
            System.out.println("Dice value : " + move);
            int currPlayerPosition = player.getPosition();
            currPlayerPosition += move;
            if(currPlayerPosition > board.getCellList().size())
                currPlayerPosition = player.getPosition();

            if(currPlayerPosition < board.getCellList().size()){
                if(board.getCellList().get(currPlayerPosition).hasBoardItem()){
                   Enum<BoardItemType> type = board.getCellList().get(currPlayerPosition).getBoardItem().getType();
                   if(type == BoardItemType.LADDER)
                       System.out.println("Ladder Encountered");
                   else if (type == BoardItemType.SNAKE)
                       System.out.println("Oops Bitten By Snake");

                   currPlayerPosition = board.getCellList().get(currPlayerPosition).getBoardItem().getEnd();
                }
            }
             player.setPosition(currPlayerPosition);
            System.out.println("Sending player : " + player.getId() + " to position " + currPlayerPosition);
            board.printBoard();
            if(winningStrategy.checkWinner(board,player)){
                 System.out.println("Player : " + player.getId() + "wins the game");
               winnerFound = true;
             }
        }
    }

    public void interrupt(){
        System.exit(0);
    }
}

package designpatterns.ankush_LLDS_HW.SnakesAndLadders.model;

import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.strategy.BoardSettingEasy;
import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.strategy.IBoardSettingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private int id;
    private List<Cell> cells;

    private IBoardSettingStrategy boardSettingStrategy;

    public Board(int id,int size, IBoardSettingStrategy boardSettingStrategy) {
        this.id = id;
        this.cells = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            cells.add(new Cell(i));
        }
        if(boardSettingStrategy != null)
            this.boardSettingStrategy = boardSettingStrategy;
        else
            this.boardSettingStrategy = new BoardSettingEasy();
    }

    public List<Cell> getCellList() {
        return cells;
    }
    public void generateBoard() {
        boardSettingStrategy.prepareBoard(cells);
    }
    public void printBoard() {
        int size = cells.size();
        int sideLen = (int) Math.sqrt(size); // assuming perfect square board like 100 → 10x10
        boolean leftToRight = true;

        System.out.println("\n======= SNAKES & LADDERS BOARD =======");
        for (int row = sideLen - 1; row >= 0; row--) { // start from top row
            if (leftToRight) {
                for (int col = sideLen - 1; col >= 0; col--) {
                    printCell(row, col, sideLen);
                }
            } else {
                for (int col = 0; col < sideLen; col++) {
                    printCell(row, col, sideLen);
                }

            }
            leftToRight = !leftToRight;
            System.out.println();
        }
        System.out.println("=========================================\n");
    }

    private void printCell(int row, int col, int sideLen) {
        int cellNum = row * sideLen + col + 1;
        Cell cell = cells.get(cellNum - 1);

        String display;
        if (cell.getPlayerId() != null) {
            display = "P" + cell.getPlayerId();
        } else if (cell.hasBoardItem()) {
            Enum<BoardItemType> type = cell.getBoardItem().getType();
            if (type == BoardItemType.SNAKE)
                display = "S↓";
            else
                display = "L↑";
        } else {
            display = String.valueOf(cellNum);
        }

        // Align neatly within 5 spaces
        System.out.printf("%5s", display);
    }


}

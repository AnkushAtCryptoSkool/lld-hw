package designpatterns.ankush_LLDS_HW.SnakesAndLadders.model;

public class Cell {
    private int cellNo;
    private BoardItem boardItem;

    private Integer playerId;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Cell(int cellNo) {
        this.cellNo = cellNo;
    }

    public int getCellNo() {
        return cellNo;
    }
    public BoardItem getBoardItem() {
        return boardItem;
    }

    public boolean hasBoardItem(){
        return  boardItem != null ? true : false;
    }

    public void setBoardItem(BoardItem boardItem) {
        this.boardItem = boardItem;
    }
}

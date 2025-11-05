package designpatterns.ankush_LLDS_HW.SnakesAndLadders.model;

public abstract class BoardItem {
    int start;
    int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public abstract Enum<BoardItemType> getType();

    public BoardItem(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

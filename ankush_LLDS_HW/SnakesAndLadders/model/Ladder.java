package designpatterns.ankush_LLDS_HW.SnakesAndLadders.model;

public class Ladder extends BoardItem{
    public Ladder(int start, int end) {
        super(start,end);
        if(start > end)
           throw new IllegalArgumentException("Ladder not vaild");
    }

    @Override
    public Enum<BoardItemType> getType() {
        return BoardItemType.LADDER;
    }
}

package designpatterns.ankush_LLDS_HW.SnakesAndLadders.model;

public class Snake extends BoardItem{
    public Snake(int head, int tail) {
        super(tail, head);
        if(tail > head)
            throw new IllegalArgumentException("Snake is not vaild");
    }

    @Override
    public Enum<BoardItemType> getType() {
        return BoardItemType.SNAKE;
    }
}

package designpatterns.ankush_LLDS_HW.SnakesAndLadders.model;

public class Player {
    private int id;

    public int getId() {
        return id;
    }

    public Player(int id, int position) {
        this.id = id;
        this.position = position;
    }

    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    int rollDice(Dice dice){
        return dice.roll();
    }
}

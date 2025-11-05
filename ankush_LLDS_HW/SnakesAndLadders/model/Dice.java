package designpatterns.ankush_LLDS_HW.SnakesAndLadders.model;

import java.util.Random;

public class Dice {
    int faces;
    int noOfDices;
    Random random = new Random();
    public Dice(int faces,int noOfDices){
        if(faces == 0) this.faces = 6;
        else this.faces = faces;

        if(noOfDices == 0) this.noOfDices = 0;
        else this.noOfDices = noOfDices;
    }

    public Dice(){
        this.faces = 6;
        this.noOfDices = 1;
    }

    public int roll(){
        int finalRollResult = 0;
        for (int i = 0; i < noOfDices; i++) {
          finalRollResult += rollHelper(faces);
        }
        return finalRollResult;
    }

    private int rollHelper(int faces) {
        return random.nextInt(faces)+1;
    }
}

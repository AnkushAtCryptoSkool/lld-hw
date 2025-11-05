package designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.strategy;

import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.Board;
import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.Cell;
import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.Ladder;
import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.Snake;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class BoardSettingEasy implements IBoardSettingStrategy{
    @Override
    public void prepareBoard(List<Cell> cellList) {
        int size = cellList.size();
        Random random = new Random();
        int noOfLadders = (size*30)/100;
        for (int i = 0; i < noOfLadders; i++) {
            int start = random.nextInt(size/2);
            int end = random.nextInt(size-noOfLadders+1)+noOfLadders;

            if(!cellList.get(start).hasBoardItem() && start < end && end < size && start > 0)
            cellList.get(start).setBoardItem(new Ladder(start,end));
        }
        int noOfsnakes = (size*10)/100;
        for (int i = 0; i < noOfsnakes; i++) {
            int tail = random.nextInt(size/2);
            int head = generateHead(random, size, noOfsnakes);
            while (head >= size){
                 head = generateHead(random,size,noOfsnakes);
            }
            if(!cellList.get(head).hasBoardItem() && tail < head && head < size && tail > 0)
                cellList.get(head).setBoardItem(new Snake(head,tail));
        }

    }

    private static int generateHead(Random random, int size, int noOfsnakes) {
        return random.nextInt(size - noOfsnakes + 1) + noOfsnakes;
    }
}

package designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.strategy;

import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.Board;
import designpatterns.ankush_LLDS_HW.SnakesAndLadders.model.Cell;

import java.util.List;

public interface IBoardSettingStrategy {
    void prepareBoard(List<Cell> cellList);
}

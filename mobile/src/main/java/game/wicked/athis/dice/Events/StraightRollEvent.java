package game.wicked.athis.dice.Events;

import game.wicked.athis.dice.enums.DiceType;

public class StraightRollEvent extends RollingEvent {

    public StraightRollEvent(DiceType diceType, int diceCount) {
        this.diceType = diceType;
        this.diceCount = diceCount;
    }

    @Override
    public int roll() {
        rolledValues.clear();
        rollDice();
        return totalRolledValues();
    }
}

package game.wicked.athis.dice.Events;

import game.wicked.athis.dice.enums.ClassFeature;
import game.wicked.athis.dice.enums.DiceType;

import java.util.ArrayList;
import java.util.Random;

public abstract class RollingEvent {
    DiceType diceType;
    int diceCount;
    private Random rng;
    private final Integer FUMBLE = 1;
    private final Integer CRIT = 20;
    ArrayList<Integer> rolledValues;

    public RollingEvent() {
        this.rng = new Random();
        this.rolledValues = new ArrayList<>();
    }

    public abstract int roll();

    private int rollDie() {
        return rng.nextInt(this.diceType.getDiceValue())+1;
    }

    void rollDice() {
        for (int roll = 0; roll < this.diceCount; roll++) {
            rolledValues.add(rollDie());
        }
    }

    void applyClassFeature(ClassFeature classFeature) {
        ArrayList<Integer> newValues = new ArrayList<>();
        switch(classFeature){
            case LUCKY:
                for (Integer rollValue: rolledValues) {
                    if (rollValue.equals(FUMBLE)) {
                        System.out.println("Shit son, you almost had a 1!");
                        newValues.add(rollDie());
                    } else {
                        newValues.add(rollValue);
                    }
                }
                break;
        }
        this.rolledValues = newValues;
    }

    int totalRolledValues() {
        int total = 0;
        for (Integer value: rolledValues) {
            total += value;
        }
        return total;
    }

}

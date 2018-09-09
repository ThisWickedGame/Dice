package game.wicked.athis.dice;

import game.wicked.athis.dice.Events.StraightRollEvent;
import game.wicked.athis.dice.enums.DiceType;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;


public class StraightDiceRollsAverage {
    private final int numOfRolls = 100000;


    @Test
    public void d2Mean() {
        int[] d2Rolls = generateDiceRolls(DiceType.d2);
        assertEquals("Average d2 value wide of margin of error",1.5, getMean(d2Rolls),0.01);
    }

    @Test
    public void d4Mean() {
        int[] d4Rolls = generateDiceRolls(DiceType.d4);
        assertEquals("Average d4 value wide of margin of error",2.5, getMean(d4Rolls),0.01);
    }

    @Test
    public void d6Mean() {
        int[] d6Rolls = generateDiceRolls(DiceType.d6);
        assertEquals("Average d6 value wide of margin of error",3.5, getMean(d6Rolls),0.01);
    }

    @Test
    public void d8Mean() {
        int[] d8Rolls = generateDiceRolls(DiceType.d8);
        assertEquals("Average d8 value wide of margin of error",4.5, getMean(d8Rolls),0.02);
    }

    @Test
    public void d10Mean() {
        int[] d10Rolls = generateDiceRolls(DiceType.d10);
        assertEquals("Average d10 value wide of margin of error",5.5, getMean(d10Rolls),0.03);
    }

    @Test
    public void d12Mean() {
        int[] d12Rolls = generateDiceRolls(DiceType.d12);
        assertEquals("Average d12 value wide of margin of error",6.5, getMean(d12Rolls),0.05);
    }

    @Test
    public void d20Mean() {
        int[] d20Rolls = generateDiceRolls(DiceType.d20);
        assertEquals("Average d20 value wide of margin of error",10.5, getMean(d20Rolls),0.07);
    }

    @Test
    public void d100Mean() {
        int[] d100Rolls = generateDiceRolls(DiceType.d100);
        assertEquals("Average d100 value wide of margin of error",50.5, getMean(d100Rolls),0.2);
    }

    private int[] generateDiceRolls(DiceType diceType) {
        int[] rolledValues = new int[numOfRolls];
        for (int num=0; num < numOfRolls; num++) {
            rolledValues[num] = new StraightRollEvent(diceType, 1).roll();
        }
        return rolledValues;
    }

    private double getMean(int[] rolledValues) {
        double total = 0.0;
        double count = rolledValues.length;
        for (int roll: rolledValues) {
            total += roll;
        }
        return total / count;
    }

}
package game.wicked.athis.dice.Events;

import game.wicked.athis.dice.enums.Ability;
import game.wicked.athis.dice.enums.AdvDis;
import game.wicked.athis.dice.utils.CharLookup;
import game.wicked.athis.dice.enums.DiceType;

import java.util.ArrayList;

public class AbilityEvent extends RollingEvent {
    private Ability abilityType;
    private int additionalModifier;
    private AdvDis advDis;

    public AbilityEvent(Ability abilityType, int additionalModifier, AdvDis advDis) {
         this.diceType = DiceType.d20;
         this.diceCount = 1;
         this.abilityType = abilityType;
         this.additionalModifier = additionalModifier;
         this.advDis = advDis;
    }

    private void applyAdvDis() {
        ArrayList<Integer> newValues = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Integer rollValue: rolledValues) {
            if (rollValue > max) {
                max = rollValue;
            }
            if (rollValue < min) {
                min = rollValue;
            }
        }

        switch (advDis) {
            case ADVANTAGE:
                System.out.println("That was close, you could have rolled a " + min + "!");
                newValues.add(max);
                break;
            case DISADVANTAGE:
                System.out.println("If you were better you'd have got a " + max + "!");
                newValues.add(min);
                break;
        }
        rolledValues = newValues;
    }

    @Override
    public int roll() {
        this.rollDice();
        this.applyClassFeature(null);
        this.applyAdvDis();

        return totalRolledValues() + CharLookup.lookupAbilityMod(abilityType) + additionalModifier;
    }


}

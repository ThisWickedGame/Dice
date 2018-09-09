package game.wicked.athis.dice.Events;

import game.wicked.athis.dice.enums.Ability;
import game.wicked.athis.dice.utils.CharLookup;
import game.wicked.athis.dice.enums.DamageType;
import game.wicked.athis.dice.enums.DiceType;

public class DamageEvent extends RollingEvent {
    private DamageType damageType;
    private Ability damageAbility;
    private int damageModifier;

    public DamageEvent(DiceType diceType, int diceCount, Ability damageAbility, int damageModifier,
                       DamageType damageType) {
        this.diceType = diceType;
        this.diceCount = diceCount;
        this.damageAbility = damageAbility;
        this.damageModifier = damageModifier;
        this.damageType = damageType;
    }

    @Override
    public int roll() {
        this.rollDice();
        this.applyClassFeature(null);

        return totalRolledValues() + CharLookup.lookupAbilityMod(damageAbility) + damageModifier;
    }
}

package game.wicked.athis.dice.Events;

import game.wicked.athis.dice.enums.DamageType;

public class RollResult {
    int diceRoll;
    int abilityCheck;
    int avoidedDiceRoll;
    boolean advDis;
    DamageType damageType;
    RollResult additionalRoll;

    public RollResult(int diceRoll, int abilityCheck, int avoidedDiceRoll, boolean advDis, DamageType damageType,
                      RollResult additionalRoll) {
        this.diceRoll = diceRoll;
        this.abilityCheck = abilityCheck;
        this.avoidedDiceRoll = avoidedDiceRoll;
        this.advDis = advDis;
        this.damageType = damageType;
        this.additionalRoll = additionalRoll;
    }
}

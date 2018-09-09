package game.wicked.athis.dice.enums;

public enum DiceType {
    d2(2),
    d4(4),
    d6(6),
    d8(8),
    d10(10),
    d12(12),
    d20(20),
    d100(100);

    private int numVal;

    DiceType(int numVal) {
        this.numVal = numVal;
    }

    public int getDiceValue() {
        return numVal;
    }
}

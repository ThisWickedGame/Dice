package game.wicked.athis.dice.enums;

public enum Ability {
    STRENGTH("STR"),
    DEXTERITY("DEX"),
    CONSTITUTION("CON"),
    INTELLIGENCE("INT"),
    WISDOM("WIS"),
    CHARISMA("CHA");

    private String abilityName;

    Ability(String abilityName) {
        this.abilityName = abilityName;
    }

    public String getAbilityName() {
        return abilityName;
    }
}

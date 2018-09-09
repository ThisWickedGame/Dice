package game.wicked.athis.dice.utils;

public class StringCleaner {

    public static String youRolledA(int rolledValue) {
        final String prefix = "You rolled a";
        String rolledString = String.valueOf(rolledValue);
        String additional = (rolledString.charAt(0)=='8') ? "n " : " ";

        return prefix + additional + String.valueOf(rolledValue);
    }
}

package Converter;

import java.util.HashMap;
import java.util.Map;
public class MorseConverter {
    // Datastruktur Hashmap för att mappa för översättning mellan engelska bokstäver och morsekod
    private static final Map<Character, String> letterToMorse = new HashMap<>();
    private static final Map<String, Character> morseToLetter = new HashMap<>();

    static {
        letterToMorse.put('E', "*");
        letterToMorse.put('W', "*--");

        morseToLetter.put("*", 'E');
        morseToLetter.put("*--", 'W');
    }

    // Översätter engelsk text till morsekod
    public static String toMorse(String text) {
        if (containsMultipleSpaces(text)) {
            throw new IllegalArgumentException("Try again! Your text contains multiple spaces.");
        }
        StringBuilder morseCode = new StringBuilder();
        for (char letterCharacter : text.toUpperCase().toCharArray()) {
            String morse = letterToMorse.get(letterCharacter);
            if (morse == null) {
                throw new IllegalArgumentException("You've entered the wrong character: " + letterCharacter);
            }
            morseCode.append(morse).append(" ");
        }
        return morseCode.toString().trim();
    }
    // Översätter morsekod till engelsk text
    public static String fromMorse(String code) {
        if (containsMultipleSpaces(code)) {
            throw new IllegalArgumentException("Try again! Your morse code contains multiple spaces.");
        }
        StringBuilder englishText = new StringBuilder();
        for (String morseCharacter : code.trim().split(" ")) {
            Character letterChar = morseToLetter.get(morseCharacter);
            if (letterChar == null) {
                throw new IllegalArgumentException("You've entered the wrong character: " + morseCharacter);
            }
            englishText.append(letterChar);
        }
        return englishText.toString();
    }
    // Extra metod för fler än två mellanslag i följd
    private static boolean containsMultipleSpaces(String str) {
        return str.contains("  ");
    }
}
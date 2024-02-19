package Converter;

import java.util.HashMap;
import java.util.Map;
public class MorseConverter {
    // mappning för översättning mellan engelska bokstäver och morsekod
    private static final Map<Character, String> letterToMorse = new HashMap<>();
    private static final Map<String, Character> morseToLetter = new HashMap<>();

    static {
        letterToMorse.put('E', "*");
        letterToMorse.put('W', "*--");

        morseToLetter.put("*", 'E');
        morseToLetter.put("*--", 'W');
    }

    // För översättning av engelsk bokstav till morsekod
    public static String toMorse(String letter) {
        if (containsMultipleSpaces(letter)) {
            throw new IllegalArgumentException("Try again! Your text contains multiple spaces.");
        }

        StringBuilder morseCode = new StringBuilder();
        for (char letterCharacter : letter.toUpperCase().toCharArray()) {
            String morse = letterToMorse.get(letterCharacter);
            if (morse == null) {
                throw new IllegalArgumentException("You've entered the wrong character: " + letterCharacter);
            }
            morseCode.append(morse).append(" ");
        }
        return morseCode.toString().trim();
    }

    //För översättning av morsekod till engelsk bokstav
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

    //mellanslagskontroll för flera mellanslag
    private static boolean containsMultipleSpaces(String str) {
        return str.contains("  ");
    }
}
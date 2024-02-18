package Converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your text for translation in English or Morse:");
        String input = scan.nextLine();

        try {
            if (input.trim().isEmpty()) {
                throw new IllegalArgumentException("Empty input! Please enter valid input");
            }
            boolean isMCode = input.contains("*") || input.contains("-");
            if (isMCode) {
                String translatedText = MorseConverter.fromMorse(input);
                System.out.println("Translation to English letters: " + translatedText);
            } else {
                String morseCode = MorseConverter.toMorse(input);
                System.out.println("Translation to Morse Code: " + morseCode);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
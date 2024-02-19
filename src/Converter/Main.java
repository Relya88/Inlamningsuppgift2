package Converter;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //En evighetsloop som forsätter programmet till man stänger
        while (true) {
            System.out.println("Enter translation letter in English or Morse code:");
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("close"))
                break;

            try {
                if (input.trim().isBlank()) {
                    throw new IllegalArgumentException("Empty input!Please enter valid input");
                }
                boolean isMCode = input.contains("*") || input.contains("-");
                if (isMCode) {
                    String translatedText = MorseConverter.fromMorse(input);
                    System.out.println("Translation to English letters: " + translatedText);
                    System.out.println();
                } else {
                    String morseCode = MorseConverter.toMorse(input);
                    System.out.println("Translation to Morse Code: " + morseCode);
                    System.out.println();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
                System.out.println();
            }
        }
    }
}
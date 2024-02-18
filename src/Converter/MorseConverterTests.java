package Converter;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MorseConverterTests {

    // Testar översättning från engelska bokstäver till morsekod
    @Test
    public void testingLettersToMorse() {
        String testdata = "WE";
        String expected = "*-- *";
        String actual = MorseConverter.toMorse(testdata);
        Assertions.assertEquals(expected, actual);
    }
    // Testar översättning från morsekod till engelska bokstäver
    @Test
    public void testingMorseToLetters() {
        String testdata = "*-- *";
        String expected = "WE";
        String actual = MorseConverter.fromMorse(testdata);
        Assertions.assertEquals(expected, actual);
    }
    // Testar hantering av ogiltiga tecken
    @Test
    public void testingWithInvalidCharacters() {
        String testdata = "% # ¤";
        Assertions.assertThrows(IllegalArgumentException.class, () -> MorseConverter.toMorse(testdata));
    }
    // Testar hantering av extra mellanslag i input
    @Test
    public void testingWithMultiSpace() {
        String testdata = "  ";
        Assertions.assertThrows(IllegalArgumentException.class, () -> MorseConverter.fromMorse(testdata));
    }
}

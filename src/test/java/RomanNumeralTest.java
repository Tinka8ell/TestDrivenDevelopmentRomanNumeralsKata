import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {

    @ParameterizedTest
    // Arrange
    @CsvSource({
            "4, IV",
            "5, V",
            "6, VI",
            "8, VIII",
            "9, IX",
            "10, X",
            "49, XLIX",
            "50, L",
            "1888, MDCCCLXXXVIII" })
    void checkValidToRoman(int natural, String expected) {
        // Act, Assert
        assertEquals(expected, RomanNumeral.toRoman(natural));
    }

    @Test
    void checkInvalidToRoman() {
        // Arrange
        Executable zero = () -> RomanNumeral.toRoman(0);
        Executable negative = () -> RomanNumeral.toRoman(-99);
        Executable tooBig = () -> RomanNumeral.toRoman(4000);

        // Act, Assert
        assertThrowsExactly(NumberFormatException.class, zero, "Check zero is invalid");
        assertThrowsExactly(NumberFormatException.class, negative, "Check zero is invalid");
        assertThrowsExactly(NumberFormatException.class, tooBig, "Check zero is invalid");
    }

    @ParameterizedTest
    // Arrange
    @CsvSource({
            "1959, MCMLIX",
            "2022, MMXXII" })
    void checkGoodMiddleToRoman(int natural, String expected) {
        // Act, Assert
        assertEquals(expected, RomanNumeral.toRoman(natural));
    }

    @ParameterizedTest
    // Arrange
    @CsvSource({
            "1, I",
            "2, II",
            "3, III",
            "4, IV",
            "5, V",
            "6, VI",
            "7, VII",
            "8, VIII",
            "9, IX" })
    void checkOnesToNatural(int expected, String roman) {
        // Act, Assert
        assertEquals(expected, RomanNumeral.toNatural(roman));
    }

    @ParameterizedTest
    // Arrange
    @CsvSource({
            "4, IV",
            "5, V",
            "6, VI",
            "8, VIII",
            "9, IX",
            "10, X",
            "49, XLIX",
            "50, L",
            "1888, MDCCCLXXXVIII" })
    @Disabled
    void checkValidToNatural(int expected, String roman) {
        // Act, Assert
        assertEquals(expected, RomanNumeral.toNatural(roman));
    }

    @Test
    void checkInvalidToNatural() {
        // Arrange
        Executable empty = () -> RomanNumeral.toNatural("");
        Executable isNull = () -> RomanNumeral.toNatural(null);

        // Act, Assert
        assertThrowsExactly(NumberFormatException.class, empty, "Check empty String is invalid");
        assertThrowsExactly(NumberFormatException.class, isNull, "Check null is invalid");
    }

    @ParameterizedTest
    // Arrange
    @CsvSource({
            "1959, MCMLIX",
            "2022, MMXXII" })
    @Disabled
    void checkGoodMiddleToNautal(int expected, String roman) {
        // Act, Assert
        assertEquals(expected, RomanNumeral.toNatural(roman));
    }

}
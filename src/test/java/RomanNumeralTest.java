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
            "10, X",
            "20, XX",
            "30, XXX",
            "40, XL",
            "50, L",
            "60, LX",
            "70, LXX",
            "80, LXXX",
            "90, XC" })
    void checkTensToNatural(int expected, String roman) {
        // Act, Assert
        assertEquals(expected, RomanNumeral.toNatural(roman));
    }

    @ParameterizedTest
    // Arrange
    @CsvSource({
            "100, C",
            "200, CC",
            "300, CCC",
            "400, CD",
            "500, D",
            "600, DC",
            "700, DCC",
            "800, DCCC",
            "900, CM" })
    void checkHundredsToNatural(int expected, String roman) {
        // Act, Assert
        assertEquals(expected, RomanNumeral.toNatural(roman));
    }

    @ParameterizedTest
    // Arrange
    @CsvSource({
            "1000, M",
            "2000, MM",
            "3000, MMM" })
    void checkThousandsToNatural(int expected, String roman) {
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
        Executable illegal = () -> RomanNumeral.toNatural("Z");
        Executable doubleV = () -> RomanNumeral.toNatural("VV");
        Executable lower = () -> RomanNumeral.toNatural("v");

        // Act, Assert
        assertThrowsExactly(NumberFormatException.class, empty, "Check empty String is invalid");
        assertThrowsExactly(NumberFormatException.class, isNull, "Check null is invalid");
        assertThrowsExactly(NumberFormatException.class, illegal, "Check String has illegal character");
        assertThrowsExactly(NumberFormatException.class, doubleV, "Check can't have two V's");
        assertThrowsExactly(NumberFormatException.class, lower, "Check not allow lowercase");
    }

    @ParameterizedTest
    // Arrange
    @CsvSource({
            "1959, MCMLIX",
            "2022, MMXXII" })
    void checkGoodMiddleToNatural(int expected, String roman) {
        // Act, Assert
        assertEquals(expected, RomanNumeral.toNatural(roman));
    }

}
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumeral {

    /**
     * Convert a Roman Numeral String into a natural number.
     *
     * @param roman a String of valid roman numberals
     * @return natural number represented by roman as an int
     */
    public static int toNatural(String roman){
        // validation of input
        if (roman == null)
            throw new NumberFormatException("Your roman number must contain something!");
        roman = roman.trim();
        if (roman.isEmpty())
            throw new NumberFormatException("Your roman number must contain something!");
        Pattern numerals = Pattern.compile("^(IX|IV|V{0,1}I{0,3})");
        Matcher matcher = numerals.matcher(roman);
        if (!matcher.find())
            throw new NumberFormatException("Your roman number contains illegal characters or badly formatted ones");
        String ones = matcher.group(1);
        if (matcher.end(1) < roman.length())
            throw new NumberFormatException("Your roman number contains illegal characters or badly formatted ones");
        if (ones.isEmpty())
            throw new NumberFormatException("Your roman number contains illegal characters or badly formatted ones");
        return translateValue(ones, "IV", "IX", 'V');
    }

    private static int translateValue(String ones, String four, String nine, char five) {
        int value;
        if (ones.equals(four))
            value = 4;
        else if (ones.equals(nine))
            value = 9;
        else if (ones.charAt(0) == five)
            value = 5 + ones.length() - 1;
        else
            value = ones.length();
        return value;
    }


    /**
     * Convert a natural number into Roman Numeral format.
     *
     * @param natural int from 1 to 3999 inclusive
     * @return String of roman numerals
     */
    public static String toRoman(int natural){
        if (natural < 1 || natural >= 4000)
            throw new NumberFormatException("For Roman Numerals the natural number must be between 1 and 3999");
        int ones = natural % 10;
        natural /= 10;
        int tens = natural % 10;
        natural /= 10;
        int hundreds = natural % 10;
        int thousands = natural / 10;

        return getRomanDigit(thousands, "M", null, null) +
                getRomanDigit(hundreds, "C", "D", "M") +
                getRomanDigit(tens, "X", "L", "C") +
                getRomanDigit(ones, "I", "V", "X");
    }

    /**
     * Utility function to format one digit with given roman numerals
     *
     * @param digit int (1 - 9) to format
     * @param one Sting representing a "one" at this ordinal
     * @param five Sting representing a "five" at this ordinal
     * @param ten Sting representing a "ten" at this ordinal
     * @return String as formatted "digit" as roman numerals
     */
    private static String getRomanDigit(int digit, String one, String five, String ten) {
        String digits;
        switch (digit){
            case 4 -> digits = one + five;
            case 9 -> digits = one + ten;
            default -> {
                if (digit < 5)
                    digits = one.repeat(digit);
                else
                    digits = five + one.repeat(digit - 5);
            }
        }
        return digits;
    }
}

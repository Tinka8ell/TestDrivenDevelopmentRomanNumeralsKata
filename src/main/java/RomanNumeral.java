public class RomanNumeral {

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

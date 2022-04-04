# Test-Driven Development - Roman Numerals Kata

## Setup
As per [the instructions](src/docs/Exercise.md), copied from the exercise spec: 
* created project 
* connected to GitHub
* put as much doc into this, so I know what I was doing
* Added copy of the [Code Dojo page](src/docs/CodingDojo.md)

## Part 1 - write a function to convert from natural numbers to Roman Numerals

### Design Decisions:

* Class will be [RomanNumeral](src/main/java/RomanNumeral.java)
* Test class will be [RomanNumeralText](src/test/java/RomanNumeralTest.java)
* Required function will be: public String toRoman(int natural)
* Valid input range: 1 - 4000 (excluding upper bound) or out put from I to MMMCMXCIX
* Add edge case tests, a good middle (1959 and 2022) and some change over tests 4, 5, 6, 8, 9, 10, 49, 50, 
and 1888 (MDCCCLXXXVIII)
* Part One completed

## Part 2 - write a function to convert from Roman Numerals to natural numbers

### Design Decisions:

* Same class [RomanNumeral](src/main/java/RomanNumeral.java)
and test class [RomanNumeralText](src/test/java/RomanNumeralTest.java) will be used
* Required function will be: public int toNatural(String roman)
* Start with digits I - IX
* tater can add reversed tests from part 1, a good middle (1959 and 2022) and some change over tests 4, 5, 6, 8, 9, 10, 49, 50,
  and 1888 (MDCCCLXXXVIII)

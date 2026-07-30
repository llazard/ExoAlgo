package main;

public class RomanNumeral {
    void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        System.out.println(toRoman(number));
    }

    // Tables de correspondance valeur -> symbole, du plus grand au plus
    // petit, y compris les formes soustractives (IV, IX, XL...). On
    // accumule les symboles en retirant à chaque fois la plus grande valeur
    // possible du nombre restant, jusqu'à atteindre 0.
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String toRoman(int number) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < VALUES.length; i++) {
            while (number >= VALUES[i]) {
                result.append(SYMBOLS[i]);
                number -= VALUES[i];
            }
        }

        return result.toString();
    }
}

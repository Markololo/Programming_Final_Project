package org.example.util;


public class Util {

    /**
     * makes a string to title case, we can assume the string is made up of max. 2 words
     * @param strIn input string
     * @return the inputed string in title case
     */
    public static  String toTitleCase(String strIn) {
        if (strIn == null || strIn.isEmpty()) {
            return strIn;
        }

        int spaceIndex = strIn.indexOf(' ');

        if (spaceIndex == -1) {
            // Single word case
            return strIn.substring(0, 1).toUpperCase() + strIn.substring(1).toLowerCase();
        } else {
            // Two-word case
            String word1 = strIn.substring(0, spaceIndex);
            String word2 = strIn.substring(spaceIndex + 1);

            word1 = word1.substring(0, 1).toUpperCase() + word1.substring(1).toLowerCase();
            word2 = word2.substring(0, 1).toUpperCase() + word2.substring(1).toLowerCase();

            return word1 + " " + word2;
        }
    }
}

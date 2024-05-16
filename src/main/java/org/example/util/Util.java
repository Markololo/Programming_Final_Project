package org.example.util;


public class Util {

    public static  String toTitleCase(String strIn) {
        strIn.toLowerCase();
        String strOut = "";
        int numOfSpaces = 0;

        for (int i = 0; i < strIn.length(); i++) {
            char c = strIn.charAt(i);
            if (strIn.contains(" ")) {
                numOfSpaces++;
            }
        }

        String[] arrOfStr = strIn.split(" ", numOfSpaces);

        for (String a : arrOfStr) {
            (a.charAt(0) + " ").toUpperCase();
            a += strOut + " ";
        }

        return strOut;
    }
}

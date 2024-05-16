package org.example;

public class Main {
    // DO NOT FORGET DOCUMENTATIONS
    public static void main(String[] args) {
        toTitleCase1("HI there");
    }
    public static  String toTitleCase1(String strIn) {
        strIn.toLowerCase();
        String strOut = "";
        int numOfSpaces = 0;

        for (int i = 0; i < strIn.length(); i++) {
            char c = strIn.charAt(i);
            if (c == ' ') {
                numOfSpaces++;
            }
        }

        String[] arrOfStr = strIn.split(" ", numOfSpaces);

        for (String a : arrOfStr) {
            (a.charAt(0) + " ").toUpperCase();
            strOut += a;
        }

        return "strOut";
    }
}
package org.example;

public class Main {
    // DO NOT FORGET DOCUMENTATIONS
    public static void main(String[] args) {
        System.out.printf("C-name-" + String.format("%03d", (int)(Math.random() * 1000)));
    }
//    public static String toTitleCase(String strIn) {
//        strIn.toLowerCase();
//        String strOut = "";
//        int spaceIdx = strIn.indexOf(' ');
//
//        (strIn.charAt(0) + "").toUpperCase();
//        (strIn.charAt(spaceIdx + 1) + "").toUpperCase();
//
//        return strIn;
//    }
}
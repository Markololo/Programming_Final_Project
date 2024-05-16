package org.example;

public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode.length() == 6) {

        } else if (postalCode.length() == 7) {

        }

        for (int i = 0; i < postalCode.length(); i++) {
            char c = postalCode.charAt(i);

        }
        return false;
    }
}

/*
a postal code can either be 6 or 7,
if the length is 6, then it must follow the format: CDCDCD,
if the length is 7, then it must follow the format: CDC DCD.
where C is a character, while D is a digit. Case-insensitive;
Note: this method is a static method, which means it requires a parameter of postalCode instead of using the field
postalCode, the reason of this is that this method should be called in the constructor, before assigning the input
postalCode to the field postalCode, only valid postalCode will be assigned to fields, or null will be assigned
 */

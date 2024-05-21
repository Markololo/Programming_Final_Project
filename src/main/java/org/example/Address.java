package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public static boolean isPostalCodeValid(String postalCode) {
        boolean isValid = false;

        if (postalCode.length() == 7) {
            for (int i = 0; i < postalCode.length(); i++) {
                char c = postalCode.charAt(i);
                isValid = switch (c) {
                    case 0, 2, 5 -> Character.isAlphabetic(c);
                    case 1, 4, 6 -> Character.isDigit(c);
                    default -> Character.isSpaceChar(c);
                };
                if (!isValid) {
                    return false;
                }
            }
            return true;
        } else if (postalCode.length() == 6) {
            for (int i = 0; i < postalCode.length(); i++) {
                char c = postalCode.charAt(i);
                isValid = switch (c) {
                    case 0, 2, 4 -> Character.isAlphabetic(c);
                    default -> Character.isDigit(c);
                };
                if (!isValid) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
            this.country = country;
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
            this.country = null;
        }

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

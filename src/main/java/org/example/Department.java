package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId;

    public static boolean validateDepartmentName(String departmentName) {
        boolean isValid;

        for (int i = 0; i < departmentName.length(); i++) {
            char c = departmentName.charAt(i);
            isValid = Character.isAlphabetic(c) || Character.isSpaceChar(c);
            if (!isValid) {
                return false;
            }
        }
        return true;
    }
    public Department(String departmentId, String departmentName) {
        if (validateDepartmentName(departmentName)){
            this.departmentId = departmentId;
            this.departmentName = departmentName;
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }
}

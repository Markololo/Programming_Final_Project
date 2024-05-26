package org.example;

public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    public static boolean validateDepartmentName(String departmentName) {
        boolean isValid;

        for (int i = 0; i < departmentName.length(); i++) {
            char c = departmentName.charAt(i);

        }
        return true;
    }
}
/*
static boolean validateDepartmentName(String departmentName) // checks if a department name is valid or not, a department name should only contain letters or space
Constructor // if the departmentName is invalid, create the object with everything as null;
toString
equals
getter
setter
 */
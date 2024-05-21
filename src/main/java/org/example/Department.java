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

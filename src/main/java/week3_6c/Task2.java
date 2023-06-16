package week3_6c;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please be aware of that our company has following departments: sales, operations, IT, customer support and retail.");
        System.out.println("Please enter necessary department:");
        String dep = scan.nextLine().toLowerCase();
        departmentSelection(dep);
    }

    public static String departmentSelection(String department) {

        switch (department) {
            case "sales":
                System.out.println(department + " department works from 8am to 8pm.");
                break;
            case "operations":
                System.out.println(department + " department works from 9am to 6pm.");
                break;
            case "it":
                System.out.println(department + " department works from 10am to 7pm.");
                break;
            case "customer support":
                System.out.println(department + " support department works from 7am to 7pm.");
                break;
            case "retail":
                System.out.println(department + " department works from 9am to 5pm.");
                break;
            default:
                System.out.println("We do not have such department, please check list above.");

        }
        return department;
    }

}

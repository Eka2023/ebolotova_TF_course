package week3_6c;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your salary:");
        Double salary = Double.valueOf(scan.nextInt());
        taxSelection(salary);

    }

    public static double taxSelection(Double value) {

        if (value > 0 && value <= 10275) {
            System.out.println("your tax will be 10%");
        } else if (value >= 10276 && value <= 41775) {
            System.out.println("your tax will be 12%");
        } else if (value >= 41776 && value <= 89075) {
            System.out.println("your tax will be 22%");
        } else {
            System.out.println("please call your CPA");
        }
        return value;

    }
}

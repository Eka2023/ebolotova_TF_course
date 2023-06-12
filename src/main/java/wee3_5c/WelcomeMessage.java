package wee3_5c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WelcomeMessage {

    public static void main(String[] args) throws IOException {
        welcomeMessage();
    }

    public static void welcomeMessage() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Please tape a username: ");
        String username = reader.readLine();
        System.out.println("Please tape your age: ");
        int age = Integer.parseInt(reader.readLine());
        System.out.println("Please tape your city: ");
        String location = reader.readLine();
        double price = 7.99;

        System.out.println("Dear " + username + "! Welcome to the book store ‘Ozone.com’. " +
                "Our data indicates that today you are turn " + age + " years old. " +
                "We offer you a special gift! With purchase on any book above $" + price + ", " +
                "you will get 1 additional " + productSelection(age, location) + " for free.");

    }

    public static String productSelection(int age, String location) {
        String productName = "";
        if (location.equals("New-York") && age > 0 && age < 15) {
            productName = "journal";
        } else if (location.equals("New-York") && age > 60) {
            productName = "audio-book";
        } else
            productName = "book";

        return productName;
    }

}

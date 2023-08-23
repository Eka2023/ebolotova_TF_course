package testcases;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PalindromeTest {

    @Test
    public void reverseString() {
        String word = "Congratulation";
        List<String> wList = Arrays.asList(word.split(""));

        Collections.reverse(wList);
        System.out.println("Reversed ArrayList: " + wList);
    }


    public void palindromeString(String word1, String word2) {
        List<String> wList = Arrays.asList(word1.split(""));
        List<String> wList2 = Arrays.asList(word2.split(""));
        Collections.reverse(wList2);
        System.out.println("wList: "+wList);
        System.out.println("wCopyList: "+wList2);
        System.out.println("-----------");
        if (wList.equals(wList2)) {
            System.out.println("This words are palindrome");
        } else
            System.out.println("This words: " + word1 + " and " + word2 + " are NOT palindrome");
    }

    @Test
    public void checkPalindrome(){
        System.out.println("-----1----");
        palindromeString("Congratulation", "Limone");
        System.out.println("-----2----");
        palindromeString("Congratulation", "noitalutargnoC");
        System.out.println("-----3----");
        palindromeString("enommiL", "Limone");
    }

}

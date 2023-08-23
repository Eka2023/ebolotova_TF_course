package testcases;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnagramTest {

    @Test
    public void anargamString() {
        String word = "Congratulation";
        List<String> wList = Arrays.asList(word.toLowerCase().split(""));

        Collections.sort(wList);
        System.out.println("Reversed ArrayList: " + wList);
    }


    public void anagramString(String word1, String word2) {
        List<String> wList = Arrays.asList(word1.split(""));
        List<String> wList2 = Arrays.asList(word2.split(""));
        Collections.sort(wList);
        Collections.sort(wList2);
        System.out.println("wList: "+wList);
        System.out.println("wList2: "+wList2);
        System.out.println("-----------");
        if (wList.equals(wList2)) {
            System.out.println("This words are anagram");
        } else
            System.out.println("This words: " + word1 + " and " + word2 + " are NOT anagram");
    }

    @Test
    public void checkAnagram(){
        System.out.println("-----1----");
        anagramString("Congratulation", "noitalurtagnoC");
        System.out.println("-----2----");
        anagramString("Congratulation", "noitalutargnoC");
        System.out.println("-----3----");
        anagramString("enommiL", "Limone");
    }

}

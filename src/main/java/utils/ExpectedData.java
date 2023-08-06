package utils;

import java.util.Arrays;
import java.util.List;

public class ExpectedData {
    public static final List<String> expectedAllJobsList = Arrays.asList("Junior level Developer", "Middle level Developer", "Senior level Developer", "Leading Developer", "QA Analyst, Software Tester", "QA Engineer", "Senior QA Engineer", "Automation QA Engineer", "Test Lead", "Automation Test Lead", "Business Analyst", "Senior Business Analyst", "Designer");
    public static final List<String> expectedDevList = Arrays.asList("Junior level Developer", "Middle level Developer", "Senior level Developer", "Leading Developer");
    public static final List<String> expectedQaList = Arrays.asList("QA Analyst, Software Tester", "QA Engineer", "Senior QA Engineer", "Automation QA Engineer", "Test Lead", "Automation Test Lead");
    public static final List<String> expectedAnalystList = Arrays.asList("QA Analyst, Software Tester", "Business Analyst", "Senior Business Analyst");
    public static final List<String> expectedBusinessAnalystList = Arrays.asList("Business Analyst", "Senior Business Analyst");

    public static final List<String> expectedActiveLinksOnHomePage = Arrays.asList(
            "https://test.my-fork.com/",
            "https://test.my-fork.com/quizzes-list",
            "https://test.my-fork.com/login",
            "https://test.my-fork.com/register",
            "https://test.my-fork.com/share-question",
            "https://test.my-fork.com/register"
    );

    public static final List<String> expectedActiveLinksOnSignInPage = Arrays.asList(
            "https://test.my-fork.com/",
            "https://test.my-fork.com/register",
            "https://test.my-fork.com/password/reset",
            "https://test.my-fork.com/login#",
            "https://test.my-fork.com/login#"
    );

}

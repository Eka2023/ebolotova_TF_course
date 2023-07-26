package utils;

import java.util.Arrays;
import java.util.List;

public class ExpectedData {


    public List<String> expectedJobTitleList() {
        List<String> expectedList = Arrays.asList("Junior level Developer", "Middle level Developer", "Senior level Developer", "Leading Developer", "QA Analyst, Software Tester", "QA Engineer", "Senior QA Engineer", "Automation QA Engineer", "Test Lead", "Automation Test Lead", "Business Analyst", "Senior Business Analyst", "Designer");
        return expectedList;
    }

    public List<String> expectedDevJobTitleList() {
        List<String> expectedList = Arrays.asList("Junior level Developer", "Middle level Developer", "Senior level Developer", "Leading Developer");
        return expectedList;
    }

    public List<String> expectedQAJobTitleList() {
        List<String> expectedList = Arrays.asList("QA Analyst, Software Tester", "QA Engineer", "Senior QA Engineer", "Automation QA Engineer", "Test Lead", "Automation Test Lead");
        return expectedList;
    }

    public List<String> expectedAnalystJobTitleList() {
        List<String> expectedList = Arrays.asList("QA Analyst, Software Tester", "Business Analyst", "Senior Business Analyst");
        return expectedList;
    }

    public List<String> expectedBAJobTitleList() {
        List<String> expectedList = Arrays.asList("Business Analyst", "Senior Business Analyst");
        return expectedList;
    }


}

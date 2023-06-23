package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignUpPage extends BaseMain {

    public SignUpPage(WebDriver dr) {
        super(dr);
    }

    By jobTitleList = By.id("job-title");
    By jobTitle = By.xpath("//select[@id='job-title']//option");

    public List<String> getJobTitleList() {
        WebElement dropDownElement = driver.findElement(jobTitleList);
        Select searchDropDown = new Select(dropDownElement);
        List<WebElement> list = searchDropDown.getOptions();
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < list.size()-1; i++) {
            resultList.add(list.get(i).getText());
            //System.out.println(list.get(i).getText());
        }
        return resultList;
    }

    public List<String> getJobListWithPreferableTitle(String title) {
        List<String> allTitleList = getJobTitleList();
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < allTitleList.size(); i++) {
            String tmp = allTitleList.get(i);
            if (tmp.toLowerCase().contains(title.toLowerCase())) {
                resultList.add(tmp);
                System.out.println(tmp);
            }
        }

        return resultList;
    }

    public List<String> getJobListWithPreferableTitle(String title, String title1) {
        List<String> allTitleList = getJobTitleList();
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < allTitleList.size()-1; i++) {
            String tmp = allTitleList.get(i);
            if (tmp.toLowerCase().contains(title.toLowerCase())
                    || tmp.toLowerCase().contains(title1.toLowerCase())) {
                resultList.add(tmp);
            }
        }
        return resultList;
    }

    public List<String> getJobTitleListWithoutSeleniumSelect() {
        List<WebElement> elementsList = driver.findElements(jobTitle);
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < elementsList.size()-1; i++) {
            resultList.add(elementsList.get(i).getText());
            System.out.println(elementsList.get(i).getText());
        }
        return resultList;
    }

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

    public void assertActualAndExpectedList(List<String> actual, List<String> expected) {
        Assert.assertEquals(expected,actual);
    }
}
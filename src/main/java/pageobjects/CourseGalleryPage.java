package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CourseGalleryPage extends BaseMain {

    By theFirstCourseName = By.xpath("//span[contains(text(), 'SQL 101 (Basics)')]");
    By historyBtn = By.xpath("//a[contains(text(), 'History')]");
    By expertiseList = By.xpath("//div[@class='expertise-areas-list']/div");

    public CourseGalleryPage(WebDriver dr) {
        super(dr);
    }

    public List<String> getExpertiseList() {
        List<WebElement> webElementsList = driver.findElements(expertiseList);
        List<String> expertiseListByName = new ArrayList<>();
        for (WebElement el : webElementsList) {
            expertiseListByName.add(el.getText());

        }
        System.out.println(expertiseListByName.toString());
        return expertiseListByName;
    }

    public String getNumOfQuestionsInStringFormat(String expertiseName, String courseName) {
        By numOfQuestions = By.xpath("//span[contains(text(),'" + courseName + "')]/ancestor::div[@data-expertise-name= '" + expertiseName + "']//div[@class='quiz-item-questions-count']");
        return driver.findElement(numOfQuestions).getText().toString();
    }

    public void clickStartBtnInCourse(String expertiseName, String courseName) {
        driver.findElement(By.xpath("//span[contains(text(),'" + courseName + "')]/ancestor::div[@data-expertise-name= '" + expertiseName + "']//div[contains(text(), 'Start')]")).click();

    }

//
}

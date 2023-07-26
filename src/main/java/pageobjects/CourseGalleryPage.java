package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println(expertiseListByName);
        return expertiseListByName;
    }

    public Integer getNumOfQuestions(String expertiseName, String courseName) {
        By numOfQuestions = By.xpath("//span[contains(text(),'" + courseName + "')]/ancestor::div[@data-expertise-name= '" + expertiseName + "']//div[@class='quiz-item-questions-count']");
        String qstN = driver.findElement(numOfQuestions).getText();
        String amountOfQuestions = qstN.replaceAll("\\d+ \\/ ","");
        return Integer.valueOf(amountOfQuestions);
    }

    public void clickStartBtnInCourse(String expertiseName, String courseName) {
        driver.findElement(By.xpath("//span[contains(text(),'" + courseName + "')]/ancestor::div[@data-expertise-name= '" + expertiseName + "']//div[contains(text(), 'Start')]")).click();

    }

    public void checkThatCoursePageIsLoaded(){
        checkIfElementIsDisplayedOrNot(getTheFirstCourseName(), true);
    }

    public void checkThatHistoryButtonIsNotPresented(){
        checkElementIsNotPresent(getHistoryBtn());
    }

    public void checkThatHistoryButtonIsPresented() {
        checkIfElementIsDisplayedOrNot(getHistoryBtn(), true);
    }

    public void checkExpertiseListIsCorrect(){
        assertActualAndExpectedList(
                expectedExpertiseList(),
                getExpertiseList());
    }

    public void checkNumberOfQuestionsForTheFirstCourse(){
        assertIfElementsAreEqual(getNumOfQuestions("Development", "SQL 101 (Basics)"),
                9);
    }

    public void clickBtnStartOnTheFirstCourse(){
        clickStartBtnInCourse("Development", "SQL 101 (Basics)");
    }

    public void clickBtnStartOnTheSecondCourse(){
        clickStartBtnInCourse("Development", "SQL 101 test");
    }

    public void checkNumberOfQuestionsForTheSecondCourse(){
        assertIfElementsAreEqual(getNumOfQuestions("Development", "SQL 101 test"),
                12);
    }




    //ExpectedData
    public List<String> expectedExpertiseList(){
        List<String> expectedList = Arrays.asList( "Development", "Testing", "Business Analyst", "Agile", "Project Management");
        return expectedList;

    }
}

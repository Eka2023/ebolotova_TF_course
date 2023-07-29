package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class CourseGalleryPage extends BaseMain {

    By coursePageTitle = By.xpath("//div[@class='quiz-section-title']");
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

    public Integer getNumOfQuestionsInCourse(String expertiseName, String courseName) {
        By numOfQuestions = By.xpath("//span[contains(text(),'" + courseName + "')]/ancestor::div[@data-expertise-name= '" + expertiseName + "']//div[@class='quiz-item-questions-count']");
        String qstN = driver.findElement(numOfQuestions).getText();
        String amountOfQuestions = qstN.replaceAll("\\d+ \\/ ", "");
        return Integer.valueOf(amountOfQuestions);
    }

    public void clickStartBtnInCourse(String expertiseName, String courseName) {
        driver.findElement(By.xpath("//span[contains(text(),'" + courseName + "')]/ancestor::div[@data-expertise-name= '" + expertiseName + "']//div[contains(text(), 'Start')]")).click();
    }

    public void clickExpertiseName(String expertiseName) {
        List<WebElement> list = driver.findElements(expertiseList);
        for (WebElement element : list) {
            if (expertiseName.equals(element.getText())) {
                element.click();
            }
        }
    }

    public void checkThatCoursePageIsLoaded() {
        checkElementIsDisplayed(getCoursePageTitle(), true);
    }

    public void checkThatHistoryButtonIsNotPresented() {
        Assert.assertTrue(checkElementIsNotPresent(getHistoryBtn()));
    }

    public void checkThatHistoryButtonIsNotPresentedViaList() {
        List<WebElement> list = driver.findElements(historyBtn);
        Assert.assertTrue(list.isEmpty());
    }

    public void checkThatHistoryButtonIsPresented() {
        checkElementIsDisplayed(getHistoryBtn(), true);
    }

    public void checkExpertiseListIsCorrect() {
        assertActualAndExpectedList(
                expectedExpertiseList(),
                getExpertiseList());
    }

    public void checkNumberOfQuestionsForACourse(String expertiseName, String courseName, double expectedQuantity) {
        assertIfElementsAreEqual(getNumOfQuestionsInCourse(expertiseName, courseName), expectedQuantity);
    }


    //ExpectedData
    public List<String> expectedExpertiseList() {
        List<String> expectedList = Arrays.asList("Development", "Testing", "Business Analyst", "Agile", "Project Management");
        return expectedList;

    }
}

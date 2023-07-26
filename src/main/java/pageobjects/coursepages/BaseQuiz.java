package pageobjects.coursepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.BaseMain;
import pageobjects.CourseGalleryPage;

import java.util.List;

public class BaseQuiz extends BaseMain {
    By questionN = By.xpath("//div[@class='quiz-process-question-block-title']/span");

    By qstAmount = By.xpath("//div[@class='quiz-process-questions-button ']");

    By answeredQstAmount = By.xpath("//div[@class='quiz-process-questions-button answered']");
    By nextBtn = By.xpath("//div[@class='quiz-process-navigations-block-button-next ']");
    By questionName = By.xpath("//div[@class='quiz-process-question-block-task']");
    By processProgressData = By.id("quiz-process-progress-data");

    public BaseQuiz(WebDriver dr) {
        super(dr);
    }

    public String getQuestionNumber() {
        return driver.findElement(questionN).getText();
    }

    public void checkThatWeGetQuestionNumberOne(){
        assertIfElementsAreEqual(getQuestionNumber(), "1");
    }

    public void checkThatWeGetQuestionNumberTwo(){
        assertIfElementsAreEqual(getQuestionNumber(), "1");
    }

    public int getAnsweredQuestionsAmount(){
        List<WebElement> list = driver.findElements(answeredQstAmount);
        System.out.println("answered questions"+list.size());
        return list.size();
    }

    public void questionNameIsDisplayed() {
        driver.findElement(questionName).isDisplayed();
    }

    public void clickToAnswer(int answerId) {
        driver.findElement(
                        By.xpath("//div[@class='quiz-process-question-block-answers-block-item ' and @data-answer-id='" + answerId + "']"))
                .click();
    }

    public WebElement getAnswer(int answerId) {
        return driver.findElement(
                        By.xpath("//div[@class='quiz-process-question-block-answers-block-item' and @data-answer-id='" + answerId + "']"));

    }

    public void clickToTheFirstAnswer() {
        getAnswer(0).click();
    }

    public double getProgressBarValue() {
        String pattern = "%";
        String value = driver.findElement(processProgressData).getText();
        double intValue = Integer.parseInt(value.replaceAll(pattern,""));
        return intValue;
    }

    public void verifyTheProgressBarValueForTheFirstCourse(){
        double totalQNum = galleryPage.getNumOfQuestions("Development", "SQL 101 (Basics)");
        double expectedValue = (getAnsweredQuestionsAmount()/totalQNum)*100;
        assertIfElementsAreEqual(getProgressBarValue(), expectedValue);
    }
    public void verifyTheProgressBarValueForTheSecondCourse(){
        double totalQNum = galleryPage.getNumOfQuestions("Development", "SQL 101 test");
        double expectedValue = (getAnsweredQuestionsAmount()/totalQNum)*100;
        assertIfElementsAreEqual(getProgressBarValue(), expectedValue);
    }

    public void clickNextBtn() {
        driver.findElement(nextBtn).click();
    }

}

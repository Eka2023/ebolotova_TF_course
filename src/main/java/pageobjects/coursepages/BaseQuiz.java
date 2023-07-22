package pageobjects.coursepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.BaseMain;

import java.util.regex.Pattern;

public class BaseQuiz extends BaseMain {

    By questionN = By.xpath("//div[@class='quiz-process-question-block-title']/span");
    //By progressBar = By.id("quiz-process-progress-progress-finish");
    By progressBar = By.xpath("//div[@class='quiz-process-progress-bar']//div[@id='quiz-process-progress-progress-finish']");
    By nextBtn = By.xpath("//div[@class='quiz-process-navigations-block-button-next ']");

    By questionName = By.xpath("//div[@class='quiz-process-question-block-task']");

    By processProgressData = By.id("quiz-process-progress-data");


    public BaseQuiz(WebDriver dr) {
        super(dr);
    }

    public String getQuestionNumber() {
        return driver.findElement(questionN).getText();
    }

    public void printQuestionName() {
        System.out.println(driver.findElement(questionName));
    }

    public void clickToAnswer(int answerId) {
        driver.findElement(
                        By.xpath("//div[@class='quiz-process-question-block-answers-block-item ' and @data-answer-id='" + answerId + "']"))
                .click();
    }

    public void clickToAnswerOtherPages(int answerId) {
        driver.findElement(
                        By.xpath("//div[@class='quiz-process-question-block-answers-block-item' and @data-answer-id='" + answerId + "']"))
                .click();
    }

    public int getProgressBarValue() {
        String pattern = "%";
        String value = driver.findElement(processProgressData).getText();
        int intValue = Integer.parseInt(value.replaceAll(pattern,""));
        return intValue;
    }

    public void clickNextBtn() {
        driver.findElement(nextBtn).click();
    }


}

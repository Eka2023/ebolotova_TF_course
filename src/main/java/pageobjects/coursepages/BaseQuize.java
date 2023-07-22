package pageobjects.coursepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.BaseMain;

public class BaseQuize extends BaseMain {

    By questionN = By.xpath("//div[@class='quiz-process-question-block-title']/span");
    //By progressBar = By.id("quiz-process-progress-progress-finish");
    By progressBar = By.xpath("//div[@class='quiz-process-progress-bar']//div[@id='quiz-process-progress-progress-finish']");
    By nextBtn = By.xpath("//div[@class='quiz-process-navigations-block-button-next']");

    By processProgressData = By.id("quiz-process-progress-data");

    public BaseQuize(WebDriver dr) {
        super(dr);
    }

    public String getQuestionNumber() {
        return driver.findElement(questionN).getText();
    }

    public void clickToAnswer(int answerId) {
        driver.findElement(
                        By.xpath("//div[@class='quiz-process-question-block-answers-block-item' and @data-answer-id=" + answerId + "]"))
                .click();
    }

    public int getProgressBarValue() {
        String styleValue = driver.findElement(processProgressData).getText();
        System.out.println(styleValue);
        int progressValue = Integer.parseInt(styleValue.substring(0, 2));
        return progressValue;
    }

    public void clickNextBtn() {
        driver.findElement(nextBtn).click();
    }


}

package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class SignUpPage extends BaseMain {

    public SignUpPage(WebDriver dr) {
        super(dr);
    }

    By jobTitleList = By.id("job-title");
    By jobTitle = By.xpath("//select[@id='job-title']//option");

    By otherInfoBlock = By.xpath("//div[contains(@class, 'other-info-block')]");

    public String getPageTitle() {
        return driver.getTitle();
    }

    public List<String> getJobTitleList() {
        WebElement dropDownElement = driver.findElement(jobTitleList);
        Select searchDropDown = new Select(dropDownElement);
        List<WebElement> list = searchDropDown.getOptions();
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < list.size()-1; i++) {
            resultList.add(list.get(i).getText());
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


}
package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class PlayersPage extends BaseMain {
    String newURL = "https://www.hltv.org/stats/players";
    By table = By.xpath("//table[@class='stats-table player-ratings-table']");
    By tableRows = By.xpath("//table[@class='stats-table player-ratings-table']//tbody/tr");
    By allowAllCookiies = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");

    //Value for particular cell in the table:
    //table[@class='stats-table player-ratings-table']//tbody/tr[1]/td[2]

    public PlayersPage(WebDriver dr, Logger log) {
        super(dr, log);
    }

    public void openPage(){
driver.get(newURL);
    }

    public void clickAgree(){
        driver.findElement(allowAllCookiies).click();
    }
    public int tableRowsCount() {
        return driver.findElements(tableRows).size();
    }

    public String columnOneValue(int row) {
        return driver.findElement(
                By.xpath("//table[@class='stats-table player-ratings-table']//tbody/tr[" + row + "]/td[1]/a")).getText();
    }

    public List<String> columnTwoValue(int row) {
        //table[@class='stats-table player-ratings-table']//tbody/tr[6]/td[2]//a/img[not(contains(@class, 'night-only'))]
        List<WebElement> elements = driver.findElements(By.xpath
                ("//table[@class='stats-table player-ratings-table']//tbody/tr["+row+"]/td[2]//a/img[not(contains(@class, 'night-only'))]"));
        List<String> teamNames = new ArrayList<>();

        for(WebElement element: elements){
            teamNames.add(element.getAttribute("alt"));
        }
        return teamNames;
    }

    public Map<String, List<String>> playersInfo() {
        Map<String, List<String>> info = new HashMap<>();
        for(int row=1; row<tableRowsCount();row++){
            info.put(columnOneValue(row), columnTwoValue(row));
            System.out.println();
        }
        return info;
    }

}

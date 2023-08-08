package testcases.outofbaseurl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class InterviewExample {
        public WebDriver driver;
        By article = By.xpath("//body/article");
        By articleParagraph = By.xpath("//body/article/p");
        By img = By.xpath("//body/article/p/img");

        @Test
        public void html(){
            String given = "<p> Click <a>href =\"https://www.goggle.com\"> </a> here </p>";
            String finalResult;
            finalResult = given.substring(4,given.indexOf("</p>"));//removing <p> tags
            //System.out.println(finalResult);
            finalResult = finalResult.substring(0,finalResult.indexOf("<a>")) + finalResult.substring(finalResult.indexOf("</a>")+5);
            //above we first cut out "Click" then cut out " here"
            //indexing works as follows: it detects provided piece and takes index of the first character, that's why we have finalResult.indexOf("</a>")+5
            System.out.println(finalResult);
            //code above will basically take any text around <a> and use it
            given = "Just another <a>href =\"https://www.goggle.com\"> </a> example to demonstrate";
            finalResult = given.substring(0,given.indexOf("<a>")) + given.substring(given.indexOf("</a>")+5);
            //replaced finalResult in substring to given because I don't remove <p> tag anymore
            System.out.println(finalResult);
        }

        public void pageTitleIsNovels() {
            Assert.assertEquals("Novels", driver.getTitle());
            Assert.assertEquals(1, getArticleAmountOnPage());
            Assert.assertEquals(2, getParagraphsInArticles());
            Assert.assertEquals(1,getImgAmountInTheFirstParagraph());
        }

        public int getArticleAmountOnPage(){
            List<WebElement> list = driver.findElements(article);
            int listSize = list.size();
            return listSize;
        }

        public int getParagraphsInArticles(){
            List<WebElement> list = driver.findElements(articleParagraph);
            int listSize = list.size();
            return listSize;
        }

        public int getImgAmountInTheFirstParagraph(){
            List<WebElement> list = driver.findElements(img);
            int listSize = list.size();
            return listSize;

        }

        public static String getLinkUrl(WebDriver driver, String linkDescription) {
            By linkList = By.xpath("//body/p/a");
            List<WebElement> list = driver.findElements(linkList);
            List<String> listWithLinks = new ArrayList();
            for(WebElement element: list){
                if(!linkDescription.isEmpty())
                    listWithLinks.add(element.getAttribute("href"));
            }
            return listWithLinks.get(0);
        }

}

package testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTests extends BaseTest {

    @BeforeMethod
    public void clickSingInButton(){
        homePage.clickSignUpBtn();
    }
    @Test(priority = 1, groups = {"high"})
    public void allJobTitleListTest() {
        dropDownTest(signUpPage.getJobTitle(), expectedAllJobsList);
    }

    @Test(priority = 4, groups = {"medium"})
    public void devJobTitleListTest() {
        dropDownTest(signUpPage.getJobListWithPreferableTitle("developer"), expectedDevList);
    }

    @Test(priority = 3, groups = {"medium"})
    public void qaJobTitleListTest() {
        dropDownTest(signUpPage.getJobListWithPreferableTitle("test", "QA"), expectedQaList);
    }

    @Test(priority = 6, groups = {"the lowest"})
    public void analystJobTitleListTest() {
        dropDownTest(signUpPage.getJobListWithPreferableTitle("analyst"), expectedAnalystList);
    }

    @Test(priority = 5, groups = {"low"})
    public void businessAnalystJobTitleListTest() {
        dropDownTest(signUpPage.getJobListWithPreferableTitle("business"), expectedBusinessAnalystList);
    }

    @Test(priority = 2, groups = {"high"})
    public void allJobTitleWithoutSeleniumSelectionTest() {
        dropDownTest(signUpPage.getJobTitleListWithoutSeleniumSelect(), expectedAllJobsList);
    }
    public void dropDownTest(List<String> actualList, List<String> expectedList) {
        //homePage.clickSignUpBtn();
        signUpPage.assertActualAndExpectedList(actualList, expectedList);
    }

}

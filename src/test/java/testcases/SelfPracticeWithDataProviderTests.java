package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SelfPracticeWithDataProviderTests extends BaseTest{

    @DataProvider(name = "CoursesNameDataProvider")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"Development", "SQL 101 (Basics)"},
                {"Development", "SQL 101 test"}
        };
    }

    @Test(dataProvider = "CoursesNameDataProvider")
    public void quizProgressBarFunctionalityTest1(String exp, String course) {
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.checkNumberOfQuestionsForTheFirstCourse();
        courseGalleryPage.clickBtnStartOnTheFirstCourse();
        switchToWindowFromTestBase(1);
        sql101BasicsPage.questionNameIsDisplayed();
        sql101BasicsPage.checkThatWeGetQuestionNumberOne();
        sql101BasicsPage.verifyTheProgressBarValueForACourse(exp, course);
        sql101BasicsPage.clickToTheFirstQuestionAnswer();
        sql101BasicsPage.verifyTheProgressBarValueForACourse(exp, course);
        sql101BasicsPage.clickNextBtn();
        sql101BasicsPage.checkThatWeGetQuestionNumberTwo();
        sql101BasicsPage.clickToTheAnotherQuestionsAnswer();
        sql101BasicsPage.verifyTheProgressBarValueForACourse(exp, course);
    }

}

package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SelfPracticeWithDataProviderTests extends BaseTest{

    @DataProvider(name = "CoursesNameDataProvider")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"Development", "SQL 101 (Basics)", 9},
                {"Development", "SQL 101 test", 12},
                {"Testing", "ISTQB Foundation level Prep", 20},
                {"Testing", "SQL Practice", 14},
                {"Testing", "Cucumber basics", 10},
                {"Business Analyst", "Business Analysis - General Questions", 6}
        };
    }

    @Test(dataProvider = "CoursesNameDataProvider")
    public void quizProgressBarFunctionalityTest(String expertiseName, String courseName, double expectedQty) {
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.clickExpertiseName(expertiseName);
        courseGalleryPage.checkNumberOfQuestionsForACourse(expertiseName, courseName, expectedQty);
        courseGalleryPage.clickStartBtnInCourse(expertiseName, courseName);
        switchToWindowFromTestBase(1);
        sql101BasicsPage.questionNameIsDisplayed();
        sql101BasicsPage.checkThatWeGetQuestionNumberOne();
        sql101BasicsPage.verifyTheProgressBarValueForACourse(expertiseName, courseName);
        sql101BasicsPage.clickToTheFirstQuestionAnswer();
        sql101BasicsPage.verifyTheProgressBarValueForACourse(expertiseName, courseName);
        sql101BasicsPage.clickNextBtn();
        sql101BasicsPage.checkThatWeGetQuestionNumberTwo();
        sql101BasicsPage.clickToTheAnotherQuestionsAnswer();
        sql101BasicsPage.verifyTheProgressBarValueForACourse(expertiseName, courseName);
    }
}

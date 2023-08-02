package testcases;

import org.testng.annotations.Test;

import java.util.logging.Logger;

public class SelfPracticeTests extends BaseTest {
    @Test
    public void historyIsAvailableForLoggedInUsersOnlyTest_new() {
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.checkThatCoursePageIsLoaded();
        courseGalleryPage.checkThatHistoryButtonIsNotPresented();
        //courseGalleryPage.checkThatHistoryButtonIsNotPresentedViaList(); //the second variant how to do it
        courseGalleryPage.navigationViaBrowserBack();
        homePage.clickSignInBtn();
        signInPage.fillInLoginForm("testing@my-fork.com", "Password");
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.checkThatCoursePageIsLoaded();
        courseGalleryPage.checkThatHistoryButtonIsPresented();
        courseGalleryPage.navigationViaBrowserBack();
        homePage.clickSignOutBtn();
        homePage.validationOfGalleryBtn();
    }
    @Test
    public void courseGalleryOptionsTest() {
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.checkExpertiseListIsCorrect();
    }

    @Test
    public void theFirstCourseQuizProgressBarFunctionalityTest(){
        quizProgressBarFunctionalityTest("Development", "SQL 101 (Basics)", 9);
    }
    @Test
    public void theSecondCourseQuizProgressBarFunctionalityTest(){
        quizProgressBarFunctionalityTest("Development", "SQL 101 test", 12);
    }

    public void quizProgressBarFunctionalityTest(String expertiseName, String courseName, double expectedQty) {
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.clickExpertiseName(expertiseName);
        courseGalleryPage.checkNumberOfQuestionsForACourse(expertiseName, courseName, expectedQty);
        courseGalleryPage.clickStartBtnInCourse(expertiseName,courseName);
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

package testcases;

import org.testng.annotations.Test;

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
        quizProgressBarFunctionalityTest("Development", "SQL 101 (Basics)");
    }
    @Test
    public void theSecondCourseQuizProgressBarFunctionalityTest(){
        quizProgressBarFunctionalityTest("Development", "SQL 101 test");
    }

    public void quizProgressBarFunctionalityTest(String exp, String course) {
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

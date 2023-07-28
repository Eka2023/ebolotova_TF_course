package testcases;

import org.testng.annotations.Test;

public class SelfPracticeTests extends BaseTest {
    @Test
    public void historyIsAvailableForLoggedInUsersOnlyTest_new() {
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.checkThatCoursePageIsLoaded();
        courseGalleryPage.checkThatHistoryButtonIsNotPresented();
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
    public void quizProgressBarFunctionalityTest1() {
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.checkNumberOfQuestionsForTheFirstCourse();
        courseGalleryPage.clickBtnStartOnTheFirstCourse();
        switchToWindow(1);
        sql101BasicsPage.questionNameIsDisplayed();
        sql101BasicsPage.checkThatWeGetQuestionNumberOne();
        sql101BasicsPage.verifyTheProgressBarValueForTheFirstCourse();
        sql101BasicsPage.clickToTheFirstAnswer();
        sql101BasicsPage.verifyTheProgressBarValueForTheFirstCourse();
        sql101BasicsPage.clickNextBtn();
        sql101BasicsPage.checkThatWeGetQuestionNumberTwo();
        sql101BasicsPage.clickToTheSecondAnswer();
        sql101BasicsPage.verifyTheProgressBarValueForTheFirstCourse();
    }

    @Test
    public void quizProgressBarFunctionalityTest2() {
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.checkNumberOfQuestionsForTheSecondCourse();
        courseGalleryPage.clickBtnStartOnTheSecondCourse();
        switchToWindow(1);
        sql101TestPage.questionNameIsDisplayed();
        sql101TestPage.checkThatWeGetQuestionNumberOne();
        sql101TestPage.verifyTheProgressBarValueForTheSecondCourse();
        sql101TestPage.clickToTheSecondAnswer();
        sql101TestPage.verifyTheProgressBarValueForTheSecondCourse();
        sql101TestPage.clickNextBtn();
        sql101TestPage.checkThatWeGetQuestionNumberTwo();
        sql101TestPage.clickToTheFirstAnswer();
        sql101TestPage.verifyTheProgressBarValueForTheSecondCourse();
    }


}

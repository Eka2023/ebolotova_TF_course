package testcases;

import org.testng.annotations.Test;

public class SelfPracticeTests extends BaseTest {
    @Test
    public void historyIsAvailableForLoggedInUsersOnlyTest() {
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.checkIfElementIsDisplayedOrNot(courseGalleryPage.getTheFirstCourseName(), true);
        courseGalleryPage.assertElementIsNotPresent(courseGalleryPage.getHistoryBtn());
        courseGalleryPage.navigationViaBrowserBack();
        homePage.clickSignInBtn();
        signInPage.fillInLoginForm("testing@my-fork.com", "Password");
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.checkIfElementIsDisplayedOrNot(courseGalleryPage.getTheFirstCourseName(), true);
        courseGalleryPage.checkIfElementIsDisplayedOrNot(courseGalleryPage.getHistoryBtn(), true);
        courseGalleryPage.navigationViaBrowserBack();
        homePage.clickSignOutBtn();
        homePage.checkIfElementIsDisplayedOrNot(homePage.getCourseGalleryBtn(), true);
    }

    @Test
    public void courseGalleryOptionsTest() {
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.assertActualAndExpectedList(
                expectedExpertiseList(),
                courseGalleryPage.getExpertiseList());
    }

    @Test
    public void quizProgressBarFunctionalityTest() {
        homePage.clickCourseGalleryBtn();
        assertEquality(courseGalleryPage.getNumOfQuestionsInStringFormat("Development", "SQL 101 (Basics)"),
                "0 / 9");
        courseGalleryPage.clickStartBtnInCourse("Development", "SQL 101 (Basics)");
        switchToWindow(1);
        sql101BasicsPage.printQuestionName();
        assertEquality(sql101BasicsPage.getQuestionNumber(), "1");
        assertEquality(sql101BasicsPage.getProgressBarValue(), 0);
        sql101BasicsPage.clickToAnswer(0);
        assertEquality(sql101BasicsPage.getProgressBarValue(), 11);
        sql101BasicsPage.clickNextBtn();
        assertEquality(sql101BasicsPage.getQuestionNumber(), "2");
        sql101BasicsPage.clickToAnswerOtherPages(0);
        assertEquality(sql101BasicsPage.getProgressBarValue(), 22);
    }

}

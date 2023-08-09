package testcases;

import org.testng.annotations.Test;

public class QuizTest extends BaseTest{

    private String expertiseName = "Development";
    private String courseName = "SQL 101 (Basics)";

    @Test
    public void verifyNextButtonStateWhenQuizIsCompleted() {
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.checkNumberOfQuestionsForACourse(expertiseName, courseName, 9);
        courseGalleryPage.clickStartBtnInCourse(expertiseName, courseName);
        switchToWindowFromTestBase(1);
        sql101BasicsPage.completeQuiz();
        sql101BasicsPage.verifyIsNextButtonDisabled();
    }
}
package testcases;

import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class NestedLoopsTest extends BaseTest {

    @Test
    public void nestedLoop() {
        for (int outer = 0; outer < 9; outer++) {
            System.out.println(outer);
            System.out.println("-------------------");
            for (int inner = 100; inner < 110; inner++) {
                System.out.println(">>" + inner);
            }
            System.out.println("==================");
        }
    }

    @Test
    public void multidimensionalArray() {
        int rows = 4;
        int columns = 5;
        int[][] multiDimensionalArray = new int[4][5];

        int value = 1;
        //this nested loop write values
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                multiDimensionalArray[i][j] = value;
                value++;
            }
        }

        //this nested loop print values from array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(multiDimensionalArray[i][j] + " | ");
            }
            System.out.println();
        }
    }

    @Test
    public void scheduleTest() {
        int rows = 4;
        int columns = 8;
        String[][] days = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            days[i][0] = "Week " + (i + 1) + ": ";
            for (int j = 1; j < columns; j++) {
                days[i][j] = "Day " + j + " | ";
            }
        }
        System.out.println("Monthly schedule is available below: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(days[i][j]);
            }
            System.out.println();
        }
    }


    @Test
    public void playersTest() {
        playersPage.openPage();
        playersPage.clickAgree();
        String a = playersPage.columnOneValue(8);
        System.out.println(a);
        List<String> b = playersPage.columnTwoValue(6);
        System.out.println(b);
    }

    @Test
    public void playersTest_duplicate() {
        playersPage.openPage();
        playersPage.clickAgree();
        Map<String, List<String>> a = playersPage.playersInfo();
        System.out.println(a);
    }

}

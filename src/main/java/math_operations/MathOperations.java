package math_operations;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MathOperations {
    static double JanProjectBudget = 1000;
    static double FebProjectBudget = 1200;
    static double MarchProjectBudget = 1500;
    static double AprilProjectBudget = 1100;
    static double MayProjectBudget = 900;

    public static void main(String[] arg) {
        //addition
        totalProjectBudget();
        //division
        averageProjectBudget();
        //subtraction
        diffBetweenMonthlyBudgets();
        //multiplication
        estimateProjectBudgetToYear();
        //additional methods
        estimateProjectBudgetToNextMonth();
        getBudgetsByMonth();
    }

    public static void totalProjectBudget() {
        System.out.println("------Total Project Budget----------");
        double total = JanProjectBudget + FebProjectBudget + MarchProjectBudget + AprilProjectBudget + MayProjectBudget;
        System.out.println("Total project budget = " + total);
    }

    public static void averageProjectBudget() {
        System.out.println("------Monthly Average Budget----------");
        System.out.println("Average project budget by month = " + averageProjectBudgetCalculation());
    }

    public static void estimateProjectBudgetToNextMonth() {
        System.out.println("------Estimate for next month----------");
        double estimate = maxProjectMonthBudget();
        System.out.println("Estimate project budget for next month = " + estimate);
    }

    public static void estimateProjectBudgetToYear() {
        System.out.println("------Estimate for next year----------");
        double estimate = averageProjectBudgetCalculation();
        System.out.println("Estimate project budget for next year = " + estimate * 12);
    }

    public static void diffBetweenMonthlyBudgets() {
        System.out.println("------Difference between months budgets----------");
        for (int i = 0; i < budgetList().size() - 1; i++) {
            double diff = budgetList().get(i) - budgetList().get(i + 1);
            System.out.println("diff between " + (i + 1) + " and " + (i + 2) + " months is: " + diff);
        }

    }

    public static void getBudgetsByMonth() {
        System.out.println("------Get monthly budgets----------");
        for (Map.Entry<String, Double> entry : budgetListInMap().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static double maxProjectMonthBudget() {
        double max = 0;

        for (double mb : budgetList()) {
            if (mb > max) {
                max = mb;
            }
        }
        return max;
    }

    public static ArrayList<Double> budgetList() {
        ArrayList<Double> monthsBudget = new ArrayList<>();
        monthsBudget.add(JanProjectBudget);
        monthsBudget.add(FebProjectBudget);
        monthsBudget.add(MarchProjectBudget);
        monthsBudget.add(AprilProjectBudget);
        monthsBudget.add(MayProjectBudget);
        return monthsBudget;
    }

    public static LinkedHashMap<String, Double> budgetListInMap() {
        LinkedHashMap<String, Double> map = new LinkedHashMap<>();
        map.put("Jan", JanProjectBudget);
        map.put("Feb", FebProjectBudget);
        map.put("Mar", MarchProjectBudget);
        map.put("Apr", AprilProjectBudget);
        map.put("May", MayProjectBudget);
        return map;
    }

    public static double averageProjectBudgetCalculation() {
        double average = 0;
        double total = 0;
        int count = 0;
        for (int i = 0; i < budgetList().size(); i++) {
            total = total + budgetList().get(i);
            count++;
        }
        average = total / count;
        return average;
    }

}

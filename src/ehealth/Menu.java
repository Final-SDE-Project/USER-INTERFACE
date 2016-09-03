package ehealth;

import java.util.Scanner;

/**
 * Created by Navid on 9/1/2016.
 */
public class Menu {
    public void printMenu() throws Exception
    {
        Scanner input = new Scanner(System.in);
        int op = -1;
        Long idPerson = Long.parseLong("1");
        String measureType = "weight";

        System.out.println("Welcome to LifeCoach App!");

        while (op != 0) {
            System.out.println("\nMENU");
            System.out.println("-----------------------------------");
            System.out.println("1 - Print your PERSONAL DETAILS & CURRENT HEALTH MEASURES");
            System.out.println("2 - Print your GOALS");
            System.out.println("3 - Have I reached my GOALS?!");
            System.out.println("4 - My weekly WALKING achievement");
            System.out.println("5 - My monthly WALKING achievement");
            System.out.println("6 - What is my IDEAL WEIGHT and set it as a GOAL");
            System.out.println("7 - My biggest WEIGHT change during the last 90 days");
            System.out.println("8 - Reminders to set GOAL or HEALTH MEASURE");
            System.out.println("9 - Print your HEALTH MEASURE HISTORY");
            System.out.println("10- Print your GOALS HISTORY");
            System.out.println("11- Save a GOAL");
            System.out.println("12- Save a MEASURE");
            System.out.println("\n0 - Exit");
            System.out.println("-----------------------------------");
            System.out.println("Quote of the day: "+new MenuMethods().printQuote());

            try
            {
                System.out.print("Select by entering number of your choice: \n");
                op = Integer.parseInt(input.next());
            }catch (Exception e)
            {
                System.out.println(e.getCause());
            }

            if (op < 0 || op > 12) {
                System.out.print("Number out of range, try again!\n\n");
            }else
            {
                switch (op) {
                    case 0:
                        System.out.println("\nThank you for using LifeCoach App!");
                        break;
                    case 1:
                        new MenuMethods().printPersonDetails(idPerson);
                        break;
                    case 2:
                        new MenuMethods().printPersonGoals(idPerson);
                        break;
                    case 3:
                        measureType = new MenuMethods().chooseMeasure();
                        new MenuMethods().printReachGoal(idPerson, measureType);
                        break;
                    case 4:
                        new MenuMethods().printStepAchievement(idPerson, 7);
                        break;
                    case 5:
                        new MenuMethods().printStepAchievement(idPerson, 31);
                        break;
                    case 6:
                        new MenuMethods().updateIdealWeightGoal(idPerson);
                        break;
                    case 7:
                        new MenuMethods().printWeightChangeAlert(idPerson);
                        break;
                    case 8:
                        new MenuMethods().printUpdateReminder(idPerson);
                        break;
                    case 9:
                        measureType = new MenuMethods().chooseMeasure();
                        new MenuMethods().printMeasureHistory(idPerson, measureType);
                        break;
                    case 10:
                        new MenuMethods().printGoalHistory(idPerson);
                        break;
                    case 11:
                        measureType = new MenuMethods().chooseMeasure();
                        new MenuMethods().createGoal(idPerson, measureType);
                        break;
                    case 12:
                        measureType = new MenuMethods().chooseMeasure();
                        new MenuMethods().createMeasure(idPerson, measureType);
                        break;

                }
            }
        }
    }
}

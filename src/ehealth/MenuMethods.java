package ehealth;

import ehealth.controller_db.ws.*;
import ehealth.controller_pc.ws.PcService;
import ehealth.controller_pc.ws.ServicePc;
import org.json.JSONObject;
import util.PrintObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Navid on 9/1/2016.
 */
public class MenuMethods {
    //Connection with Process Centric layer
    private PcService pcService = new PcService();
    private ServicePc servicePc = pcService.getServicePcImplPort();

    //1
    public void printPersonDetails(Long idPerson) throws Exception
    {
        Person person = servicePc.readPerson(idPerson);
        List<Person> personList = new ArrayList<Person>();
        personList.add(person);
        new PrintObjects().printPerson(personList, true);
    }

    //2
    public void printPersonGoals(Long idPerson) throws Exception
    {
        List<String> goalList = servicePc.readLatestGoalList(idPerson);
        new PrintObjects().printGoals(goalList);
    }

    //3
    public void printReachGoal(Long idPerson, String measureType) throws Exception
    {
        Person person = new Person();
        person.setIdPerson(idPerson);
        System.out.println(servicePc.readGoalStatus(person, measureType));
    }

    //3 & 9
    public String chooseMeasure() throws Exception
    {
        List<String> measureTypes = servicePc.readMeasureTypes();

        Scanner input = new Scanner(System.in);
        int op = -1;
        while (true) {
            System.out.println("\nMeasure Menu ");
            System.out.println("-----------------------------------");
            new PrintObjects().printMeasureTypes(measureTypes);
            System.out.println("-----------------------------------");

            try
            {
                System.out.print("Select by entering number of your choice: \n");
                op = Integer.parseInt(input.next());
            }catch (Exception e)
            {
                System.out.println(e.getCause());
            }

            if (op < 1 || op > measureTypes.size()) {
                System.out.print("Number out of range, try again!\n\n");
            }else
            {
                return measureTypes.get(op-1);
            }
        }
    }

    //4 & 5
    public void printStepAchievement(Long idPerson, int days) throws Exception
    {
        Person person = new Person();
        person.setIdPerson(idPerson);
        System.out.println(servicePc.readSteps(person, days));
    }

    //6
    public void updateIdealWeightGoal(Long idPerson) throws Exception
    {
        Person person = new Person();
        person.setIdPerson(idPerson);
        System.out.println(servicePc.updateIdealWeight(person));
    }

    //7
    public void printWeightChangeAlert(Long idPerson) throws Exception
    {
        Person person = new Person();
        person.setIdPerson(idPerson);
        System.out.println(servicePc.readBigWeightChange(person));
    }

    //8
    public void printUpdateReminder(Long idPerson) throws Exception
    {
        Person person = new Person();
        person.setIdPerson(idPerson);
        System.out.println(servicePc.readMeasureReminder(person));
        System.out.println(servicePc.readGoalReminder(person));
    }

    //9
    public void printMeasureHistory(Long idPerson, String measureType) throws Exception
    {
        List<HealthMeasureHistory> healthMeasureHistoryList = servicePc.readPersonHistory(idPerson, measureType);
        new PrintObjects().printMeasureHistory(healthMeasureHistoryList);
    }

    //10
    public void printGoalHistory(Long idPerson) throws Exception
    {
        List<String> goalList = servicePc.readGoalList(idPerson);
        new PrintObjects().printGoals(goalList);
    }

    //11
    public void createGoal(Long idPerson, String measureType) throws Exception
    {
        Goal goal = new Goal();
        Person person = new Person();
        MeasureDefinition measureDefinition = new MeasureDefinition();
        person.setIdPerson(idPerson);
        measureDefinition.setMeasureType(measureType);

        goal.setPerson(person);
        goal.setMeasureDefinition(measureDefinition);

        String currentMeasure = "";
        if("weight".equals(measureType) || "height".equals(measureType) || "heart rate".equals(measureType))
        {
            currentMeasure = getCurrentMeasure(idPerson,measureType);
            //getCurrentMeasure returned "" which means there is no corresponding measure
            if(currentMeasure.equals(""))
            {
                System.out.println("You should first enter a MEASURE for "+measureType.toUpperCase()+".");
            }
        }else
        {
            //This is needed for other measures
            currentMeasure = "0";
        }

        String middleSign = chooseIncreaseDecrease(measureType);
        double goalValue = enterMeasureValue_Goal(measureType, middleSign);
        goal.setGoalValue(currentMeasure + middleSign + goalValue);

        if(servicePc.saveGoal(goal).getGoalValue().equals(goal.getGoalValue()))
        {
            System.out.println("Your "+measureType.toUpperCase()+" GOAL has been stored.");
        }
    }

    //11
    public String chooseIncreaseDecrease(String measureType) throws Exception
    {
        Scanner input = new Scanner(System.in);
        int op = -1;
        while (true) {
            System.out.println("\nYour goal is to: ");
            System.out.println("-----------------------------------");
            System.out.println("1 - INCREASE your "+measureType+" level");
            System.out.println("2 - DECREASE your " + measureType + " level");
            System.out.println("-----------------------------------");

            try
            {
                System.out.print("Select by entering number of your choice: \n");
                op = Integer.parseInt(input.next());
            }catch (Exception e)
            {
                System.out.println(e.getCause());
            }

            if (op < 1 || op > 2) {
                System.out.print("Number out of range, try again!\n\n");
            }else
            {
                if(op == 1)
                {
                    return "+";
                }
                else if(op == 2)
                {
                    return "-";
                }
            }
        }
    }

    //11
    public double enterMeasureValue_Goal(String measureType, String middleSign) throws Exception
    {
        Scanner input = new Scanner(System.in);
        double value = 0;
        while (true) {
            System.out.println("\nYour "+measureType.toUpperCase()+" GOAL is: ");
            System.out.println("-----------------------------------");
            System.out.println("To \'"+middleSign+"\' what (double) quantity?");
            System.out.println("-----------------------------------");

            try
            {
                value = Double.parseDouble(input.next());
                return value;
            }catch (Exception e)
            {
                System.out.println(e.getCause());
            }
        }
    }

    //11
    //Getting Current HealthMeasure
    public String getCurrentMeasure(Long idPerson, String measureType) throws Exception
    {
        List<HealthProfile> healthProfileList = servicePc.readPerson(idPerson).getCurrentHealth().getMeasure();
        for(HealthProfile hp:healthProfileList)
        {
            if(hp.getMeasureType().equals(measureType))
            {
                return hp.getMeasureValue();
            }
        }
        return "";
    }

    //12
    public void createMeasure(Long idPerson, String measureType) throws Exception
    {
        double measureValue = enterMeasureValue_Measure(measureType);

        HealthMeasureHistory healthMeasureHistory = new HealthMeasureHistory();
        healthMeasureHistory.setMeasureType(measureType);
        healthMeasureHistory.setMeasureValue(measureValue+"");

        if(servicePc.savePersonMeasure(idPerson,healthMeasureHistory).getMeasureValue().equals(healthMeasureHistory.getMeasureValue()))
        {
            System.out.println("Your MEASURE has been stored.");
        }
    }

    //12
    public double enterMeasureValue_Measure(String measureType) throws Exception
    {
        Scanner input = new Scanner(System.in);
        double value = 0;
        while (true) {
            System.out.println("\nYour "+measureType.toUpperCase()+" MEASURE is: ");
            System.out.println("-----------------------------------");
            System.out.println("What (double) quantity?");
            System.out.println("-----------------------------------");

            try
            {
                value = Double.parseDouble(input.next());
                return value;
            }catch (Exception e)
            {
                System.out.println(e.getCause());
            }
        }
    }

    //Quote of the day
    public String printQuote() throws Exception
    {
        String result = servicePc.readQuote();
        JSONObject obj = new JSONObject(result);
        String quote = obj.getString("quote");
        String author = obj.getString("author");
        return "\""+quote+"\" -"+author;
    }


}

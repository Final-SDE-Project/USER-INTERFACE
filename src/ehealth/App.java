package ehealth;


import java.io.IOException;
import java.net.URISyntaxException;

public class App
{
    public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException
    {
        try
        {
            new Menu().printMenu();
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
        //TEST
        //PcService pcService = new PcService();
        //ServicePc servicePc = pcService.getServicePcImplPort();
        //Person person = new Person();
        //person.setIdPerson(Long.parseLong("1"));
        //System.out.println(servicePc.readGoalStatus(person, "weight"));
    }

}

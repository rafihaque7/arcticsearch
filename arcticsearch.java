import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rafihaque
 */

public class arcticsearch {
    //Global variable, so you can simply type blank for spaces
    String blank = "\t\t";

    //PRINT how to use the program, and general Information
    public static void startInfo()
    {
        System.out.println("This application will help you get the data you want faster!\n\n");
        System.out.println("1) General Information (Stock Price, Market Cap, P/E Ratio, Number of Employees)");
        System.out.println("2) Current Stock Price");
        System.out.println("3) Number of Employees");
        System.out.println("4) Market Cap");
        System.out.println("5) Net Profit Margin last quarter");
        System.out.println("6) Net Profit Margin last year");
        System.out.println("7) Operating Margin last quarter");
        System.out.println("8) Operating Margin last year");
        System.out.println("9) Select from the list(Display multiple data at once)");
        System.out.println("\n\nType stop to stop the program");
    }

    public static void numEmployees(Scanner input)
    {
        System.out.println("Start typing the ticker symbols. type \"stop\" to stop the program");
        String in = input.next();
        //System.out.println("Name, Price, Market Cap, Beta, Employees, Range 52 weeks, PE Ratio \n");
        System.out.printf("%15s %8s\n","Company Name","# of Employees");
        while (!in.startsWith("stop")) {

            try{
            Stock s1 = new Stock(in);
            //s1.getHistoricaldata("Jan",6,2016);
            System.out.printf("%15s %8s",s1.name(),s1.EmployeesLatest());
            //System.out.printf("%16s",s1.name());
            //System.out.print(s1.market_cap() + blank);
            //System.out.print(s1.beta() + blank);
            //System.out.print(s1.EmployeesLatest() + blank);
            //System.out.print(s1.range_52week() + blank);
            //System.out.print(s1. + blank);
            //System.out.print(s1.NetprofitmarginLatest() + blank);
            //System.out.print(s1.histLow + blank);
            //s1.getHistoricaldata("Jan",6,2017);
            //System.out.print(s1.histLow + blank);

            System.out.println();
            in = input.next();}

            catch(Exception tiggle){
                //System.err.println(tiggle.getCause());
                in=input.next();
            }
        }
    }

    public static void main(String[] args){


        //start this program
        startInfo();
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch(option)
        {
            case 3: numEmployees(input);
        }




    }
}

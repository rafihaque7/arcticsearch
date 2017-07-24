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
    public static void clearScreen()
    {
        //Clears the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
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

    //The selected option list
    public static void listofOptions()
    {
        clearScreen();
        System.out.printf("List of options\n");
        //Big vector length is 23
        for(int i=0; i<23; i++)
        {
            System.out.printf("%3d) %18s\t",i, Data.permName[i]);
            if(i%2==0) System.out.println();
        }
        System.out.println("\nType numbers from the list above, type 123 to stop");
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

            System.out.printf("%15s %8s",s1.name(),s1.EmployeesLatest());


            System.out.println();
            in = input.next();}

            catch(Exception tiggle){
                //System.err.println(tiggle.getCause());
                in=input.next();
            }
        }
    }

    public static void printGathereddata(Scanner input, int[] bigVector)
    {
        clearScreen();
        System.out.println("Start typing the ticker symbols. type \"stop\" to stop the program");
        String in = input.next();
        System.out.printf("%15s","Company Name");
        for(int i=0; i<bigVector.length; i++)
        {
            if(bigVector[i]==1) System.out.printf(" %30s",Data.permName[i]);
        }
        System.out.println();

        while (!in.startsWith("stop")) {
            try{
            //Stock s1 = new Stock(in);
            Data s1 = new Data(in);
            //Adds everything to the arraylist
            s1.doall();
            //This is for the name of the company
            System.out.printf("%15s",s1.content.get(11));
            for(int i=0; i<bigVector.length; i++)
            {
                if(bigVector[i]==1) System.out.printf(" %30s",s1.content.get(i));
            }


            System.out.println();
            in = input.next();}

            catch(Exception tiggle){
                //System.err.println(tiggle.getCause());
                in=input.next();
            }
        }

    }

    public static void main(String[] args){

        //Big vector
        int[] bigVector = new int[23];

        //System.out.println("bigVector[0] is " + bigVector[0]);
        //start this program
        startInfo();
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch(option)
        {
            case 1: bigVector[17]=bigVector[4]=bigVector[5]=1;printGathereddata(input,bigVector); break; // 17 is price, 4 is market cap, 5 is PE Ratio
            case 2: bigVector[17]=1; printGathereddata(input,bigVector); break; //17 corrensponds with price
            case 3: numEmployees(input); break;
            case 4: bigVector[4]=1; printGathereddata(input,bigVector); break; //4 corrensponds with Market cap
            case 9:
            {
                listofOptions();

                Scanner vectorInput = new Scanner(System.in);

                while(vectorInput.hasNext())
                {
                    int vectorIn = vectorInput.nextInt();
                    if(vectorIn==123) break;
                    bigVector[vectorIn] = 1;
                }
                printGathereddata(input,bigVector);
            }
        }




    }
}

//s1.getHistoricaldata("Jan",6,2016);

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

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
	clearScreen();
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
        //Big vector length is 35
        for(int i=0; i<permName.size(); i++)
        {
            System.out.printf("%3d) %28s\t",i, permName.get(i));
            if(i%2==0) System.out.println();
        }
        System.out.println("\nType numbers from the list above, type 123 to stop");
    }

    //The way this function is written is absolutely not necessary
    public static void numEmployees(Scanner input)
    {
        clearScreen();
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

    //If the user types list
    public static void precurList(Scanner input)
    {
        System.out.println("Select from the list of symbols");
        System.out.println("1) Growth Technology Stocks");
        System.out.println("2) Day Losers List ");
        int option = input.nextInt();
        switch(option)
        {
            case 1:
            {

                System.out.println("Showing result for tech growth stocks");
                //Loading the list of stocks
                System.out.println("CURRENTLY WORK IN PROGRESS!!!!!!!!!!!");
                try
                {
                    ListofStocks.techgGowth();
                }
                catch (Exception e){
                    System.out.println("invalid tech growth URL");
                    System.out.println("CURRENTLY WORK IN PROGRESS!!!!!!!!!!!");
                }



            }
        }
    }

    //The most important method of the program
    public static void printGathereddata(Scanner input, int[] bigVector)
    {
        clearScreen();
        System.out.println("Start typing the ticker symbols or type list to get a list of ticker symbols. Type \"stop\" to stop the program, menu to go back to the original menu");
        String in = input.next();
        System.out.printf("%15s","Company Name");
        for(int i=0; i<bigVectorSize; i++)
        {
            if(bigVector[i]==1) System.out.printf(" %30s",permName.get(i));
        }
        System.out.println();
        if(in.startsWith("list"))
        {
            precurList(input);
        }

        while (!in.startsWith("stop")) {
	    if( in.startsWith("menu")) //If the user types mnenu, it will take it back to the original meny
	    {
		selectionMenu();
		break;
	    }
	    if( in.startsWith("add"))
	    {
		subSelection(input,bigVector);
            }
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
            in = input.next();
            } catch(Exception tiggle){
                //System.err.println(tiggle.getCause());
                in=input.next();
            }

        }
    }

    //The program evolves depending on what google finance operates
    static int bigVectorSize = 0;
    static List<String> permName = new ArrayList<>(Arrays.asList("xyz"));   //xyz is just for initializing
    //Adds the Permanent name field from googl stock
    public static void sample()
    {
        try
        {
            Data sample1 = new Data("googl");
            sample1.doall();
            bigVectorSize = sample1.name.size();
            permName.remove(0);
            for(int i=0; i<bigVectorSize; i++)
            {
                permName.add(sample1.name.get(i));
            }
        } catch(Exception e)
        {

        }

    }
   
    public static void subSelection(Scanner input, int[] bigVector)
    {
         listofOptions();

                Scanner vectorInput = new Scanner(System.in);

                while(vectorInput.hasNext())
                {
                    int vectorIn = vectorInput.nextInt();
                    if(vectorIn==123) break;
                    if(vectorIn <=bigVector.length) bigVector[vectorIn] = 1;
                }
                printGathereddata(input,bigVector);
                
    }

    public static void selectionMenu()
    {
	
       //Big vector
        int[] bigVector = new int[bigVectorSize];

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
        	subSelection(input,bigVector);
            }
        }


    }	



    public static void main(String[] args){
	sample(); 
	selectionMenu();

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

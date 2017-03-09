import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rafihaque on 2/20/17.
 */
public class datatest {

    public static void main(String[] args) throws IOException {

        String blank = "\t\t";
        //start this program
     Scanner input = new Scanner(System.in);

        String in = input.next();
        //System.out.println("Name, Price, Market Cap, Beta, Employees, Range 52 weeks, PE Ratio \n");

        while (!in.startsWith("stop")) {

            try{
            Stock s1 = new Stock(in);
            s1.getHistoricaldata("Jan",6,2016);
            System.out.print(s1.name() + blank);
            System.out.print(s1.EmployeesLatest() + blank);
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
                System.err.println(tiggle.getCause());
                in=input.next();
            }
        }

        //Data.analyzeIndividual(input);
        //Data.keepgoing(input);

/*        List<String> a = new ArrayList<>(Arrays.asList("aapl", "amzn"));

        for(int i=0; i<a.size();i++) {
            Stock s1 = new Stock(a.get(i));
            System.out.print(s1.name() + blank);
            System.out.print(s1.price() + blank);
            System.out.print(s1.beta() + blank);
            System.out.print(s1.EmployeesLatest() + blank);
            System.out.print(s1.range_52week() + blank);
            System.out.print(s1.pe_ratio());
            System.out.println();
        }*/

/*       ListofStocks.techgGowth();

        for (int i = 0; i < ListofStocks.listTechgrowth.length; i++) {
            Stock s1 = new Stock(ListofStocks.listTechgrowth[i]);
            System.out.print(s1.tickerSymbol() + blank);
            System.out.print(s1.name() + blank);
            System.out.print(s1.market_cap() + blank);
            System.out.print(s1.EmployeesLatest() + blank);
            System.out.println();


        }*/

   /*     ListofStocks.DayLosers();
        for (int i = 0; i < ListofStocks.listDayLosers.length; i++) {

            Stock s1 = new Stock(ListofStocks.listDayLosers[i]);

            System.out.print(s1.name() + blank);
            System.out.print(s1.EmployeesLatest());
            System.out.println();


        }*/








    }
}

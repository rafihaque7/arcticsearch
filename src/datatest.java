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
            //s1.getHistoricaldata("Jan",6,2016);
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

    }
}

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rafihaque on 2/22/17.
 */
public class ListofStocks {

    public static String[] listTechgrowth;
    public static String[] listDayLosers;


    public static void techgGowth() throws IOException {


        ArrayList<String> strarray = new ArrayList<>();


        String line = " ";


        String techGrowthUrl = "http://finance.yahoo.com/screener/predefined/growth_technology_stocks?offset=0&count=100";

        Scanner input1 = new Scanner(new URL(techGrowthUrl).openStream());

        while (input1.hasNext()) {
            strarray.add(input1.next());
        }


        for (int i = 0; i < strarray.size(); i++) {
            if (strarray.get(i).contains("pageCategory\":\"YFINANCE:")) {

                line += strarray.get(i);
            }

        }

        String[] cutStart = line.split("\"pageCategory\":\"YFINANCE:");
        String[] cutEnd = cutStart[1].split("\",\"fallbackCategory\":");


        listTechgrowth = cutEnd[0].split(",");


    }


    //List of day losers

    public static void DayLosers() throws IOException {


        ArrayList<String> strarray = new ArrayList<>();


        String line = " ";


        String DayLosersUrl = "http://finance.yahoo.com/screener/predefined/day_losers?offset=0&count=1000";

        Scanner input1 = new Scanner(new URL(DayLosersUrl).openStream());

        while (input1.hasNext()) {
            strarray.add(input1.next());
        }


        for (int i = 0; i < strarray.size(); i++) {
            if (strarray.get(i).contains("pageCategory\":\"YFINANCE:")) {

                line += strarray.get(i);
            }

        }

        String[] cutStart = line.split("\"pageCategory\":\"YFINANCE:");
        String[] cutEnd = cutStart[1].split("\",\"fallbackCategory\":");


        listDayLosers = cutEnd[0].split(",");


    }


}

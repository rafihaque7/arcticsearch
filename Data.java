import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rafihaque on 2/20/17.
 */
public class Data {

    //The main one
    private String symbol;
    private String url;
    static final String blank = "\t";

    //Permanent name
    // public static String[] permName = {"range" ,"range_52week" ,"open" ,"vol_and_avg" ,"market_cap" ,"pe_ratio" ,"latest_dividend-dividend_yield" ,"eps" ,"shares" ,"beta" ,"inst_own" ,"name" ,"url" ,"imageUrl" ,"tickerSymbol" ,"exchange" ,"exchangeTimezone" ,"price" ,"priceChange" ,"priceChangePercent" ,"quoteTime" ,"dataSource" ,"dataSourceDisclaimerUrl" ,"priceCurrency", "Net profit margin(Q)" ,"Net profit margin(Y)" ,"Operating margin(Q)" ,"Operating margin(Y)" ,"EBITD margin(Q)" ,"EBITD margin(Y)" ,"Return on average assets(Q)" ,"Return on average assets(Y)" ,"Return on average equity(Q)" ,"Return on average equity(Y)" ,"Employees(Q)"
    // };

    public ArrayList<String> name;
    public ArrayList<String> content;
    public ArrayList<String> stats;
    public ArrayList<String> contentstatsLatest;
    public ArrayList<String> contentstatsLastyear;



    Data(String symbol)
    {
        this.symbol = symbol;
    }


    //Converts it to a URL
    public void symboltoUrl()
    {

        //String url = "https://www.google.com/finance?q=" + this.symbol + "&ei=9iGpWNmkBsWO2AaSnZ3YBg";
        //String url = "https://www.google.com/finance?q=NASDAQ%3A" + this.symbol;
        String url = "https://www.google.com/finance?q=NYSE%3A" + this.symbol;
        this.url = url;
    }

    //Makes the content arraylist and fills it with data
    public void doall() throws IOException
    {
        symboltoUrl();
        //Starts reading the html file
        Scanner input1 = new Scanner(new URL(this.url).openStream());

        ArrayList<String> strarray = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> content = new ArrayList<>();

        //For key stats such as the number of employees
        ArrayList<String> stats = new ArrayList<>();
        ArrayList<String> contentstatsLatest = new ArrayList<>();
        ArrayList<String> contentstatsLastyear = new ArrayList<>();


        while (input1.hasNext()) {
            strarray.add(input1.nextLine());
        }

        //It looks for certain keywords and adds it to the arraylist
        for (int i = 0; i < strarray.size(); i++)
        {
            if (strarray.get(i).contains("itemprop=")) {
                String[] temp = strarray.get(i).split("\"");
                name.add(temp[1]);
                String[] temp2 = strarray.get(i + 1).split("\"");
                content.add(temp2[1]);
            }
            if (strarray.get(i).contains("data-snapfield=")) {
                String[] temp = strarray.get(i).split("\"");
                name.add(temp[1]);
                String[] temp2 = strarray.get(i + 2).split(">");
                content.add(temp2[1]);
                //System.out.println(strarray.get(i+2));
            }
            //For key stats
            if (strarray.get(i).contains("<td class=\"lft name\">") && !strarray.get(i).contains("<td class=\"lft name\">CDP Score")) {
                String[] temp = strarray.get(i).split(">");
                stats.add(temp[1]);
                String[] temp2 = strarray.get(i + 1).split(">");
                contentstatsLatest.add(temp2[1]);
                String[] temp3 = strarray.get(i + 2).split(">");
                contentstatsLastyear.add(temp3[1]);
            }
        }

        //Adding stats  and contentstatsLatest and contentstatsLastyear to name and content arraylist

        for(int i=0; i< stats.size(); i++)
        {
            name.add(stats.get(i)+"(Q)");
            content.add(contentstatsLatest.get(i)); //Last quarter
            name.add(stats.get(i)+"(Y)");
            content.add(contentstatsLastyear.get(i));   //Last Year
        }

        // for(int i=24; i<35; i++)
        // {
        //     System.out.print("\"" + name.get(i) + "\" " + ",");
        // }

        this.name = name;
        this.content = content;
        this.stats = stats;
        this.contentstatsLatest = contentstatsLatest;
        this.contentstatsLastyear = contentstatsLastyear;

    }

    // public static void main(String[] args) throws IOException
    // {
    //     Data a1 = new Data("googl");
    //     a1.doall();
    //     for(int i=0 ; i< a1.name.size(); i++)
    //     {
    //         System.out.printf("%d) ", i);
    //         System.out.printf("%20s", a1.name.get(i));
    //         System.out.printf("%20s",a1.content.get(i));
    //         System.out.println();
    //     }
    //
    // }
}

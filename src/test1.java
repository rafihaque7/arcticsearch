import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rafihaque on 2/20/17.
 */
public class test1 {

    public static void main(String[] args) throws IOException{


        String url = "https://www.google.com/finance?q=twtr&ei=9iGpWNmkBsWO2AaSnZ3YBg";

        Scanner input1 = new Scanner(new URL(url).openStream());


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

        for (int i = 0; i < strarray.size(); i++) {

            if (strarray.get(i).contains("itemprop=")) {
                String[] temp = strarray.get(i).split("\"");
                name.add(temp[1]);

                for(int j=0;j<Data.permName.length;j++){
                if(!Data.permName[j].equals(name.get(name.size()-1))){
                System.out.println(name.get(name.size()-1));}}


                String[] temp2 = strarray.get(i+1).split("\"");
                content.add(temp2[1]);
            }

            if(strarray.get(i).contains("data-snapfield=")){
                String[] temp = strarray.get(i).split("\"");
                name.add(temp[1]);
                String[] temp2 = strarray.get(i+2).split(">");
                content.add(temp2[1]);
                //System.out.println(strarray.get(i+2));
            }

            //To get the stats
            if(strarray.get(i).contains("<td class=\"lft name\">") && !strarray.get(i).contains("<td class=\"lft name\">CDP Score")){
                String[] temp = strarray.get(i).split(">");
                stats.add(temp[1]);
                String[] temp2 = strarray.get(i+1).split(">");
                contentstatsLatest.add(temp2[1]);
                String[] temp3 = strarray.get(i+2).split(">");
                contentstatsLastyear.add(temp3[1]);

            }




        }


//Print name and content
      /*for(int i=0; i<name.size();i++){

            System.out.print(name.get(i));
            System.out.print(" " + content.get(i));
            System.out.println();
        }*/


//Print name and content code
/*     for(int i=0; i<name.size();i++) {

           System.out.print("public String " + name.get(i) +  "() throws IOException{\n" + " this.symboltoUrl(); \n this.doall();\n"+ " return " + "this.content.get(" + i +");" + " } \n");



        }*/


//Print stats stuff
/*       for(int i=0; i<stats.size();i++){

            System.out.print(stats.get(i));
            System.out.print(" " + contentstatsLatest.get(i));
            System.out.print(" " + contentstatsLastyear.get(i));
            System.out.println();
        }*/



        //Prints the code for stats and stuff
      /*for(int i=0; i<stats.size();i++) {

           System.out.print("public String " + stats.get(i) +  "Latest() throws IOException{\n" + " this.symboltoUrl(); \n this.doall();\n"+ " return " + "this.contentstatsLatest.get(" + i +");" + " } \n");
          System.out.print("public String " + stats.get(i) +  "Lastyear() throws IOException{\n" + " this.symboltoUrl(); \n this.doall();\n"+ " return " + "this.contentstatsLastyear.get(" + i +");" + " } \n");



        }*/

      //Prints the permanent name array
      /*  for(int i=0; i<name.size();i++){
        System.out.print("\"" + name.get(i)+"\" ,");}*/


        //Printing for the gui

/*        for(int i=0; i<Data.permName.length;i++) {

            System.out.print("pane.add(new JLabel(\"" + Data.permName[i] +"\"));\n");
            //System.out.print("JCheckBox " + Data.permName[i] + "Check" + " = new JCheckBox(); \n");
            System.out.print("pane.add(" + Data.permName[i] + "Check);\n");

        }*/



    }
}


/*
//Just prints the name of the company and the current price of the stock
public static void keepgoing(Scanner input) throws IOException {

    String in = input.next();

    while (!in.startsWith("stop")) {
        Stock s1 = new Stock(in);
        System.out.print(s1.name() + " ");
        System.out.print(s1.price());
        System.out.println();
        in = input.next();
    }

}

//Gives a lot of information to analyze one stock
public static void analyzeIndividual(Scanner input) throws IOException {

    String in = input.next();
    Data s1 = new Data(in);
    s1.symboltoUrl();
    s1.doall();
    for (int i = 0; i < s1.name.size(); i++) {
        System.out.print(s1.name.get(i) + blank);
        System.out.print(s1.content.get(i));
        System.out.println();
    }
    for (int i = 0; i < s1.stats.size(); i++) {
        System.out.print(s1.stats.get(i) + blank);
        System.out.print(s1.contentstatsLatest.get(i) + blank);
        System.out.print(s1.contentstatsLastyear.get(i));
        System.out.println();


    }


}


//Get historical data for certain dates with month=Jan, 02,2017
    public void getHistoricaldata(String month, int date, int year ) throws IOException{

        //String url = "https://www.google.com/finance/historical?q=NYSE%3A" + this.symbol +"&startdate=" + month + "+" + date + "%2C+"+ year + "&num=1";
        String url = "https://www.google.com/finance/historical?q=NYSE%3A"+ this.symbol+ "&&startdate=" + month +"+"+date+"%2C+"+year+"&enddate=" +month+"+"+date+"%2C+"+year+"&num=1";


        Scanner input = new Scanner(new URL(url).openStream());
        ArrayList<String> codeHistWeb = new ArrayList<>();
        ArrayList<Double> histData = new ArrayList<>();

        while(input.hasNext()){
            codeHistWeb.add(input.nextLine());
        }

        for(int i=0; i<codeHistWeb.size(); i++) {

            if(codeHistWeb.get(i).contains("<td class=\"rgt\">")){
                String[] temp = codeHistWeb.get(i).split(">");
                histData.add(Double.parseDouble(temp[1]));
            }
        }

        this.histOpen = histData.get(0);
        this.histHigh = histData.get(1);
        this.histLow = histData.get(2);
        this.histClose = histData.get(3);
        //this.histVolume = histData.get(4);





        private ArrayList<String> name;
        public ArrayList<String> content;
        private ArrayList<String> stats;
        public ArrayList<String> contentstatsLatest;
        public ArrayList<String> contentstatsLastyear;

        //Get historical data
        public double histOpen;
        public double histHigh;
        public double histLow;
        public double histClose;
        //public double histVolume;

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

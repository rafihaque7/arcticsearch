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

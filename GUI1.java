import javax.swing.*;
import java.awt.*;

/**
 * Created by rafihaque on 3/5/17.
 */
public class GUI1 {
    public static void main(String[] args) {

        //Introduce stuff
        JFrame frame = new JFrame("GUI1");
        Container pane = frame.getContentPane();

        //All the check Boxes
        JCheckBox rangeCheck = new JCheckBox();
        JCheckBox range_52weekCheck = new JCheckBox();
        JCheckBox openCheck = new JCheckBox();
        JCheckBox vol_and_avgCheck = new JCheckBox();
        JCheckBox market_capCheck = new JCheckBox();
        JCheckBox pe_ratioCheck = new JCheckBox();
        JCheckBox latest_dividend_dividend_yieldCheck = new JCheckBox();
        JCheckBox epsCheck = new JCheckBox();
        JCheckBox sharesCheck = new JCheckBox();
        JCheckBox betaCheck = new JCheckBox();
        JCheckBox inst_ownCheck = new JCheckBox();
        JCheckBox nameCheck = new JCheckBox();
        JCheckBox urlCheck = new JCheckBox();
        JCheckBox imageUrlCheck = new JCheckBox();
        JCheckBox tickerSymbolCheck = new JCheckBox();
        JCheckBox exchangeCheck = new JCheckBox();
        JCheckBox exchangeTimezoneCheck = new JCheckBox();
        JCheckBox priceCheck = new JCheckBox();
        JCheckBox priceChangeCheck = new JCheckBox();
        JCheckBox priceChangePercentCheck = new JCheckBox();
        JCheckBox quoteTimeCheck = new JCheckBox();
        JCheckBox dataSourceCheck = new JCheckBox();
        JCheckBox dataSourceDisclaimerUrlCheck = new JCheckBox();
        JCheckBox priceCurrencyCheck = new JCheckBox();








        pane.setLayout(new GridLayout(Data.permName.length,2));
        //Add it to the show container stuff
       /* for(int i=0; i<Data.permName.length;i++){
        pane.add(new JLabel(Data.permName[i]));
        }*/

        pane.add(new JLabel("range"));
        pane.add(rangeCheck);
        pane.add(new JLabel("range_52week"));
        pane.add(range_52weekCheck);
        pane.add(new JLabel("open"));
        pane.add(openCheck);
        pane.add(new JLabel("vol_and_avg"));
        pane.add(vol_and_avgCheck);
        pane.add(new JLabel("market_cap"));
        pane.add(market_capCheck);
        pane.add(new JLabel("pe_ratio"));
        pane.add(pe_ratioCheck);
        pane.add(new JLabel("latest_dividend-dividend_yield"));
        pane.add(latest_dividend_dividend_yieldCheck);
        pane.add(new JLabel("eps"));
        pane.add(epsCheck);
        pane.add(new JLabel("shares"));
        pane.add(sharesCheck);
        pane.add(new JLabel("beta"));
        pane.add(betaCheck);
        pane.add(new JLabel("inst_own"));
        pane.add(inst_ownCheck);
        pane.add(new JLabel("name"));
        pane.add(nameCheck);
        pane.add(new JLabel("url"));
        pane.add(urlCheck);
        pane.add(new JLabel("imageUrl"));
        pane.add(imageUrlCheck);
        pane.add(new JLabel("tickerSymbol"));
        pane.add(tickerSymbolCheck);
        pane.add(new JLabel("exchange"));
        pane.add(exchangeCheck);
        pane.add(new JLabel("exchangeTimezone"));
        pane.add(exchangeTimezoneCheck);
        pane.add(new JLabel("price"));
        pane.add(priceCheck);
        pane.add(new JLabel("priceChange"));
        pane.add(priceChangeCheck);
        pane.add(new JLabel("priceChangePercent"));
        pane.add(priceChangePercentCheck);
        pane.add(new JLabel("quoteTime"));
        pane.add(quoteTimeCheck);
        pane.add(new JLabel("dataSource"));
        pane.add(dataSourceCheck);
        pane.add(new JLabel("dataSourceDisclaimerUrl"));
        pane.add(dataSourceDisclaimerUrlCheck);
        pane.add(new JLabel("priceCurrency"));
        pane.add(priceCurrencyCheck);


        //Add everything to listener


        //Close it
        frame.pack();
        frame.setVisible(true);



    }

}

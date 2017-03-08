import java.io.IOException;

/**
 * Created by rafihaque on 2/21/17.
 */
public class Stock extends Data {
    Stock(String symbol) {
        super(symbol);
    }


    public String range() throws IOException {
        this.doall();
        return this.content.get(0);
    }

    public String range_52week() throws IOException {
        this.doall();
        return this.content.get(1);
    }

    public String open() throws IOException {
        this.doall();
        return this.content.get(2);
    }

    public String vol_and_avg() throws IOException {
        this.doall();
        return this.content.get(3);
    }

    public String market_cap() throws IOException {
        this.doall();
        return this.content.get(4);
    }

    public String pe_ratio() throws IOException {
        this.doall();
        return this.content.get(5);
    }

    public String latest_dividenddividend_yield() throws IOException {
        this.doall();
        return this.content.get(6);
    }

    public String eps() throws IOException {
        this.doall();
        return this.content.get(7);
    }

    public String shares() throws IOException {
        this.doall();
        return this.content.get(8);
    }

    public String beta() throws IOException {
        this.doall();
        return this.content.get(9);
    }

    public String inst_own() throws IOException {
        this.doall();
        return this.content.get(10);
    }

    public String name() throws IOException {
        this.doall();
        return this.content.get(11);
    }

    public String url() throws IOException {
        this.doall();
        return this.content.get(12);
    }

    public String imageUrl() throws IOException {
        this.doall();
        return this.content.get(13);
    }

    public String tickerSymbol() throws IOException {
        this.doall();
        return this.content.get(14);
    }

    public String exchange() throws IOException {
        this.doall();
        return this.content.get(15);
    }

    public String exchangeTimezone() throws IOException {
        this.doall();
        return this.content.get(16);
    }

    public String price() throws IOException {
        this.doall();
        return this.content.get(17);
    }

    public String priceChange() throws IOException {
        this.doall();
        return this.content.get(18);
    }

    public String priceChangePercent() throws IOException {
        this.doall();
        return this.content.get(19);
    }

    public String quoteTime() throws IOException {
        this.doall();
        return this.content.get(20);
    }

    public String dataSource() throws IOException {
        this.doall();
        return this.content.get(21);
    }

    public String dataSourceDisclaimerUrl() throws IOException {
        this.doall();
        return this.content.get(22);
    }

    public String priceCurrency() throws IOException {
        this.doall();
        return this.content.get(23);
    }


    //Key stats
    public String NetprofitmarginLatest() throws IOException {
        this.doall();
        return this.contentstatsLatest.get(0);
    }

    public String NetprofitmarginLastyear() throws IOException {
        this.doall();
        return this.contentstatsLastyear.get(0);
    }

    public String OperatingmarginLatest() throws IOException {
        this.doall();
        return this.contentstatsLatest.get(1);
    }

    public String OperatingmarginLastyear() throws IOException {
        this.doall();
        return this.contentstatsLastyear.get(1);
    }

    public String EBITDmarginLatest() throws IOException {
        this.doall();
        return this.contentstatsLatest.get(2);
    }

    public String EBITDmarginLastyear() throws IOException {
        this.doall();
        return this.contentstatsLastyear.get(2);
    }

    public String ReturnonaverageassetsLatest() throws IOException {
        this.doall();
        return this.contentstatsLatest.get(3);
    }

    public String ReturnonaverageassetsLastyear() throws IOException {
        this.doall();
        return this.contentstatsLastyear.get(3);
    }

    public String ReturnonaverageequityLatest() throws IOException {
        this.doall();
        return this.contentstatsLatest.get(4);
    }

    public String ReturnonaverageequityLastyear() throws IOException {
        this.doall();
        return this.contentstatsLastyear.get(4);
    }

    public String EmployeesLatest() throws IOException {
        this.doall();
        return this.contentstatsLatest.get(5);
    }

    public String EmployeesLastyear() throws IOException {
        this.doall();
        return this.contentstatsLastyear.get(5);
    }












}

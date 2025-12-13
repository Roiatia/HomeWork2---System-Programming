package Stocks;

public class Stocks_Main {
    public static void main(String[] args) {
        StockServer server = new StockServer();

        Thread t1 = new Thread(new StockView("Tami Tan", StockServer.Stock.MICROSOFT, server));
        Thread t2 = new Thread(new StockView("Tim Sorli ", StockServer.Stock.APPLE, server));
        Thread t3 = new Thread(new StockView("Sima didas", StockServer.Stock.GOOGLE, server));
        //asssignment 3 requirement
        Thread update =  new Thread(new StockUpdate(server));

        t1.start();
        t2.start();
        t3.start();

        update.start();//asssignment 3 requirement

    }
}

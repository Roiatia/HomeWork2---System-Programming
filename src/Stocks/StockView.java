package Stocks;

import java.util.Random;

public class StockView implements Runnable {
private String name;
private StockServer.Stock stock;
private  StockServer server;
private Random random = new Random();

public StockView(String name, StockServer.Stock stock, StockServer server) {
    this.name = name;
    this.stock = stock;
    this.server = server;
}

@Override
    public void run() {
        for(int i =0 ; i < 10; i++) {
            int value = server.GetStock(stock);

            System.out.println("Name: "  + name + " Stock: " + stock + " Value: " + value + " USD");

            try {
               Thread.sleep(1000 + random.nextInt(2000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

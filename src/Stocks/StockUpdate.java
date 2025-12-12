package Stocks;

import java.util.Random;

public class StockUpdate implements Runnable {
private StockServer server;
private Random random = new Random();

public StockUpdate(StockServer server) {
    this.server = server;
}

@Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            StockServer.Stock[] arr = StockServer.Stock.values();
                for(int  j = 0; j < arr.length; j++) {
                    int newValues  = 100 + random.nextInt(401);
                    server.updateStock(arr[j], newValues);
                    System.out.println("Updated Stock: " + arr[j] + " to " + newValues + " USD");
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }

        }
}
}

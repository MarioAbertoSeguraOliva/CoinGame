package application;

import controller.ThrowCoinOperation;
import view.CoinLoader;

public class Application {

    public static void main(String[] args) {
        ThrowCoinOperation throwCoinOperation = new ThrowCoinOperation(CoinLoader.load());
        throwCoinOperation.execute();
    }
    
}

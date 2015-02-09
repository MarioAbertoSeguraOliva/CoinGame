package controller;

import model.Coin;
import view.CoinDisplay;

public class ThrowCoinOperation {
    private final Coin coin;
    
    public ThrowCoinOperation(Coin coin) {
        this.coin=coin;
    }
    
    public void execute(){
        new CoinDisplay(coin);
    }
}

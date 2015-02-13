package controller;

import model.Coin;
import view.CoinDisplay;

public class ThrowCoinOperation {
    private final Coin coin;
    
    public ThrowCoinOperation(Coin coin) {
        this.coin=coin;
    }
    
    public void execute(){
        CoinDisplay displayer = new CoinDisplay(coin);
        displayer.display();
    }
}

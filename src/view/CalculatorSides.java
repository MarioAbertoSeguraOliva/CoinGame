package view;

import model.Coin;

public class CalculatorSides {
    
    public Coin.Side calculateNextCoinState() {
        int coinState = (int) (Math.random()*50);
        if(coinState==50)
            return Coin.Side.Edge;
        else if(coinState<25)
            return Coin.Side.Head;
        else
            return Coin.Side.Tail;
    }
}

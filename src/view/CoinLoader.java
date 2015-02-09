package view;

import model.Coin;
import model.Coin.Side;

public class CoinLoader {
    
    public static Coin load(){
        Coin coin = new Coin(Side.Edge, "C:\\Users\\HP\\Desktop\\TRABAJO\\GSD\\02-02-2015\\Logo.png");
        return coin;
    }
}

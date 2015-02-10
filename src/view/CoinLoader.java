package view;

import model.Coin;
import model.Coin.Side;

public class CoinLoader {
    
    public static Coin load(){
        String[] imagesNames = new String[]{"C:\\Users\\HP\\Desktop\\Proyectos\\ProyectosGráficos\\Sin Nombre.png",
                                            "C:\\Users\\HP\\Desktop\\TRABAJO\\GSD\\02-02-2015\\Logo.png",
                                            "C:\\Users\\HP\\Desktop\\TRABAJO\\GSD\\path4142.png"};
        Coin coin = new Coin(Side.Edge, imagesNames);
        return coin;
    }
}

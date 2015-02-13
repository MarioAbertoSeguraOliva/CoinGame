package view;

import model.Coin;
import model.Coin.Side;

public class CoinLoader {
    
    public static Coin load(){
        String[] imagesNames = new String[]{"C:\\Users\\HP\\Desktop\\Proyectos\\ProyectosGráficos\\Sin Nombre.png",
                                            "C:\\Users\\HP\\Desktop\\TRABAJO\\cara.jpg",
                                            "C:\\Users\\HP\\Desktop\\TRABAJO\\cruz.jpg"};
        String[] soundsNames = new String[]{"C:\\Users\\HP\\Desktop\\TRABAJO\\cara.wav",
                                            "C:\\Users\\HP\\Desktop\\TRABAJO\\cruz.wav"};
        Coin coin = new Coin(Side.Edge, imagesNames, soundsNames);
        return coin;
    }
}

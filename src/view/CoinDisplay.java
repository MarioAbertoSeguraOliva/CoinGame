package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Coin;
import model.Coin.Side;
import model.Sound;

public class CoinDisplay extends JFrame{
    private final Coin coin;
    private final JTextField textField;
    private Image image;
    private final Sound sound;
    private SoundPLayer soundPlayer;
    
    public CoinDisplay(Coin coin){
        this.coin=coin;
        textField = createOutputInformation();
        image=coin.getImages()[0];
        sound=coin.getSound();
    }

    public void display(){
        setTitle("Coin Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 300);
        createComponents();
        setMinimumSize(new Dimension(400,400));
        setVisible(true);
    }
    
    private void createComponents() {
        add(createImagePanel(), BorderLayout.CENTER);
        add(createControlPanel(),BorderLayout.SOUTH);
    }

    private JPanel createImagePanel() {
        return new JPanel() {
        {
            getContentPane().addComponentListener(createComponentListener());
        }
        @Override
            public void paint(Graphics g) {
                super.paint(g); 
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }

            private ComponentListener createComponentListener() {
                return new ComponentListener() {

                    @Override
                    public void componentResized(ComponentEvent e) {
                        revalidate();
                    }

                    @Override
                    public void componentMoved(ComponentEvent e) {
                    }

                    @Override
                    public void componentShown(ComponentEvent e) {
                    }

                    @Override
                    public void componentHidden(ComponentEvent e) {
                    }
                };
            }
        };
    }

    private JPanel createControlPanel() {
        JPanel panel = new JPanel();
        panel.add(textField, BorderLayout.WEST);
        panel.add(throwButton(), BorderLayout.EAST);
        return panel;
    }

    private JTextField createOutputInformation() {
        JTextField text = new JTextField(coin.getSide().toString());
        text.setEditable(false);
        return text;
    }

    private JButton throwButton() {
        JButton button = new JButton("Throw Coin");
        button.addActionListener((ActionEvent e) -> {
            CalculatorSides calculatorSides = new CalculatorSides();
            update(coin, calculatorSides.calculateNextCoinState()); /*fix circular reference */
            this.textField.setText(coin.getSide().toString());
            if(coin.getSide()==Side.Head){ image = coin.getImages()[1]; repaint();
                                           new SoundPLayer(sound).getPlayer()[0].play();}
            if(coin.getSide()==Side.Tail){ image = coin.getImages()[2]; repaint();
                                           new SoundPLayer(sound).getPlayer()[1].play();}
            });
        return button;
    }
    
    public void update(Coin coin, Side side) {
        coin.setSide(side);
    }
}
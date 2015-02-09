package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Coin;
import model.Coin.Side;

public class CoinDisplay extends JFrame{
    private final Coin coin;
    private final JTextField textField;
    
    public CoinDisplay(Coin coin){
        this.coin=coin;
        textField = createOutputInformation();
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
                g.drawImage(coin.getImage(), 0, 0, getWidth(), getHeight(), null);
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
            update(coin, calculateNextCoinState());
            this.textField.setText(coin.getSide().toString());
        });
        return button;
    }
    
    public void update(Coin coin, Side side) {
        coin.setSide(side);
    }

    private Side calculateNextCoinState() {
        int coinState = (int) (Math.random()*50);
        if(coinState==50){
            return Side.Edge;
        }else if(coinState<25){
            return Side.Head;
        }else
            return Side.Tail;
    }
}
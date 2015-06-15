package kunya.snakegame;

import kunya.snakegame.objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @autor kuanysh
 * @since: 12.06.15
 */
public class SnakeGame extends JPanel implements ActionListener{

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int SPEED = 5;

    Snake s = new Snake(10, 10, 9, 10);
    Timer t = new Timer(1000/SPEED, this);

    public SnakeGame(){
        t.start();
    }

    public void paint(Graphics g){
        g.setColor(color(15, 50, 10));
        g.fillRect(0,0, WIDTH*SCALE, HEIGHT*SCALE);
        g.setColor(color(255, 216, 0));

        for (int xx = 0; xx <= WIDTH*SCALE; xx+=SCALE){
            g.drawLine(xx, 0, xx, HEIGHT * SCALE);
        }

        for (int yy = 0; yy <= HEIGHT*SCALE; yy+=SCALE){
            g.drawLine(0, yy, WIDTH * SCALE, yy);
        }


        for (int d = 0; d < s.length; d++){
            g.setColor(color(20, 30, 150));
            g.fillRect(s.snakeX[d]*SCALE+1, s.snakeY[d]*SCALE+1, SCALE-1, SCALE-1);
        }
    }

    public Color color(int red, int green, int blue){
        return new Color(red,green,blue);
    }

    public static void main(String[] args){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(WIDTH * SCALE+7, HEIGHT * SCALE+30);
        f.setLocationRelativeTo(null);
        f.add(new SnakeGame());
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        s.move();

        repaint();
    }
}

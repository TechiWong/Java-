package com.company;

import java.awt.*;
import javax.swing.*;

public class billiards extends JFrame{

    Image ball=Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk=Toolkit.getDefaultToolkit().getImage("images/desk.png");

    double x=428;
    double y=250;

    double degree=3.14/3;

    public void paint(Graphics g){
        System.out.println("画出窗口");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);

        x=x+10*Math.cos(degree);
        y=y+10*Math.sin(degree);

        if(y>501-40-30||y<40+40){
            degree=-degree;
        }
        if(x>856-40-30||x<40){
            degree=3.14-degree;
        }
    }

    void launchFrame(){
        setSize(856, 501);
        setLocation(200, 200);
        setVisible(true);

        while(true){
            repaint();
            try{
                Thread.sleep(40);   //1s = 1000ms; 大约1秒绘制1000/40=25次。
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        System.out.println("游戏开始");
        billiards game=new billiards();
        game.launchFrame();
    }
}
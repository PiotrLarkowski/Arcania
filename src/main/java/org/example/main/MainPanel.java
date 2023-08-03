package org.example.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MainPanel extends JPanel implements Runnable {

    //player default position
    public int playerX = 100;
    public int playerY = 100;
    public int playerSpeed = 4;
    public int mousePositionX = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
    public int mousePositionY = Toolkit.getDefaultToolkit().getScreenSize().height / 2;
    public int FPS = 60;

    Thread mainThread;
    KeyHandler keyHandler = new KeyHandler();
    MouseHandler mouseHandler = new MouseHandler();

    public MainPanel() {
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        this.setFocusable(true);
    }

    public void startMainThread() {
        mainThread = new Thread(this);
        mainThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long time = 0;
        long drawCount = 0;
        while (mainThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            time += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta > 1) {

                //UPDATE
                Update();
                //DRAW
                repaint();
                delta--;
                drawCount++;
            }
            //Print on console FPS
            if (time >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                time = 0;
            }
        }
    }

    public void Update() {
        if (mouseHandler.mouseMoved) {
            mousePositionX = mouseHandler.mousePositionX;
            mousePositionY = mouseHandler.mousePositionY;
            mouseHandler.mouseMoved = false;
        }
        if (keyHandler.upPressed) {
            playerY -= playerSpeed;
        } else if (keyHandler.downPressed) {
            playerY += playerSpeed;
        } else if (keyHandler.rightPressed) {
            playerX += playerSpeed;
        } else if (keyHandler.leftPressed) {
            playerX -= playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(mousePositionX, mousePositionY, 50, 50);
        g2.dispose();
    }


}
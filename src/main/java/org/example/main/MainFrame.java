package org.example.main;

import javax.swing.JFrame;

public class MainFrame {
    public static void main(String[] args){

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setUndecorated(true);
        window.setTitle("Arcania");

        MainPanel mainPanel = new MainPanel();
        window.add(mainPanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        mainPanel.startMainThread();

    }
}
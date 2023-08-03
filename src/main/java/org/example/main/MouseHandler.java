package org.example.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {
    public MouseEvent event;
    int mousePositionX = 0;
    int mousePositionY = 0;
    public boolean mouseMoved;
    @Override
    public void mouseClicked(MouseEvent e) {
        event = e;
        System.out.println("mouseClicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousePositionX = e.getX();
        mousePositionY = e.getY();
        mouseMoved = true;
    }
}

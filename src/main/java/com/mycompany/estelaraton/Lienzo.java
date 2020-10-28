/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estelaraton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JPanel;

/**
 *
 * @author AZAEL
 */
public class Lienzo extends JPanel{
    private Queue<Point> points= new LinkedList<Point>();
    private int[] colores= new int[]{0,0};
    private final Color[] rainbow= new Color[]{Color.red,Color.orange,Color.yellow,Color.green,
        Color.BLUE,Color.getHSBColor(75, 0, 130),Color.getHSBColor(128, 0, 128)};
    private int counter=0;
    public Lienzo(){
        super();
        setColors();
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setColors();
        for (Point point : points) {
            g.fillOval(point.x, point.y, 10, 10);
        }
    }
    
    public void addPoint(int x, int y){
        if(points.size()>=5) points.poll();
        points.add(new Point(x,y));
    }
    
    public void setBack(int opt){
        this.colores[0]=opt;
        this.repaint();
    }
    
    public void setFront(int opt){
        this.colores[1]=opt;
        this.repaint();
    }

    private Color rainbowNextColor() {
        if(counter==12) counter=0;
        else counter++;
        System.out.println(counter%7);
        return rainbow[counter%7];
    }

    private void setColors()  {
        switch(colores[0]){
            case 0:this.setBackground(Color.white);
                break;
            case 1:this.setBackground(Color.gray);
                break;
            case 2:this.setBackground(Color.BLACK);
                break;
        }
        switch(colores[1]){
            case 0:this.setForeground(Color.red);
                break;
            case 1:this.setForeground(Color.green);
                break;
            case 2:this.setForeground(Color.yellow);
                break;
            case 3:this.setForeground(rainbowNextColor());
                break;
        }
    }

    void reset() {
        points.clear();
        this.repaint();
    }
    
}
        
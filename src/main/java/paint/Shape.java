/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Merna
 */
public interface Shape extends Moveable {
    public void setPosition(Point position);
    public Point getPosition();
    public void setColor(Color color);
    public Color getColor();
    public void setFillColor(Color color);
    public Color getFillColor();
    public void draw(Graphics canvas);
    public String getName_key();
    public void setShapeName(String shapeName); 
   
}

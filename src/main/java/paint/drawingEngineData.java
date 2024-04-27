/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Merna
 */
public class drawingEngineData extends JPanel implements DrawingEngine {
    private final ArrayList<Shape> shapes = new ArrayList<>();
    private final ArrayList<Shape> corners=new ArrayList<>();
public Shape[] getCorners()
{
    return corners.toArray(Shape[]::new);
}

    @Override
    public Shape[] getShapes() {
        
        return shapes.toArray(new Shape[0]);
    }

    @Override
    public void paintComponent(Graphics canvas) {
        super.paintComponent(canvas);

        for (Shape shape : shapes) {
            shape.draw(canvas);
        }
        for (Shape shape : corners) {
            shape.draw(canvas);
        }
    }

    public void refresh() {
        this.repaint();
    }

    @Override
    public void refresh(Graphics g) {
        this.refresh();
    }

    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        shapes.removeIf(currentShape -> currentShape.getName_key().equals(shape.getName_key()));
    }
    public void drawCorners(Point[]points)
    {
        for(Point p: points)
        {
          Rectangle rec=new Rectangle(new Point(p.x-5,p.y-5),10,10);
            rec.setFillColor(Color.yellow);
            corners.add(rec);
         
        }
        refresh();
    }
public void deleteCorners()
{
    corners.clear(); 
}

}

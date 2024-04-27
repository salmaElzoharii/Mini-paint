/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paint;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import static java.lang.Math.abs;
//import org.json.JSONObject;

/**
 *
 * @author Merna
 */
public class Triangle extends Shapes implements Shape {

    private Point point2;
    private Point point3;
private Point[] corners=new Point[3];
    public Triangle(Point position, Point point2, Point point3) {
        super(position);
        this.point2 = point2;
        this.point3 = point3;
    }

    public Point[] getCorners() {
        return corners;
    }

    public void setCorners() {
    corners[0]=this.getPosition();
    corners[1]=this.getPoint2();
    corners[2]=this.getPoint3();
    
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }
    

    @Override
    public void draw(Graphics canvas) {
        int [] x={(int) getPosition().x,(int) point2.getX(),(int) point3.getX()};
        int [] y={(int) getPosition().y,(int) point2.getY(),(int) point3.getY()};
        Polygon p = new Polygon(x, y, 3);
        if (getFillColor() != null) {
            canvas.setColor(getFillColor());
            canvas.fillPolygon(p);
        }

        canvas.setColor(getColor());
        canvas.drawPolygon(p);
    }

    @Override
    public boolean contains(Point point) {
        int x1=(int)getPosition().x;
        int y1=(int)getPosition().y;
        int x2=(int)point2.getX();
        int y2=(int)point2.getY();
         int x3=(int)point3.getX();
        int y3=(int)point3.getY();
        int[] x={x1,x2,x3};
        int []y={y1,y2,y3};
        Polygon polygon= new Polygon(x,y,3);
        return polygon.contains(point);
  
    }

    @Override
    public void moveTo(Point point) {
        int x=point.x-getDraggingPoint().x;
        int y=point.y-getDraggingPoint().y;
        Point p1=new Point(x+getPosition().x,y+getPosition().y);
        setPosition(p1);
        Point p2=new Point(x+point2.x,y+point2.y);
        setPoint2(p2);
        Point p3=new Point(x+point3.x,y+point3.y);
        setPoint3(p3);
    }
public void resize(Point corner, Point to) {
    Point[] points = this.getCorners();
               corner.x=corner.x+5;corner.y=corner.y+5;
        if (corner.x == points[0].x && corner.y == points[0].y)
        {
            setPosition(to);
        }
        if (corner.x == points[1].x && corner.y == points[1].y)
        {
            this.setPoint2(to);
        }
         if (corner.x == points[2].x && corner.y == points[2].y)
        {
            this.setPoint3(to);
        }
}
    //@Override
   /* public JSONObject Json() {
         JSONObject json=super.Json();
        json.put("point2_x",point2.x);
        json.put("point2_y",point2.y);
        json.put("point3_x",point3.x);
        json.put("point3_y",point3.y);
        return json;
    }*/
    

}

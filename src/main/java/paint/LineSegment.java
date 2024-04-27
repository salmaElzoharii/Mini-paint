/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paint;

import java.awt.Graphics;
import java.awt.Point;
//import org.json.JSONObject;

/**
 *
 * @author Merna
 */
public class LineSegment extends Shapes implements Shape {

    
  private Point point2;
  private Point[] corners=new Point[2];

   

    public LineSegment(Point point1,Point point2) {
        super(point1 );
        this.point2=point2;
        
    }
    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }
    
    public Point[] getCorners() {
        return corners;
    }

    public void setCorners() {
    corners[0]=this.getPosition();
    corners[1]=this.getPoint2();
   
    
    }
    @Override
    public void draw(Graphics canvas) {
       canvas.setColor(getColor());
       canvas.setColor(getFillColor());
        canvas.drawLine((int)getPosition().x,(int)getPosition().y,(int)point2.getX(),(int)point2.getY());
    }

    @Override
    public boolean contains(Point point) {
        int x1=(int)getPosition().x;
        int y1=(int)getPosition().y;
        int x2=(int)point2.getX();
        int y2=(int)point2.getY();
        int x3= (int) point.getX();
        int y3= (int) point.getY();
               
       double triangleArea = 0.5*(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
      return triangleArea==0;
    }
    

    @Override
    public void moveTo(Point point) {
         int x=point.x-getDraggingPoint().x;
        int y=point.y-getDraggingPoint().y;
         Point p1=new Point(x+getPosition().x,y+getPosition().y);
        setPosition(p1);
        Point p2=new Point(x+point2.x,y+point2.y);
        setPoint2(p2);
    }
public void resize(Point corner, Point to) {
    Point[] points = this.getCorners();
    
         corner.x=corner.x+5;corner.y=corner.y+5;
    if (corner.x == points[0].x && corner.y == points[0].y)
        {
          System.out.println(corner.x+"cornerrr"+corner.y);
        System.out.println(points[0].x+"sent point"+points[0].y);  
            this.setPosition(to);
        }
        if (corner.x == points[1].x && corner.y == points[1].y)
        {
           System.out.println(corner.x+"cornerrr"+corner.y);
        System.out.println(points[1].x+"sent point"+points[1].y);   
            this.setPoint2(to);
        }
}

    //@Override
    /*public JSONObject Json() {
        JSONObject json=super.Json();
        json.put("point2_x",point2.x);
        json.put("point2_y",point2.y);
        return json;
    }*/
    
}

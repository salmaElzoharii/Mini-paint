 package paint;

import java.awt.Graphics;
import java.awt.Point;
//import org.json.JSONObject;

public class Circle extends Shapes implements Shape {
 private  int h_radius;
 private  int v_radius;
private Point[] corners=new Point[4];

    public Point[] getCorners() {
        return corners;
    }

    public void setCorners() {
        corners[0]= this.getPosition();//topleft
        corners[1]=new Point(getPosition().x,getPosition().y+(2*v_radius));//bottomLeft
        corners[2]=new Point(getPosition().x+(2*h_radius),getPosition().y);//Topright
        corners[3]=new Point(getPosition().x+(2*h_radius),getPosition().y+(2*v_radius));//bottomRight
    }

    public Circle(Point point,int h_radius,int v_radius) {
        super(point);
        this.setH_radius(h_radius);
        this.setV_radius(v_radius);
     
    }

    public int getH_radius() {
        return h_radius;
    }

    public void setH_radius(int h_radius) {
        this.h_radius = h_radius;
    }

    public int getV_radius() {
        return v_radius;
    }

    public void setV_radius(int v_radius) {
        this.v_radius = v_radius;
    }

    @Override
public void draw(Graphics canvas) {

        if(getFillColor()!=null){ canvas.setColor(getFillColor());
            canvas.fillOval((int)getPosition().x, (int)getPosition().y, 2*h_radius, 2*v_radius);}

        canvas.setColor(getColor());
        canvas.drawOval((int)getPosition().x, (int)getPosition().y, 2*h_radius, 2*v_radius);
    }

    @Override
    public boolean contains(Point point) {
       int x=((int) point.getX()-((int)getPosition().x+h_radius));
       int y=((int) point.getY()-(int)getPosition().y-v_radius);
     return (((x*x)+(y*y)<=h_radius*v_radius));
    }

    @Override
    public void moveTo(Point point) {
         int x=point.x-getDraggingPoint().x;
        int y=point.y-getDraggingPoint().y;
         Point p1=new Point(x+getPosition().x,y+getPosition().y);
        setPosition(p1);
    }
   public void resize(Point corner, Point to) {
        Point[] points = this.getCorners();
        int x = 0;
        int y = 0;
        corner.x = corner.x + 5;
        corner.y = corner.y + 5;

        int index = 0;
        if (corner.x == points[0].x && corner.y == points[0].y) {
            //if(corner.equals(points[0])) {
            x = corner.x - to.x;
            y = corner.y - to.y;
            setPosition(to);
            System.out.println("in top left");
        }
        if (corner.x == points[1].x && corner.y == points[1].y) {

            //if (corner.equals(points[1])) {
            x = corner.x - to.x;
            y = to.y - corner.y;
            index = 1;
            Point p = new Point(to.x, to.y - 2*v_radius);
            setPosition(p);
        }
        if (corner.x == points[2].x && corner.y == points[2].y) {
            System.out.println(corner.x+"cornerr "+corner.y);
            System.out.println(points[2].x+"point sent "+points[2].y);
            // if (corner.equals(points[2])) {
            x = to.x - corner.x;
            y = corner.y - to.y;
            index = 2;
            Point p = new Point(to.x -2*h_radius, to.y);
            setPosition(p);
        }
        if (corner.x == points[3].x && corner.y == points[3].y) {

            // if (corner.equals(points[3])) {
            x = to.x - corner.x;
            y = to.y - corner.y;
            index = 3;
            Point p = new Point(to.x -2*h_radius, to.y - 2*v_radius);
            setPosition(p);
        }
        this.setH_radius(Math.abs(h_radius+x));
        this.setV_radius(Math.abs(v_radius+x));
        //  width = Math.abs(width + x);
        // length = Math.abs(length + y);
       // return getCorners()[index];
    }


    //@Override
   /* public JSONObject Json() {
        JSONObject json=super.Json();
        json.put("horizontal_radius",h_radius);
        json.put("vertical_radius",v_radius);
        return json;
         
       
    }*/

   
}


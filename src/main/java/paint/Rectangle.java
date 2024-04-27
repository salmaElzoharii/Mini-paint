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
public class Rectangle extends Shapes implements Shape {

    private int length;
    private int width;
    private Point[] corners = new Point[4];

    public Point[] getCorners() {
        return corners;
    }

    public void setCorners() {
        corners[0] = new Point(this.getPosition().x,this.getPosition().y);//top left
        corners[1] = new Point(corners[0].x, corners[0].y + this.getLength());//bottom left
        corners[2] = new Point(corners[0].x + this.getWidth(), corners[0].y);//TOP RIGHT
        corners[3] = new Point(corners[0].x + this.getWidth(), corners[0].y + this.getLength());//bottom right

    }

    public Rectangle(Point point, int length, int width) {
        super(point);
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void draw(Graphics canvas) {
        if (getFillColor() != null) {
            canvas.setColor(getFillColor());
            canvas.fillRect((int) getPosition().x, (int) getPosition().y, width, length);
        }

        canvas.setColor(getColor());
        canvas.drawRect((int) getPosition().x, (int) getPosition().y, width, length);

    }

    @Override
    public boolean contains(Point point) {
        Point p1 = new Point(getPosition().x, getPosition().y);
        Point p2 = new Point(getPosition().x + width, getPosition().y + length);
        if (point.x >= p1.x && point.x <= p2.x && point.y >= p1.y && point.y <= p2.y) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void moveTo(Point point) {
        int x = point.x - getDraggingPoint().x;
        int y = point.y - getDraggingPoint().y;
        Point p1 = new Point(x + getPosition().x, y + getPosition().y);
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
            Point p = new Point(to.x, to.y - length);
            setPosition(p);
        }
        if (corner.x == points[2].x && corner.y == points[2].y) {
            System.out.println(corner.x+"cornerr "+corner.y);
            System.out.println(points[2].x+"point sent "+points[2].y);
            // if (corner.equals(points[2])) {
            x = to.x - corner.x;
            y = corner.y - to.y;
            index = 2;
            Point p = new Point(to.x - width, to.y);
            setPosition(p);
        }
        if (corner.x == points[3].x && corner.y == points[3].y) {

            // if (corner.equals(points[3])) {
            x = to.x - corner.x;
            y = to.y - corner.y;
            index = 3;
            Point p = new Point(to.x - width, to.y - length);
            setPosition(p);
        }
        this.setWidth(Math.abs(width + x));
        this.setLength(Math.abs(length + y));
      
    }

    /*@Override
    public JSONObject Json(){
       JSONObject json=super.Json();
        json.put("length",length);
        json.put("width",width);
        return json;
    }
     */
}

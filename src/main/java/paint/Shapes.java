/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paint;
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
//import org.json.JSONObject ; 


/**
 *
 * @author Merna
 */
public abstract class Shapes implements Shape,Moveable{
     private Point position;
     private Point draggingPoint;
    private Color color; 
    private Color fillcolor; 
    private String name_key;
    private String ShapeName;
    static int key=1;

    public Shapes(Point position) {
        this.position = position;
        //this.color = new Color(color.BLACK.getRGB());
        //this.fillcolor = new Color(color.WHITE.getRGB());
        
    }
    

    @Override
   public void setPosition(Point position)
   {
       this.position = position;
   }
    @Override
    public Point getPosition()
    {
        
       return position  ;
        
    }
    @Override
    public void setColor(Color color)
    {
        this.color = color;
    }
    @Override
    public Color getColor()
    {
        
   return this.color == null ? Color.black : this.color;
        
    }
    @Override
    public void setFillColor(Color color)
    {
        this.fillcolor = color;
    }
    @Override
    public Color getFillColor()
    {
        
       return fillcolor;
        
    }
    @Override
    public abstract void draw(Graphics canvas);
      
    public void generateKey(){
       name_key=ShapeName+"_"+String.format("%02d",key++);
    }
    @Override
    public String getName_key() {
        return name_key;
    }
    @Override
    public void setShapeName(String shapeName) {
        ShapeName = shapeName;
    }

     @Override
    public Point getDraggingPoint() {
        return draggingPoint;
    }

     @Override
    public void setDraggingPoint(Point draggingPoint) {
        this.draggingPoint = draggingPoint;
    }

    @Override
     public abstract  boolean contains(Point point);
   
    @Override
    public abstract  void moveTo(Point point);
    
   /* public JSONObject Json() 
    { 
        JSONObject jsonobject=new JSONObject();
        jsonobject.put("SHAPE_KEY",getName_key());
        jsonobject.put("position_x",getPosition().getX());
        jsonobject.put("position_y",getPosition().getY());
        jsonobject.put("color",color.getRGB());
        jsonobject.put("color",fillcolor.getRGB());
         return jsonobject;
        
        
    }*/
    
}

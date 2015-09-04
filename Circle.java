import java.awt.*;import javax.swing.*;
public class Circle extends Shape
{
       private Point midpoint;
       private double radius;
       
       public Circle(Point x, double y)
       {
              midpoint=x;
              if(y>0.0)
                       radius=y;
              else
                       radius=0.0;
       }

       public Point getMidpoint()
       {
              return midpoint;
       }

       public double getRadius()
       {
              return radius;
       }
       
       public void setMidpoint(Point x)
       {
              midpoint=x;
       }
       
       public void move(double dx, double dy)
       {
              midpoint.move(dx,dy);
       }

       public String toString()
       {
              return "<Circle("+midpoint+","+radius+")>";
       }
       
       public void paint(Graphics g)
       {
              super.paint(g);
              //Zet de x-coordinaat, y-coordinaat en straal over in integers
              int x=(int)midpoint.getX();
              int y=(int)midpoint.getY();
              int r=(int)radius;
              //Tekent een ovaal gebaseert op het gegeven middelpunt, met de breedte een 
              //hoogte gelijk aan 2 keer de straal
              g.drawOval(x-r,y-r,2*r,2*r);
       }
       
       public Point getPoint1()
       {
              return new Point(getMidpoint().getX(),getMidpoint().getY()+radius);
       }

       public Point getPoint2()
       {
              return new Point(getMidpoint().getX(),getMidpoint().getY()+radius);
       }
}
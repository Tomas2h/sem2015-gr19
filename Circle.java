import java.awt.*;import javax.swing.*;
public class Circle extends Shape
{
       private Point Midpoint;
       private double radius;
       
       public Circle(Point x, double y)
       {
              Midpoint=x;
              if(y>0.0)
                       radius=y;
              else
                       radius=0.0;
       }

       public Point getMidpoint()
       {
              return Midpoint;
       }

       public double getRadius()
       {
              return radius;
       }
       
       public void setMidpoint(Point x)
       {
              Midpoint=x;
       }
       
       public void Move(double dx, double dy)
       {
              Midpoint.Move(dx,dy);
       }

       public String toString()
       {
              return "<Circle("+Midpoint+","+radius+")>";
       }
       
       public void paint(Graphics g)
       {
              super.paint(g);
              //Zet de x-coordinaat, y-coordinaat en straal over in integers
              int x=(int)Midpoint.getX();
              int y=(int)Midpoint.getY();
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
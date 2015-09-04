import java.awt.*;import javax.swing.*;
public class Triangle extends Shape
{
       private Point Midpoint;
       private double dist;
       
       public Triangle(Point x, double y)
       {
              Midpoint=x;
              if(y>0.0)
                    dist=y;
              else
                    dist=0.0;
       }
       
       public Point[] Equilaterate()
       {
              Point[] res=new Point[3];
              res[0]=new Point(Midpoint.getX(), Midpoint.getY()-dist);
              res[1]=new Point(Midpoint.getX()-dist*(Math.sqrt(3)/2), Midpoint.getY()+(dist/2));
              res[2]=new Point(Midpoint.getX()+dist*(Math.sqrt(3)/2), Midpoint.getY()+(dist/2));
              return res;
       }
       
       public Point getPoint1()
       {
              Point[] res=Equilaterate();
              return res[0];
       }
       
       public Point getPoint2()
       {
              Point[] res=Equilaterate();
              return res[1];
       }

       public Point getPoint3()
       {
              Point[] res=Equilaterate();
              return res[2];
       }
       
       public void Move(double dx,double dy)
       {
              Midpoint.Move(dx,0);
       }

       public String toString()
       {
              Point[] res=Equilaterate();
              return "<Driehoek("+res[0]+","+res[1]+","+res[2]+")>";
       }
       
       public void paint(Graphics g)
       {
              super.paint(g);
              //Zet de x-coordinaten en y-coordinaten over in integers
              Point[] res=Equilaterate();
              int x1=(int)res[0].getX();
              int y1=(int)res[0].getY();
              int x2=(int)res[1].getX();
              int y2=(int)res[1].getY();
              int x3=(int)res[2].getX();
              int y3=(int)res[2].getY();
              //Tekent de lijnen tussen de drei punten
              g.drawLine(x1,y1,x2,y2);
              g.drawLine(x1,y1,x3,y3);
              g.drawLine(x3,y3,x2,y2);
       }
}
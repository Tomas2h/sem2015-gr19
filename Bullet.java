import java.awt.*;import javax.swing.*;
public class Bullet extends Shape
{
       private Point origin;
       
       public Bullet(Point x)
       {
              origin=x;
       }
       
       public Point[] Shaper()
       {
              Point[] res=new Point[4];
              res[0]=new Point(origin.getX()-2,origin.getY()+10);
              res[1]=new Point(origin.getX()+2,origin.getY()+10);
              res[2]=new Point(origin.getX()+2,origin.getY()-10);
              res[3]=new Point(origin.getX()-2,origin.getY()-10);
              return res;
       }

       public Point getPoint1()
       {
              Point[] res=Shaper();
              return res[0];
       }
       
       public Point getPoint2()
       {
              Point[] res=Shaper();
              return res[1];
       }

       public Point getPoint3()
       {
              Point[] res=Shaper();
              return res[2];
       }

       public Point getPoint4()
       {
              Point[] res=Shaper();
              return res[3];
       }
       
       public void Move(double dx,double dy)
       {
              origin.Move(0,dy);
       }

       public String toString()
       {
              Point[] res=Shaper();
              return "<Bullet("+res[0]+","+res[1]+","+res[2]+","+res[3]+")>";
       }

       public void paint(Graphics g)
       {
              super.paint(g);
              //Zet de x-coordinaten en y-coordinaten over in integers
              Point[] res=Shaper();
              int x1=(int)res[0].getX();
              int y1=(int)res[0].getY();
              int x2=(int)res[1].getX();
              int y2=(int)res[1].getY();
              int x3=(int)res[2].getX();
              int y3=(int)res[2].getY();
              int x4=(int)res[3].getX();
              int y4=(int)res[3].getY();
              //Tekent de lijnen tussen de drei punten
              g.drawLine(x1,y1,x2,y2);
              g.drawLine(x2,y2,x3,y3);
              g.drawLine(x3,y3,x4,y4);
              g.drawLine(x1,y1,x4,y4);
       }
}
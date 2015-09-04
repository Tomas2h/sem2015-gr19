import java.awt.*;import javax.swing.*;
public abstract class Shape extends JFrame
{
       public abstract void Move(double dx, double dy);
       public abstract Point getPoint1();
       public abstract Point getPoint2();
       
       public void paint(Graphics g){}
}
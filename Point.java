public class Point
{
       private double x;
       private double y;

       public Point(double xCoor,double yCoor)
       {
              x=xCoor;
              y=yCoor;
       }
       
       public double getX()
       {
              return x;
       }
       
       public double getY()
       {
              return y;
       }
       
       public String toString()
       {
              return "<Point("+x+", "+y+")>";
       }
       
       public void move(double dx, double dy)
       {
              x=x+dx;
              y=y+dy;
       }

       public double distance(Point that)
       {
              double x1=this.getX();
              double y1=this.getY();
              double x2=that.getX();
              double y2=that.getY();
              return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
       }
       
}
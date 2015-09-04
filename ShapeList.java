import java.awt.*;import javax.swing.*;
public class ShapeList extends JFrame
{
       private Shape[] shapes;
       private int N;
       
       public ShapeList(int capacity)
       {
              N=0;
              if(capacity>0)
              {
                    shapes=new Shape[capacity];
              }
              else
              {
                    shapes=new Shape[0];
              }
       }

       public int getAmount()
       {
              return N;
       }
       
       public int getLength()
       {
              return shapes.length;
       }
       
       public void add(Shape v)
       {
              if(N<shapes.length)
              {
                    shapes[N]=v;
                    N=N+1;
              }
              else
              {
                  System.out.println("The Shapelist has reached its capacity");
              }
       }
       
       //public void Delete(Shape v)
       //{
       //
       //}
       
       public Shape get(int i)
       {
              if(0<=i&&i<N)
              {
                    return shapes[i];
              }
              else
              {
                    return null;
              }
       }

      public void set(int i,Shape v)
      {
              if(0<=i&&i<N)
              {
                    shapes[i]=v;
                    //System.out.println(Shapes[i].toString());
              }
      }

      public int index(Shape v)
      {
              for(int i=0;i!=shapes.length;i++)
              {
                    if(shapes[i]==v)
                    {
                          return i;
                    }
              }
              return -1;
      }
      
      public void move(double dx, double dy)
      {
              for(int i=0;i!=N;i++)
              {
                    shapes[i].move(dx,dy);
              }
      }
      
      public String toString()
      {
             String res="<ShapeList[";
             for(int i=0;i<N;i++)
             {
                    if(i==0)
                    {
                            res=res+shapes[i].toString();
                    }
                    else
                    {
                            res=res+","+shapes[i].toString();
                    }
             }
             res=res+"]>";
             return res;
      }

      public void paint(Graphics g)
      {
             for(int i=0;i!=N;i++)
             {
                     shapes[i].paint(g);
             }
      }
}
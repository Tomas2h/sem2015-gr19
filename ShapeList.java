import java.awt.*;import javax.swing.*;
public class ShapeList extends JFrame
{
       private Shape[] Shapes;
       private int N;
       
       public ShapeList(int capacity)
       {
              N=0;
              if(capacity>0)
                    Shapes=new Shape[capacity];
              else
                    Shapes=new Shape[0];
       }

       public int getAmount()
       {
              return N;
       }
       
       public int getLength()
       {
              return Shapes.length;
       }
       
       public void Add(Shape v)
       {
              if(N<Shapes.length)
              {
                    Shapes[N]=v;
                    N=N+1;
              }
              else
                  System.out.println("The Shapelist has reached its capacity");
       }
       
       //public void Delete(Shape v)
       //{
       //
       //}
       
       public Shape Get(int i)
       {
              if(0<=i&&i<N)
              {
                    return Shapes[i];
              }
              else
                    return null;
       }

      public void Set(int i,Shape v)
      {
              if(0<=i&&i<N)
              {
                    Shapes[i]=v;
                    //System.out.println(Shapes[i].toString());
              }
      }

      public int Index(Shape v)
      {
              for(int i=0;i!=Shapes.length;i++)
              {
                    if(Shapes[i]==v)
                    {
                          return i;
                    }
              }
              return -1;
      }
      
      public void Move(double dx, double dy)
      {
              for(int i=0;i!=N;i++)
              {
                    Shapes[i].Move(dx,dy);
              }
      }
      
      public String toString()
      {
             String res="<ShapeList[";
             for(int i=0;i<N;i++)
             {
                    if(i==0)
                            res=res+Shapes[i].toString();

                    else
                            res=res+","+Shapes[i].toString();
             }
             res=res+"]>";
             return res;
      }

      public void paint(Graphics g)
      {
             for(int i=0;i!=N;i++)
             {
                     Shapes[i].paint(g);
             }
      }
}
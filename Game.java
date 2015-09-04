import java.awt.*;import java.awt.event.*;import javax.swing.*;import java.util.Timer;import java.util.TimerTask;
public class Game extends JFrame implements KeyListener
{
       //private Point POrigin;
       //private Triangle P;
       //private Circle A;
       private ShapeList Shapes;
       private Timer timer=new Timer();
       private boolean Projectile=false;

       public Game(ShapeList S)
       {
              Shapes=S;
              setTitle("Space Invaders");
              setBounds(0,0,500,500);
              Container c=getContentPane();
                   c.setBackground(Color.black);
                   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   setVisible(true);
                   addKeyListener(this);
       }
       
       public void paint (Graphics g)
       {
              super.paint(g);
              g.setColor(Color.white);
              Shapes.paint(g);
       }

       public void keyReleased(KeyEvent e){}
       public void keyTyped(KeyEvent e){}

       public void keyPressed(KeyEvent e)
       {
              if(e.getKeyCode()==KeyEvent.VK_LEFT)
              {
                    Shapes.Get(0).Move(-10.0,0.0);
                    repaint();
              }
              if(e.getKeyCode()==KeyEvent.VK_RIGHT)
              {
                    Shapes.Get(0).Move(10.0,0.0);
                    repaint();
              }
              
              if(e.getKeyCode()==KeyEvent.VK_UP)
              {
                    Point BOrigin=Shapes.Get(0).getPoint1();
                    Bullet B=new Bullet(BOrigin);
                    Shapes.Add(B);
                    repaint();
                    Projectile=true;
              }
       }

       public static void main (String[] args)
       {
              Point POrigin=new Point(250,460);
              Triangle P=new Triangle(POrigin,20);

              Point AOrigin=new Point(250,60);
              Circle A=new Circle(AOrigin,20);

              ShapeList Chars=new ShapeList(3);
              Chars.Add(P);
              Chars.Add(A);

              new Game(Chars);
       }

}
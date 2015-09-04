import java.awt.*;import java.awt.event.*;import javax.swing.*;import java.util.Timer;import java.util.TimerTask;
public class Game extends JFrame implements KeyListener
{
       //private Point POrigin;
       //private Triangle P;
       //private Circle A;
       private ShapeList shapes;
       private Timer timer=new Timer();
       private boolean projectile=false;

       public Game(ShapeList list)
       {
              shapes=list;
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
              shapes.paint(g);
       }

       public void keyReleased(KeyEvent e){}
       public void keyTyped(KeyEvent e){}
       public void keyPressed(KeyEvent e)
       {
              if(e.getKeyCode()==KeyEvent.VK_LEFT)
              {
                    shapes.get(0).move(-10.0,0.0);
                    repaint();
              }
              if(e.getKeyCode()==KeyEvent.VK_RIGHT)
              {
                    shapes.get(0).move(10.0,0.0);
                    repaint();
              }
              
              if(e.getKeyCode()==KeyEvent.VK_UP)
              {
                    Point bOrigin=shapes.get(0).getPoint1();
                    Bullet b=new Bullet(bOrigin);
                    shapes.add(b);
                    repaint();
                    projectile=true;
              }
       }

       public static void main (String[] args)
       {
              Point pOrigin=new Point(250,460);
              Triangle p=new Triangle(pOrigin,20);

              Point aOrigin=new Point(250,60);
              Circle a=new Circle(aOrigin,20);

              ShapeList chars=new ShapeList(3);
              chars.add(p);
              chars.add(a);

              new Game(chars);
       }

}
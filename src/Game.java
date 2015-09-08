import javafx.application.Application;

//import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.*;
//import javafx.scene.control.*;
//import javafx.scene.effect.*;
import javafx.scene.input.*;
//import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.scene.text.Text;

import javafx.animation.*;
//import javafx.geometry.*;
import javafx.stage.*;
import javafx.util.Duration;


public class Game extends Application
{
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("Space Invaders");
		Group root=new Group();
		
		Group antagonists=new Group();
		for(int i=0;i<2;i++)
		{
			Circle circle=new Circle(15,Color.web("white",1));
			circle.setStrokeType(StrokeType.OUTSIDE);
			circle.setStroke(Color.web("red",1));
			circle.setStrokeWidth(4);
			circle.setCenterX(300);
			circle.setCenterY(40);
			antagonists.getChildren().add(circle);
		}
		
		Rectangle protagonist=new Rectangle(30,30,Color.WHITE);
		protagonist.setX(281);
		protagonist.setY(560);
		protagonist.setStrokeType(StrokeType.OUTSIDE);
		protagonist.setStroke(Color.web("blue",1));
		protagonist.setStrokeWidth(4);
		
		root.getChildren().add(antagonists);
		root.getChildren().add(protagonist);
		
		Scene scene=new Scene(root,600,600,Color.BLACK);
		moveProtagonist(scene, protagonist, root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
	private void moveProtagonist(Scene scene, Rectangle protagonist, Group group) 
	{
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() 
		{
		      @Override 
		      public void handle(KeyEvent event) 
		      {
		    	  switch (event.getCode()) 
		    	  { 
		          		case RIGHT: protagonist.setX(protagonist.getX()+15); break;
		          		case LEFT:  protagonist.setX(protagonist.getX()-15); break;
		          		case UP: Rectangle bullet=new Rectangle(6,15,Color.WHITE);
		          			bullet.setX(protagonist.getX()+12);
		          			bullet.setY(protagonist.getY());
		          			bullet.setStrokeType(StrokeType.OUTSIDE);
		          			bullet.setStroke(Color.web("yellow",1));
		          			group.getChildren().add(bullet);
					
		          			Timeline timeline=new Timeline();
		          			KeyFrame keyframe=new KeyFrame(Duration.seconds(5),new KeyValue(bullet.yProperty(), -560));
		          			timeline.getKeyFrames().add(keyframe);
		          			timeline.play();
		       
		          			collision(bullet,protagonist,group);
		          			
		    	  }
		      }
		 });
	}
	
	public void collision(Rectangle bullet,Rectangle protagonist,Group group)
	{
			for(Node component:group.getChildren())
			{						
							if(bullet.getBoundsInParent().intersects(component.getBoundsInParent()))
							{
								if(component!=bullet&&component!=protagonist)
								{
									group.getChildren().remove(component);
									group.getChildren().remove(bullet);
								}
							}
			}
	}
}

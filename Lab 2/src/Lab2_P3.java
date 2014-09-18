import RobotClient.CreateClient;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.util.Scanner;

public class Lab2_P3
{
	
    public static void main(String[] args) 
    {
    	
        // Instantiate the robot and robot GUI
        CreateClient myRobot = new CreateClient("EGN3060 Robot","10.0.0.10");
        
        myRobot.waitForPlay();
        myRobot.initialize();
        
        smoothCurve(myRobot);
       
    }

    public static void squareSpiral(int x, CreateClient i) 
    {
    	int y = 100;
		for(;x>0;x--)
		{
			i.moveDistance(y);
			i.moveAngle(90);
			y += 100;
		}
    }
    
    public static void smoothCurve(CreateClient i)
    {
    	long x, y;
    	
    	while(i.isPlaying())
    	{
    		x = System.currentTimeMillis();
    		y = 0;
    		
			while(y < 4000)
			{
				i.moveMotors(200,100);
				i.sleepUnlessStop(200);
				y = System.currentTimeMillis() - x;
			}
			
			x = System.currentTimeMillis();
			y = 0;
			
			while(y < 4000)
			{
				i.moveMotors(100,200);
				i.sleepUnlessStop(200);
				y = System.currentTimeMillis() - x;
			}
			
    	}
		i.stopMoving();
   	
    }
}


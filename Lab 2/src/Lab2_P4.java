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

public class Lab2_P4
{
	
    public static void main(String[] args) 
    {
        // Instantiate the robot and robot GUI
        CreateClient myRobot = new CreateClient("EGN3060 Robot","10.0.0.10");
        
        myRobot.waitForPlay();
        myRobot.initialize();
        
        while(myRobot.isPlaying())
        {
        	
        }
       
    }
}
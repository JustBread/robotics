import RobotClient.CreateClient;
import RobotClient.MapGUI;
import java.util.Arrays;


public class Lab3 
{
    public static void main(String[] args) 
    {
        // Instantiate the robot and robot GUI
        CreateClient myRobot = new CreateClient();
        MapGUI myMap = new MapGUI("maze.txt");
        
        //Data Structures
        int guiMap[][];
        int costMap[][];
        
        int goal [] = { 1 , 3 };
        int location [];
        String direction;
        
        
        //Read Map using MapGUI
        guiMap = myMap.getMap();
        printMap(guiMap);
        
        //Fix Orientation
        costMap = FreshLib.flipMap(guiMap);
        printMap(costMap);
        
        //Get Final Cost Map
        costMap = FreshLib.calculateFinal(costMap, goal);
        printMap(costMap);
        guiMap = FreshLib.flipMap(costMap);
        updateText(guiMap, myMap);
        
        //Move Robot
        location = myMap.getRobotLocation();
        direction = myMap.getRobotDirection();
        System.out.println(location[0] + " " + location[1]);
        
        
        myRobot.waitForPlay();
        myRobot.initialize();
        myRobot.sleepUnlessStop(3000);
              
        while (myRobot.isPlaying()) 
        {
        	
        }
    }
    
    public static void printMap(int[][] x)
    {
        System.out.println("This map is: " + x.length + " by " + x[0].length);
        for(int i = 0; i < x.length; i++)
        {
        	for(int j = 0; j < x[0].length; j++)
        	{
        		System.out.printf("%d", x[i][j]);
        	}
        	System.out.println();
        }
        return;
    }
    
    public static void updateText(int[][] x, MapGUI m)
    {
    	for(int i = 0; i < x.length; i++)
    	{
    		for(int j = 0; j < x[0].length; j++)
    		{
    			m.setText(Integer.toString(x[i][j]), i, j);
    		}
    	}
    }

    
}

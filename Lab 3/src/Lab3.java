import RobotClient.CreateClient;
import RobotClient.MapGUI;


public class Lab3 
{
    public static void main(String[] args) 
    {
        // Instantiate the robot and robot GUI
        CreateClient myRobot = new CreateClient();
        MapGUI myMap = new MapGUI("maze.txt");
        
        //Data Structures
        int oldMap[][];
        int newMap[][];
        
        //Get Current Map
        oldMap = myMap.getMap();
        System.out.println("This map is: " + oldMap.length + " by " + oldMap[0].length);
        
        for(int i = 0; i < oldMap.length; i++)
        {
        	for(int j = 0; j < oldMap[0].length; j++)
        	{
        		System.out.printf("%d", oldMap[i][j]);
        	}
        	System.out.println();
        }
        
        myRobot.waitForPlay();
        myRobot.initialize();
        myRobot.sleepUnlessStop(3000);
              
        while (myRobot.isPlaying()) 
        {
        	
        }
    }
    
    
}

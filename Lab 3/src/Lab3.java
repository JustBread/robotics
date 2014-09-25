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
        int oldMap[][];
        int newMap[][] = new int[6][7];
        int goal [] = { 2 , 4 };
        
        //Get Current Map
        oldMap = myMap.getMap();
        int k = 0, l = 0;
        
        //Out of Bounds
        for(int i = 0; i < newMap.length; i++)
        {
        	Arrays.fill(newMap[i], 1);
        }
        
        //Fix Map Orientation for Analysis
        for(int i = oldMap.length - 1; i >= 0; i--)
        {
        	l = 0;
        	for(int j = 0; j < oldMap[0].length; j++)
        	{
        		System.out.printf("%d", oldMap[i][j]);
        		if(k == 3 && l == 1)
        		{
        			newMap[l + 1][k + 1] = 2;
        		}
        		else
        			newMap[k + 1][l + 1] = oldMap[i][j];
        		l++;
        	}
        	k++;
        	System.out.println();
        }
        
        
        
        printMap(newMap);
        
        //Wavefront
        for(int i = 0; i < newMap.length; i++)
        {
        	for(int j = 0; j < newMap[0].length ; j++)
        	{
        		
        	}
        }
        
        
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
    
}

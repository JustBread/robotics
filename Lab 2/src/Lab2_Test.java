import RobotClient.CreateClient;


public class Lab2_Test 
{
    public static void main(String[] args) 
    {
        // Instantiate the robot and robot GUI
        CreateClient myRobot = new CreateClient("EGN3060 Robot","10.0.0.10");
        
        myRobot.waitForPlay();
        myRobot.initialize();
        
       	myRobot.moveMotors(100,100);
        	
    }
}

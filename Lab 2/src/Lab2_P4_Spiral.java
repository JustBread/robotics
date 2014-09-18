import RobotClient.CreateClient;

public class Lab2_P4_Spiral implements Runnable
{
	enum task
	{ SHRINK, EXPAND };
	
	task currentState;
	private CreateClient robot;
	private int strips;
	private int distance;
	
	public Lab2_P4_Spiral(int x, CreateClient y)
	{
		this.robot = y;
		this.strips = x;
		this.distance = 0;
	}
	
	public void run()
	{
		currentState = task.EXPAND;
		
	}
	
    public void expand(int x, int y) 
    {
    	int stripCt, stripTotal = y;
    	int pendingLength = x;
    	long tStart, tDuration;
    	
    	for(stripCt = 1; stripCt < stripTotal; stripCt++)
    	{
    		tStart = System.currentTimeMillis();
    		tDuration = 0;
    		
    		while(tDuration < stripCt * 100)
    		{
    			robot.moveMotor(100,100);
    			if(Thread.currentThread().isInterrupted())
    			{
    				robot.moveMotors(0,0);
    				recover(stripCt, robot.distance());
    			}
    			tDuration = System.currentTimeMillis() - tStart;
    		}
    		
    	}
    }
    
    public void shrink(int x, int y)
    {
    	int stripCt, stripTotal = y;
    	int pendingLength = x;
    	long tStart, tDuration;

    	for(stripCt = stripTotal; stripCt > 1; stripCt--)
    	{
    		tStart = System.currentTimeMillis();
    		tDuration = 0;
    		
    		while(tDuration < stripCt * 100)
    		{
    			robot.moveMotor(100,100);
    			if(Thread.currentThread().isInterrupted())
    			{
    				robot.moveMotors(0,0);
    				recover(stripCt, robot.distance());
    			}
    			tDuration = System.currentTimeMillis() - tStart;
    		}
    		
    	}
    	
    	
    }
    
    public void recover(int x, int y)
    {
    	
    }
	public void run(){return;}
}

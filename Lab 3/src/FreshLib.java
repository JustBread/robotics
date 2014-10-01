import java.util.Arrays;
import java.util.ArrayList;

public class FreshLib 
{
	public static int [][] flipMap(int [][] m)
	{
		int newMap [][] = new int[m.length][m[0].length];
		
        for(int i = 0; i < m.length; i++)
        {
        	for(int j = 0; j < m[0].length; j++)
        	{
        		newMap[i][j] = m[m.length - 1 - i][j];
        	}
        }
        
        return newMap;
	}
	
	public static int [][] calculateFinal(int [][] m, int[] goal)
	{
		//Vars
		int padRow = m.length;
		int padCol = m[0].length;
		int [][] padded = new int[padRow + 2][padCol + 2];
		
		int orphaned = 0;
		Boolean engine = true;
		
		ArrayList<Integer[]> dir = new ArrayList<Integer[]>();
		
		//Populate Directions (4 or 8)
		dir.add(new Integer[]{-1, -1});
		dir.add(new Integer[]{-1, 0});
		dir.add(new Integer[]{-1, 1});
		
		dir.add(new Integer[]{0, -1});
		dir.add(new Integer[]{0, 1});
		
		dir.add(new Integer[]{1, -1});
		dir.add(new Integer[]{1, 0});
		dir.add(new Integer[]{1, 1});
		
		//Pad Array
		for(int i = 0; i < padded.length; i++)
		{
			Arrays.fill(padded[i],1);
		}
		
		//Insert Goal
		m[goal[0]][goal[1]] = 2;
		
		//Copy Array to Padded
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[0].length; j++)
			{
				padded[i+1][j+1] = m[i][j];
			}
		}
		
		//Wavefront
		while(engine)
		{
			//Reset
			orphaned = 0;
			
			//Iterate through grid
			for(int i = 1; i < padded.length - 1; i++)
			{
				for(int j = 1; j < padded[0].length - 1; j++)
				{
					if(padded[i][j] > 1) //detect an existing cost
					{
						//Search all directions for cost
						for(Integer[] direction : dir)
						{
							//Search specific direction for cost and update if possible
							if(padded[i + direction[0]][j + direction[1]] != 1 &&
							  (padded[i + direction[0]][j + direction[1]] == 0 ||
							   padded[i + direction[0]][j + direction[1]] > padded[i][j] + 1))
							 {
								padded[i + direction[0]][j + direction[1]] = padded[i][j] + 1; //Update if better
								System.out.println("Changed!");
							 }
						}
					}
					else if(padded[i][j] == 0)
						orphaned++; //ignore
					else;
				}
			}
			
			if(orphaned == 0)
				engine = false; //cut if all elements checked
		}
		
		//Copy back to original array
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[0].length; j++)
			{
				m[i][j] = padded[i+1][j+1];
			}
		}
		
		return m;
	}
	
	public static int[][] getBestPath(int
}

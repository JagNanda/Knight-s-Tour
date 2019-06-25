package KnightsTour;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleKnight
{
    int rowPos = 0;
    int colPos = 0;
    int[][] knightCounterArr;
    int sequence = 1;
    
    public SimpleKnight(int rowPos, int colPos)
    {
        this.rowPos = rowPos;
        this.colPos = colPos;
    }
    
    public void startSimpleKnight()
    {
        this.knightCounterArr = new int[8][8];
    }

    
    public void moveKnight()
    {

       int movKnight = (int)(Math.random() * 7);
       
       switch(movKnight)
       {
           case 0: 
               moveKnightUpLeft();
               break;
           
           case 1:
               moveKnightUpRight();
               break;
               
           case 2:
               moveKnightRightUp();
               break;
               
           case 3:
               moveKnightRightDown();
               break;
               
           case 4:
               moveKnightDownRight();
               break;
           
           case 5:
               moveKnightDownLeft();
               break;
               
           case 6:
               moveKnightLeftDown();
               break;
               
           case 7:
               moveKnightLeftUp();
               break;
           
       }
    }
    
    public void moveKnightUpLeft()
    {
        if(rowPos >= 2 && colPos >= 1 && knightCounterArr[rowPos - 2][colPos - 1] == 0)
        {
            knightCounterArr[rowPos][colPos] = sequence;
            rowPos -= 2;
            colPos -= 1;
            sequence++;
        }
        else
        {
            moveKnightUpRight();
        }
    }
    
    public void moveKnightUpRight()
    {
        if(rowPos >=2 && colPos <=6 && knightCounterArr[rowPos - 2][colPos + 1] == 0)
        {
            knightCounterArr[rowPos][colPos] = sequence;
            rowPos -= 2;
            colPos += 1;
            sequence++;
        }
        else
        {
            moveKnightRightUp();
        }
    }
    
    public void moveKnightRightUp()
    {
        if(rowPos >=1 && colPos <=5 && knightCounterArr[rowPos - 1][colPos + 2] == 0)
        {
            knightCounterArr[rowPos][colPos] = sequence;
            rowPos -= 1;
            colPos += 2;
            sequence++;
        }
        else
        {
            moveKnightRightDown();
        }
    }
    
    public void moveKnightRightDown()
    {
        if(rowPos <=6 && colPos <=5 && knightCounterArr[rowPos + 1][colPos + 2] == 0)
        {
            knightCounterArr[rowPos][colPos] = sequence;
            rowPos += 1;
            colPos += 2;
            sequence++;
        }
        else
        {
            moveKnightDownRight();
        }
    }
    
    public void moveKnightDownRight()
    {
        if(rowPos <= 5 && colPos <= 6 && knightCounterArr[rowPos + 2][colPos + 1] == 0)
        {
            knightCounterArr[rowPos][colPos] = sequence;
            rowPos += 2;
            colPos += 1;
            sequence++;
        }
        else
        {
            moveKnightDownLeft();
        }
    }
    
    public void moveKnightDownLeft()
    {
        if(rowPos <= 5 && colPos >= 1 && knightCounterArr[rowPos + 2][colPos - 1] == 0)
        {
            knightCounterArr[rowPos][colPos] = sequence;
            rowPos += 2;
            colPos -= 1;
            sequence++;
        }
        else
        {
            moveKnightLeftUp();
        }
    }
    
    public void moveKnightLeftUp()
    {
        if(rowPos >= 1 && colPos >= 2 && knightCounterArr[rowPos - 1][colPos - 2] == 0)
        {
            knightCounterArr[rowPos][colPos] = sequence;
            rowPos -= 1;
            colPos -= 2;
            sequence++;
        }
        else
        {
            moveKnightLeftDown();
        }
    }
    
    public void moveKnightLeftDown()
    {
        if(rowPos <= 6 && colPos >= 2 && knightCounterArr[rowPos + 1][colPos - 2] == 0)
        {
            knightCounterArr[rowPos][colPos] = sequence;
            rowPos += 1;
            colPos -= 2;
            sequence++;
        }
        
    }
    
    
    
    
    public void print2dArr()
    {
        
        
        System.out.println("---------------------------------------------");
        for(int i = 0; i < knightCounterArr.length; i++)
        {
            System.out.print(i + ")");
            for(int j=0; j < knightCounterArr[i].length; j++)
            {
                if(i == rowPos && j == colPos)
                {
                    System.out.printf("%-5c",'K');
                }
                else
                {
                    System.out.printf("%-5d",knightCounterArr[i][j]);
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
        
    }
    
    public void print2dArrToFile(int counter)
    {
    	try
    	{
    		File file = new File("JagNandaNonIntelligentMethod.txt");
    		if(counter == 1 && file.exists())
    		{
    			file.delete();
    		}
    		file.createNewFile();
    		FileWriter fw = new FileWriter(file.getAbsolutePath(),true);
    		PrintWriter pw = new PrintWriter(fw);
    		
    		System.out.println("in file writer");
    		System.out.println(file.getAbsolutePath() + "created.");
    		pw.println("Ending Position: ");
    		pw.println("Trial: " + counter + ") The Knight was able to touch " + this.getSequence() + " squares.");
    		
            pw.println("---------------------------------------------");
            for(int i = 0; i < knightCounterArr.length; i++)
            {
                pw.print(i + ")");
                for(int j=0; j < knightCounterArr[i].length; j++)
                {
                    if(i == rowPos && j == colPos)
                    {
                        pw.printf("%-5c",'K');
                    }
                    else
                    {
                        pw.printf("%-5d",knightCounterArr[i][j]);
                    }
                    pw.print(" ");
                }
                pw.println("");
            }
            pw.close();
    		
    	}
    	catch(IOException ex)
    	{
    		System.out.println(ex);
    	}
    }
    
    public void print2dArrWebPage(PrintWriter pw)
    {
    	pw.println("---------------------------------------------<br>");
        pw.println("<table>");
        for(int i = 0; i < knightCounterArr.length; i++)
        {
            pw.print("<tr><td>" + i + ")</td>");
            for(int j=0; j < knightCounterArr[i].length; j++)
            {
                if(i == rowPos && j == colPos)
                {
                    pw.print("<td> K </td>");
                }
                else
                {
                    pw.print("<td>" + knightCounterArr[i][j] + "</td>");
                }
            }
        }
        pw.println("</table>");
        
    }
    
    public int getSequence()
    {
        return sequence;
    }
}

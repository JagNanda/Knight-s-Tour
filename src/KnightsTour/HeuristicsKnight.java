
package KnightsTour;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;


public class HeuristicsKnight
{
    int[][] knightCounterArr;
    //this array controls the knight's movements
    int[][] knightMovementArr;
    Integer[] availableMoves;
    int colPos = 0;
    int rowPos = 0;
    int sequence = 1;
    
    public HeuristicsKnight(int row, int col)
    {
        this.rowPos = row;
        this.colPos = col;
    }
    
    public void startHeuristicsKnight()
    {
        int arr[][] = {
                        {2,3,4,4,4,4,3,2},
                        {3,4,6,6,6,6,4,3},
                        {4,6,8,8,8,8,6,4},
                        {4,6,8,8,8,8,6,4},
                        {4,6,8,8,8,8,6,4},
                        {4,6,8,8,8,8,6,4},
                        {3,4,6,6,6,6,4,3},
                        {2,3,4,4,4,4,3,2}
                      };
        this.knightCounterArr = arr;
        this.knightMovementArr = new int[8][8];
    }
    
    public void moveKnight()
    {
        int smallestNum = checkAvailableMoves();  
        knightMovementArr[rowPos][colPos] = sequence;
        ArrayList<Integer> moveDirectionList = new ArrayList<Integer>();
        
        //UpLeft
        if (availableMoves[0] != null && smallestNum == availableMoves[0])
        {
            moveDirectionList.add(0);
        } 
        //UpRight
        if (availableMoves[1] != null && smallestNum == availableMoves[1])
        {
            moveDirectionList.add(1);
        }
        //RightUp
        if (availableMoves[2] != null && smallestNum == availableMoves[2])
        {
            moveDirectionList.add(2);
        }
        //RightDown
        if (availableMoves[3] != null && smallestNum == availableMoves[3])
        {
            moveDirectionList.add(3);
        }
        //DownRight
        if (availableMoves[4] != null && smallestNum == availableMoves[4])
        {
            moveDirectionList.add(4);
        }
        //DownLeft
        if (availableMoves[5] != null && smallestNum == availableMoves[5])
        {
            moveDirectionList.add(5);
        }
        //LeftDown
        if (availableMoves[6] != null && smallestNum == availableMoves[6])
        {
            moveDirectionList.add(6);
        }
        //LeftUp
        if (availableMoves[7] != null && smallestNum == availableMoves[7])
        {
            moveDirectionList.add(7);
        }
        
        if(!moveDirectionList.isEmpty())
        {
            int randomIndex = new Random().nextInt(moveDirectionList.size());
            int moveDirection = moveDirectionList.get(randomIndex);

            switch(moveDirection)
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
    }
    
    public void moveKnightUpLeft()
    {
        knightMovementArr[rowPos][colPos] = sequence;
        rowPos -= 2;
        colPos -= 1;
        sequence++;    
    }
    
    public void moveKnightUpRight()
    {
        knightMovementArr[rowPos][colPos] = sequence;
        rowPos -= 2;
        colPos += 1;
        sequence++;
    }
    
    public void moveKnightRightUp()
    {
        knightMovementArr[rowPos][colPos] = sequence;
        rowPos -= 1;
        colPos += 2;
        sequence++;        
    }
    
    public void moveKnightRightDown()
    {
        knightMovementArr[rowPos][colPos] = sequence;
        rowPos += 1;
        colPos += 2;
        sequence++;    
    }
    
    public void moveKnightDownRight()
    {
        knightMovementArr[rowPos][colPos] = sequence;
        rowPos += 2;
        colPos += 1;
        sequence++;
    }
    
    public void moveKnightDownLeft()
    {
        knightMovementArr[rowPos][colPos] = sequence;
        rowPos += 2;
        colPos -= 1;
        sequence++;        
    }    
    
    public void moveKnightLeftDown()
    {
        knightMovementArr[rowPos][colPos] = sequence;
        rowPos += 1;
        colPos -= 2;
        sequence++;
    }    
    
    public void moveKnightLeftUp()
    {
        knightMovementArr[rowPos][colPos] = sequence;
        rowPos -= 1;
        colPos -= 2;
        sequence++;        
    }    
    
    public int checkAvailableMoves()
    {
        int smallestNum = 99;
        
        availableMoves = new Integer[8];
        //Upleft
        if(rowPos >= 2 && colPos >= 1 && knightMovementArr[rowPos - 2][colPos - 1] == 0)
        {
            availableMoves[0] = knightCounterArr[rowPos - 2][colPos - 1];
        }
        else
        {
            availableMoves[0] = null;
        }
        //UpRight
        if(rowPos >=2 && colPos <=6 && knightMovementArr[rowPos - 2][colPos + 1] == 0)
        {
            availableMoves[1] = knightCounterArr[rowPos - 2][colPos + 1];
        }
        else
        {
            availableMoves[1] = null;
        }
        //RightUp
        if(rowPos >=1 && colPos <=5 && knightMovementArr[rowPos - 1][colPos + 2] == 0)
        {
            availableMoves[2] = knightCounterArr[rowPos - 1][colPos + 2];
        }
        else
        {
            availableMoves[2] = null;
        }
        //RightDown
        if(rowPos <=6 && colPos <=5 && knightMovementArr[rowPos + 1][colPos + 2] == 0)
        {
            availableMoves[3] = knightCounterArr[rowPos + 1][colPos + 2];
        }
        else
        {
            availableMoves[3] = null;
        }
        //DownRight
        if(rowPos <= 5 && colPos <= 6 && knightMovementArr[rowPos + 2][colPos + 1] == 0)
        {
            availableMoves[4] = knightCounterArr[rowPos + 2][colPos + 1];
        }
        else
        {
            availableMoves[4] = null;
        }
        //DownLeft
        if(rowPos <= 5 && colPos >= 1 && knightMovementArr[rowPos + 2][colPos - 1] == 0)
        {
            availableMoves[5] = knightCounterArr[rowPos + 2][colPos - 1];
        }
        else
        {
            availableMoves[5] = null;
        }
        //LeftDown
        if(rowPos <= 6 && colPos >= 2 && knightMovementArr[rowPos + 1][colPos - 2] == 0)
        {
            availableMoves[6] = knightCounterArr[rowPos + 1][colPos - 2];
        }
        else
        {
            availableMoves[6] = null;
        }
        //LeftUp
        if(rowPos >= 1 && colPos >= 2 && knightMovementArr[rowPos - 1][colPos - 2] == 0)
        {
            availableMoves[7] = knightCounterArr[rowPos - 1][colPos - 2];
        }
        else
        {
            availableMoves[7] = null;
        }
        
        for(int i = 0; i < availableMoves.length; i++)
        {
            if(availableMoves[i] != null)
            {
                if(availableMoves[i] < smallestNum)
                {
                    smallestNum = availableMoves[i];
                }
            }
        }
        
        return smallestNum;
    }
    
    public void print2dArr()
    {         
        System.out.println("---------------------------------------------");
        for(int i = 0; i < knightMovementArr.length; i++)
        {
            System.out.print(i + ")");
            for(int j=0; j < knightMovementArr[i].length; j++)
            {
                if(i == rowPos && j == colPos)
                {
                    System.out.printf("%-5c",'K');
                }
                else
                {
                    System.out.printf("%-5d",knightMovementArr[i][j]);
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
    		File file = new File("JagNandaHeuristicsMethod.txt");
    		if(counter == 1 && file.exists())
    		{
    			file.delete();
    		}
    		file.createNewFile();
    		FileWriter fw = new FileWriter(file.getAbsolutePath(),true);
    		PrintWriter pw = new PrintWriter(fw);
    		
    		System.out.println("in file writer");
    		System.out.println(file.getAbsolutePath() + "created");
    		pw.println("Ending Position: ");
    		pw.println("Trial: " + counter + ") The Knight was able to touch " + this.getSequence() + " squares.");
    		
            pw.println("---------------------------------------------");
            for(int i = 0; i < knightMovementArr.length; i++)
            {
                pw.print(i + ")");
                for(int j=0; j < knightMovementArr[i].length; j++)
                {
                    if(i == rowPos && j == colPos)
                    {
                        pw.printf("%-5c",'K');
                    }
                    else
                    {
                        pw.printf("%-5d",knightMovementArr[i][j]);
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
    
    
    public void print2dArrToWebPage(PrintWriter pw)
    {         
        pw.println("---------------------------------------------");
        pw.println("<table>");
        for(int i = 0; i < knightMovementArr.length; i++)
        {
            pw.print("<tr><td>" + i + ")</td>");
            for(int j=0; j < knightMovementArr[i].length; j++)
            {
                if(i == rowPos && j == colPos)
                {
                    pw.print("<td> K </td>");
                }
                else
                {
                    pw.print("<td>" + knightMovementArr[i][j] + "</td>");
                }
                pw.print(" ");
            }
            pw.println("");
        }
        pw.println("</table>");
    }
    
    public int getSequence()
    {
        return sequence;
    }
    
}

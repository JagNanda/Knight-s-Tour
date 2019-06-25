Knight's Tour Servlet Application Explanation

- Before running app, please make sure to use either firefox or chrome as the app does not display the error page otherwise
- Make sure tomcatserver is running
- To start app, please run index.jsp on tomcatserver
- index.jsp, process.jsp, and error.jsp used to check for errors and create an errorpage
- To see the error page, type in anything other than a number in the second textbox ("How many times would you like to run it (enter a number in decimal format such as 1,99,234,etc...")
	- This error page is used in case a user enters a number in the wrong format accepted. 
	- The error page will redirect to index.jsp after a few seconds
- requestDisptacher() is used in KnightPicker.java to select the unintelligent version of Knight's Tour based on form data
- sendRedirect() is also used in KnightPicker.java, but to select the HeuristicsKnightServlet instead
- The text file will show where it is created in the console
- There are 3 servlets in total. 
	- There is KnightPicker.java which chooses a version of Knight's tour based on which version you choose
	- SimpleKnightServlet.java which is used to validate form data, set up html page and css styles, create an object from the SimpleKnight.java class using parameters from form data, and print the grid for the unintelligent version of the app
	- HeuristicsKnightServlet.java does the same as above except for the Heuristics version of the app
- There are two regular classes used for the game logic
	- SimpleKnight.java is for unintelligent version 
	- HeuristicsKnight.java is for the heuristics version

SimpleKnight.java:
	- 4 fields
		- int rowPos: current row position of knight
		- int colPos: current column position of knight
		- int[][] knightCounterArr: the grid
		- int sequence: to show the number of movements
	- first rowPos and colPos are set using form data and together determine position of knight
	- moveKnight()
		- uses switch case statement to determine where to move knight based on random number generated
	- moveKnightUpLeft(), moveKnightRightUp(), etc...
		- logic used to move knight and make sure it does not go to a square its been on before (if the future position of knight equals 0 in knightcounterArr, it will not move there)
		- if it cannot perform the move, then the next move direction is called until one move can be called
		- sequence incremented after each successful move 
	- print2dArr()
		- was used for debugging and show position of knight in grid
	- print2dArrToFile() 
		- used to print grid to a .txtfile
	- print2dArrWebPage()
		- used to print grid to a webpage (is organized using a table html element)

HeuristicsKnight.java
	- 6 fields
		- int[][]KnightCounterArr: a 2d array containing heuristics values for the next available moves
		- int[][]KnightMovementArr: stores the knight's position and movements
		- Integer[] availableMoves: if a knight can move in a certain direction, then logic for that move stored here. 
					  - Integer[] used to store a null value if knight cannot move in that direction
		- int rowPos: current row position of knight
		- int colPos: current column position of knight
		- int sequence: to show the number of movements
	- moveKnight()
		- checks available moves, adds sequence numbers to grid, stores moves in an arraylist and moves in a direction randomnly(if more than 1 move tied for lowest heuristics value) based on one of the available moves available
		- if one of the available moves is equal to the lowest heuristics value available (returned by checkAvailableMoves()), then it moves in that direction. 
			- if two or more values equal to lowest heuristics value, then it randomnly decides on a direction based on one of those moves.
	- moveKnightUpLeft(), moveKnightRightUp(), etc...
		- used by moveKnight() to determine how to move knight in a certain direction
	- checkAvailableMoves()
		- is called by moveKnight() to make sure knight stays on grid and has not stepped in the same place twice
		- determines lowest heuristics value available and passes that value to moveKnight()
	- print2dArr()
		- was used for debugging and show position of knight in grid
	- print2dArrToFile() 
		- used to print grid to a .txtfile
	- print2dArrWebPage()
		- used to print grid to a webpage (is organized using a table html element)
	
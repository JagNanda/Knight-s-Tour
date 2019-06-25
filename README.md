# Explanation of Knight's Tour

A knight's tour is a sequence of moves of a knight on a chessboard such that the knight visits every square only once. If the knight ends on a square that is one knight's move from the beginning square (so that it could tour the board again immediately, following the same path), the tour is closed, otherwise it is open. The knight is only able to move in an L-shaped pattern like it does in chess. 

![image](https://upload.wikimedia.org/wikipedia/commons/c/ca/Knights-Tour-Animation.gif)

## Home page
A simple form asking whether to run the non-intelligent method or heuristics method as well how many times to run the tour, which row to start from, and which column to start from.
![image](https://user-images.githubusercontent.com/47337941/60121329-d1876500-9750-11e9-9f39-def3692981d4.png)


## Non-Intelligent method
A knight randomnly selects an available square until it can no longer move. The knight using this method does not manage to reach many squares.
![image](https://user-images.githubusercontent.com/47337941/60121825-f8926680-9751-11e9-9cf0-2b75594ada26.png)


## Accessibility Heuristics method

![image](https://user-images.githubusercontent.com/47337941/60121777-d862a780-9751-11e9-80e7-c8070ba340f3.png)

 Using this method, the knight is consistently able to hit 55+ squares.


![image](https://user-images.githubusercontent.com/47337941/60121979-44dda680-9752-11e9-94d4-0692b0d87483.png)


package bbc.codingtests.gameoflife.gamestate;

import static java.awt.SystemColor.text;
import java.lang.Object;
import org.apache.commons.lang3.StringUtils;


//ASSUMPTIONS
//
//The user will only enter stars (*) to represent live cells
//The user will only enter dots (.) to represent dead cells
//The number of cells on a row should be the same on each row of the 2D Grid

public class GameStateImpl implements GameState {

    //Initialise 2D array to store live and dead cells
    int[][] matrixBefore;

    //Method allows another class to access the 2D array/matrix which contains
    //the 2D grid
    @Override
    public int[][] getMatrix() {

        return matrixBefore;

    }

    //toString() method converts the cells in the matrix into an output string
    //NOTE: The output string uses the same layout as the input string, whereby
    //live cells are represented as a '*' and dead cells are represented by a '.'
    //and use newline ('\n') to separate rows
    @Override
    public String toString() {
        //Initialise output string variable
        String outputString = "";
        for (int i = 0; i < matrixBefore.length; i++) {

            for (int j = 0; j < matrixBefore[i].length; j++) {
                
                if (matrixBefore[i][j] == 1) {
                    //Convert cells containing the number '1' to '*'
                    outputString = outputString + "*";
                } else {
                    //Convert cells containing the number '0' to '.'
                    outputString = outputString + ".";
                }
            }
            //add a return line to the output string at the end of each row
            outputString = outputString + "\n";
        }
        //remove redundant return line '\n' at the end of the output string 
        //once completed
        outputString = outputString.substring(0, outputString.length() - 1);
        return outputString;

    }

    //This constructor is used to parse an input string and return a new 
    //GameStateImpl object representing what you got in the string
    //as above, live cells are '*' and dead cells are '.' 
    //Rows are separated by newline ('\n')
    public GameStateImpl(String input) {
        String inputer = input;
        //Split string up to each individual line/row and store in this array
        String[] rowString = inputer.split("\n");

        //Initialise matrix with No. of rows declared
        int[][] grid = new int[rowString.length][];

        for (int i = 0; i < grid.length; i++) {
            //Split the string arrays into individual characters 
            String[] colString = rowString[i].split("");
            //Identify the number of columns the matrix will have            
            grid[i] = new int[colString.length];
            //For loop used to populate the matrix with the data recieved from
            //the input string

            //NOTE: I am converting the string input into either 1's (*) or
            //0's (.). This is being done for simplification and to reduce
            //errors
            for (int j = 0; j < grid[i].length; j++) {
                if ("*".equals(colString[j])) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = 0;
                }
            }
        }
        //Save the matrix into the 'matrixBefore' variable by calling this 
        //method
        this.setArray(grid);
    }

   
    //isCellAliveAt(int row, int col) method is used to check whether the cell
    //at the given row and column is alive or not
    //Should return false if the coordinates are outside the grid
    public boolean isCellAliveAt(int row, int col) {
        
        //Try Block used to handle the 'ArrayIndexOutOfBoundsException'
        try {
            //If statement used to check whether this particular cell is alive
            //or not
            if (matrixBefore[row][col] == 1) {
                return true;
            }
            return false;

        } catch (ArrayIndexOutOfBoundsException e) {
            //Catch exception if this cell does not exist
            return false;
        }

    }

    //Get the number of rows in 2D grid
    @Override
    public int getRows() {
        int Rows = matrixBefore.length;
        return Rows;
    }

    //Get the number of columns in 2D grid
    @Override
    public int getCols() {
        int Cols = matrixBefore[0].length;
        return Cols;
    }

    //Save and overwrite changes made to the 2D grid
    @Override
    public final void setArray(int[][] array) {
        this.matrixBefore = array;
    }

}

package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;

//ASSUMPTIONS
//
//The user will only enter stars (*) to represent live cells
//The user will only enter dots (.) to represent dead cells
//The number of cells on a row should be the same on each row of the 2D Grid

public class LifeImpl implements Life {

    public GameState evolve(GameState currentState) {
        //Initialise matrices which will be used to store the state of 
        //the 2D grid
        int matrixBefore[][] = currentState.getMatrix();
        int matrixAfter[][] = new int[currentState.getRows()][currentState.getCols()];
        //Initialise counter to count the number of neighbours surrounding a 
        //particular cell
        int counter = 0;
        for (int i = 0; i < matrixBefore.length; i++) {

            for (int j = 0; j < matrixBefore[i].length; j++) {
                //The following if statements check all eight neighbours (where
                //applicable)
                //NEIGHBOUR ONE                
                if (currentState.isCellAliveAt(i - 1, j - 1)) {
                    //Increment the counter if this cell is alive
                    counter++;
                }

                //NEIGHBOUR TWO
                if (currentState.isCellAliveAt(i - 1, j)) {
                    counter++;
                }

                //NEIGHBOUR THREE
                if (currentState.isCellAliveAt(i - 1, j + 1)) {
                    counter++;
                }

                //NEIGHBOUR FOUR
                if (currentState.isCellAliveAt(i, j - 1)) {
                    counter++;
                }

                //NEIGHBOUR FIVE
                if (currentState.isCellAliveAt(i, j + 1)) {
                    counter++;
                }

                //NEIGHBOUR SIX 
                if (currentState.isCellAliveAt(i + 1, j - 1)) {
                    counter++;
                }

                //NEIGHBOUR SEVEN
                if (currentState.isCellAliveAt(i + 1, j)) {
                    counter++;
                }

                //NEIGHBOUR EIGHT
                if (currentState.isCellAliveAt(i + 1, j + 1)) {
                    counter++;
                }

                //This if statement contains all the rules applicable to
                //the Game Of Life
                if ((matrixBefore[i][j] == 1 && (counter == 2 || counter == 3))
                        || (matrixBefore[i][j] == 0 && (counter == 3))) {
                    //Cell is created/cell stays alive
                    matrixAfter[i][j] = 1;
                } else {
                    //Cell is not created/cell dies
                    matrixAfter[i][j] = 0;
                }
                //Counter returns to 0, ready for checking the next cell
                counter = 0;
            }

        }

        //Save the changes to the original matrix grid
        currentState.setArray(matrixAfter);
        return currentState;
    }

}

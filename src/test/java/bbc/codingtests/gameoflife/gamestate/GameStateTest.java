package bbc.codingtests.gameoflife.gamestate;

import org.junit.Test;

import static org.junit.Assert.*;

//ASSUMPTIONS
//
//The user will only enter stars (*) to represent live cells
//The user will only enter dots (.) to represent dead cells
//The number of cells on a row should be the same on each row of the 2D Grid

public class GameStateTest {

    //This test checks to see whether this program can identify both live and 
    //dead cells when parsing the following input string
    @Test
    public void testParsing() {
        String input = ".*.\n*.*\n...";
        GameState testState = new GameStateImpl(input);
        assertTrue("Row 0, col 1 should be alive",testState.isCellAliveAt(0,1));
        assertFalse("Row 2, col 2 should not be alive",testState.isCellAliveAt(2,2));
    }

    //This test checks to see whether this program can identify the number of 
    //rows and collumns of the 2D grid correctly
    @Test
    public void testRowColCounts() {
        String input = "...\n***\n..*\n...";
        GameState testState = new GameStateImpl(input);
        assertEquals("The game should have 3 columns", 3, testState.getCols());
        assertEquals("The game should have 4 rows", 4, testState.getRows());
    }
}

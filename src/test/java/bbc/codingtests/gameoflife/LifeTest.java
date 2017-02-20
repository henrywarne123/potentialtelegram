package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;
import org.junit.Test;

import static org.junit.Assert.*;

//ASSUMPTIONS
//
//The user will only enter stars (*) to represent live cells
//The user will only enter dots (.) to represent dead cells
//The number of cells on a row should be the same on each row of the 2D Grid
public class LifeTest {

    //TODO make this test pass
    @Test
    public void testEmptyGrid() {
        String testStateInput = "...\n...\n...";

        Life testLife = new LifeImpl();
        GameState emptyState = new GameStateImpl(testStateInput);

        assertEquals("An empty grid should stay the same", "...\n...\n...", testLife.evolve(emptyState).toString());
    }

    //TODO implement further tests for the other cases in the instructions
    //TODO make this test pass
    //Scenario 6: Expected game outcome for seeded grid
    //INITIAL STATE
    @Test
    public void testScenario6a() {
        String testStateInput = "...\n***\n...";
        Life testLife = new LifeImpl();
        GameState testState = new GameStateImpl(testStateInput);
        assertEquals("Not the correct outcome", ".*.\n.*.\n.*.", testLife.evolve(testState).toString());
    }

    //SECOND STATE
    @Test
    public void testScenario6b() {
        String testStateInput = ".*.\n.*.\n.*.";
        Life testLife = new LifeImpl();
        GameState testState = new GameStateImpl(testStateInput);
        assertEquals("Not the correct outcome", "...\n***\n...", testLife.evolve(testState).toString());
    }

    //Use of a for loop so that the game evolves two turns so that it returns to
    //its original state
    @Test
    public void testScenario6c() {
        String testStateInput = "...\n***\n...";
        String testOutput = null;
        Life testLife = new LifeImpl();
        GameState testState = new GameStateImpl(testStateInput);
        //Game evolves two times
        for (int i = 0; i < 2; i++) {
            testOutput = testLife.evolve(testState).toString();
        }
        assertEquals("Not the correct outcome", "...\n***\n...", testOutput);
    }

    //Scenario 2: Overcrowding
    @Test
    public void testScenario2() {
        String testStateInput = "..*.\n***.\n..*.";
        Life testLife = new LifeImpl();
        GameState testState = new GameStateImpl(testStateInput);
        assertEquals("Not the correct outcome", "..*.\n..**\n..*.", testLife.evolve(testState).toString());
    }

    //Scenario 3: Survival
    //Testing live cells with two neighbours
    @Test
    public void testScenario3a() {
        String testStateInput = "......\n..**..\n.*..*.\n..**..\n......";
        Life testLife = new LifeImpl();
        GameState testState = new GameStateImpl(testStateInput);
        assertEquals("Not the correct outcome", "......\n..**..\n.*..*.\n..**..\n......", testLife.evolve(testState).toString());
    }

    //Scenario 3: Survival
    //Testing live cells with three neighbours
    @Test
    public void testScenario3b() {
        String testStateInput = "....\n.**.\n.**.\n....";
        Life testLife = new LifeImpl();
        GameState testState = new GameStateImpl(testStateInput);
        assertEquals("Not the correct outcome", "....\n.**.\n.**.\n....", testLife.evolve(testState).toString());
    }

    //Scenario 4: Creation of Life
    @Test
    public void testScenario4() {
        String testStateInput = "...\n*.*\n*..";
        Life testLife = new LifeImpl();
        GameState testState = new GameStateImpl(testStateInput);
        assertEquals("Not the correct outcome", "...\n.*.\n.*.", testLife.evolve(testState).toString());
    }

    //Scenario 1: Underpopulation
    @Test
    public void testScenario1() {
        String testStateInput = "....\n.**.\n....";
        Life testLife = new LifeImpl();
        GameState testState = new GameStateImpl(testStateInput);
        assertEquals("Not the correct outcome", "....\n....\n....", testLife.evolve(testState).toString());
    }

    //Scenario 5: Grid with no live cells
    @Test
    public void testScenario5() {
        String testStateInput = "....\n....\n....";
        Life testLife = new LifeImpl();
        GameState testState = new GameStateImpl(testStateInput);
        assertEquals("Not the correct outcome", "....\n....\n....", testLife.evolve(testState).toString());
    }

}

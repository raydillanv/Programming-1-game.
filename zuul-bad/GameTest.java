import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

/**
 * GameTest - a class to test the zuul game engine.
 *
 * @author  William H. Hooper
 * @version 2018-11-19
 */
public class GameTest
{
    private Game game1;
    private Console console1; 

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        System.out.println("\f");
        game1 = new Game();
        console1 = new Console(game1);
        String message = game1.readMessages();
        System.out.print(message + "> ");
    }

    @Test
    public void start()
    {
        assertEquals(false, game1.finished());
    }

    @Test
    public void map()
    {
        assertEquals(true, console1.testCommand("go right", "language"));
        assertEquals(true, console1.testCommand("go right", "first floor"));
        assertEquals(true, console1.testCommand("go right", "Starbucks"));
        assertEquals(true, console1.testCommand("go right", "first floor stairs"));
        
        assertEquals(true, console1.testCommand("go left", "Starbucks"));
        assertEquals(true, console1.testCommand("go left", "first floor"));
        assertEquals(true, console1.testCommand("go left", "language"));
        //to test if in set "assertEquals(false...
        // assertEquals(true, console1.testCommand("go west", "outside"));
        // assertEquals(true, console1.testCommand("go west", "pub"));
        // assertEquals(true, console1.testCommand("go east", "outside"));
        // assertEquals(true, console1.testCommand("go south", "lab"));
        // assertEquals(true, console1.testCommand("go east", "office"));
        // assertEquals(true, console1.testCommand("go west", "lab"));
        // assertEquals(true, console1.testCommand("go north", "outside"));
    }

    @Test
    public void noDoor()
    {
        assertEquals(true, console1.testCommand("go left", "Ouch"));
    }

    @Test
    public void quit()
    {
        console1.testCommand("quit");
        assertEquals(true, game1.finished());
        assertEquals(false, console1.testCommand("go North", "doorway"));
        assertEquals(true, console1.testCommand("anything", "game is over"));
    }

    //@Test
    //public void theater()
    //{
    //    assertEquals(true, console1.testCommand("go east", "theater"));
    //}

    //@Test
    //public void office()
    //{
    //    console1.testCommand("go south");
    //    assertEquals(true, console1.testCommand("go east", "office"));
    //}

    @Test
    public void help()
    {
        String string1 = console1.getResponse("help");
        assertNotNull(string1);
        assertEquals(true, string1.contains("go"));
        assertEquals(true, string1.contains("quit"));
        assertEquals(true, string1.contains("help"));
    }
    
    @Test
    public void look()
    {
        assertEquals(true, console1.testCommand("look", "What are"));
    }
    
    @Test
    public void yes()
    {
      assertEquals(true, console1.testCommand("yes", "yourself"));  
    }
    
}





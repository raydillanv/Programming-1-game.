import java.util.HashMap;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room 
{
    public String description;
    private String imageName;
    private String audioName;
    
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;
    public static int count;
    private HashMap<String, Room> exits;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        count = 0;
        exits = new HashMap<>();
    }
    
    // --- added Nov 16 ---
    
    public void incrementCount()
    {
        count++;
    }
    
    public int getCount()
    {
        return count;
    }
    
    // --- added Nov 16 ---
    
    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    // public void setExits(Room north, Room east, Room south, Room west) 
    // {
        // if(north != null) {
            // northExit = north;
        // }
        // if(east != null) {
            // eastExit = east;
        // }
        // if(south != null) {
            // southExit = south;
        // }
        // if(west != null) {
            // westExit = west;
        // }
    // }
    
    public void setExit(String direction, Room nextRoom)
    {
        exits.put(direction, nextRoom);
    }
    
    public Room getDirection(String direction)
    {
        return exits.get(direction);
    }
    
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
    
    //8.7
    public String getExitString()
    {
        String message = "Exits:"; 
        
        //message += " east";
        for(String myDirection : exits.keySet()) 
        {
            message += " " + myDirection; 
        }
        return message;
    }
    
    /**
     * @return The description of the room.
     * It's exits and anything else we need
     * to know about.
     */
    public String getDescription()
    {
        return description;
    }
    
    public String getLongDescription()
    {
        incrementCount();
        return description + "\n" + getExitString();
    }
    
    /*************************************************************
     * added by William H. Hooper, 2006-11-28
    *************************************************************/
    /**
     * @return a String, which hopefully contains the file name
     * of an Image file.
     */
    public String getImage()
    {
        return imageName;
    }
    
    /**
     * associate an image with this room
     * @param filename a String containing a file.
     * The file <b>must</b> reside in the media directory, 
     * and must be in a format viewable in the Java AWT.
     * Readable formats include: 
     * PNG, JPG (RGB color scheme only), GIF
     */
    public void setImage(String filename)
    {
        imageName = "media/" + filename;
    }
    
    /**
     * @return a String, which hopefully contains the file name
     * of an audio file.
     */
    public String getAudio()
    {
        return audioName;
    }
    
    /**
     * associate an audio clip with this room
     * @param filename a String containing a file.
     * The file <b>must</b> reside in the media directory, 
     * and must be in a format palyable in the Java AWT.
     * Readable formats include: 
     * WAV, AU.
     */
    public void setAudio(String filename)
    {
        audioName = "media/" + filename;
    }
    
    
}

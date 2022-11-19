/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room previousRoom;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms2()
    {
        //Room outside, theater, pub, lab, office;
        Room Caf, GYM, mainLawn, Patton;

        // create the rooms
        //outside = new Room("outside the main entrance of the university");
        //theater = new Room("in a lecture theater");
        //pub = new Room("in the campus pub");
        //lab = new Room("in a computing lab");
        //office = new Room("in the computing admin office");
        Caf = new Room("At the Caf. Time to be disapointed.");
        GYM = new Room("Time to get shred Boys we at the Gym!");
        mainLawn = new Room("Big fountain & lotta grass. Main Lawn!");
        Patton = new Room("#1 Freshman Dorm! Duh its Patton");

        // assign images
        //outside.setImage("deakinsign.jpg");
        mainLawn.setImage("deakinsign.jpg");
        //theater.setImage("lecture-hall.jpg");
        GYM.setImage("lecture-hall.jpg");
        //pub.setImage("cozy-little-pub.jpg");
        Caf.setImage("cozy-little-pub.jpg");
        //lab.setImage("computer-lab.jpg");
        //office.setImage("cluttered-office.jpg");
        Patton.setImage("cluttered-office.jpg");

        // assign sounds
        //office.setAudio("cricket.mp3");
        Patton.setAudio("cricket.mp3");
        // initialise room exits
        //outside.setExits(null, theater, lab, pub);

        //Caf.setExits(null, null, null, mainLawn);
        Caf.setExit("east", mainLawn);

        //theater.setExits(null, null, null, outside);

        //GYM.setExits(null, null, null, mainLawn);
        GYM.setExit("west", mainLawn);

        //pub.setExits(null, outside, null, null);

        //mainLawn.setExits(Caf, GYM, Patton, null);
        mainLawn.setExit("south", Caf);

        //lab.setExits(outside, office, null, null);

        //Patton.setExits(null, null, null, mainLawn);
        Patton.setExit("north", Patton);

        //office.setExits(null, null, null, lab);

        //using setEcit on Nov 16
        mainLawn.setExit("north", GYM);
        mainLawn.setExit("west", Caf);
        mainLawn.setExit("south", Patton);

        //currentRoom = outside;  // start game outside
        currentRoom = mainLawn;
    }

    /**
     * Create all the rooms and link their exits together.
     */
    //private void createRoomsJAAC()
    private void createRooms()
    {
        //Room outside, theater, pub, lab, office;
        Room Caf, GYM, mainLawn, Patton;

        //JAAC FLOOR 1 Right-to-left!
        Room JAAC_Entrance, Language_Center, Elevator_F1, Starbucks, 
        Stairs_F1; 

        //JAAC FLOOR 2 Left-to-Right!
        Room Stairs_F2, Room_2102, Room_2130, Elevator_F2, Room_2150, 
        Room_2149;

        //JAAC FLOOR 3 Left-to-Right!
        Room Stairs_F3, Bathroom_F3, Elevator_F3, Yeos_office, Borns_office;

        //JAAC FLOOR 4 Left-to-Right!
        Room Stairs_F4, ConvoCredit_room, WellCore_room, Elevator_F4,
        Hoopers_office, Neophytous_office;

        //JAAC FLOOR 5 Left-to-Right!
        Room Stairs_F5, Easter_Egg1, Elevator_F5, Class_Interaction;

        // |THE PARKING GARAGE FLOORS|

        //JAAC Parking 1
        Room Stairs_P1, Car_Accident, Elevator_P1, Parking_Ticket, 
        Parking_Spot;

        //JAAC Parking 2
        Room Stairs_P2, Parking_Ticket2, Interaction, Elevator_P2, Event, 
        Parking_Spot2;

        //JAAC Parking 3
        Room Stairs_P3, Parking_Spot3, Elevator_P3, Party, Easter_Egg2;

        // create the rooms

        //JAAC FLOOR 1 Right-to-left!

        JAAC_Entrance = new Room("inside the main entrance of the JAAC");

        Language_Center = new Room("the language center. No one who speaks" 
            + " Japanese seems to be here.");

        Elevator_F1= new Room("The first floor elevator");

        Starbucks = new Room("The Starbucks");

        Stairs_F1= new Room("The first floor stairs.");

        //JAAC Floor 2 Left-to-Right!

        Stairs_F2 = new Room("The second floor stairs.");

        Room_2102 = new Room("Class room 2102 on the second floor");

        Room_2130 = new Room("Class room 2130 on the second floor");

        Elevator_F2 = new Room("The second floor elevator");

        Room_2150 = new Room("Class room 2150 on the second floor");

        Room_2149 = new Room("Class room 2149 on the second floor"); 

        //JAAC 3 Left-to-Right!

        Stairs_F3 = new Room("The third floor stairs.");

        Bathroom_F3 = new Room("The third floor bathroom.");

        Elevator_F3 = new Room("The third floor elevator.");

        Yeos_office = new Room("Dr. Yeo's office, on the third floor");

        Borns_office = new Room("Dr. Born's office, on the third floor");

        //JAAC 4 Left-to-Right!
        //Room Stairs_F4, ConvoCredit_room, WellCore_room, Elevator_F4,
        //Hoopers_office, Neophytous_office;
        Stairs_F4 = new Room("The fourth floor stairs.");

        ConvoCredit_room = new Room("The Convo Credit " +
            "presentation.");
        WellCore_room = new Room("The Well Core Credit " +
            "presentation");
        Elevator_F4 = new Room("The fourth floor elevator");

        Hoopers_office = new Room("The man. The myth. The legend's"+
            " very own office. Hoop Hoop.");
        Neophytous_office = new Room("Your Calculus teacher's office"+
            ". She seems to be busy helping students in office hours");
        //JAAC 5 Left-to-RIght!
        //Room Stairs_F5, Easter_Egg1, Elevator_F5, Class_Interaction;

        Stairs_F5 = new Room("The fifth floor stairs");

        Easter_Egg1 = new Room("I'm dreaming of a white Christmas...");

        Elevator_F5 = new Room("The fifth floor Elevator.");

        Class_Interaction = new Room("Easter Egg" +"Hey you! Ohayo gozaimasu!" +
            "you must be the Japanese exchange student I've heard"
            + " so much about!");

        //JAAC Parking 1
        //Room Stairs_P1, Car_Accident, Elevator_P1, Parking_Ticket, 
        //Parking_Spot;

        Stairs_P1 = new Room("The parking garage P1 stairs.");

        Car_Accident = new Room("Oh now two students seem to have " + 
            "gotten into a collision. Is Cyrus around?");

        Elevator_P1 = new Room("The parking garage P1 elevator.");

        Parking_Ticket = new Room("Don't park here unless you want a ticket.");

        //JAAC Parking 2
        //Room Stairs_P2, Parking_Ticket2, Interaction, Elevator_P2, Event, 
        //Parking_Spot2;

        Stairs_P2 = new Room("The parking garage P2 stairs.");

        Parking_Ticket2 = new Room("Parking here will land you a ticket.");

        Interaction = new Room("There seems to be someone drinking sake.");

        Elevator_P2 = new Room("The parking garage P2 elevator.");

        Event = new Room("A car looks as though it is going to leave" +
            " after waiting for 5 minutes it looks like they live in their"
            + " car.");
        Parking_Spot2 = new Room("You can park here!");

        //JAAC Parking 3
        //Room Stairs_P3, Parking_Spot3, Elevator_P3, Party, Easter_Egg2;

        Stairs_P3 = new Room("The parking garage P3 stairs.");

        Parking_Spot3 = new Room("You can park here too!");

        Elevator_P3 = new Room("The parking garage P3 Elevator.");

        Party = new Room("Some Japanese minor students are partying!");

        Easter_Egg2 = new Room("Spooky Scary Skeletons.");

        //Set the first floor Exits.
        //JAAC FLOOR 1 Right-to-left!
        //Room JAAC_Entrance, Language_Center, Elevator_F1, Starbucks, 
        //Stairs_F1; 

        JAAC_Entrance.setExit("right", Language_Center);

        Language_Center.setExit("right", Elevator_F1);
        Language_Center.setExit("left", JAAC_Entrance);

        Elevator_F1.setExit("right", Starbucks);
        Elevator_F1.setExit("left", Language_Center);
        Elevator_F1.setExit("up", Elevator_F2);
        Elevator_F1.setExit("down", Elevator_P1);

        Starbucks.setExit("right", Stairs_F1);
        Starbucks.setExit("left", Elevator_F1);

        Stairs_F1.setExit("left", Starbucks);
        Stairs_F1.setExit("up", Stairs_F1);
        Stairs_F1.setExit("down", Stairs_P1);

        //Set the second floor exits.
        //Room Stairs_F2, Room_2102, Room_2130, Elevator_F2, Room_2150, 
        //Room_2149;

        //Stairs_F2.setExit("

        currentRoom = JAAC_Entrance;

        //talking

        
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        //println();
        // println("Welcome to the World of Zuul!");
        // println("World of Zuul is a new, incredibly boring adventure game.");
        // println("Type 'help' if you need help.");
        // println();
        //println("You are at " + currentRoom.getDescription());
        // print("Exits: ");
        // if(currentRoom.northExit != null) {
        // print("north ");
        // }
        // if(currentRoom.eastExit != null) {
        // print("east ");
        // }
        // if(currentRoom.southExit != null) {
        // print("south ");
        // }
        // if(currentRoom.westExit != null) {
        // print("west ");
        // }

        println(currentRoom.getLongDescription());
    }

    //implement talking?
    private void speak(Command speech)
    {
        println("You get no reply. How rude!");
    }

    private void look(Command speech)
    {
        println("What are you looking at?");
    }
    
    private void yes(Command speech)
    {
        println("Why don't you go yes yourself.");
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private void processCommand(Command command) 
    {
        
        if(command.isUnknown()) {
            println("I don't know what you mean...");
            return;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            quit(command);
        }
        else if (commandWord.equals("speak")) {
            speak(command);
        }
        else if (commandWord.equals("look")) {
            look(command);
        }
        else if (commandWord.equals("yes")){
            yes(command);
        }
        else if (commandWord.equals("no")) {

        }
    }
    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        println("You are lost. You are alone. You wander");
        println("around in the JAAC the university.");
        println();
        println("Your command words are:");
        println("   go quit help");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            println("Go where?");
            println();
            return;
        }

        String direction = command.getSecondWord();

        //direction.
        Room nextRoom = null;
        nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            println("Ouch! You ran into a wall. " +
                "Try a different direction.");
        }
        else {
            currentRoom = nextRoom;

            println(currentRoom.getLongDescription());
            //println();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private void quit(Command command) 
    {
        if(command.hasSecondWord()) {
            println("Quit what?");
            return;
        }

        wantToQuit = true;  // signal that we want to quit
    }

    /****************************************************************
     * If you want to launch an Applet
     ****************************************************************/

    /**
     * @return an Image from the current room
     * @see Image
     */
    public String getImage()
    {
        return currentRoom.getImage();
    }

    /**
     * @return an audio clip from the current room
     * @see AudioClip
     */
    public String getAudio()
    {
        return currentRoom.getAudio();
    }

    /****************************************************************
     * Variables & Methods added 2018-04-16 by William H. Hooper
     ****************************************************************/

    private String messages;
    private boolean wantToQuit;

    /**
     * Initialize the new variables and begin the game.
     */
    private void start()
    {
        messages = "";
        wantToQuit = false;
        printWelcome();
    }

    /**
     * process commands or queries to the game
     * @param input user-supplied input
     */
    public void processInput(String input)
    {
        if(finished()) {
            println("This game is over.  Please go away.");
            return;
        }

        Command command = parser.getCommand(input);
        processCommand(command);
    }

    /**
     * clear and return the output messages
     * @return current contents of the messages.
     */
    public String readMessages()
    {
        if(messages == null) {
            start();
        }
        String oldMessages = messages;
        messages = "";
        return oldMessages;
    }

    /**
     * @return true when the game is over.
     */
    public boolean finished()
    {
        return wantToQuit;
    }

    /**
     * add a message to the output list.
     * @param message the string to be displayed
     */
    private void print(String message)
    {
        messages += message;
    }

    /**
     * add a message to the output list, 
     * followed by newline.
     * @param message the string to be displayed
     * @see readMessages
     */
    private void println(String message)
    {
        print(message + "\n");
    }

    /**
     * add a blank line to the output list.
     */
    private void println()
    {
        println("");
    }

    //8.5
    private void printLocationInfo()
    {
        println("You are " + currentRoom.getLongDescription());
    }

    //8.6
}

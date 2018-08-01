import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private List<Room> rooms;
    private List<Suspect> suspects;
    private ConfidentialFolder folder;
    private List<Weapon> weapons;
    private boolean playerHasWon = false;
    private Board board;
    private Suspect currentPlayer;

    public Game() {
        board = new Board();
        boardPrep();
        //setup();
        play();
    }


    private void play() {
        while(!playerHasWon) {
            // Go through players clock wise

            int dice = (int) (Math.random()*12) + 1;
            // Present choices to players
            System.out.println("You rolled + " );
            board.moveSuspect();


        }
    }

    public void boardPrep() {
        // Make the tiles

        // Make the rooms
        // Might not need private fields for the rooms, suspects and folder, might just create them here and
        // then pass them all into board
        List<String> roomNames = new ArrayList<>(Arrays.asList("Cellar", "Kitchen", "Ballroom", "Conservatory", "Dining Room", "Library", "Lounge", "Hall", "Study"));
        List<String> weaponNames = new ArrayList<>(Arrays.asList("Candlestick", ""))

        for(String roomName : roomNames) {
            rooms.add(new Room(roomName));
        }


        // Make the weapons
        weapons.add(new Weapon("Candlestick"));
        weapons.add(new Weapon("Knife"));
        weapons.add(new Weapon("Lead Pipe"));
        weapons.add(new Weapon("Revolver"));
        weapons.add(new Weapon("Rope"));
        weapons.add(new Weapon("Wrench"));

        // Make the suspects
        suspects.add(new Suspect("Miss Scarlet"));
        suspects.add(new Suspect("Professor Plum"));
        suspects.add(new Suspect("Mrs. Peacock"));
        suspects.add(new Suspect("Mr. Green"));
        suspects.add(new Suspect("Colonel Mustard"));
        suspects.add(new Suspect("Mrs. White"));

        // Assign everything to the tiles
    }

    private void setup(List<Suspect> suspects, List<Room> rooms, List<Weapon> weapons) {
        // Shuffle
        List<Suspect> suspectsCopy = suspects;
        List<Room> roomsCopy = rooms;
        List<Weapon> weaponsCopy = weapons;

        Collections.shuffle(suspectsCopy);
        Collections.shuffle(roomsCopy);
        Collections.shuffle(weaponsCopy);

        Suspect murderer = suspectsCopy.remove(0);
        Room usedRoom = roomsCopy.remove(0);
        Weapon usedWeapon = weaponsCopy.remove(0);
        //ConfidentialFolder folder = new ConfidentialFolder(murderer, usedWeapon, usedRoom);


    }

    public static void main(String[] args) {
        Game game = new Game();
    }
}

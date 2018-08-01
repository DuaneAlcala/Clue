import java.util.*;

public class Game {
    private List<Room> rooms;
    private List<Suspect> suspects;
    private ConfidentialFolder folder;
    private List<Weapon> weapons;
    private boolean playerHasWon = false;
    private Board board;
    private Suspect currentPlayer;

    private Scanner sc;

    private int numTurns = 0;
    private int numPlayers = 0;
    private boolean gameGoing;

    public Game() {
        sc = new Scanner(System.in);
        board = new Board();
        boardPrep();
        gameGoing = true;
        //setup();
        play();
    }


    private void play() {
        System.out.println("Welcome to Cluedo");

        numPlayers = Input.readInt(sc, "Please select the number of player to play with (3-6)");
        while(numPlayers < 3 || numPlayers > 6) {
            System.out.println("Select a proper amount of players");
            numPlayers = Input.readInt(sc, "Please select the number of players to play with (3-6)");
        }
        System.out.println();
        System.out.println("Setting up the board and handing out cards...");

        while(gameGoing) {
            currentPlayer = suspects.get(numTurns % numPlayers);
            currentPlayer.doTurn(board);

            // Checking if the current player got an accusation right and won
            if(currentPlayer.getHasAccused()) {
                if(currentPlayer.getAccuseResult()) {
                    gameGoing = false;
                    playerHasWon = true;
                }else if(!currentPlayer.getAccuseResult()) {
                    currentPlayer.setPlaying(false);
                }
            }

            // Checking if everyone has failed their accusations and no one else can play
            boolean allWrongAccused = true;
            for(Suspect suspect : suspects) {
                if(!suspect.getAccuseResult()) allWrongAccused = false;
            }
            if(allWrongAccused) {
                gameGoing = false;
            }

            numTurns++;
        }

        if(playerHasWon) {
            System.out.println(currentPlayer.getName() + " solved the murder and won!");
        }else {
            System.out.println("No one could solve the murder. Everyone handed the wrong accusations.");
        }
        System.out.println("Thanks for playing Cluedo!");
    }

    public void boardPrep() {
        // Make the tiles

        // Make the rooms
        // Might not need private fields for the rooms, suspects and folder, might just create them here and
        // then pass them all into board
        List<String> roomNames = new ArrayList<>(Arrays.asList("Cellar", "Kitchen", "Ballroom", "Conservatory", "Dining Room", "Library", "Lounge", "Hall", "Study"));
        //List<String> weaponNames = new ArrayList<>(Arrays.asList("Candlestick", ""))

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

import java.util.*;

public class Game {
    private List<Room> rooms;
    private List<Suspect> suspects;
    private ConfidentialFolder folder;
    private List<Weapon> weapons;
    private Board board;
    private Suspect currentPlayer;

    private Scanner sc;

    private int numTurns = 0;
    private int numPlayers = 0;
    private boolean gameGoing = true;
    private boolean playerHasWon = false;

    public Game() {
        sc = new Scanner(System.in);
        suspects = new ArrayList<>();
        weapons = new ArrayList<>();
        rooms = new ArrayList<>();
        board = new Board();

        setup();
        play();
    }

    // This shit should be in some utilities package
    // probably remove this shit
    public static enum Direction {
        NORTH, SOUTH, EAST, WEST;

        public static boolean checkDirection(String direction) {
            return (direction.toUpperCase().equals("N") ||
                    direction.toUpperCase().equals("S") ||
                    direction.toUpperCase().equals("E") ||
                    direction.toUpperCase().equals("W"));
        }

        public static Direction getDirection(String direction) {
            if(direction.toUpperCase().equals("N")) return NORTH;
            if(direction.toUpperCase().equals("S")) return SOUTH;
            if(direction.toUpperCase().equals("E")) return EAST;
            if(direction.toUpperCase().equals("W")) return WEST;
            return null;
        }
    }

    private void setup() {
        System.out.println("Welcome to Cluedo");

        numPlayers = Input.readInt(sc, "Please select the number of player to play with (3-6)");
        while(numPlayers < 3 || numPlayers > 6) {
            System.out.println("Select a proper amount of players");
            numPlayers = Input.readInt(sc, "Please select the number of players to play with (3-6)");
        }
        System.out.println();
        System.out.println("Setting up the board and handing out cards...");

        List<String> suspectNames = new ArrayList<>(Arrays.asList("Mrs. White", "Mr. Green", "Mrs. Peacock", "Prof. Plum", "Miss Scarlett", "Col. Mustard"));
        List<String> weaponNames = new ArrayList<>(Arrays.asList("Candlestick", "Dagger", "Lead Pipe", "Revolver", "Rope", "Spanner"));
        List<String> roomNames = new ArrayList<>(Arrays.asList("Kitchen", "Ballroom", "Conservatory", "Billiard Room", "Library", "Study", "Hall", "Lounge", "Dining Room"));

        List<Card> suspectCards = new ArrayList<>();
        List<Card> weaponCards = new ArrayList<>();
        List<Card> roomCards = new ArrayList<>();

        for(int i = 0; i < numPlayers; i++) {
            suspects.add(new Suspect(suspectNames.get(i)));
        }

        // wtf happens if there are less than 6 do you still give all the cards
        for(String suspectName : suspectNames) {
            suspectCards.add(new Card(suspectName));
        }

        for(String weaponName : weaponNames) {
            weapons.add(new Weapon(weaponName));
            weaponCards.add(new Card(weaponName));
        }

        for(String roomName : roomNames) {
            rooms.add(new Room(roomName));
            roomCards.add(new Card(roomName));
        }

        Collections.shuffle(suspectCards);
        Collections.shuffle(weaponCards);
        Collections.shuffle(roomCards);

        folder = new ConfidentialFolder(suspectCards.remove(0), weaponCards.remove(0), roomCards.remove(0));

        List<Card> allCards = new ArrayList<>();
        allCards.addAll(suspectCards);
        allCards.addAll(weaponCards);
        allCards.addAll(roomCards);

        Collections.shuffle(allCards);


        // Giving cards to players
        int i = 0;
        while(allCards.size() > 0) {
            suspects.get(i % numPlayers).addCard(allCards.remove(0));
            i++;
        }
    }

    private void play() {
        while(gameGoing) {
            currentPlayer = suspects.get(numTurns % numPlayers);
            if(!currentPlayer.isPlaying()) {

            }else {

            }
            currentPlayer.doTurn(board, sc, this);

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

    public List<Suspect> getSuspects() {
        return suspects;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public static void main(String[] args) {
        new Game();
    }

    public ConfidentialFolder getFolder() {
        return folder;
    }
}

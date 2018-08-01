import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Suspect {
    private String name;
    private List<Card> cards;
    private Color color;
    private Room currentRoom;
    private boolean hasAccused;
    private boolean playing;
    private boolean accuseResult;

    public Suspect(String name) {
        this.name = name;
        cards = new ArrayList<>();
        hasAccused = false;
        playing = true;
    }

    public void doTurn(Board board, Scanner sc, Game gameInstance) {
        System.out.println(name + "'s turn");

        int diceResult = (int) (Math.random() * 12) + 1;
        System.out.println("You rolled both dice and got " + diceResult + ". What will you do?");

        String action = "";
        action = displayOptions();

        if(action.toUpperCase().equals("M")){
            move(board, diceResult, sc, gameInstance);
        }
    }

    public String displayOptions() {
        String action = "";
        System.out.println("Enter the letter at the start of the sentence to execute that action");
        System.out.println("(M) Move");
        if(currentRoom != null) {
            System.out.println("(S) Make a suggestion");
        }
        System.out.println("(A) Make an accusation");
        System.out.println("(V) View cards");


        // get the inputs here

        // if it's wrong say please enter proper input then display dice result then options

        return action;
    }

    public void move(Board board, int diceResult, Scanner sc, Game gameInstance) {
        System.out.println("");
        // print the board
        while(diceResult > 0) {
            boolean properMove = false;
            int numMoves = 0;
            String direction = "";

            // Still has problems what if they input 5 WWDA AWD it would still accept it
            // Check for the length and then if the length is ok then
            while(!properMove) {
                String input = Input.readString(sc,"Enter the number of moves, a space, and then the direction you want to move in");
                char inputArray[] = new char[2];
                char movesEntered = input.charAt(0);
                char directionEntered = input.charAt(1);
                if(input.length() == 3) {
                    if(Character.isDigit(movesEntered) && Character.isLetter(directionEntered)){
                        numMoves = Character.getNumericValue(movesEntered);
                        direction = String.valueOf(directionEntered);
                        properMove = true;
                    }else{
                        System.out.println("Please enter the proper format eg. 5 N");
                    }
                }else{
                    System.out.println("Please enter the proper format eg. 5 N");
                }
            }

            // prompt for number and then the direction

            // check if it's valid on the board and while loop until valid

            // you can end your move turns also and just stop moving
        }
    }

    private void viewCards() {
        for(Card card : cards) {
            System.out.print(card.getCardName() + " ");
        }
        System.out.println();
    }

    public void makeSuggestion(Scanner sc, Game gameInstance) {
        List<String> assumptions = getAssumptions(sc, gameInstance);

        String suspectSuggestion = assumptions.get(0);
        String weaponSuggestion = assumptions.get(1);
        String roomSuggestion = assumptions.get(2);

        boolean provenFalse = false;
        for(Suspect suspect : gameInstance.getSuspects()) {
           if(!suspect.getName().equals(this.name)) {

           }
        }
    }

    private List<String> getAssumptions(Scanner sc, Game gameInstance) {
        String suspectAccusation = "";
        String weaponAccusation = "";
        String roomAccusation = "";

        boolean properSuspect = false;
        boolean properWeapon = false;
        boolean properRoom = false;

        // Probably change to while trues
        while(!properSuspect) {
            suspectAccusation = Input.readString(sc, "Accuse a suspect");
            for(Suspect suspect : gameInstance.getSuspects()) {
                if(suspect.getName().equals(suspectAccusation)) {
                    properSuspect = true;
                    break;
                }
            }
            System.out.println("");
        }

        while(!properWeapon) {
            weaponAccusation = Input.readString(sc, "Accuse a weapon");
            for(Weapon weapon : gameInstance.getWeapons()) {
                if(weapon.getName().equals(weaponAccusation)) {
                    properWeapon = true;
                    break;
                }
            }
        }

        while(!properRoom) {
            roomAccusation = Input.readString(sc, "Accuse a room");
            for(Room room : gameInstance.getRooms()) {
                if(room.getName().equals(roomAccusation)){
                    properRoom = true;
                    break;
                }
            }
        }

        return new ArrayList<>(Arrays.asList(suspectAccusation, weaponAccusation, roomAccusation));
    }

    public void makeAccusation(Scanner sc, Game gameInstance) {
        hasAccused = true;

        ConfidentialFolder folder = gameInstance.getFolder();
        List<String> assumptions = getAssumptions(sc, gameInstance);

        String suspectAccusation = assumptions.get(0);
        String weaponAccusation = assumptions.get(1);
        String roomAccusation = assumptions.get(2);
        accuseResult = folder.verifyAccusation(suspectAccusation, weaponAccusation, roomAccusation);

        if(!accuseResult) {

            playing = false;
        }
    }

    public boolean isPlaying() {
        return playing;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public boolean getHasAccused() {
        return hasAccused;
    }

    public boolean getAccuseResult() {
        return accuseResult;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
}

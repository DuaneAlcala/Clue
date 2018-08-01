import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

    public void doTurn(Board board) {
        System.out.println(name + "'s turn");

        int diceResult = (int) (Math.random() * 12) + 1;
        System.out.println("You rolled both dice and got " + diceResult + ". What will you do?");

        String action = "";
        action = displayOptions();

        if(action.toUpperCase().equals("M")){
            move(board, diceResult);
        }
    }

    public String displayOptions() {
        String action = "";
        System.out.println("Enter the letter at the start of the sentence to execute that action");
        System.out.println("(M) Move");
        System.out.println("(S) Make a suggestion");
        System.out.println("(A) Make an accusation");
        System.out.println("(V) View cards");


        // get the inputs here

        // if it's wrong say please enter proper input then display dice result then options

        return action;
    }

    public void move(Board board, int diceResult) {
        System.out.println("Enter the number of moves and then the direction you want to move in");
        while(diceResult > 0) {
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

    public void makeSuggestion(String suspectName, String weaponName, String roomName) {

    }

    public void makeAccusation(String suspectName, String weaponName, String roomName) {
        hasAccused = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

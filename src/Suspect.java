import javax.smartcardio.Card;
import java.awt.*;
import java.util.List;

public class Suspect {
    private String name;
    private List<Card> cards;
    private Color color;

    public Suspect(String name) {
        this.name = name;
    }

    public void makeSuggestion(String suspectName, String weaponName, String roomName) {

    }

    public void makeAccusation(String suspectName, String weaponName, String roomName) {

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
}

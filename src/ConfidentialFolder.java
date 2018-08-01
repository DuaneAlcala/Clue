public class ConfidentialFolder {
    private Card suspect;
    private Card weapon;
    private Card room;

    public ConfidentialFolder(Card suspect, Card weapon, Card room) {
        this.suspect = suspect;
        this.weapon = weapon;
        this.room = room;
    }

    public boolean verifyAccusation(String suspect, String weapon, String room) {
        return (this.suspect.getCardName().equals(suspect) &&
                this.weapon.getCardName().equals(weapon) &&
                this.room.getCardName().equals(room));
    }
}

public class ConfidentialFolder {
    private Card.SuspectCard suspect;
    private Card.WeaponCard weapon;
    private Card.RoomCard room;

    public ConfidentialFolder(Card.SuspectCard suspect, Card.WeaponCard weapon, Card.RoomCard room) {
        this.suspect = suspect;
        this.weapon = weapon;
        this.room = room;
    }

    public boolean verifyAccusation(Card.SuspectCard suspect, Card.WeaponCard weapon, Card.RoomCard room) {
        return (this.suspect.getSuspectName().equals(suspect.getSuspectName()) &&
                this.weapon.getWeaponName().equals(weapon.getWeaponName()) &&
                this.room.getRoomName().equals(room.getRoomName()));
    }
}

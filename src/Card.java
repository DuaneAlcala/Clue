import java.util.Objects;

public class Card {

    public static class SuspectCard {
        private String suspectName;

        public SuspectCard(String suspectName) {
            this.suspectName = suspectName;
        }

        public String getSuspectName() {
            return suspectName;
        }
    }

    public static class WeaponCard {
        private String weaponName;

        public WeaponCard(String weaponName) {
            this.weaponName = weaponName;
        }

        public String getWeaponName() {
            return weaponName;
        }
    }

    public static class RoomCard {
        private String roomName;

        public RoomCard(String roomName) {
            this.roomName = roomName;
        }

        public String getRoomName() {
            return roomName;
        }
    }
}

public abstract class Tile {

    public abstract void display();

    public static class MoveTile extends Tile {
        private int x;
        private int y;
        private Room room;
        private Suspect suspect;

        // Probably want to make an enum for direction
        private String roomDirection;

        public MoveTile(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // certain x y tiles will have a room attached and a direction
        private void setRoom(Room room) {
            this.room = room;
        }

        // Can be null
        private void setSuspect(Suspect suspect) {
            this.suspect = suspect;
        }

        @Override
        public void display() {

        }
    }

    public static class BlankTile extends Tile {
        private int x;
        private int y;

        public BlankTile(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void display() {

        }
    }

    public static class RoomTile extends Tile {
        private String suspectName;
        private int x;
        private int y;

        public RoomTile(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void display() {

        }
    }

    public static class StartTile extends Tile {
        private String suspectName;
        private int x;
        private int y;

        public StartTile(String suspectName, int x, int y) {
            this.suspectName = suspectName;
            this.x = x;
            this.y = y;
        }

        @Override
        public void display() {

        }
    }
}

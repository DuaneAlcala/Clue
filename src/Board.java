import java.util.List;

public class Board {
    private List<Suspect> suspects;
    private List<Weapon> weapons;
    private List<Room> rooms;
    private Suspect currentPlayer;
    private Tile[][] tiles;
    private int boardWidth = 22;
    private int boardHeight = 22;

    public Board() {
        setTiles();
    }

    private void setTiles() {
        for(int i = 0; i < boardWidth; i++) {
            for(int j = 0; j < boardHeight; j++) {
                tiles[i][j] = new Tile.MoveTile(i ,j);
            }
        }

        // Setting up the tiles of the rooms, if the player tries to move to that tile, they are not allowed
        for(Room room : rooms) {
            for(int i = room.getTileX(); i < room.getTileWidth() + 1; i++) {
                for(int j = room.getTileY(); j < room.getTileHeight() + 1; j++) {
                    tiles[i][j] = new Tile.BlankTile(i, j);
                }
            }
        }
    }

    public void displayTiles() {
        for(int i = 0; i < tiles[i].length; i++) {
            for(int j = 0; j < tiles[j].length; j++) {
                tiles[i][j].display();
            }
        }
    }

    public void moveSuspect() {

    }
}

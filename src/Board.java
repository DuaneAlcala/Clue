import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Board {
    private List<Suspect> suspects;
    private List<Weapon> weapons;
    private List<Room> rooms;
    private Suspect currentPlayer;
    private Tile[][] tiles;
    private int width = 24;
    private int height = 25;

    public Board() {

    }

    public boolean loadBoard(File board) {
        BufferedImage boardImage = null;
        try {
            boardImage = ImageIO.read(board);
        }catch (IOException e) {
            e.printStackTrace();
        }

        if(boardImage == null) {
            return false;
        }

        // Getting pixels and then loading board
        tiles = new Tile[width][height];
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                Color color = new Color(boardImage.getRGB(x, y));
                Tile tile = getTile(color, x, y);
                tiles[x][y] = tile;
            }
        }
        return true;
    }

    private Tile getTile(Color color, int x, int y) {
        Color normalTile = new Color(255, 216, 0); // normal tile
        Color roomTile = new Color(0, 148, 255);
        Color unplayableTile = new Color(255, 127, 127);

        if(color.equals(normalTile)) {
            return new Tile.MoveTile(x, y);
        }
        if(color.equals(roomTile)) {
            return new Tile.RoomTile(x, y);
        }
        if(color.equals(unplayableTile)) {
            return new Tile.BlankTile(x, y);
        }
        return null;
    }

    public void displayTiles() {
        for(int i = 0; i < tiles[i].length; i++) {
            for(int j = 0; j < tiles[j].length; j++) {
                tiles[i][j].display();
            }
        }
    }

    public void moveSuspect(int numMoves, Game.Direction direction) {

    }
}

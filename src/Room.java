import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private List<Suspect> suspects;
    private List<Weapon> weapons;
    private int tileX;
    private int tileY;
    private int tileWidth;
    private int tileHeight;
    private boolean isCornerRoom;
    private Room secretPassageRoom;

    public Room(String name) {
        this.name = name;
    }

    public Room(String name, int tileX, int tileY, int tileWidth, int tileHeight) {
        this.name = name;
        this.tileX = tileX;
        this.tileY = tileY;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

        this.suspects = new ArrayList<>();
        this.weapons = new ArrayList<>();
    }

    // For constructing the board
    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }
}

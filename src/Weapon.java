public class Weapon {
    private String name;
    private Room room;

    public Weapon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

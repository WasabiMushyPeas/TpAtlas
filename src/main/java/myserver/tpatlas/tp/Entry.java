package myserver.tpatlas.tp;

public class Entry {

    private int x;
    private int y;
    private int z;

    private String playerName;
    private String locationName;

    public Entry(int x, int y, int z, String playerName, String locationName) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.playerName = playerName;
        this.locationName = locationName;
    }

    public Entry(int x, int y, int z, String playerName) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.playerName = playerName;
        this.locationName = "X: " + x + " Y: " + y + " Z: " + z;
    }

    // Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}

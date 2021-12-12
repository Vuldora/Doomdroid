package awesome.vulldozer.doombuilder;

public class Thing {
    // These variables should be treated like short16_t meaning the max value shouldn't be higher than 65535
    private short x; // Starting x position on map
    private short y; // Starting y position on map
    private short angle; // Starting facing angle
    private short type; // The ID for the thing I think
    private short flags; // multiplayer, ambush, difficulty flags
    //region Getters and Setters
    public short getX() { return x; }
    public short getY() { return y; }
    public short getAngle() { return angle; }
    public short getType() { return type; }
    public short getFlags() { return flags; }
    public void setX(short x) { this.x = x; }
    public void setY(short y) { this.y = y; }
    public void setAngle(short angle) { this.angle = angle; }
    public void setType(short type) { this.type = type; }
    public void setFlags(short flags) { this.flags = flags; }
    //endregion

}

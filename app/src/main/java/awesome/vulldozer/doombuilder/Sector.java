package awesome.vulldozer.doombuilder;

public class Sector {
    private short floorHeight;
    private short ceilingHeight;
    private long floorTexture;
    private long ceilingTexture;
    private short brightness;
    private short specialType;
    private short tag;
    //region Getters and Setters
    public short getFloorHeight() { return floorHeight; }
    public short getCeilingHeight() { return ceilingHeight; }
    public long getFloorTexture() { return floorTexture; }
    public long getCeilingTexture() { return ceilingTexture; }
    public short getBrightness() { return brightness; }
    public short getSpecialType() { return specialType; }
    public short getTag() { return tag; }
    public void setFloorHeight(short floorHeight) { this.floorHeight = floorHeight; }
    public void setCeilingHeight(short ceilingHeight) { this.ceilingHeight = ceilingHeight; }
    public void setFloorTexture(long floorTexture) { this.floorTexture = floorTexture; }
    public void setCeilingTexture(long ceilingTexture) { this.ceilingTexture = ceilingTexture; }
    public void setBrightness(short brightness) { this.brightness = brightness; }
    public void setSpecialType(short specialType) { this.specialType = specialType; }
    public void setTag(short tag) { this.tag = tag; }
    //endregion
}

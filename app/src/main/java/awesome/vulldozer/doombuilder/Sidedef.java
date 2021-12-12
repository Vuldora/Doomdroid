package awesome.vulldozer.doombuilder;

public class Sidedef {
    private short xOffset;
    private short yOffset;
    private long upperTexture;
    private long lowerTexture;
    private long middleTexture;
    private short facingSector;
    //region Getters and Setters
    public short getxOffset() { return xOffset; }
    public short getyOffset() { return yOffset; }
    public long getUpperTexture() { return upperTexture; }
    public long getLowerTexture() { return lowerTexture; }
    public long getMiddleTexture() { return middleTexture; }
    public short getFacingSector() { return facingSector; }
    public void setxOffset(short xOffset) { this.xOffset = xOffset; }
    public void setyOffset(short yOffset) { this.yOffset = yOffset; }
    public void setUpperTexture(long upperTexture) { this.upperTexture = upperTexture; }
    public void setLowerTexture(long lowerTexture) { this.lowerTexture = lowerTexture; }
    public void setMiddleTexture(long middleTexture) { this.middleTexture = middleTexture; }
    public void setFacingSector(short facingSector) { this.facingSector = facingSector; }
    //endregion
}

package awesome.vulldozer.doombuilder;

public class Linedef {
    private short startVertex;
    private short endVertex;
    private short flags;
    private short specialType;
    private short sectorTag;
    private short frontSidedef;
    private short backSidedef;
    //region Getters and Setters
    public short getStartVertex() { return startVertex; }
    public short getEndVertex() { return endVertex; }
    public short getFlags() { return flags; }
    public short getSpecialType() { return specialType; }
    public short getSectorTag() { return sectorTag; }
    public short getFrontSidedef() { return frontSidedef; }
    public short getBackSidedef() { return backSidedef; }
    public void setStartVertex(short startVertex) { this.startVertex = startVertex; }
    public void setEndVertex(short endVertex) { this.endVertex = endVertex; }
    public void setFlags(short flags) { this.flags = flags; }
    public void setSpecialType(short specialType) { this.specialType = specialType; }
    public void setSectorTag(short sectorTag) { this.sectorTag = sectorTag; }
    public void setFrontSidedef(short frontSidedef) { this.frontSidedef = frontSidedef; }
    public void setBackSidedef(short backSidedef) { this.backSidedef = backSidedef; }
    //endregion
}

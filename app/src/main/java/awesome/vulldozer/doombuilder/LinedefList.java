package awesome.vulldozer.doombuilder;

public class LinedefList
{
    //region Variables
    private Linedef[] linedefs;
    private int count;
    //endregion
    //region Getters and Setters
    public Linedef[] getLinedefs() { return linedefs; }
    public int getCount() { return count; }
    public void setLinedefs(Linedef[] linedefs) { this.linedefs = linedefs; }
    public void setCount(int count) { this.count = count; }
    //endregion
    //region Constructors
    public LinedefList() { count = 0; }
    //endregion
    //region Functions
    public void addLinedef(short startVertex,short endVertex, short flags,short specialType, short sectorTag,short frontSidedef,short backSidedef)
    {
        Linedef[] newLinedefs = new Linedef[count + 1];
        for (int i = 0; i < newLinedefs.length;i++)
        {
            newLinedefs[i] = new Linedef();
        }
        for(int i = 0; i < count;i++)
        {
            newLinedefs[i].setStartVertex(this.linedefs[i].getStartVertex());
            newLinedefs[i].setEndVertex(this.linedefs[i].getEndVertex());
            newLinedefs[i].setFlags(this.linedefs[i].getFlags());
            newLinedefs[i].setSpecialType(this.linedefs[i].getSpecialType());
            newLinedefs[i].setSectorTag(this.linedefs[i].getSectorTag());
            newLinedefs[i].setFrontSidedef(this.linedefs[i].getFrontSidedef());
            newLinedefs[i].setBackSidedef(this.linedefs[i].getBackSidedef());
        }
        newLinedefs[count].setStartVertex(startVertex);
        newLinedefs[count].setEndVertex(endVertex);
        newLinedefs[count].setFlags(flags);
        newLinedefs[count].setSpecialType(specialType);
        newLinedefs[count].setSectorTag(sectorTag);
        newLinedefs[count].setFrontSidedef(frontSidedef);
        newLinedefs[count].setBackSidedef(backSidedef);
        count++;
        linedefs = newLinedefs;
    }
    public void addLinedef(Linedef linedef)
    {
        Linedef[] newLinedefs = new Linedef[count + 1];
        for (int i = 0; i < newLinedefs.length;i++)
        {
            newLinedefs[i] = new Linedef();
        }
        for(int i = 0; i < count;i++)
        {
            newLinedefs[i].setStartVertex(this.linedefs[i].getStartVertex());
            newLinedefs[i].setEndVertex(this.linedefs[i].getEndVertex());
            newLinedefs[i].setFlags(this.linedefs[i].getFlags());
            newLinedefs[i].setSpecialType(this.linedefs[i].getSpecialType());
            newLinedefs[i].setSectorTag(this.linedefs[i].getSectorTag());
            newLinedefs[i].setFrontSidedef(this.linedefs[i].getFrontSidedef());
            newLinedefs[i].setBackSidedef(this.linedefs[i].getBackSidedef());
        }
        newLinedefs[count].setStartVertex(linedef.getStartVertex());
        newLinedefs[count].setEndVertex(linedef.getEndVertex());
        newLinedefs[count].setFlags(linedef.getFlags());
        newLinedefs[count].setSpecialType(linedef.getSpecialType());
        newLinedefs[count].setSectorTag(linedef.getSectorTag());
        newLinedefs[count].setFrontSidedef(linedef.getFrontSidedef());
        newLinedefs[count].setBackSidedef(linedef.getBackSidedef());
        count++;
        linedefs = newLinedefs;
    }
    public byte[] toByteArray()
    {
        ByteList byteList = new ByteList();
        for (int i = 0; i < linedefs.length;i++)
        {
            byteList.addByteArray(linedefs[i].toByteArray());
        }
        return byteList.getBytes();
    }
    //endregion
}

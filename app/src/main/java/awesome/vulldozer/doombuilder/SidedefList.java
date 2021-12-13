package awesome.vulldozer.doombuilder;

public class SidedefList {
    //region Variabels
    private Sidedef[] sidedefs;
    private int count;
    //endregion
    //region Getters and Setters
    public Sidedef[] getSidedefs() { return sidedefs; }
    public int getCount() { return count; }
    public void setSidedefs(Sidedef[] sidedefs) { this.sidedefs = sidedefs; }
    public void setCount(int count) { this.count = count; }
    //endregion
    //region Constructors
    public SidedefList() { count = 0; }
    //endregion
    //region Functions
    public void addSidedef(short xOffset,short yOffset,long upperTexture,long lowerTexture,long middleTexture,short facingSector)
    {
        Sidedef[] newSidedefs = new Sidedef[count + 1];
        for (int i = 0; i < newSidedefs.length;i++)
        {
            newSidedefs[i] = new Sidedef();
        }
        for(int i = 0; i < count;i++)
        {
            newSidedefs[i].setxOffset(this.sidedefs[i].getxOffset());
            newSidedefs[i].setyOffset(this.sidedefs[i].getyOffset());
            newSidedefs[i].setUpperTexture(this.sidedefs[i].getUpperTexture());
            newSidedefs[i].setLowerTexture(this.sidedefs[i].getLowerTexture());
            newSidedefs[i].setMiddleTexture(this.sidedefs[i].getMiddleTexture());
            newSidedefs[i].setFacingSector(this.sidedefs[i].getFacingSector());
        }
        newSidedefs[count].setxOffset(xOffset);
        newSidedefs[count].setyOffset(yOffset);
        newSidedefs[count].setUpperTexture(upperTexture);
        newSidedefs[count].setLowerTexture(lowerTexture);
        newSidedefs[count].setMiddleTexture(middleTexture);
        newSidedefs[count].setFacingSector(facingSector);
        count++;
        sidedefs = newSidedefs;
    }
        public void addSidedef(Sidedef sidedef)
    {
        Sidedef[] newSidedefs = new Sidedef[count + 1];
        for (int i = 0; i < newSidedefs.length;i++)
        {
            newSidedefs[i] = new Sidedef();
        }
        for(int i = 0; i < count;i++)
        {
            newSidedefs[i].setxOffset(this.sidedefs[i].getxOffset());
            newSidedefs[i].setyOffset(this.sidedefs[i].getyOffset());
            newSidedefs[i].setUpperTexture(this.sidedefs[i].getUpperTexture());
            newSidedefs[i].setLowerTexture(this.sidedefs[i].getLowerTexture());
            newSidedefs[i].setMiddleTexture(this.sidedefs[i].getMiddleTexture());
            newSidedefs[i].setFacingSector(this.sidedefs[i].getFacingSector());
        }
        newSidedefs[count].setxOffset(sidedef.getxOffset());
        newSidedefs[count].setyOffset(sidedef.getyOffset());
        newSidedefs[count].setUpperTexture(sidedef.getUpperTexture());
        newSidedefs[count].setLowerTexture(sidedef.getLowerTexture());
        newSidedefs[count].setMiddleTexture(sidedef.getMiddleTexture());
        newSidedefs[count].setFacingSector(sidedef.getFacingSector());
        count++;
        sidedefs = newSidedefs;
    }
    public byte[] toByteArray()
    {
        ByteList byteList = new ByteList();
        for (int i = 0; i < sidedefs.length;i++)
        {
            byteList.addByteArray(sidedefs[i].toByteArray());
        }
        return byteList.getBytes();
    }
    //endregion
}

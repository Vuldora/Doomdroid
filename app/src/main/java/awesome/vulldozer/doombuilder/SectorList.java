package awesome.vulldozer.doombuilder;

public class SectorList {
    //region Variables
    private Sector[] sectors;
    private int count;
    //endregion
    //region Getters and Setters
    public Sector[] getSectors() { return sectors; }
    public int getCount() { return count; }
    public void setSectors(Sector[] sectors) { this.sectors = sectors; }
    public void setCount(int count) { this.count = count; }
    //endregion
    //region Constructors
    public SectorList() { count = 0; }
    //endregion
    //region Functions
    public void addSector(short floorHeight,short ceilingHeight,long floorTexture,long ceilingTexture,short brightness,short specialType,short tag)
    {
        Sector[] newSectors = new Sector[count + 1];
        for (int i = 0; i < newSectors.length;i++)
        {
            newSectors[i] = new Sector();
        }
        for(int i = 0; i < count;i++)
        {
            newSectors[i].setFloorHeight(this.sectors[i].getFloorHeight());
            newSectors[i].setCeilingHeight(this.sectors[i].getCeilingHeight());
            newSectors[i].setFloorTexture(this.sectors[i].getFloorTexture());
            newSectors[i].setCeilingTexture(this.sectors[i].getCeilingTexture());
            newSectors[i].setBrightness(this.sectors[i].getBrightness());
            newSectors[i].setSpecialType(this.sectors[i].getSpecialType());
            newSectors[i].setTag(this.sectors[i].getTag());
        }
        newSectors[count].setFloorHeight(floorHeight);
        newSectors[count].setCeilingHeight(ceilingHeight);
        newSectors[count].setFloorTexture(floorTexture);
        newSectors[count].setCeilingTexture(ceilingTexture);
        newSectors[count].setBrightness(brightness);
        newSectors[count].setSpecialType(specialType);
        newSectors[count].setTag(tag);
        count++;
        sectors = newSectors;
    }
    public void addSector(Sector sector)
    {
        Sector[] newSectors = new Sector[count + 1];
        for (int i = 0; i < newSectors.length;i++)
        {
            newSectors[i] = new Sector();
        }
        for(int i = 0; i < count;i++)
        {
            newSectors[i].setFloorHeight(this.sectors[i].getFloorHeight());
            newSectors[i].setCeilingHeight(this.sectors[i].getCeilingHeight());
            newSectors[i].setFloorTexture(this.sectors[i].getFloorTexture());
            newSectors[i].setCeilingTexture(this.sectors[i].getCeilingTexture());
            newSectors[i].setBrightness(this.sectors[i].getBrightness());
            newSectors[i].setSpecialType(this.sectors[i].getSpecialType());
            newSectors[i].setTag(this.sectors[i].getTag());
        }
        newSectors[count].setFloorHeight(sector.getFloorHeight());
        newSectors[count].setCeilingHeight(sector.getCeilingHeight());
        newSectors[count].setFloorTexture(sector.getFloorTexture());
        newSectors[count].setCeilingTexture(sector.getCeilingTexture());
        newSectors[count].setBrightness(sector.getBrightness());
        newSectors[count].setSpecialType(sector.getSpecialType());
        newSectors[count].setTag(sector.getTag());
        count++;
        sectors = newSectors;
    }
    public byte[] toByteArray()
    {
        ByteList byteList = new ByteList();
        for (int i = 0; i < sectors.length;i++)
        {
            byteList.addByteArray(sectors[i].toByteArray());
        }
        return byteList.getBytes();
    }
    //endregion
}

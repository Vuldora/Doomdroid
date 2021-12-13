package awesome.vulldozer.doombuilder;

public class Map
{
    //region Variables
    private DirectoryList directoryList;
    private ThingList thingList;
    private LinedefList linedefList;
    private SidedefList sidedefList;
    private VertexList vertexList;
    private SectorList sectorList;
    //endregion
    //region Getters and Setters
    public DirectoryList getDirectoryList() { return directoryList; }
    public ThingList getThingList() { return thingList; }
    public LinedefList getLinedefList() { return linedefList; }
    public SidedefList getSidedefList() { return sidedefList; }
    public VertexList getVertexList() { return vertexList; }
    public SectorList getSectorList() { return sectorList; }
    public void setDirectoryList(DirectoryList directoryList) { this.directoryList = directoryList; }
    public void setThingList(ThingList thingList) { this.thingList = thingList; }
    public void setLinedefList(LinedefList linedefList) { this.linedefList = linedefList; }
    public void setSidedefList(SidedefList sidedefList) { this.sidedefList = sidedefList; }
    public void setVertexList(VertexList vertexList) { this.vertexList = vertexList; }
    public void setSectorList(SectorList sectorList) { this.sectorList = sectorList; }
    //endregion
    //region Constructors
    public Map(String mapNumb)
    {
        directoryList = new DirectoryList();
        directoryList.addDirectory(12,0,mapNumb); // Map Marker
        directoryList.addDirectory(12,0,"THINGS"); // Things directory
        directoryList.addDirectory(12,0,"LINEDEFS"); // Lindefs directoy
        directoryList.addDirectory(12,0,"SIDEDEFS"); // etc.. etc..
        directoryList.addDirectory(12,0,"VERTEXES");
        directoryList.addDirectory(12,0,"SECTORS");
        thingList = null;
        linedefList = null;
        sidedefList = null;
        vertexList = null;
        sectorList = null;
    }
    //endregion
    //region Functions
    public byte[] toByteArray()
    {
        ByteList byteList = new ByteList();
        if(thingList != null) thingList.toByteArray();
        if(linedefList != null) linedefList.toByteArray();
        if(sidedefList != null) sidedefList.toByteArray();
        if(vertexList != null) vertexList.toByteArray();
        if(sectorList != null) sectorList.toByteArray();
        byteList.addByteArray(directoryList.toByteArray());
        return byteList.getBytes();
    }
    public void addThing(Thing thing)
    {
        thingList.addThing(thing);
        directoryList.addToDirectorySize("THINGS",10);
        directoryList.addToElseFilepos("THINGS", 10);
    }
    public void addThing(short x,short y,short angle,short type,short flags)
    {
        thingList.addThing(x, y, angle, type, flags);
        directoryList.addToDirectorySize("THINGS",10);
        directoryList.addToElseFilepos("THINGS", 10);
    }
    public void addLinedef(Linedef linedef)
    {
        linedefList.addLinedef(linedef);
        directoryList.addToDirectorySize("LINEDEFS",14);
        directoryList.addToElseFilepos("LINEDEFS", 14);
    }
    public void addLinedef(short startVertex,short endVertex,short flags, short specialType,short sectorTag,short frontSidedef,short backSidedef)
    {
        linedefList.addLinedef(startVertex, endVertex, flags, specialType, sectorTag, frontSidedef, backSidedef);
        directoryList.addToDirectorySize("LINEDEFS",14);
        directoryList.addToElseFilepos("LINEDEFS", 14);
    }
    public void addSidedef(Sidedef sidedef)
    {
        sidedefList.addSidedef(sidedef);
        directoryList.addToDirectorySize("SIDEDEFS",30);
        directoryList.addToElseFilepos("SIDEDEFS", 30);
    }
    public void addSidedef(short xOffset,short yOffset,long upperTexture,long lowerTexture,long middleTexture,short facingSector)
    {
        sidedefList.addSidedef(xOffset, yOffset, upperTexture, lowerTexture, middleTexture, facingSector);
        directoryList.addToDirectorySize("SIDEDEFS",30);
        directoryList.addToElseFilepos("SIDEDEFS", 30);
    }
    public void addVertex(Vertex vertex)
    {
        vertexList.addVertex(vertex);
        directoryList.addToDirectorySize("VERTEXES",4);
        directoryList.addToElseFilepos("VERTEXES", 4);
    }
    public void addVertex(short x,short y)
    {
        vertexList.addVertex(x, y);
        directoryList.addToDirectorySize("VERTEXES",4);
        directoryList.addToElseFilepos("VERTEXES", 4);
    }
    public void addSector(Sector sector)
    {
        sectorList.addSector(sector);
        directoryList.addToDirectorySize("SECTORS",26);
        directoryList.addToElseFilepos("SECTORS", 26);
    }
    public void addSector(short floorHeight,short ceilingHeight,long floorTexture,long ceilingTexture,short brightness,short specialType,short tag)
    {
        sectorList.addSector(floorHeight, ceilingHeight, floorTexture, ceilingTexture, brightness, specialType, tag);
        directoryList.addToDirectorySize("SECTORS",26);
        directoryList.addToElseFilepos("SECTORS", 26);
    }
    //endregion
}

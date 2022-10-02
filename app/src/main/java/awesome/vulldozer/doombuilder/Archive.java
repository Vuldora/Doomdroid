package awesome.vulldozer.doombuilder;

public class Archive {
    //region Variables
    private Header header;
    private MapList mapList;
    //endregion
    //region Getters and Setters
    public Header getHeader() { return header; }
    public MapList getMapList() { return mapList; }
    public void setHeader(Header header) { this.header = header; }
    public void setMapList(MapList mapList) { this.mapList = mapList; }
    //endregion
    //region Constructors
    public Archive(String IWAD_PWAD)
    {
        header = new Header(IWAD_PWAD,0,0);
        mapList = new MapList();
    }
    //endregion
    //region Functions
    public void addMap(String name)
    {
        Map map = new Map(name);
        mapList.addMap(map);
        header.setNumlumbs(header.getNumlumbs() + 6);
        header.setInfotableofs(header.getInfotableofs() + 12);
    }
    public void addMap(Map map)
    {
        mapList.addMap(map);
        header.setNumlumbs(header.getNumlumbs() + map.getDirectoryList().getCount());
    }
    public byte[] toByteArray()
    {
        ByteList byteList = new ByteList();
        byteList.addByteArray(header.toByteArray());
        byteList.addByteArray(mapList.toByteArray());
        return byteList.getBytes();
    }
    //endregion

}

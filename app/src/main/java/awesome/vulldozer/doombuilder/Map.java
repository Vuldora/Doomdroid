package awesome.vulldozer.doombuilder;

import android.util.Log;

public class Map
{
    private Header header;
    private DirectoryList directoryList;
    public Map() {}
    public void createMap(String PWAD_IWAD,String mapNumb)
    {
        header = new Header(PWAD_IWAD,6,12);
        directoryList = new DirectoryList();
        directoryList.addDirectory(12,0,mapNumb); // Map Marker
        directoryList.addDirectory(12,0,"THINGS"); // Things directory
        directoryList.addDirectory(12,0,"LINEDEFS"); // Lindefs directoy
        directoryList.addDirectory(12,0,"SIDEDEFS"); // etc.. etc..
        directoryList.addDirectory(12,0,"VERTEXES");
        directoryList.addDirectory(12,0,"SECTORS");
    }
    public byte[] toByteArray()
    {
        ByteList byteList = new ByteList();
        byteList.addByteArray(header.toByteArray());
        byteList.addByteArray(directoryList.toByteArray());
        return byteList.getBytes();
    }
}

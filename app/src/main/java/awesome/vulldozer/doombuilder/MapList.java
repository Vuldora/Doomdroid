package awesome.vulldozer.doombuilder;

public class MapList {
    //region Variables
    private Map[] maps;
    private int count;
    //endregion
    //region Setters and Getters
    public Map[] getMaps() { return maps; }
    public int getCount() { return count; }
    public void setMaps(Map[] maps) { this.maps = maps; }
    public void setCount(int count) { this.count = count; }
    //endregion
    //region Constuctors
    public MapList() { count = 0; }
    //endregion
    //region Functions
    public void addMap(Map map) // Adds a new directory to the list
    {
        Map[] newMaps = new Map[count + 1];
        for(int i = 0; i < count;i++)
        {
            newMaps[i].setDirectoryList(this.maps[i].getDirectoryList());
            newMaps[i].setThingList(this.maps[i].getThingList());
        }
        newMaps[count].setDirectoryList(maps[count].getDirectoryList());
        newMaps[count].setThingList(maps[count].getThingList());
        count++;
        maps = newMaps;
    }
    //endregion
}

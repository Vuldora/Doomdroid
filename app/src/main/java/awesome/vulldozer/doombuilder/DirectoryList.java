package awesome.vulldozer.doombuilder;

public class DirectoryList
{
    //region Variables
    private Directory[] directories;
    private int count;
    //endregion
    //region Getters and Setters
    public Directory[] getDirectories() { return directories; }
    public int getCount() { return count; }
    public void setDirectories(Directory[] directories) { this.directories = directories; }
    public void setCount(int count) { this.count = count; }
    //endregion
    //region Constructors
    public DirectoryList()
    {
        this.count = 0;
    }
    //endregion
    //region Functions
    public void addDirectory(Directory directory) // Adds a new directory to the list
    {
        Directory[] newDirectories = new Directory[count + 1];
        for(int i = 0; i < count;i++)
        {
            newDirectories[i].setFilepos(this.directories[i].getFilepos());
            newDirectories[i].setSize(this.directories[i].getSize());
            newDirectories[i].setName(this.directories[i].getName());
        }
        newDirectories[count].setFilepos(directory.getFilepos());
        newDirectories[count].setSize(directory.getSize());
        newDirectories[count].setName(directory.getName());
        count++;
        directories = newDirectories;
    }
    public void addDirectory(int filepos, int size, String name)
    {
        Directory[] newDirectories = new Directory[count + 1];
        for (int i = 0; i < newDirectories.length;i++)
        {
            newDirectories[i] = new Directory();
        }
        for(int i = 0; i < count;i++)
        {
            newDirectories[i].setFilepos(this.directories[i].getFilepos());
            newDirectories[i].setSize(this.directories[i].getSize());
            newDirectories[i].setName(this.directories[i].getName());
        }
        newDirectories[count].setFilepos(filepos);
        newDirectories[count].setSize(size);
        newDirectories[count].setName(name);
        count++;
        directories = newDirectories;
    }
    public byte[] toByteArray()
    {
        ByteList byteList = new ByteList();
        for (int i = 0; i < directories.length;i++)
        {
            byteList.addByteArray(directories[i].toByteArray());
        }
        return byteList.getBytes();
    }
    public void addToDirectorySize(String directoryName,int size)
    {
        for(int i = 0;i < directories.length;i++)
        {
            if (directories[i].getName() == directoryName)
            {
                directories[i].setSize(directories[i].getSize() + size);
            }
        }
    }
    public void addToElseFilepos(String directoryName, int size)
    {
        for(int i = 0;i < directories.length;i++)
        {
            if (directories[i].getName() == directoryName)
            {
                directories[i].setFilepos(directories[i].getFilepos() + size);
            }
        }
    }
    //endregion
}

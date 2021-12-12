package awesome.vulldozer.doombuilder;

import android.util.Log;

import java.nio.file.ClosedWatchServiceException;

public class DirectoryList
{
    private static final String TAG = "Stuff";
    private Directory[] directories;
    private int count;

    public DirectoryList()
    {
        this.count = 0;
    }
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
        Log.w(TAG, "toByteArray: successs");
        return byteList.getBytes();
    }
}

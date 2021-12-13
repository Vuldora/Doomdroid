package awesome.vulldozer.doombuilder;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Directory
{
    //region Variables
    private int filepos; // An integer holding a pointer to the start of the lump's data in the file.
    private int size; // An integer representing the size of the lump in bytes.
    private String name; //  An ASCII string defining the lump's name. Only the characters A-Z (uppercase), 0-9, and [ ] - _ should be used in lump names (an exception has to be made for some of the Arch-Vile sprites, which use "\"). When a string is less than 8 bytes long, it should be null-padded to the eighth byte. Values exceeding 8 bytes are forbidden.
    //endregion
    //region Getters and Setters
    public int getFilepos() { return this.filepos; }
    public int getSize () { return this.size; }
    public String getName() { return this.name; }
    public void setFilepos(int filepos) { this.filepos = filepos; }
    public void setSize(int size) { this.size = size; }
    public void  setName(String name) { this.name = name; }
    //endregion
    //region Constructors
    public Directory()
    {
        filepos = 0;
        size = 0;
        name = "empty";
    }
    public Directory(int filepos, int size, String name) //Creates a wad directory (lump info)
    {
        this.filepos = filepos;
        this.size = size;
        this.name = name;
    }
    //endregion
    //region Functions
    public byte[] toByteArray()
    {
        byte[] fileposBytes = ByteBuffer.allocate(4).putInt(filepos).array();
        byte[] sizeBytes = ByteBuffer.allocate(4).putInt(size).array();
        //region Ugly reverse array
        // For some reason the bytes are in reverse order, so we have to flip them
        byte[] temp1 = new byte[4];
        byte[] temp2 = new byte[4];
        for(int i = 0;i < 4;i++)
        {
            temp1[i] = fileposBytes[3-i];
            temp2[i] = sizeBytes[3-i];
        }
        for(int i =0;i < 4;i++)
        {
            fileposBytes[i] = temp1[i];
            sizeBytes[i] = temp2[i];
        }
        //endregion
        byte[] nameBytes = name.getBytes(StandardCharsets.US_ASCII);
        byte[] directoryBytes = new byte[16];
        for(int i = 0;i < 16;i++)
        {
            if(i < 4) directoryBytes[i] = fileposBytes[i];
            else if(i < 8) directoryBytes[i] = sizeBytes[i - 4];
            else if (i < nameBytes.length + 8) directoryBytes[i] = nameBytes[i - 8];
            else directoryBytes[i] = (byte)0;
        }
        return directoryBytes;
    }
    //endregion
}

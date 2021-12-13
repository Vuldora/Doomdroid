package awesome.vulldozer.doombuilder;

public class ByteList {
    //region Variables
    private byte[] bytes;
    private int count;
    //endregion
    //region Getters and Setters
    public byte[] getBytes() { return bytes; }
    public int getCount() { return count; }
    public void setBytes(byte[] bytes) { this.bytes = bytes; }
    public void setCount(int count) { this.count = count; }
    //endregion
    //region Constructors
    public ByteList()
    {
        count = 0;
    }
    //endregion
    //region Functions
    public void addByteArray(byte[] byteArray)
    {
        int i;
        byte[] newBytes = new byte[count + byteArray.length];
        for(i = 0; i < count;i++)
        {
            newBytes[i] = this.bytes[i];
        }
        for (;i < count + byteArray.length;i++)
        {
            newBytes[i] = byteArray[i - count];
        }
        count += byteArray.length;
        bytes = newBytes;
    }
    //endregion
}

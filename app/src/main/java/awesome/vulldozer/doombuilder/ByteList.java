package awesome.vulldozer.doombuilder;

import androidx.annotation.NonNull;

public class ByteList {
    private byte[] bytes;
    private int count;
    //region Getters and Setters
    public byte[] getBytes() { return bytes; }
    public int getCount() { return count; }
    public void setBytes(byte[] bytes) { this.bytes = bytes; }
    public void setCount(int count) { this.count = count; }
    //endregion
    public ByteList()
    {
        count = 0;
    }
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
}

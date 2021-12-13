package awesome.vulldozer.doombuilder;

import java.nio.ByteBuffer;

public class Vertex {
    //region Variables
    private short x;
    private short y;
    //endregion
    //region Getters and Setters
    public short getX() { return x; }
    public short getY() { return y; }
    public void setX(short x) { this.x = x; }
    public void setY(short y) { this.y = y; }
    //endregion
    //region Constructors
    public Vertex()
    {
        x = 0;
        y = 0;
    }
    public Vertex(short x, short y)
    {
        this.x = x;
        this.y = y;
    }
    //endregion
    //region Functions
    public byte[] toByteArray()
    {
        //region Turn them to bytes
        byte[] xBytes = ByteBuffer.allocate(2).putShort(x).array();
        byte[] yBytes = ByteBuffer.allocate(2).putShort(y).array();
        //endregion
        //region Reverse arrays
        // I know it looks ugly SHUT UP!
        byte[] temp1 = new byte[2];
        byte[] temp2 = new byte[2];
        for(int i = 0;i < 2;i++)
        {
            temp1[i] = xBytes[1-i];
            temp2[i] = yBytes[1-i];
        }
        for(int i =0;i < 2;i++)
        {
            xBytes[i] = temp1[i];
            yBytes[i] = temp2[i];
        }
        //endregion
        //region Combine arrays
        byte[] vertexBytes = new byte[4];
        for(int i = 0;i < 4;i++)
        {
            if(i < 2) vertexBytes[i] = xBytes[i];
            else if(i < 4) vertexBytes[i] = yBytes[i - 2];
        }
        //endregion
        return vertexBytes;
    }
    //endregion
}

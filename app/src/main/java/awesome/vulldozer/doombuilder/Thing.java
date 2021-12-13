package awesome.vulldozer.doombuilder;

import java.nio.ByteBuffer;

public class Thing {
    //region Variables
    private short x; // Starting x position on map
    private short y; // Starting y position on map
    private short angle; // Starting facing angle
    private short type; // The ID for the thing I think
    private short flags; // multiplayer, ambush, difficulty flags
    //endregion
    //region Getters and Setters
    public short getX() { return x; }
    public short getY() { return y; }
    public short getAngle() { return angle; }
    public short getType() { return type; }
    public short getFlags() { return flags; }
    public void setX(short x) { this.x = x; }
    public void setY(short y) { this.y = y; }
    public void setAngle(short angle) { this.angle = angle; }
    public void setType(short type) { this.type = type; }
    public void setFlags(short flags) { this.flags = flags; }
    //endregion
    //region Constructors
    public Thing()
    {
        this.x = 0;
        this.y = 0;
        this.angle = 0;
        this.type = 0;
        this.flags = 0;
    }
    public Thing(short x,short y,short angle,short type,short flags)
    {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.type = type;
        this.flags = flags;
    }
    //endregion
    //region Functions
    public byte[] toByteArray()
    {
        //region Turn them to bytes
        byte[] xBytes = ByteBuffer.allocate(2).putShort(x).array();
        byte[] yBytes = ByteBuffer.allocate(2).putShort(y).array();
        byte[] angleBytes = ByteBuffer.allocate(2).putShort(angle).array();
        byte[] typeBytes = ByteBuffer.allocate(2).putShort(type).array();
        byte[] flagBytes = ByteBuffer.allocate(2).putShort(flags).array();
        //endregion
        //region Reverse arrays
        // I know it looks ugly SHUT UP!
        byte[] temp1 = new byte[2];
        byte[] temp2 = new byte[2];
        byte[] temp3 = new byte[2];
        byte[] temp4 = new byte[2];
        byte[] temp5 = new byte[2];
        for(int i = 0;i < 2;i++)
        {
            temp1[i] = xBytes[1-i];
            temp2[i] = yBytes[1-i];
            temp3[i] = angleBytes[1-i];
            temp4[i] = typeBytes[1-i];
            temp5[i] = flagBytes[1-i];
        }
        for(int i =0;i < 2;i++)
        {
            xBytes[i] = temp1[i];
            yBytes[i] = temp2[i];
            angleBytes[i] = temp3[i];
            typeBytes[i] = temp4[i];
            flagBytes[i] = temp5[i];
        }
        //endregion
        //region Combine arrays
        byte[] thingBytes = new byte[10];
        for(int i = 0;i < 10;i++)
        {
            if(i < 2) thingBytes[i] = xBytes[i];
            else if(i < 4) thingBytes[i] = yBytes[i - 2];
            else if(i < 6) thingBytes[i] = angleBytes[i - 4];
            else if(i < 8) thingBytes[i] = typeBytes[i - 6];
            else thingBytes[i] = flagBytes[i - 8];
        }
        //endregion
        return thingBytes;
    }
    //endregion
}

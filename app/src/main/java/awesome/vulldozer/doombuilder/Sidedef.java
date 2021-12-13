package awesome.vulldozer.doombuilder;

import java.nio.ByteBuffer;

public class Sidedef {
    //region Variables
    private short xOffset;
    private short yOffset;
    private long upperTexture;
    private long lowerTexture;
    private long middleTexture;
    private short facingSector;
    //endregion
    //region Getters and Setters
    public short getxOffset() { return xOffset; }
    public short getyOffset() { return yOffset; }
    public long getUpperTexture() { return upperTexture; }
    public long getLowerTexture() { return lowerTexture; }
    public long getMiddleTexture() { return middleTexture; }
    public short getFacingSector() { return facingSector; }
    public void setxOffset(short xOffset) { this.xOffset = xOffset; }
    public void setyOffset(short yOffset) { this.yOffset = yOffset; }
    public void setUpperTexture(long upperTexture) { this.upperTexture = upperTexture; }
    public void setLowerTexture(long lowerTexture) { this.lowerTexture = lowerTexture; }
    public void setMiddleTexture(long middleTexture) { this.middleTexture = middleTexture; }
    public void setFacingSector(short facingSector) { this.facingSector = facingSector; }
    //endregion
    //region Constructors
    public Sidedef()
    {
        xOffset = 0;
        yOffset = 0;
        upperTexture = 0;
        lowerTexture = 0;
        middleTexture = 0;
        facingSector = 0;
    }
    public Sidedef(short xOffset,short yOffset,long upperTexture,long lowerTexture,long middleTexture,short facingSector)
    {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.upperTexture = upperTexture;
        this.lowerTexture = lowerTexture;
        this.middleTexture = middleTexture;
        this.facingSector = facingSector;
    }
    //endregion
    //region Functions
    public byte[] toByteArray() {
        //region Turn them to bytes
        byte[] xOffsetBytes = ByteBuffer.allocate(2).putShort(this.xOffset).array();
        byte[] yOffsetBytes = ByteBuffer.allocate(2).putShort(this.yOffset).array();
        byte[] upperTexture = ByteBuffer.allocate(8).putLong(this.upperTexture).array();
        byte[] lowerTexture = ByteBuffer.allocate(8).putLong(this.lowerTexture).array();
        byte[] middleTexture = ByteBuffer.allocate(8).putLong(this.middleTexture).array();
        byte[] facingSector = ByteBuffer.allocate(2).putShort(this.facingSector).array();
        //endregion
        //region Reverse arrays
        // I know it looks ugly SHUT UP!
        byte[] temp1 = new byte[2];
        byte[] temp2 = new byte[2];
        byte[] temp3 = new byte[8];
        byte[] temp4 = new byte[8];
        byte[] temp5 = new byte[8];
        byte[] temp6 = new byte[2];
        for (int i = 0; i < 2; i++) {
            temp1[i] = xOffsetBytes[1 - i];
            temp2[i] = yOffsetBytes[1 - i];
            temp6[i] = facingSector[1 - i];
        }
        for (int i = 0; i < 8; i++) {
            temp3[i] = upperTexture[7 - i];
            temp4[i] = lowerTexture[7 - i];
            temp5[i] = middleTexture[7 - i];
        }
        for (int i = 0; i < 2; i++) {
            xOffsetBytes[i] = temp1[i];
            yOffsetBytes[i] = temp2[i];
            facingSector[i] = temp6[i];
        }
        for (int i = 0; i < 8; i++) {
            upperTexture[i] = temp3[i];
            lowerTexture[i] = temp4[i];
            middleTexture[i] = temp5[i];
        }
        //endregion
        //region Combine arrays
        byte[] sidedefBytes = new byte[30];
        for (int i = 0; i < 30; i++) {
            if (i < 2) sidedefBytes[i] = xOffsetBytes[i];
            else if (i < 4) sidedefBytes[i] = yOffsetBytes[i - 2];
            else if (i < 12) sidedefBytes[i] = upperTexture[i - 4];
            else if (i < 20) sidedefBytes[i] = lowerTexture[i - 12];
            else if (i < 28) sidedefBytes[i] = middleTexture[i - 20];
            else sidedefBytes[i] = facingSector[i - 28];
        }
        //endregion
        return sidedefBytes;
        //endregion
    }
}

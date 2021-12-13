package awesome.vulldozer.doombuilder;

import java.nio.ByteBuffer;

public class Linedef {
    //region Variables
    private short startVertex;
    private short endVertex;
    private short flags;
    private short specialType;
    private short sectorTag;
    private short frontSidedef;
    private short backSidedef;
    //endregion
    //region Getters and Setters
    public short getStartVertex() { return startVertex; }
    public short getEndVertex() { return endVertex; }
    public short getFlags() { return flags; }
    public short getSpecialType() { return specialType; }
    public short getSectorTag() { return sectorTag; }
    public short getFrontSidedef() { return frontSidedef; }
    public short getBackSidedef() { return backSidedef; }
    public void setStartVertex(short startVertex) { this.startVertex = startVertex; }
    public void setEndVertex(short endVertex) { this.endVertex = endVertex; }
    public void setFlags(short flags) { this.flags = flags; }
    public void setSpecialType(short specialType) { this.specialType = specialType; }
    public void setSectorTag(short sectorTag) { this.sectorTag = sectorTag; }
    public void setFrontSidedef(short frontSidedef) { this.frontSidedef = frontSidedef; }
    public void setBackSidedef(short backSidedef) { this.backSidedef = backSidedef; }
    //endregion
    //region Constructors
    public Linedef()
    {
        startVertex = 0;
        endVertex = 0;
        flags = 0;
        specialType = 0;
        sectorTag = 0;
        frontSidedef = 0;
        backSidedef = 0;
    }
    public Linedef(short startVertex,short endVertex,short flags, short specialType,short sectorTag,short frontSidedef,short backSidedef)
    {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.flags = flags;
        this.specialType = specialType;
        this.sectorTag = sectorTag;
        this.frontSidedef = frontSidedef;
        this.backSidedef = backSidedef;
    }
    //endregion
    //region Functions
    public byte[] toByteArray() {
        //region Turn them to bytes
        byte[] startVertexBytes = ByteBuffer.allocate(2).putShort(startVertex).array();
        byte[] endVertexBytes = ByteBuffer.allocate(2).putShort(endVertex).array();
        byte[] flagsBytes = ByteBuffer.allocate(2).putShort(flags).array();
        byte[] specialTypeBytes = ByteBuffer.allocate(2).putShort(specialType).array();
        byte[] sectorTagBytes = ByteBuffer.allocate(2).putShort(sectorTag).array();
        byte[] frontSidedefBytes = ByteBuffer.allocate(2).putShort(frontSidedef).array();
        byte[] backSidedefBytes = ByteBuffer.allocate(2).putShort(backSidedef).array();
        //endregion
        //region Reverse arrays
        // I know it looks ugly SHUT UP!
        byte[] temp1 = new byte[2];
        byte[] temp2 = new byte[2];
        byte[] temp3 = new byte[2];
        byte[] temp4 = new byte[2];
        byte[] temp5 = new byte[2];
        byte[] temp6 = new byte[2];
        byte[] temp7 = new byte[2];
        for (int i = 0; i < 2; i++) {
            temp1[i] = startVertexBytes[1 - i];
            temp2[i] = endVertexBytes[1 - i];
            temp3[i] = flagsBytes[1 - i];
            temp4[i] = specialTypeBytes[1 - i];
            temp5[i] = sectorTagBytes[1 - i];
            temp6[i] = frontSidedefBytes[1 - i];
            temp7[i] = backSidedefBytes[1 - i];
        }
        for (int i = 0; i < 2; i++) {
            startVertexBytes[i] = temp1[i];
            endVertexBytes[i] = temp2[i];
            flagsBytes[i] = temp3[i];
            specialTypeBytes[i] = temp4[i];
            sectorTagBytes[i] = temp5[i];
            frontSidedefBytes[i] = temp6[i];
            backSidedefBytes[i] = temp7[i];
        }
        //endregion
        //region Combine arrays
        byte[] linedefBytes = new byte[14];
        for (int i = 0; i < 14; i++) {
            if (i < 2) linedefBytes[i] = startVertexBytes[i];
            else if (i < 4) linedefBytes[i] = endVertexBytes[i - 2];
            else if (i < 6) linedefBytes[i] = flagsBytes[i - 4];
            else if (i < 8) linedefBytes[i] = specialTypeBytes[i - 6];
            else if (i < 10) linedefBytes[i] = sectorTagBytes[i - 8];
            else if (i < 12) linedefBytes[i] = frontSidedefBytes[i - 10];
            else linedefBytes[i] = backSidedefBytes[i - 12];
        }
        //endregion
        return linedefBytes;
        //endregion
    }
}

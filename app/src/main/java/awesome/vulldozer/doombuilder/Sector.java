package awesome.vulldozer.doombuilder;

import java.nio.ByteBuffer;

public class Sector {
    //region Variables
    private short floorHeight;
    private short ceilingHeight;
    private long floorTexture;
    private long ceilingTexture;
    private short brightness;
    private short specialType;
    private short tag;
    //endregion
    //region Getters and Setters
    public short getFloorHeight() { return floorHeight; }
    public short getCeilingHeight() { return ceilingHeight; }
    public long getFloorTexture() { return floorTexture; }
    public long getCeilingTexture() { return ceilingTexture; }
    public short getBrightness() { return brightness; }
    public short getSpecialType() { return specialType; }
    public short getTag() { return tag; }
    public void setFloorHeight(short floorHeight) { this.floorHeight = floorHeight; }
    public void setCeilingHeight(short ceilingHeight) { this.ceilingHeight = ceilingHeight; }
    public void setFloorTexture(long floorTexture) { this.floorTexture = floorTexture; }
    public void setCeilingTexture(long ceilingTexture) { this.ceilingTexture = ceilingTexture; }
    public void setBrightness(short brightness) { this.brightness = brightness; }
    public void setSpecialType(short specialType) { this.specialType = specialType; }
    public void setTag(short tag) { this.tag = tag; }
    //endregion
    //region Constructors
    public Sector()
    {
        floorHeight = 0;
        ceilingHeight = 0;
        floorTexture = 0;
        ceilingTexture = 0;
        brightness = 0;
        specialType = 0;
        tag = 0;
    }
    public Sector(short floorHeight,short ceilingHeight,long floorTexture,long ceilingTexture,short brightness,short specialType,short tag)
    {
        this.floorHeight = floorHeight;
        this.ceilingHeight = ceilingHeight;
        this.floorTexture = floorTexture;
        this.ceilingTexture = ceilingTexture;
        this.brightness = brightness;
        this.specialType = specialType;
        this.tag = tag;
    }
    //endregion
    //region Functions
    public byte[] toByteArray() {
        //region Turn them to bytes
        byte[] floorHeightBytes = ByteBuffer.allocate(2).putShort(this.floorHeight).array();
        byte[] ceilingHeightBytes = ByteBuffer.allocate(2).putShort(this.ceilingHeight).array();
        byte[] floorTextureBytes = ByteBuffer.allocate(8).putLong(this.floorTexture).array();
        byte[] ceilingTextureBytes = ByteBuffer.allocate(8).putLong(this.ceilingTexture).array();
        byte[] brightnessBytes = ByteBuffer.allocate(2).putShort(this.brightness).array();
        byte[] specialTypeBytes = ByteBuffer.allocate(2).putShort(this.specialType).array();
        byte[] tagBytes = ByteBuffer.allocate(2).putShort(this.tag).array();
        //endregion
        //region Reverse arrays
        // I know it looks ugly SHUT UP!
        byte[] temp1 = new byte[2];
        byte[] temp2 = new byte[2];
        byte[] temp3 = new byte[8];
        byte[] temp4 = new byte[8];
        byte[] temp5 = new byte[2];
        byte[] temp6 = new byte[2];
        byte[] temp7 = new byte[2];
        for (int i = 0; i < 2; i++) {
            temp1[i] = floorHeightBytes[1 - i];
            temp2[i] = ceilingHeightBytes[1 - i];
            temp5[i] = brightnessBytes[1 - i];
            temp6[i] = specialTypeBytes[1 - i];
            temp7[i] = tagBytes[1 - i];
        }
        for (int i = 0; i < 8; i++) {
            temp3[i] = floorTextureBytes[7 - i];
            temp4[i] = ceilingTextureBytes[7 - i];
        }
        for (int i = 0; i < 2; i++) {
            floorHeightBytes[i] = temp1[i];
            ceilingHeightBytes[i] = temp2[i];
            brightnessBytes[i] = temp5[i];
            specialTypeBytes[i] = temp6[i];
            tagBytes[i] = temp7[i];
        }
        for (int i = 0; i < 8; i++) {
            floorTextureBytes[i] = temp3[i];
            ceilingTextureBytes[i] = temp4[i];
        }
        //endregion
        //region Combine arrays
        byte[] sectorBytes = new byte[26];
        for (int i = 0; i < 26; i++) {
            if (i < 2) sectorBytes[i] = floorHeightBytes[i];
            else if (i < 4) sectorBytes[i] = ceilingHeightBytes[i - 2];
            else if (i < 12) sectorBytes[i] = floorTextureBytes[i - 4];
            else if (i < 20) sectorBytes[i] = ceilingTextureBytes[i - 12];
            else if (i < 22) sectorBytes[i] = brightnessBytes[i - 20];
            else if (i < 24) sectorBytes[i] = specialTypeBytes[i - 22];
            else sectorBytes[i] = tagBytes[i - 24];
        }
        //endregion
        return sectorBytes;
        //endregion
    }
}

package awesome.vulldozer.doombuilder;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Header {
    //region Variables
    private String identification ; // The ASCII characters "IWAD" or "PWAD".
    private int numlumbs; // An integer specifying the number of lumps in the WAD.
    private int infotableofs; // An integer holding a pointer to the location of the directory.
    //endregion
    //region Getters and Setters
    public String getIdentification() { return this.identification; }
    public int getNumlumbs() { return this.numlumbs; }
    public int getInfotableofs() { return this.infotableofs; }
    public void setIdentification(String identification) { this.identification = identification; }
    public void setNumlumbs(int numlumbs) { this.numlumbs = numlumbs; }
    public void setInfotableofs(int infotableofs) {this.infotableofs = infotableofs; }
    //endregion
    //region Constructors
    public Header() {} // Construct an empty header
    public Header(String identification, int numlumbs, int infotableofs) // Construct a header
    {
        this.identification = identification;
        this.numlumbs = numlumbs;
        this.infotableofs = infotableofs;
    }
    //endregion
    //region Functions
    public byte[] toByteArray()
    {
        byte[] identificationBytes = identification.getBytes(StandardCharsets.US_ASCII);
        byte[] numLumpsBytes = ByteBuffer.allocate(4).putInt(numlumbs).array();
        byte[] infotableofsBytes = ByteBuffer.allocate(4).putInt(infotableofs).array();
        //region Ugly reverse array
        // For some reason the bytes are in reverse order, so we have to flip them
        byte[] temp1 = new byte[4];
        byte[] temp2 = new byte[4];
        for(int i = 0;i < 4;i++)
        {
            temp1[i] = numLumpsBytes[3-i];
            temp2[i] = infotableofsBytes[3-i];
        }
        for(int i =0;i < 4;i++)
        {
            numLumpsBytes[i] = temp1[i];
            infotableofsBytes[i] = temp2[i];
        }
        //endregion
        byte[] headerBytes = new byte[12];
        for(int i = 0;i < 12;i++)
        {
            if(i < 4) headerBytes[i] = identificationBytes[i];
            else if(i < 8) headerBytes[i] = numLumpsBytes[i - 4];
            else headerBytes[i] = infotableofsBytes[i - 8];
        }
        return headerBytes;
    }
    //endregion
}

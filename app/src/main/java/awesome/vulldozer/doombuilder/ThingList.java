package awesome.vulldozer.doombuilder;

public class ThingList {
    //region Variables
    private Thing[] things;
    private int count;
    //endregion
    //region Getters and Setters
    public Thing[] getThings() { return things; }
    public int getCount() { return count; }
    public void setThings(Thing[] things) { this.things = things; }
    public void setCount(int count) { this.count = count; }
    //endregion
    //region Constructors
    public ThingList() { count = 0; }
    //endregion
    //region Functions
    public void addThing(short x, short y,short angle,short type,short flags)
    {
        Thing[] newThings = new Thing[count + 1];
        for (int i = 0; i < newThings.length;i++)
        {
            newThings[i] = new Thing();
        }
        for(int i = 0; i < count;i++)
        {
            newThings[i].setX(this.things[i].getX());
            newThings[i].setY(this.things[i].getY());
            newThings[i].setAngle(this.things[i].getAngle());
            newThings[i].setType(this.things[i].getType());
            newThings[i].setFlags(this.things[i].getFlags());
        }
        newThings[count].setX(x);
        newThings[count].setY(y);
        newThings[count].setAngle(angle);
        newThings[count].setType(type);
        newThings[count].setFlags(flags);
        count++;
        things = newThings;
    }
    public void addThing(Thing thing)
    {
        Thing[] newThings = new Thing[count + 1];
        for (int i = 0; i < newThings.length;i++)
        {
            newThings[i] = new Thing();
        }
        for(int i = 0; i < count;i++)
        {
            newThings[i].setX(this.things[i].getX());
            newThings[i].setY(this.things[i].getY());
            newThings[i].setAngle(this.things[i].getAngle());
            newThings[i].setType(this.things[i].getType());
            newThings[i].setFlags(this.things[i].getFlags());
        }
        newThings[count].setX(thing.getX());
        newThings[count].setY(thing.getY());
        newThings[count].setAngle(thing.getAngle());
        newThings[count].setType(thing.getType());
        newThings[count].setFlags(thing.getFlags());
        count++;
        things = newThings;
    }
    public byte[] toByteArray()
    {
        ByteList byteList = new ByteList();
        for (int i = 0; i < things.length;i++)
        {
            byteList.addByteArray(things[i].toByteArray());
        }
        return byteList.getBytes();
    }
    //endregion
}

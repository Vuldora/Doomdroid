package awesome.vulldozer.doombuilder;

public class VertexList {
    //region Variables
    private Vertex[] vertices;
    private int count;
    //endregion
    //region Getters and Setters
    public Vertex[] getVertices() { return vertices; }
    public int getCount() { return count; }
    public void setVertices(Vertex[] vertices) { this.vertices = vertices; }
    public void setCount(int count) { this.count = count; }
    //endregion
    //region Constructors
    public VertexList() { count = 0; }
    //endregion
    //region Functions
    public void addVertex(short x, short y)
    {
        Vertex[] newVertices = new Vertex[count + 1];
        for (int i = 0; i < newVertices.length;i++)
        {
            newVertices[i] = new Vertex();
        }
        for(int i = 0; i < count;i++)
        {
            newVertices[i].setX(this.vertices[i].getX());
            newVertices[i].setY(this.vertices[i].getY());
        }
        newVertices[count].setX(x);
        newVertices[count].setY(y);
        count++;
        vertices = newVertices;
    }
    public void addVertex(Vertex vertex)
    {
        Vertex[] newVertices = new Vertex[count + 1];
        for (int i = 0; i < newVertices.length;i++)
        {
            newVertices[i] = new Vertex();
        }
        for(int i = 0; i < count;i++)
        {
            newVertices[i].setX(this.vertices[i].getX());
            newVertices[i].setY(this.vertices[i].getY());
        }
        newVertices[count].setX(vertex.getX());
        newVertices[count].setY(vertex.getY());
        count++;
        vertices = newVertices;
    }
    public byte[] toByteArray()
    {
        ByteList byteList = new ByteList();
        for (int i = 0; i < vertices.length;i++)
        {
            byteList.addByteArray(vertices[i].toByteArray());
        }
        return byteList.getBytes();
    }
    //endregion
}

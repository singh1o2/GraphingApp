
public class Edge
{
    private Node A,B;
    
    public Edge(Node A, Node B)
    {
    	this.A=A;
    	this.B=B;
    }
    
    public Node getA()
	{
		return A;
	}
	public Node getB()
	{
		return B;
	}
	
	public void setA(Node A)
	{
		this.A=A;
	}
	public void setB(Node B)
	{
		this.B=B;
	}
	
}

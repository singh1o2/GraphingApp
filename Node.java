
import java.awt.Point;
public class Node
{
      private Point p;
      private int Size;
   	  public String label;
      public Node(int x, int y,String label)
      {
            p = new Point(x, y);
            Size = 10;
            this.label=label;
      }
      public void setPoint(int x, int y)
      {
            this.p = new Point(x, y);
      }
      public boolean inside(int x, int y)
      {
            Point o = new Point(x, y);
            double distance = p.distance(o);
            if (distance <= Size)
            {
                  return true;
            }
            return false;
      }
	  public int getX() 
	  {    
		  return p.x;
	  }
      public int getY()
      {
    	  return p.y;
      }
      public int getSize()
      {	  
    	   return Size;
      }
      public void setSize(int size) 
      {
    	  this.Size = size;
      }

}

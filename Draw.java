
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
public class Draw extends JPanel implements MouseListener,MouseMotionListener 
{
		private ArrayList<Node> Nodes;
		private ArrayList<Edge> Edges;
		private State state ;
		public String Nlabel,Elabel1,Elabel2;
	    
		public Draw() 
		{
			Nodes = new ArrayList<Node>();
			Edges = new ArrayList<Edge>();
            setPreferredSize(new Dimension(500, 500));
            setBackground(Color.WHITE);
            setLayout(null);
            addMouseListener(this);
            addMouseMotionListener(this);
       }
		
	    public void addEdge(String labelA,String labelB)
	  	{
	  		Node temp;
	  		Node A=null,B=null;
	  		 for (int i = 0; i < Nodes.size(); i++)
	         {
	  			temp=Nodes.get(i);
	  			if(temp.label.equals(labelA))
	  			{
	  				A=temp;
	  			}
	  			if(temp.label.equals(labelB))
	  			{
	  				B=temp;
	  			}
	         }
	  		Edges.add(new Edge(A,B));
	  		repaint();
	  	}

		 public void mouseClicked(MouseEvent e)
	     {
	            if (state == State.Add_Node) 
	            {
	            	Node temp=new Node(e.getX(), e.getY(), Nlabel);
	            	Nodes.add(temp);
	                repaint();	
	            }
	            
	            else if(state == State.Add_Edge)
	            {
	            	addEdge(Elabel1,Elabel2);
	            }
	            
	            else if (state == State.Remove)
	            {
 	            	Node remove=null;
 	            	for (int i = 0; i < Nodes.size(); i++)
 	                {
 	                       Node v = Nodes.get(i);
 	                       if (v.inside(e.getX(),e.getY())) 
 	                       {
 	                             remove=Nodes.remove(i);
 	                             break;
 	                       }
 	                 }
 	            	 for (int i = 0; i <Edges.size(); i++)
 	            	 { 
 	                     String labelA=Edges.get(i).getA().label;
 	                     String labelB=Edges.get(i).getB().label;
 	                     if(labelA==remove.label||labelB==remove.label)
 	                     {
 	                    	  Edges.remove(i);
 	                          i--;
 	                     }
 	                 }
 	                 repaint();
	 	    	  }
	           
	     }
		 
		 public void mouseDragged(MouseEvent e) 
	      {
	            if (state == State.Move)
	            {
	                  for (Node v : Nodes) 
	                  {
	                       if (v.inside(e.getX(), e.getY())) 
	                       {
	                             v.setPoint(e.getX(), e.getY());
	                             break;
	                       }
	                  }
	                  repaint();
	            }
	      }

       protected void paintComponent(Graphics g)
       {
            super.paintComponent(g);
            for (Node N :Nodes) 
            {
                  g.setColor(Color.BLUE);
                  g.fillOval(N.getX() - N.getSize(), N.getY() - N.getSize(),N.getSize(), N.getSize());
                  g.drawString(N.label,N.getX()+10,N.getY());
            }
            for (Edge E:Edges)
            {
                 g.drawLine(E.getA().getX()-5, E.getA().getY()-5,E.getB().getX()-7, E.getB().getY()-7);
                 Node A=E.getA();
            	 g.setColor(Color.ORANGE);
                 g.fillOval(A.getX() - A.getSize(), A.getY() - A.getSize(),A.getSize(), A.getSize());
                 g.setColor(Color.BLACK);
                 g.drawString(A.label,A.getX()+10,A.getY());
                 Node B=E.getB();
                 g.setColor(Color.RED);
                 g.fillOval(B.getX() - B.getSize(), B.getY() - B.getSize(),B.getSize(), B.getSize());
                 g.setColor(Color.BLACK);
                 g.drawString(B.label,B.getX()+10,B.getY());

            }
            
      }

      public void setCurrentState(State state)
      {
            this.state = state;
      }

     
      public void mouseEntered(MouseEvent arg0) {}
      public void mouseExited(MouseEvent arg0) {}
      public void mousePressed(MouseEvent arg0) {}
      public void mouseReleased(MouseEvent arg0) {}
      public void mouseMoved(MouseEvent arg0) {}
      
   
}

enum State {
      Add_Edge,Add_Node,Remove,Move;
}
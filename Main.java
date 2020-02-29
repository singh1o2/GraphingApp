
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainClass extends JFrame implements ActionListener 
{

      private Draw draw;
      private JPanel buttonPanel;

      private JRadioButton radio, radio2, radio3,radio4;
     
      public MainClass()
      {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            draw = new Draw();
            buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(1, 0));
            buttonPanel.setSize(700, 60);
            
            radio = new JRadioButton("ADD NODE");
            radio.setSelected(false);
            radio2 = new JRadioButton("DELETE NODE");
            radio3 = new JRadioButton("MOVE NODE");
            radio4 = new JRadioButton("Add EDGE");
            
            
            ButtonGroup Bgroup = new ButtonGroup();
            Bgroup.add(radio);
            Bgroup.add(radio4);
            Bgroup.add(radio2);
            Bgroup.add(radio3);
          
            buttonPanel.add(radio);
            buttonPanel.add(radio4);
            buttonPanel.add(radio2);
            buttonPanel.add(radio3);
            
            setLayout(new BorderLayout(2,1));
            add(buttonPanel, BorderLayout.PAGE_START);
            add(draw, BorderLayout.CENTER);

            radio.addActionListener(this);
            radio2.addActionListener(this);
            radio3.addActionListener(this);
            radio4.addActionListener(this);

      }
      public void actionPerformed(ActionEvent e) 
      {
            if (radio.isSelected())
            {
            	draw.Nlabel=JOptionPane.showInputDialog(null, "ENTER LABEL FOR NODE");
            	JOptionPane.showMessageDialog(null, "CLICK ON PANEL TO DRAW NODE. DONT CLICK TWICE ON PANEL OTHERWISE NODE WITH SAME NAME WILL BE GENERATED! CLICK AGAIN ON ADD NODE TO ADD NEW ONE!");
            	draw.setCurrentState(State.Add_Node);
            }
            else if (radio2.isSelected())
            {
            	draw.setCurrentState(State.Remove);
            } 
            else if (radio3.isSelected()) 
            {
                draw.setCurrentState(State.Move);
            }
            else if (radio4.isSelected()) 
            {
            	draw.Elabel1=JOptionPane.showInputDialog(null, "ENTER INITIAL LABEL FOR NODE");
            	draw.Elabel2=JOptionPane.showInputDialog(null, "ENTER OTHER LABEL FOR NODE");
            	JOptionPane.showMessageDialog(null,"NOW CLICK ON JPANEL TO DRAW THE EDGE");
            	draw.setCurrentState(State.Add_Edge);
            }
      }
      
      public static void main(String[] args)
      {
            MainClass window = new MainClass();
            window.setSize(700,700);
            window.setVisible(true);
      }

}

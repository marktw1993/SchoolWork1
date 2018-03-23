import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel extends JPanel
{
   private int numberOne;
   private int numberTwo;
   private JButton newProblem;
   private JButton check;
   private JLabel label;

   //-----------------------------------------------------------------
   //  Constructor: Sets up the GUI.
   //-----------------------------------------------------------------
   public Panel()
   {
	   
      numberOne = 0;
      numberTwo = 0;

      newProblem = new JButton ("NewProblem");
      newProblem.addActionListener (new ButtonListener());
      
      check = new JButton("Check Answer");
      check.addActionListener(new ButtonListener());
      
      label = new JLabel (numberOne + " + " + numberTwo + " = ");

      add(newProblem);
      add(label);
      add(check);

      setPreferredSize (new Dimension(300, 40));
      setBackground (Color.white);
   }

   //*****************************************************************
   //  Represents a listener for button push (action) events.
   //*****************************************************************
   private class ButtonListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Updates the counter and label when the button is pushed.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
         label.setText(numberOne + " + " + numberTwo + " = ");
      }
   }
}


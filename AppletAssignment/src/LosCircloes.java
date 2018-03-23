import javax.swing.JApplet;
import java.awt.*;

public class LosCircloes extends JApplet
{
   public void paint (Graphics page)
   {
	  page.setColor (Color.blue);
	  page.drawOval (25, 0, 150, 150);	//blue    
	  
	  page.setColor (Color.yellow);
	  page.drawOval (115, 75, 150, 150);    //yellow
	  
	  page.setColor (Color.black);
      page.drawOval (200, 0, 150, 150);    //black
      
      page.setColor (Color.green);
      page.drawOval (290, 75, 150, 150);    //green
     
      page.setColor (Color.red);
      page.drawOval (375, 0, 150, 150);    //red
   }
}

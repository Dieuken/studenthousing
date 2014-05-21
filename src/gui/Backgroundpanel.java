package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Backgroundpanel extends JPanel
{
	Image image;
	  public Backgroundpanel()
	  {
		  try
		    {
		      image = ImageIO.read(getClass().getResource("/resources/welcome.png"));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	  }

	  @Override
	  protected void paintComponent(Graphics g)
	  {
	    super.paintComponent(g); 
	    if (image != null)
	      g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
	  }
}

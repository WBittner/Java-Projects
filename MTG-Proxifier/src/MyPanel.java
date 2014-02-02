import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Will Bittner
 */
@SuppressWarnings("serial")
public class MyPanel extends JPanel
{
		public Image image;
                public Card card;
		
                public MyPanel(Card c)
                {
                    card = c;
                    setImage(card.getName());
                }
		public void paintComponent(Graphics g)
		{
			g.drawImage(image,0,0,null);
			super.paintComponent(g);
		}
		public void setImage(String s)
		{
            try {
                image=new ImageIcon(new URL("http://www.wizards.com/global/images/magic/general/" +s+ ".jpg")).getImage();
            	} catch (MalformedURLException ex) 
            		{
            			Logger.getLogger(MyPanel.class.getName()).log(Level.SEVERE, null, ex);
            		}
			setMinimumSize(new Dimension(image.getWidth(null),image.getHeight(null)+10));
            setPreferredSize(new Dimension(image.getWidth(null),image.getHeight(null)+10));
            setBackground(new Color(255,255,255,0));
            setToolTipText(card.name + " " + card.cvc + " " + card.color);
		}
		public String getCardName()
		{
			return card.getName();
		}
		public Card getCard()
		{
			return card;
		}
}

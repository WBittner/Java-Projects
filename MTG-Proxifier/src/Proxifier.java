import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * 
 * @author William Bittner
 *
 */
public class Proxifier// implements Printable
{
	private static State state;
	private static JButton readyButton;
	private static JButton clearButton;
	private static TextArea textArea;
	private static JFrame mainFrame;
	private static JPanel mainPanel;
	private static JPanel buttonPanel;
	private static JLabel instructionsLabel;
	private static JButton printButton;
	private static JFrame cardFrame;
	private static JPanel cardPanel;
	//private static ArrayList<JPanel> listOfCardPanels;
	
	public static void main(String args[])
	{
		final int FRAME_WIDTH = 620;
		final int FRAME_HEIGHT = 480;

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		mainFrame = new JFrame("Welcome To Will's Wonderful Proxifier!");
		mainFrame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		mainFrame.setLocation((dim.width-FRAME_WIDTH)/2, (dim.height-FRAME_HEIGHT)/2);
		
		mainPanel = new JPanel(new BorderLayout());
		
		textArea = new TextArea();
		textArea.addTextListener(new TextAreaListener());
		instructionsLabel = new JLabel("<html>Write the number of the card you want followed by a space, "
				+ "then the name of the card. One card per line! <br> "
				+ "For example: <br>"
				+ "4 Avacyn Angel of Hope <br>"
				+ "2 Builders Blessing<br>"
				+ "1 Vanguards Shield</html>");
		
		readyButton = new JButton("Type your cards!");
		readyButton.addActionListener(new ReadyButtonActionListener());
		readyButton.setEnabled(false);
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ClearButtonActionListener());
		
		/*//printButton = new JButton("Print");
		//printButton.addActionListener(new PrintButtonActionListener());
		(new ActionListener() 
		{
	        @Override
	        public void actionPerformed(ActionEvent event) 
	        {
	            new Thread(new PrintActionListener(mainFrame)).start();
	        }
	    });*/
		
		
		state = new TextIsNotAvailableState();
		buttonPanel = new JPanel();
		buttonPanel.add(readyButton);
		buttonPanel.add(clearButton);
		mainPanel.add(buttonPanel,BorderLayout.SOUTH);
		mainPanel.add(textArea, BorderLayout.CENTER);
		mainPanel.add(instructionsLabel,BorderLayout.NORTH);
		mainFrame.add(mainPanel);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public class PrintActionListener implements Runnable 
	{

    private JFrame frame;

    public PrintActionListener(JFrame frame) {
        this.frame = cardFrame;
    }

     @Override
    public void run() 
    {
        final BufferedImage image = createPanelImage();

        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable(new ImagePrintable(printJob, image));

        if (printJob.printDialog()) 
        {
            try 
            {
                printJob.print();
            } 
            catch (PrinterException prt) 
            {
                prt.printStackTrace();
            }
        }
    }
        
        private BufferedImage createPanelImage() {
            JPanel panel = mainPanel;
            BufferedImage image = new BufferedImage(panel.getWidth(),
                    panel.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            panel.paint(g);
            g.dispose();
            return image;
    }
	}

	public class ImagePrintable implements Printable {

        private double          x, y, width;

        private int             orientation;

        private BufferedImage   image;

        public ImagePrintable(PrinterJob printJob, BufferedImage image) {
            PageFormat pageFormat = printJob.defaultPage();
            this.x = pageFormat.getImageableX();
            this.y = pageFormat.getImageableY();
            this.width = pageFormat.getImageableWidth();
            this.orientation = pageFormat.getOrientation();
            this.image = image;
        }

        @Override
        public int print(Graphics g, PageFormat pageFormat, int pageIndex)
                throws PrinterException {
            if (pageIndex == 0) {
                int pWidth = 0;
                int pHeight = 0;
                if (orientation == PageFormat.PORTRAIT) {
                    pWidth = (int) Math.min(width, (double) image.getWidth());
                    pHeight = pWidth * image.getHeight() / image.getWidth();
                } else {
                    pHeight = (int) Math.min(width, (double) image.getHeight());
                    pWidth = pHeight * image.getWidth() / image.getHeight();
                }
                g.drawImage(image, (int) x, (int) y, pWidth, pHeight, null);
                return PAGE_EXISTS;
            } else {
                return NO_SUCH_PAGE;
            }
        }

    }
	private static class ReadyButtonActionListener implements ActionListener
	   {
	   	public void actionPerformed(ActionEvent ev)
	   	{
	   		cardFrame = new JFrame("Here are your cards! :D");

	   		GridLayout layout = new GridLayout(0,4);
	   		JPanel panel = new JPanel(layout);
	   		
	   		String text = textArea.getText().trim() + System.getProperty("line.separator");
	   		int indexOfNewLine = text.indexOf(System.getProperty("line.separator"));
	   		
	   		while(indexOfNewLine!=-1)
	   		{
	   			//read card info
	   			int indexOfSpace = text.indexOf(" ");
	   			String num = text.substring(0, indexOfSpace);
	   			int number = Integer.parseInt(num);
	   			String cardName = text.substring(indexOfSpace,indexOfNewLine).trim() + "-0c";
	   			
	   			//put card on panel
	   			for(int i = 0; i < number; i++)
	   			{
		   			MyCard card = new MyCard(cardName);
		   			JPanel op = card.getPanel();
		            panel.add(op);
	   			}
	   			
	   			//delete card off text
	   			text = text.substring(indexOfNewLine+2);
	   			indexOfNewLine = text.indexOf(System.getProperty("line.separator"));
	   		}
	   		
	   		printButton = new JButton("Print me!");
	   		printButton.addActionListener(new PrintButtonActionListener());
	   		panel.add(printButton);
	   		
	   		cardFrame.add(new JScrollPane(panel));
	   		//frame.add(printButton);
	   		
			cardFrame.setBounds(300, 150, 840, 620);
	   		cardFrame.setVisible(true);
	   		cardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   	} /* end actionPerformed */
	   } /* end ResetButtonActionListener */
	
	private static class ClearButtonActionListener implements ActionListener
	   {
	   	public void actionPerformed(ActionEvent ev)
	   	{
	   		textArea.setText("");
	   		textArea.requestFocus();
	   	} /* end actionPerformed */
	   } /* end ResetButtonActionListener */
	   
	
	private static class TextAreaListener implements TextListener
	   {
	   	public void textValueChanged(TextEvent ev)
	   	{
	   		boolean isTextAvailable = !((TextArea)ev.getSource()).getText().isEmpty();
	   		state = (isTextAvailable) ? new TextIsAvailableState() : new TextIsNotAvailableState();
	   		state.prepareComponents();
	   	} /* end textValueChanged */
	   } /* end TextAreaListener */
	
	 private static abstract class State
	   {
	      public abstract void prepareComponents();
	   } /* end State */

	   private static class TextIsAvailableState extends State
	   {
	      public void prepareComponents()
	      {
	   		readyButton.setEnabled(true);   
	   		readyButton.setText("Ready!");
	      } /* end prepareComponents */
	   } /* end TextIsAvailableState */

	   private static class TextIsNotAvailableState extends State
	   {   	
	      public void prepareComponents()
	      {
	   		readyButton.setEnabled(false); 
	   		readyButton.setText("Type your cards!");
	      } /* end prepareComponents */
	   } /* end TextIsNotAvailableState */
	   
	   
	   private static class PrintButtonActionListener implements ActionListener, Printable
	   {
	   public void actionPerformed(ActionEvent ae)
	   {
	       if (ae.getSource() == printButton)
	       {
	           PrinterJob job = PrinterJob.getPrinterJob();
	           job.setPrintable(this);
	           boolean ok = job.printDialog();
	           System.out.println("here");
	           if (ok)
	           {
	               try
	               {
	                   job.print();
	               }
	               catch (PrinterException ex)
	               {
	                   System.out.println(ex);
	               }
	           }
	       }

	   }

	   public int print(Graphics g, PageFormat pf, int page) throws PrinterException
	   {

	       if (page > 0)
	       {
	           return NO_SUCH_PAGE;
	       }

	       Graphics2D g2d = (Graphics2D)g;
	       g2d.translate(pf.getImageableX(), pf.getImageableY());

	       cardFrame.printAll(g);

	       return PAGE_EXISTS;
	   }
	   }
}

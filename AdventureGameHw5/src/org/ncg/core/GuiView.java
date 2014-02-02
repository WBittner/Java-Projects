package org.ncg.core;

import java.awt.*;
import java.awt.event.*;


public class GuiView extends View {
	TextArea textArea;
	Button northButton;
	Button southButton;
	Button eastButton;
	Button westButton;
	
	public GuiView()
	{
		Frame frame = new Frame();
		frame.addWindowListener(new GuiWindowListener());
	   	frame.setLocation(100, 200);
	   	frame.setSize(640, 480);
	   	frame.setTitle("Nittany Cubs Gaming GUI");
	   	
	   	Panel panel = new Panel();
	   	panel.setLayout(new BorderLayout());
	   	frame.add(panel);
	   	
	   	textArea = new TextArea();
	   	textArea.setEditable(false);
	   	panel.add(textArea, BorderLayout.CENTER);
	   	
	   	
	   	northButton = new Button("Go north");
	   	panel.add(northButton,  BorderLayout.NORTH);
	   	northButton.addActionListener(new GoButtonActionListener());
	   	
	   	eastButton = new Button("Go east");
	   	panel.add(eastButton,  BorderLayout.EAST);
	   	eastButton.addActionListener(new GoButtonActionListener());
	   	
	   	southButton = new Button("Go south");
	   	panel.add(southButton,  BorderLayout.SOUTH);
	   	southButton.addActionListener(new GoButtonActionListener());
	   	
	   	westButton = new Button("Go west");
	   	panel.add(westButton,  BorderLayout.WEST);
	   	westButton.addActionListener(new GoButtonActionListener());

	   	frame.setVisible(true);
	}

	 private static class GuiWindowListener extends WindowAdapter
	   {
	   	@Override
	   	public void windowClosing(WindowEvent ev)
	   	{
	   		ev.getComponent().setVisible(false);
	   		System.exit(0);
	   	} /* end windowClosing */
	   } /* end GuiWindowListener */
	 
	 private static class GoButtonActionListener implements ActionListener
	   {
	   	public void actionPerformed(ActionEvent ev)
	   	{
	   		if("Go north".equals(((Button)ev.getSource()).getLabel()))
	   		{
	   			Application.instance().movePlayerNorth();
	   		}
	   		else if("Go south".equals(((Button)ev.getSource()).getLabel()))
	   		{
	   			Application.instance().movePlayerSouth();
	   		}
	   		else if("Go west".equals(((Button)ev.getSource()).getLabel()))
	   		{
	   			Application.instance().movePlayerWest();
	   		}
	   		else if("Go east".equals(((Button)ev.getSource()).getLabel()))
	   		{
	   			Application.instance().movePlayerEast();
	   		}
	   	} /* end actionPerformed */
	   } /* end ResetButtonActionListener */
	
	@Override
	public void informInvalidGoDirection(String direction) {
		textArea.append("You hit your nose on the wall trying to go " + direction +
				System.lineSeparator());

	}

	@Override
	public void informPlayerMoved() {
		look();

	}

	@Override
	public void look() {
		Location currentLocation = Application.instance().playerCurrentLocation();
		textArea.setText(currentLocation.description() +
   			             getItemsDescription(currentLocation) +
   			             getMobsDescription(currentLocation) +
   			             getCanMoveDirectionsDescription(currentLocation) +
   			             System.lineSeparator() );
	}

}



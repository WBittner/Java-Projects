package bittner.william.dwmhelper.core;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import bittner.william.dwmhelper.testApp.MonsterPanelTest;

public class Player extends JFrame{
	static JButton addMonsterToBankButton,transferMonsterToBankButton,transferMonsterToPartyButton;
	static JComboBox<MonsterPanel> partyMonstersComboBox, bankMonstersComboBox;
	static JLabel partyLabel, bankLabel;
	static JPanel layoutPanel;
	static MonsterPanel currentBankMonster, currentPartyMonster;
	
	public Player()
	{
		final int FRAME_WIDTH = 640;
		final int FRAME_HEIGHT = 480;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		partyMonsters = new ArrayList<MonsterPanel>();
		bankMonsters = new ArrayList<MonsterPanel>();
		
		setUpButtons();
		setUpJComboBoxes();
		setUpJLabels();
		setUpMonsterPanels();
		
		setUpLayoutPanel();
				
		
		add(layoutPanel);
		setSize(new Dimension(480,340));
		setTitle("DWM Helper!");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setLocation((dim.width-FRAME_WIDTH)/2, (dim.height-FRAME_HEIGHT)/2-100);
	}/* end Player */
	
	public void update()
	{		
		currentBankMonster.repaint();
		currentPartyMonster.repaint();
		invalidate();
		repaint();		
		revalidate();
	}
	
	public void setUpLayoutPanel()
	{
		layoutPanel = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		
		
		c.gridx = 0;
		c.gridy = 0;		
		c.insets = new Insets(0,0,0,50);
		layoutPanel.add(partyLabel, c);

		c.gridx = 2;
		c.gridy = 0;	
		c.insets = new Insets(0,50,0,0);
		layoutPanel.add(bankLabel, c);
		
		c.gridx = 0;
		c.gridy = 1;	
		c.insets = new Insets(10,0,0,50);
		layoutPanel.add(partyMonstersComboBox,c);
		
		c.gridx = 2;
		c.gridy = 1;	
		c.insets = new Insets(10,50,0,0);
		layoutPanel.add(bankMonstersComboBox,c);
		
		c.gridx = 0;
		c.gridy = 2;	
		c.insets = new Insets(100,0,0,50);
		layoutPanel.add(currentPartyMonster,c);
		
		c.gridx = 2;
		c.gridy = 2;	
		c.insets = new Insets(100,50,0,0);
		layoutPanel.add(currentBankMonster,c);
		
		c.gridx = 0;
		c.gridy = 3;	
		c.insets = new Insets(100,0,0,50);
		layoutPanel.add(transferMonsterToBankButton,c);
		
		c.gridx = 2;
		c.gridy = 3;	
		c.insets = new Insets(100,50,0,0);
		layoutPanel.add(transferMonsterToPartyButton,c);
		
		c.gridx = 1;
		c.gridy = 4;	
		c.insets = new Insets(10,0,0,0);
		layoutPanel.add(addMonsterToBankButton,c);
	}
	
	public void setUpMonsterPanels()
	{
		currentPartyMonster = new MonsterPanel("Almiraj","yolo","yolo",null,null);
		currentBankMonster = new MonsterPanel("IronTurt","yolo","yolo",null,null);
	}
	public void setUpJLabels()
	{
		partyLabel = new JLabel("Your Party");
		partyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel = new JLabel("Your Bank");
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void setUpJComboBoxes()
	{
		bankMonstersComboBox = new JComboBox();
		bankMonstersComboBox.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e) 
				{
			        JComboBox cb = (JComboBox)e.getSource();
			        
			        Player.layoutPanel.remove(currentBankMonster);
			        currentBankMonster = (MonsterPanel)cb.getSelectedItem();
			        
			        GridBagConstraints c = new GridBagConstraints();
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 1;
			        c.gridx = 2;
					c.gridy = 2;	
					c.insets = new Insets(100,50,0,0);
			        Player.layoutPanel.add(currentBankMonster,c);

					((Player)((Component) e.getSource()).getParent().getParent().getParent().getParent().getParent()).update();
				}
		});
		partyMonstersComboBox = new JComboBox();
		partyMonstersComboBox.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e) 
				{
			        JComboBox cb = (JComboBox)e.getSource();
			        
			        Player.layoutPanel.remove(currentPartyMonster);
			        currentPartyMonster = (MonsterPanel)cb.getSelectedItem();
			        
			        GridBagConstraints c = new GridBagConstraints();
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 1;
			        c.gridx = 0;
					c.gridy = 2;	
					c.insets = new Insets(100,0,0,50);
			        Player.layoutPanel.add(currentPartyMonster,c);

					((Player)((Component) e.getSource()).getParent().getParent().getParent().getParent().getParent()).update();
				}
		});
	}
	
	public void setUpButtons()
	{
		addMonsterToBankButton = new JButton("Add a Monster to Bank");
		addMonsterToBankButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO: popup form to create monster
				String name = (String)JOptionPane.showInputDialog(
	                   new JFrame(), "Name of Monster:\n");
				
				String nickname = (String)JOptionPane.showInputDialog(
		                   new JFrame(), "Nickname of Monster:\n");
				int male = JOptionPane.showConfirmDialog(
					    new JFrame(),"Is it male?","Sex",JOptionPane.YES_NO_OPTION);
				String sex;
				if(male==JOptionPane.YES_OPTION)
					sex = "male";
				else
					sex = "female";
				addMonsterToBank(name, nickname, sex);
				
				((Player)((Component) arg0.getSource()).getParent().getParent().getParent().getParent().getParent()).update();
			}
		});
		
		transferMonsterToBankButton = new JButton("Transfer Monster to Bank");
		transferMonsterToBankButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO: select current monster specified
				MonsterPanel mp = currentPartyMonster;
				transferMonsterToBank(mp);
			}
		});
		
		transferMonsterToPartyButton = new JButton("Transfer Monster to Party");
		transferMonsterToPartyButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO: select current monster specified
				MonsterPanel mp = currentBankMonster;
				transferMonsterToParty(mp);
			}
		});
	}
	
	public void addMonsterToBank(String name, String nickname, String sex)
	{
		MonsterPanel mp = new MonsterPanel(name, nickname, sex, null, null);
		//bankMonstersComboBox.add(mp);
		bankMonsters.add(mp);
		bankMonstersComboBox.addItem(mp);
	}/* end addMonsterToBank */
	
	public void transferMonsterToBank(MonsterPanel mp)
	{
		bankMonsters.add(mp);
		bankMonstersComboBox.addItem(mp);
		partyMonsters.remove(mp);
		partyMonstersComboBox.removeItem(mp);

		bankMonstersComboBox.setSelectedIndex(bankMonstersComboBox.getModel().getSize());
	}/* end transferMonsterToBank */
	
	public void transferMonsterToParty(MonsterPanel mp)
	{
		partyMonsters.add(mp);
		partyMonstersComboBox.addItem(mp);
		bankMonsters.remove(mp);
		bankMonstersComboBox.removeItem(mp);

		bankMonstersComboBox.setSelectedIndex(partyMonstersComboBox.getModel().getSize());
	}/* end transferMonsterToParty */

	
	private ArrayList<MonsterPanel> partyMonsters, bankMonsters;
}

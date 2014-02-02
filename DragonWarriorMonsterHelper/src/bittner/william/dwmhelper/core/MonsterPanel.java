package bittner.william.dwmhelper.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MonsterPanel extends JPanel{
	
	private JPanel picturePanel;
	private JLabel nicknameLabel;
	
	public MonsterPanel(String monsterName,String nickname, String sex, MonsterPanel mother, MonsterPanel father)
	{
		picturePanel = new JPanel(){
			protected void paintComponent(Graphics g)
			{
				int x = (180-image.getWidth(null))/2;
				int y = (50 - image.getHeight(null))/2;
				super.paintComponent(g);
				g.drawImage(image, x, y, null); 
			}
		};
		nicknameLabel = new JLabel();
		
		this.nickname = nickname;
		this.monsterName = monsterName;
		this.sex = sex;
		this.mother = mother;
		this.father = father;
		
		setImage(monsterName.toLowerCase());
		createNicknameLabel(nickname);
		

		this.setLayout(new GridBagLayout());
		attachAllComponents();
		setMinimumSize(new Dimension(50,75));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}/* end MonsterPanel*/

	
	public void setImage(String s)
	{
        try {
        	
        	String url = "http://www.realmofdarkness.net/dq/img/gbc/dwm/monsters/" +s+ ".png";
        	//System.out.println(url);
        	
            image=new ImageIcon(new URL(url)).getImage();
        	} catch (MalformedURLException ex) 
        		{
        			Logger.getLogger(MonsterPanel.class.getName()).log(Level.SEVERE, null, ex);
        		}
        //System.out.println(image.getWidth(null) + " " + image.getHeight(null));
        picturePanel.setMinimumSize(new Dimension(50,50));
        picturePanel.setPreferredSize(new Dimension(50,50));
		picturePanel.setBackground(new Color(255,255,255,0));  
		
		picturePanel.repaint();
        /*TODO:*/
        setToolTipText(monsterName + "\n Sex: " + sex + "\nParents:" + mother + " and " + father);
	}/* end setImage*/
	
	public void createNicknameLabel(String nickname)
	{
		nicknameLabel = new JLabel(nickname);	
		nicknameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}/* end createNicknameLabel */
	
	public void attachAllComponents()
	{
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 0;		
		c.anchor = GridBagConstraints.PAGE_START;
		add(nicknameLabel, c);
		
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 1;	
		c.anchor = GridBagConstraints.CENTER;
		add(picturePanel, c);
	}/* end attachAllComponents */
	
	public boolean canMateWith(MonsterPanel other) {return(this.sex!=other.sex);}
	
	public String getMonsterName() {return monsterName;}
	
	public String getNickname() {return nickname;}
	
	public JPanel getPicturePanel() {return picturePanel;}
	
	public void setMother(MonsterPanel mp) {mother = mp;}
	public MonsterPanel getMother() {return mother;}
	
	public void setFather(MonsterPanel mp) {father = mp;}
	public MonsterPanel getFather() {return father;}
	
	public String toString(){return (nickname + " (" + monsterName + ")");}
	
	private MonsterPanel mother, father;
	private String monsterName, nickname, sex;
	private Image image;
	private ArrayList<MonsterPanel> potentialChildren, recommendedChildren;
}

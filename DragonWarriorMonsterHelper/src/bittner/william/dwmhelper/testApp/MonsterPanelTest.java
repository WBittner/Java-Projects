package bittner.william.dwmhelper.testApp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bittner.william.dwmhelper.core.*;

public class MonsterPanelTest {
	static JFrame f;
	static JPanel p;
	static MonsterPanel mp;
	static JButton mb;
	static String currentMonsterName;
	
	
	public static void main(String args[])
	{
		final int FRAME_WIDTH = 310;
		final int FRAME_HEIGHT = 240;

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		p = new JPanel(new BorderLayout());
		
		
		/*MonsterPanel mp1 = new MonsterPanel("Almiraj","Almy");
		MonsterPanel mp2 = new MonsterPanel("BigEye","Bigy");
		MonsterPanel mp3 = new MonsterPanel("DeadNoble","Deno");
		
		
		p.add(mp1);
		p.add(mp2);
		p.add(mp3);*/
		
		String[] monsterNames = {"Almiraj", "Anteater","BigEye", "CatFly", "DarkHorn", "FairyRat", "Goategon", "Grizzly", "GulpBeast", "HammerMan", 
				"Ironturt", "KingLeo", "MadCat", "MadGopher", "Mommonja","PillowRat","Saccer","Skullroo","SuperTen","Tonguella","Trumpeter",
				"Unicorn","WildApe","WindBeast","Yeti"};
		
		JComboBox monsterList = new JComboBox(monsterNames);
		//monsterList.setSelectedIndex(0);
		monsterList.addActionListener(new MonsterComboBoxListener());
		p.add(monsterList, BorderLayout.NORTH);
		
		mb = new JButton("Create!");
		mb.addActionListener(new MonsterButtonListener());
		p.add(mb, BorderLayout.SOUTH);
		
		
		mp = new MonsterPanel("Almiraj","Don't forget to nickname!", "male",null,null);
		p.add(mp);
		
		f = new JFrame();
		f.add(p);		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		f.setLocation((dim.width-FRAME_WIDTH)/2, (dim.height-FRAME_HEIGHT)/2-200);
	}
	
	public static void setPicturePanel(String monsterName, String nickname)
	{
		p.remove(mp);
		mp = new MonsterPanel(monsterName,nickname,"female",null,null);
		p.add(mp);
      	mp.revalidate();
	}

}

class MonsterComboBoxListener implements ActionListener
{
	public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        MonsterPanelTest.currentMonsterName = (String)cb.getSelectedItem();
	}
}

class MonsterButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent e) {
        String monsterName = MonsterPanelTest.currentMonsterName;
        String nickname = (String)JOptionPane.showInputDialog(new JFrame(), "What is the it's nickname?","Nickname yo shit", JOptionPane.PLAIN_MESSAGE);
      	MonsterPanelTest.setPicturePanel(monsterName, nickname);
	}
}

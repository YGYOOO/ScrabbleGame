import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;


public class mainFrame extends JFrame implements MouseMotionListener, MouseListener, ActionListener 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font f1;
	JFrame frame = new JFrame();
	private RoundPanel main = new RoundPanel("pictures/mainFrame_background.png",0);
	private RoundPanel beginner = new RoundPanel("pictures/mainFrame_beginner.png",0);
	private RoundPanel graduated = new RoundPanel("pictures/mainFrame_graduated.png",0);
	private RoundPanel challenger = new RoundPanel("pictures/mainFrame_graduated.png",0);
	private RoundPanel beginnerS = new RoundPanel("pictures/mainFrame_beginner_selected.png",0);
	private RoundPanel graduatedS = new RoundPanel("pictures/mainFrame_graduated_selected.png",0);
	private RoundPanel challengerS = new RoundPanel("pictures/mainFrame_graduated_selected.png",0);
	
	private JTextField userName1 = new JTextField();
	private JTextField nameInput1 = new JTextField();
	private JTextField userName2 = new JTextField();
	private JTextField nameInput2 = new JTextField();
	private RoundPanel lightning = new RoundPanel("pictures/mainFrame_lightning.png",0);
	private RoundPanel lightningE = new RoundPanel("pictures/mainFrame_lightning_energy.png",0);
	
	private JTextField howMany = new JTextField();
	private JComboBox<String> numberOfUser = new JComboBox<String>();
	
	private JTextField username1 = new JTextField();
	private JTextField nameinput1 = new JTextField();
	private JTextField username2 = new JTextField();
	private JTextField nameinput2 = new JTextField();
	private JTextField username3 = new JTextField();
	private JTextField nameinput3 = new JTextField();
	private JTextField username4 = new JTextField();
	private JTextField nameinput4 = new JTextField();
	
	private JTextField selectTile = new JTextField();
	private RoundPanel tile1 = new RoundPanel("pictures/mainFrame_tile1.png",0);
	private RoundPanel tile1S = new RoundPanel("pictures/mainFrame_tile1_selected.png",0);
	private RoundPanel tile2 = new RoundPanel("pictures/mainFrame_tile2.png",0);
	private RoundPanel tile2S = new RoundPanel("pictures/mainFrame_tile2_selected.png",0);
	
	private JTextField selectFont = new JTextField();
	private JComboBox<String> fontBox = new JComboBox<String>();
	
	private RoundPanel settings = new RoundPanel("pictures/mainFrame_settingButton.png",0);
	private RoundPanel settingsS = new RoundPanel("pictures/mainFrame_settingButton_selected.png",0);
	private RoundPanel back = new RoundPanel("pictures/mainFrame_backButton.png",0);
	private RoundPanel backS = new RoundPanel("pictures/mainFrame_backButton_selected.png",0);
	private RoundPanel start = new RoundPanel("pictures/mainFrame_start.png",0);
	private RoundPanel startS = new RoundPanel("pictures/mainFrame_start_selected.png",0);
	
	private int grade = 1;
	private String tileSrc = "pictures/tile1.png";
	private boolean setting = false;
	private boolean degree1Selected = false;
	private boolean degree2Selected = false;
	private boolean degree3Selected = false;
	private boolean tile1Selected = false;
	private boolean tile2Selected = false;
	private String font = "Fontdinerdotcom Jazz Dark";
	
	
	public mainFrame() 
	{
		f1 = new Font("Arial",Font.CENTER_BASELINE,15);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(400, 100, 500, 520);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.add(main);
		main.setBounds(0, 0, 500, 500);
		main.setLayout(null);
		main.addMouseMotionListener(this);
		
		main.add(beginner);
		beginner.setBounds(65, 129, 100, 110);
		beginner.addMouseListener(this);
		beginner.addMouseMotionListener(this);
		main.add(graduated);
		graduated.setBounds(191, 124, 120, 120);
		graduated.addMouseListener(this);
		graduated.addMouseMotionListener(this);
		main.add(challenger);
		challenger.setBounds(333, 124, 120, 120);
		challenger.addMouseListener(this);
		challenger.addMouseMotionListener(this);
		main.add(beginnerS);
		beginnerS.setBounds(65, 129, 100, 110);
		beginnerS.addMouseListener(this);
		main.add(graduatedS);
		graduatedS.setBounds(191, 124, 120, 120);
		graduatedS.addMouseListener(this);
		main.add(challengerS);
		challengerS.setBounds(333, 124, 120, 120);
		challengerS.addMouseListener(this);
		
		
		main.add(userName1);
		userName1.setVisible(false);
		userName1.setBounds(110, 290, 115, 30);
		userName1.setText("Player1's Name:");
		userName1.setEditable(false);
		userName1.setFont(f1);
		userName1.setForeground(Color.white);
		userName1.setBorder(BorderFactory.createEmptyBorder());
		userName1.setOpaque(false);
		main.add(nameInput1);
		nameInput1.setVisible(false);
		nameInput1.setBounds(110, 320, 115, 25);
		nameInput1.setFont(f1);
		nameInput1.setBorder(BorderFactory.createEmptyBorder());

		main.add(lightning);
		lightning.setBounds( 230, 245, 46, 74);
		lightning.setVisible(false);
		main.add(lightningE);
		lightningE.setBounds( 230, 245, 46, 74);
		lightningE.setVisible(false);
		
		main.add(userName2);
		userName2.setVisible(false);
		userName2.setBounds(275, 290, 115, 30);
		userName2.setText("Player2's Name:");
		userName2.setEditable(false);
		userName2.setFont(f1);
		userName2.setForeground(Color.white);
		userName2.setBorder(BorderFactory.createEmptyBorder());
		userName2.setOpaque(false);
		main.add(nameInput2);
		nameInput2.setBounds(275, 320, 115, 25);
		nameInput2.setFont(f1);
		nameInput2.setBorder(BorderFactory.createEmptyBorder());
		nameInput2.setVisible(false);
		nameInput2.addMouseMotionListener(this);
		
		main.add(howMany);
		howMany.setVisible(false);
		howMany.setBounds(143, 270, 215, 30);
		howMany.setText("Choose the number of players");
		howMany.setEditable(false);
		howMany.setFont(f1);
		howMany.setForeground(Color.white);
		howMany.setBorder(BorderFactory.createEmptyBorder());
		howMany.setOpaque(false);
		
		main.add(numberOfUser);
		numberOfUser.setVisible(false);
		numberOfUser.addItem("2");
		numberOfUser.addItem("3");
		numberOfUser.addItem("4");
		numberOfUser.setBounds(215, 300, 70, 25);
		numberOfUser.setFont(f1);
		numberOfUser.setForeground(Color.white);
		numberOfUser.addActionListener(this);
		
		main.add(username1);
		username1.setVisible(false);
		username1.setBounds(100, 240, 115, 30);
		username1.setText("Player1's Name:");
		username1.setEditable(false);
		username1.setFont(f1);
		username1.setForeground(Color.white);
		username1.setBorder(BorderFactory.createEmptyBorder());
		username1.setOpaque(false);
		main.add(nameinput1);
		nameinput1.setVisible(false);
		nameinput1.setText("");
		nameinput1.setBounds(100, 270, 115, 25);
		nameinput1.setFont(f1);
		nameinput1.setBorder(BorderFactory.createEmptyBorder());	
		
		main.add(username2);
		username2.setVisible(false);
		username2.setBounds(285, 240, 115, 30);
		username2.setText("Player2's Name:");
		username2.setEditable(false);
		username2.setFont(f1);
		username2.setForeground(Color.white);
		username2.setBorder(BorderFactory.createEmptyBorder());
		username2.setOpaque(false);
		main.add(nameinput2);
		nameinput2.setVisible(false);
		nameinput2.setText("");
		nameinput2.setBounds(285, 270, 115, 25);
		nameinput2.setFont(f1);
		nameinput2.setBorder(BorderFactory.createEmptyBorder());
		
		main.add(username3);
		username3.setVisible(false);
		username3.setBounds(100, 305, 115, 30);
		username3.setText("Player3's Name:");
		username3.setEditable(false);
		username3.setFont(f1);
		username3.setForeground(Color.white);
		username3.setBorder(BorderFactory.createEmptyBorder());
		username3.setOpaque(false);
		main.add(nameinput3);
		nameinput3.setVisible(false);
		nameinput3.setText("");
		nameinput3.setBounds(100, 335, 115, 25);
		nameinput3.setFont(f1);
		nameinput3.setBorder(BorderFactory.createEmptyBorder());
		
		main.add(username4);
		username4.setVisible(false);
		username4.setBounds(285, 305, 115, 30);
		username4.setText("Player4's Name:");
		username4.setEditable(false);
		username4.setFont(f1);
		username4.setForeground(Color.white);
		username4.setBorder(BorderFactory.createEmptyBorder());
		username4.setOpaque(false);
		main.add(nameinput4);
		nameinput4.setVisible(false);
		nameinput4.setText("");
		nameinput4.setBounds(285, 335, 115, 25);
		nameinput4.setFont(f1);
		nameinput4.setBorder(BorderFactory.createEmptyBorder());
		
		main.add(selectTile);
		selectTile.setVisible(false);
		selectTile.setBounds(209, 120, 82, 30);
		selectTile.setText("Style of tile:");
		selectTile.setEditable(false);
		selectTile.setFont(f1);
		selectTile.setForeground(Color.white);
		selectTile.setBorder(BorderFactory.createEmptyBorder());
		selectTile.setOpaque(false);
		main.add(tile1);
		tile1.setVisible(false);
		tile1.setBounds(150, 170, 57, 57);
		tile1.addMouseListener(this);
		tile1.addMouseMotionListener(this);
		main.add(tile1S);
		tile1S.setVisible(false);
		tile1S.setBounds(150, 170, 57, 57);
		tile1S.addMouseListener(this);
		main.add(tile2);
		tile2.setVisible(false);
		tile2.setBounds(293, 170, 57, 57);
		tile2.addMouseListener(this);
		tile2.addMouseMotionListener(this);
		main.add(tile2S);
		tile2S.setVisible(false);
		tile2S.setBounds(293, 170, 57, 57);
		tile2S.addMouseListener(this);
		
		main.add(selectFont);
		selectFont.setVisible(false);
		selectFont.setBounds(209, 250, 82, 30);
		selectFont.setText("Font of tile:");
		selectFont.setEditable(false);
		selectFont.setFont(f1);
		selectFont.setForeground(Color.white);
		selectFont.setBorder(BorderFactory.createEmptyBorder());
		selectFont.setOpaque(false);
		main.add(fontBox);
		fontBox.setVisible(false);
		fontBox.addItem("Jazz Dark");
		fontBox.addItem("Arial Black");
		fontBox.addItem("Chalkduster");
		fontBox.addItem("Noteworthy");
		fontBox.setSelectedItem("Jazz Dark");
		fontBox.setBounds(200, 300, 100, 25);
		fontBox.setFont(f1);
		fontBox.setForeground(Color.white);
		fontBox.addActionListener(this);
		
		main.add(back);
		back.setVisible(false);
		back.setBounds(216, 365, 68, 35);
		back.addMouseListener(this);
		back.addMouseMotionListener(this);
		main.add(backS);
		backS.setVisible(false);
		backS.setBounds(216, 365, 68, 35);
		backS.addMouseListener(this);
		
		main.add(start);
		start.setBounds(200, 440, 100, 45);
		start.addMouseListener(this);
		start.addMouseMotionListener(this);
		main.add(startS);
		startS.setVisible(false);
		startS.setBounds(200, 440, 100, 45);
		startS.addMouseListener(this);
		
		main.add(settings);
		settings.setBounds(460, 0, 40, 40);
		settings.addMouseListener(this);
		settings.addMouseMotionListener(this);
		main.add(settingsS);
		settingsS.setVisible(false);
		settingsS.setBounds(460, 0, 40, 40);
		settingsS.addMouseListener(this);
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		 try
		    {
		        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
		        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		    }
		    catch(Exception e)
		    {
		        //TODO exception
		    }
		 new mainFrame();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if(e.getSource()==beginnerS)
		{
			grade = 1;
			degree1Selected = true;
			degree2Selected = false;
			degree3Selected = false;
			username1.setVisible(false);
			nameinput1.setVisible(false);
			username2.setVisible(false);
			nameinput2.setVisible(false);
			username3.setVisible(false);
			nameinput3.setVisible(false);
			username4.setVisible(false);
			nameinput4.setVisible(false);
			howMany.setVisible(false);
			numberOfUser.setVisible(false);
			userName1.setVisible(true);
			nameInput1.setVisible(true);
			lightning.setVisible(true);
			userName2.setVisible(true);
			nameInput2.setVisible(true);
		}
		if(e.getSource()==graduatedS)
		{
			grade = 2;
			degree1Selected = false;
			degree2Selected = true;
			degree3Selected = false;
			username1.setVisible(false);
			nameinput1.setVisible(false);
			username2.setVisible(false);
			nameinput2.setVisible(false);
			username3.setVisible(false);
			nameinput3.setVisible(false);
			username4.setVisible(false);
			nameinput4.setVisible(false);
			howMany.setVisible(false);
			numberOfUser.setVisible(false);
			userName1.setVisible(true);
			nameInput1.setVisible(true);
			lightning.setVisible(true);
			userName2.setVisible(true);
			nameInput2.setVisible(true);
		}
		if(e.getSource()==challengerS)
		{
			grade = 3;
			degree1Selected = false;
			degree2Selected = false;
			degree3Selected = true;
			userName1.setVisible(false);
			nameInput1.setVisible(false);
			lightning.setVisible(false);
			lightningE.setVisible(false);
			userName2.setVisible(false);
			nameInput2.setVisible(false);
			username1.setVisible(false);
			nameinput1.setVisible(false);
			username2.setVisible(false);
			nameinput2.setVisible(false);
			username3.setVisible(false);
			nameinput3.setVisible(false);
			username4.setVisible(false);
			nameinput4.setVisible(false);
			howMany.setVisible(true);
			numberOfUser.setVisible(true);
		}
		
		if(e.getSource()==tile1S)
		{
			tile1Selected = true;
			tile2Selected = false;
			tileSrc = "pictures/tile1.png";
		}
		if(e.getSource()==tile2S)
		{
			tileSrc = "pictures/tile2.png";
			tile1Selected = false;
			tile2Selected = true;
		}
		
		if(e.getSource()==startS)
		{
			int index = fontBox.getSelectedIndex();
			switch(index)
			{
				case 0:
					font = "Fontdinerdotcom Jazz Dark";
					break;
				case 1:
					font = "Arial Black";
					break;
				case 2:
					font  = "Chalkduster";
					break;
				case 3:
					font = "Noteworthy";
			}
			if(grade==1)
			{
				try 
				{
					new GUI_beginner(nameInput1.getText(),nameInput2.getText(),tileSrc,font);
					frame.dispose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(grade==2)
			{
				try 
				{
					new GUI_graduated(nameInput1.getText(),nameInput2.getText(),tileSrc,font);
					frame.dispose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(grade==3)
			{
				try 
				{
					new GUI_challenger(nameinput1.getText(),nameinput2.getText(),nameinput3.getText(), nameinput4.getText(), numberOfUser.getSelectedIndex()+2, tileSrc,font);
					System.out.println(numberOfUser.getSelectedIndex()+2);
					frame.dispose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource()==fontBox)
		{
			int index = fontBox.getSelectedIndex();
			switch(index)
			{
				case 0:
					font = "Fontdinerdotcom Jazz Dark";
					break;
				case 1:
					font = "Arial Black";
					break;
				case 2:
					font  = "Chalkduster";
					break;
				case 3:
					font = "Noteworthy";
			}		
			 
		}
		if(e.getSource()==settingsS)
		{
			howMany.setVisible(false);
			numberOfUser.setVisible(false);
			userName1.setVisible(false);
			lightning.setVisible(false);
			lightningE.setVisible(false);
			nameInput1.setVisible(false);
			userName2.setVisible(false);
			nameInput2.setVisible(false);
			username1.setVisible(false);
			nameinput1.setVisible(false);
			username2.setVisible(false);
			nameinput2.setVisible(false);
			username3.setVisible(false);
			nameinput3.setVisible(false);
			username4.setVisible(false);
			nameinput4.setVisible(false);
			beginner.setVisible(false);
			beginnerS.setVisible(false);
			graduated.setVisible(false);
			graduatedS.setVisible(false);
			challenger.setVisible(false);
			challengerS.setVisible(false);
			
			back.setVisible(true);
			selectTile.setVisible(true);
			tile1.setVisible(true);
			tile2.setVisible(true);
			selectFont.setVisible(true);
			fontBox.setVisible(true);
			
			setting=true;

		}
		
		if(e.getSource()==backS)
		{
			back.setVisible(false);
			backS.setVisible(false);
			selectTile.setVisible(false);
			tile1.setVisible(false);
			tile1S.setVisible(false);
			tile2.setVisible(false);
			tile2S.setVisible(false);
			selectFont.setVisible(false);
			fontBox.setVisible(false);
			
			beginner.setVisible(true);
			beginnerS.setVisible(true);
			graduated.setVisible(true);
			graduatedS.setVisible(true);
			challenger.setVisible(true);
			challengerS.setVisible(true);
			
			setting=false;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		if(e.getSource()==nameInput2)
		{
				lightning.setVisible(false);
				lightningE.setVisible(true);
		}
		if(e.getSource()==beginner)
		{
			beginner.setVisible(false);
			beginnerS.setVisible(true);
		}
		if(e.getSource()==graduated)
		{
			graduated.setVisible(false);
			graduatedS.setVisible(true);
		}
		if(e.getSource()==challenger)
		{
			challenger.setVisible(false);
			challengerS.setVisible(true);
		}
		if(e.getSource()==start)
		{
			start.setVisible(false);
			startS.setVisible(true);
		}
		if(e.getSource()==tile1)
		{
			tile1.setVisible(false);
			tile1S.setVisible(true);
		}
		if(e.getSource()==tile2)
		{
			tile2.setVisible(false);
			tile2S.setVisible(true);
		}
		if(e.getSource()==main&&setting)
		{
			if(tile1Selected)
			{
				tile1.setVisible(false);
				tile1S.setVisible(true);
				tile2.setVisible(true);
				tile2S.setVisible(false);
			}
			else if(tile2Selected)
			{
				tile1.setVisible(true);
				tile1S.setVisible(false);
				tile2.setVisible(false);
				tile2S.setVisible(true);
			}
			else
			{
				tile1.setVisible(true);
				tile1S.setVisible(false);
				tile2.setVisible(true);
				tile2S.setVisible(false);
			}
		}
		if(e.getSource()==back)
		{
			back.setVisible(false);
			backS.setVisible(true);
		}
		if(e.getSource()==settings)
		{
			settings.setVisible(false);
			settingsS.setVisible(true);
		}
		if(e.getSource()==main)
		{
			start.setVisible(true);
			startS.setVisible(false);
			settings.setVisible(true);
			settingsS.setVisible(false);
		}
		if(e.getSource()==main&&setting)
		{
			back.setVisible(true);
			backS.setVisible(false);
		}
		if(e.getSource()==main&&setting==false)
		{
			if(degree1Selected)
			{
				graduated.setVisible(true);
				challenger.setVisible(true);
				graduatedS.setVisible(false);
				challengerS.setVisible(false);
			}
			else if(degree2Selected)
			{
				beginner.setVisible(true);
				challenger.setVisible(true);
				beginnerS.setVisible(false);
				challengerS.setVisible(false);
			}
			else if(degree3Selected)
			{
				graduated.setVisible(true);
				beginner.setVisible(true);
				graduatedS.setVisible(false);
				beginnerS.setVisible(false);
			}
			else
			{
				graduatedS.setVisible(false);
				challengerS.setVisible(false);
				challengerS.setVisible(false);
				beginner.setVisible(true);
				graduated.setVisible(true);
				challenger.setVisible(true);
			}
		}
		if(e.getSource()==main&&setting)
		{
			int index = fontBox.getSelectedIndex();
			switch(index)
			{
				case 0:
					font = "Fontdinerdotcom Jazz Dark";
					break;
				case 1:
					font = "Arial Black";
					break;
				case 2:
					font  = "Chalkduster";
					break;
				case 3:
					font = "Noteworthy";
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==numberOfUser)
		{
			if(numberOfUser.getSelectedIndex()==0)
			{
				howMany.setVisible(false);
				numberOfUser.setVisible(false);
				userName1.setVisible(false);
				nameInput1.setVisible(false);
				lightning.setVisible(false);
				lightningE.setVisible(false);
				userName2.setVisible(false);
				nameInput2.setVisible(false);
				username1.setVisible(true);
				nameinput1.setVisible(true);
				username2.setVisible(true);
				nameinput2.setVisible(true);
			}
			else if(numberOfUser.getSelectedIndex()==1)
			{
				howMany.setVisible(false);
				numberOfUser.setVisible(false);
				userName1.setVisible(false);
				nameInput1.setVisible(false);
				lightning.setVisible(false);
				lightningE.setVisible(false);
				userName2.setVisible(false);
				nameInput2.setVisible(false);
				username1.setVisible(true);
				nameinput1.setVisible(true);
				username2.setVisible(true);
				nameinput2.setVisible(true);
				username3.setVisible(true);
				nameinput3.setVisible(true);
			}
			else if(numberOfUser.getSelectedIndex()==2)
			{
				howMany.setVisible(false);
				numberOfUser.setVisible(false);
				userName1.setVisible(false);
				nameInput1.setVisible(false);
				lightning.setVisible(false);
				lightningE.setVisible(false);
				userName2.setVisible(false);
				nameInput2.setVisible(false);
				username1.setVisible(true);
				nameinput1.setVisible(true);
				username2.setVisible(true);
				nameinput2.setVisible(true);
				username3.setVisible(true);
				nameinput3.setVisible(true);
				username4.setVisible(true);
				nameinput4.setVisible(true);
			}
		}
	}
	
}

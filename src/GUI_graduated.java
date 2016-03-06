
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Random;

import javax.swing.*;


public class GUI_graduated extends JFrame implements MouseMotionListener, MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font f1;
	private Font f2;
	private Main m; 
	private User u[] = new User[2];
	JFrame frame = new JFrame();
	private Dictionary d;
	private RoundPanel board = new RoundPanel("pictures/normalboard1_board.png",5);
//	private RoundPanel user1 = new RoundPanel("pictures/glass3.png",5);
	private JTextField name1= new JTextField();
	private JTextField name2= new JTextField();
	private JTextField score1 = new JTextField();
	private JTextField score2 = new JTextField();
	private JTextField user1Name = new JTextField();
	private JTextField user1Score = new JTextField();
	private JTextField user2Name = new JTextField();
	private JTextField user2Score = new JTextField();
	private RoundPanel menu = new RoundPanel("pictures/normalboard1_menu.png",5);
	private JButton confirm = new JButton();
	private JButton pass = new JButton();
	private JButton back = new JButton();

	private JLabel letter[] = new JLabel[10];
	private JLabel letter2[] = new JLabel[10];
	private int times = 0;
	private Tile Tiles[][] = new Tile[15][15];
	private int coordinate[][] = new int[7][2];
	private boolean tiles[][] = new boolean[15][15];
	private int IncreaseScore[][] = new int[15][15];
	
	private String tileSrc = "pictures/tile1.png";
	
	public GUI_graduated(String inputName1,String inputName2, String tileSrc1, String font) throws FileNotFoundException
	{
		tileSrc = tileSrc1;
		f1 = new Font(font,Font.BOLD,18);
		f2 = new Font("Arial",Font.CENTER_BASELINE,16);
		m = new Main();
		d = new Dictionary();
		u[0] = new User(inputName1);
		u[1] = new User(inputName2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(250, 0, 890, 820);
		frame.setVisible(true);
		frame.addComponentListener(new ComponentAdapter()
		{
			@Override 
			public void componentResized(ComponentEvent e)
			{
				double frameWidth =  frame.getSize().getWidth();
				double frameHeight = frame.getSize().getHeight();
				menu.setBounds(0, 0, (int)frame.getSize().getWidth()*140/890,(int)frame.getSize().getHeight());
				board.setBounds((int)frame.getSize().getWidth()*140/890, 0, (int)frame.getSize().getWidth()*750/890,(int)frame.getSize().getHeight());
				for(int i=0;i<7;i++)
				{
					ImageIcon image = new ImageIcon(tileSrc); 
					letter[i].setLayout(new BorderLayout());
					image.setImage(image.getImage().getScaledInstance((int)(frameWidth*50/890),(int)(frameHeight*50/820), Image.SCALE_SMOOTH)); 
					letter[i].setIcon(image);
					letter[i].add("Center",letter2[i]);
					letter2[i].setHorizontalAlignment(JTextField.CENTER);
					letter2[i].setFont(f1);
					letter2[i].setOpaque(false);
					letter[i].setBounds( (int)(frameWidth*200/890+i*frameWidth*50/890), (int)(frameHeight*750/820), (int)(frameWidth*50/890), (int)(frameHeight*50/820));
				}
				name1.setBounds(20, 18, 50, 30);
				user1Name.setBounds(75, 18, 90, 30);
				score1.setBounds(20, 48, 60, 30);
				user1Score.setBounds(75, 48, 60, 30);
				name1.setBounds((int)(frameWidth*20/890), (int)(frameHeight*18/820),(int)(frameWidth*50/890), (int)(frameHeight*30/820));
				user1Name.setBounds((int)(frameWidth*75/890), (int)(frameHeight*18/820),(int)(frameWidth*90/890), (int)(frameHeight*30/820));
				score1.setBounds((int)(frameWidth*20/890), (int)(frameHeight*48/820),(int)(frameWidth*60/890), (int)(frameHeight*30/820));
				user1Score.setBounds((int)(frameWidth*75/890), (int)(frameHeight*48/820),(int)(frameWidth*60/890), (int)(frameHeight*30/820));
				name2.setBounds((int)(frameWidth*20/890), (int)(frameHeight*118/820),(int)(frameWidth*50/890), (int)(frameHeight*30/820));
				user2Name.setBounds((int)(frameWidth*75/890), (int)(frameHeight*118/820),(int)(frameWidth*90/890), (int)(frameHeight*30/820));
				score2.setBounds((int)(frameWidth*20/890), (int)(frameHeight*148/820),(int)(frameWidth*60/890), (int)(frameHeight*30/820));
				user2Score.setBounds((int)(frameWidth*75/890), (int)(frameHeight*148/820),(int)(frameWidth*90/890), (int)(frameHeight*30/820));
				
//				name3.setBounds((int)(frameWidth*20/890), (int)(frameHeight*218/820),(int)(frameWidth*50/890), (int)(frameHeight*30/820));
//				user3Name.setBounds((int)(frameWidth*75/890), (int)(frameHeight*218/820),(int)(frameWidth*90/890), (int)(frameHeight*30/820));
//				score3.setBounds((int)(frameWidth*20/890), (int)(frameHeight*248/820),(int)(frameWidth*60/890), (int)(frameHeight*30/820));
//				user3Score.setBounds((int)(frameWidth*75/890), (int)(frameHeight*248/820),(int)(frameWidth*60/890), (int)(frameHeight*30/820));
//				name4.setBounds((int)(frameWidth*20/890), (int)(frameHeight*318/820),(int)(frameWidth*50/890), (int)(frameHeight*30/820));
//				user4Name.setBounds((int)(frameWidth*75/890), (int)(frameHeight*318/820),(int)(frameWidth*90/890), (int)(frameHeight*30/820));
//				score4.setBounds((int)(frameWidth*20/890), (int)(frameHeight*348/820),(int)(frameWidth*60/890), (int)(frameHeight*30/820));
//				user4Score.setBounds((int)(frameWidth*75/890), (int)(frameHeight*348/820),(int)(frameWidth*90/890), (int)(frameHeight*30/820d));
//				
				confirm.setBounds((int)(frameWidth*20/890), (int)(frameHeight*751/820),(int)(frameWidth*45/890), (int)(frameHeight*45/820));
				pass.setBounds((int)(frameWidth*75/890), (int)(frameHeight*751/820),(int)(frameWidth*45/890), (int)(frameHeight*45/820));
				back.setBounds((int)(frameWidth*702/890), (int)(frameHeight*751/820),(int)(frameWidth*45/890), (int)(frameHeight*45/820));
			}
		});
		frame.setLayout(null);
		
		
		frame.add(menu);
		menu.setBounds(0, 0, (int)frame.getSize().getWidth()*140/890,(int)frame.getSize().getHeight());
		menu.setLayout(null);
		frame.add(board);
		board.setBounds(140, 0, (int)frame.getSize().getWidth()*750/890,(int)frame.getSize().getHeight());
		board.setLayout(null);

		menu.add(name1);
		name1.setBounds(20, 18, 50, 30);
		name1.setText("Name:");
		name1.setEditable(false);
		name1.setFont(f2);
		name1.setForeground(Color.white);
		name1.setBorder(BorderFactory.createEmptyBorder());
		name1.setOpaque(false);
		menu.add(user1Name);
		user1Name.setBounds(75, 18, 90, 30);
		user1Name.setText(u[0].getName());
		user1Name.setEditable(false);
		user1Name.setFont(f2);
		user1Name.setForeground(Color.white);
		user1Name.setBorder(BorderFactory.createEmptyBorder());
		user1Name.setOpaque(false);
		menu.add(score1);
		score1.setBounds(20, 48, 60, 30);
		score1.setText("Score:");
		score1.setEditable(false);
		score1.setFont(f2);
		score1.setForeground(Color.white);
		score1.setBorder(BorderFactory.createEmptyBorder());
		score1.setOpaque(false);
		menu.add(user1Score);
		user1Score.setBounds(75, 48, 60, 30);
		user1Score.setText(Integer.toString(u[0].getScore()));
		user1Score.setEditable(false);
		user1Score.setFont(f2);
		user1Score.setForeground(Color.white);
		user1Score.setBorder(BorderFactory.createEmptyBorder());
		user1Score.setOpaque(false);
		menu.add(name2);
		name2.setBounds(20, 118, 50, 30);
		name2.setText("Name:");
		name2.setEditable(false);
		name2.setFont(f2);
		name2.setForeground(Color.white);
		name2.setBorder(BorderFactory.createEmptyBorder());
		name2.setOpaque(false);
		menu.add(user2Name);
		user2Name.setBounds(75, 118, 90, 30);
		user2Name.setText(u[1].getName());
		user2Name.setEditable(false);
		user2Name.setFont(f2);
		user2Name.setForeground(Color.white);
		user2Name.setBorder(BorderFactory.createEmptyBorder());
		user2Name.setOpaque(false);
		menu.add(score2);
		score2.setBounds(20, 148, 60, 30);
		score2.setText("Score:");
		score2.setEditable(false);
		score2.setFont(f2);
		score2.setForeground(Color.white);
		score2.setBorder(BorderFactory.createEmptyBorder());
		score2.setOpaque(false);
		menu.add(user2Score);
		user2Score.setBounds(75, 148, 60, 30);
		user2Score.setText(Integer.toString(u[1].getScore()));
		user2Score.setEditable(false);
		user2Score.setFont(f2);
		user2Score.setForeground(Color.white);
		user2Score.setBorder(BorderFactory.createEmptyBorder());
		user2Score.setOpaque(false);
		
//		menu.add(name3);
//		name3.setBounds(20, 218, 50, 30);
//		name3.setText("Name:");
//		name3.setEditable(false);
//		name3.setFont(f2);
//		name3.setForeground(Color.white);
//		name3.setBorder(BorderFactory.createEmptyBorder());
//		name3.setOpaque(false);
//		menu.add(user3Name);
//		user3Name.setBounds(75, 218, 90, 30);
//		user3Name.setText(u[2].getName());
//		user3Name.setEditable(false);
//		user3Name.setFont(f2);
//		user3Name.setForeground(Color.white);
//		user3Name.setBorder(BorderFactory.createEmptyBorder());
//		user3Name.setOpaque(false);
//		menu.add(score3);
//		score3.setBounds(20, 248, 60, 30);
//		score3.setText("Score:");
//		score3.setEditable(false);
//		score3.setFont(f2);
//		score3.setForeground(Color.white);
//		score3.setBorder(BorderFactory.createEmptyBorder());
//		score3.setOpaque(false);
//		menu.add(user3Score);
//		user3Score.setBounds(75, 248, 60, 30);
//		user3Score.setText(Integer.toString(u[2].getScore()));
//		user3Score.setEditable(false);
//		user3Score.setFont(f2);
//		user3Score.setForeground(Color.white);
//		user3Score.setBorder(BorderFactory.createEmptyBorder());
//		user3Score.setOpaque(false);
//		menu.add(name4);
//		name4.setBounds(20, 318, 50, 30);
//		name4.setText("Name:");
//		name4.setEditable(false);
//		name4.setFont(f2);
//		name4.setForeground(Color.white);
//		name4.setBorder(BorderFactory.createEmptyBorder());
//		name4.setOpaque(false);
//		menu.add(user4Name);
//		user4Name.setBounds(75, 318, 90, 30);
//		user4Name.setText(u[3].getName());
//		user4Name.setEditable(false);
//		user4Name.setFont(f2);
//		user4Name.setForeground(Color.white);
//		user4Name.setBorder(BorderFactory.createEmptyBorder());
//		user4Name.setOpaque(false);
//		menu.add(score4);
//		score4.setBounds(20, 348, 60, 30);
//		score4.setText("Score:");
//		score4.setEditable(false);
//		score4.setFont(f2);
//		score4.setForeground(Color.white);
//		score4.setBorder(BorderFactory.createEmptyBorder());
//		score4.setOpaque(false);
//		menu.add(user4Score);
//		user4Score.setBounds(75, 348, 60, 30);
//		user4Score.setText(Integer.toString(u[3].getScore()));
//		user4Score.setEditable(false);
//		user4Score.setFont(f2);
//		user4Score.setForeground(Color.white);
//		user4Score.setBorder(BorderFactory.createEmptyBorder());
//		user4Score.setOpaque(false);
		
		menu.add(confirm); 
		confirm.setIcon(new ImageIcon("pictures/normalboard1_OK.png"));
//		confirm.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
		confirm.setBounds(20, 751, 45, 45);
		confirm.addMouseListener(this);
		
		menu.add(pass);
		pass.setIcon(new ImageIcon("pictures/normalboard1_Pass.png"));
		pass.setBounds(75, 751, 45, 45);
		pass.addMouseListener(this);
		
		board.add(back);
		back.setIcon(new ImageIcon("pictures/normalboard1_Back.png"));
		back.setBounds(702, 751, 45, 45);
		back.addMouseListener(this);
		
		assignLettersToUser();
		showTiles();
		
		for(int i=0;i<7;i++)
		{
			coordinate[i][0]=1000;
			coordinate[i][1]=1000;
		}
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
				Tiles[i][j]=null;
			}
		}
		
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
				IncreaseScore[i][j]=0;
			}
		}
		IncreaseScore[1][1]=1;IncreaseScore[2][2]=1;IncreaseScore[3][3]=1;IncreaseScore[4][4]=1;
		IncreaseScore[10][10]=1;IncreaseScore[11][11]=1;IncreaseScore[12][12]=1;IncreaseScore[13][13]=1;
		IncreaseScore[13][1]=1;IncreaseScore[12][2]=1;IncreaseScore[11][3]=1;IncreaseScore[10][4]=1;
		IncreaseScore[1][13]=1;IncreaseScore[2][12]=1;IncreaseScore[3][11]=1;IncreaseScore[4][10]=1;
		IncreaseScore[0][0]=2;IncreaseScore[7][0]=2;IncreaseScore[14][0]=2;IncreaseScore[0][7]=2;IncreaseScore[14][7]=2;
		IncreaseScore[0][14]=2;IncreaseScore[7][14]=2;IncreaseScore[14][14]=2;
		IncreaseScore[3][0]=3;IncreaseScore[11][0]=3;IncreaseScore[6][2]=3;IncreaseScore[8][2]=3;
		IncreaseScore[0][3]=3;IncreaseScore[7][3]=3;IncreaseScore[14][3]=3;
		IncreaseScore[2][6]=3;IncreaseScore[6][6]=3;IncreaseScore[8][6]=3;IncreaseScore[12][6]=3;
		IncreaseScore[3][7]=3;IncreaseScore[11][7]=3;
		IncreaseScore[3][14]=3;IncreaseScore[11][14]=3;IncreaseScore[6][12]=3;IncreaseScore[8][12]=3;
		IncreaseScore[0][11]=3;IncreaseScore[7][11]=3;IncreaseScore[14][11]=3;
		IncreaseScore[2][8]=3;IncreaseScore[6][8]=3;IncreaseScore[8][8]=3;IncreaseScore[12][8]=3;
		IncreaseScore[5][1]=4;IncreaseScore[9][1]=4;
		IncreaseScore[1][5]=4;IncreaseScore[5][5]=4;IncreaseScore[9][5]=4;IncreaseScore[13][5]=4;
		IncreaseScore[5][13]=4;IncreaseScore[9][13]=4;
		IncreaseScore[1][9]=4;IncreaseScore[5][9]=4;IncreaseScore[9][9]=4;IncreaseScore[13][9]=4;
	}
	
	public void showTiles()
	{
		for(int i=0;i<7;i++)
		{
			letter[i]=new JLabel();
			board.add(letter[i]);
			double frameWidth =  frame.getSize().getWidth();
			double frameHeight = frame.getSize().getHeight();
			letter[i].setBounds( (int)(frameWidth*200/890+i*frameWidth*50/890), (int)(frameHeight*750/820), (int)(frameWidth*50/890), (int)(frameHeight*50/820));
			ImageIcon image = new ImageIcon(tileSrc); 
			letter[i].setLayout(new BorderLayout());
			image.setImage(image.getImage().getScaledInstance((int)(frameWidth*50/890),(int)(frameHeight*50/820), Image.SCALE_SMOOTH)); 
			letter[i].setIcon(image);
			letter2[i] = new JLabel();
			letter[i].add("Center",letter2[i]);
			letter2[i].setHorizontalAlignment(JTextField.CENTER);
			letter2[i].setFont(f1);
			letter2[i].setOpaque(false);
			if(u[times%2].getTile(i).getLetter().equals(""))
			{
				letter2[i].setText("");
			}
			else
			{
				letter2[i].setText(u[times%2].getTile(i).getLetter()+" "+u[times%2].getTile(i).getScore());
			}			
			letter[i].setFont(f1);
			letter[i].addMouseMotionListener(this);
			letter[i].addMouseListener(this);
		}		
	}
	
	public void assignLettersToUser()
	{
		HashSet<Tile> set = m.getAllLetters();
		Random r = new Random();
//		System.out.println(set.size());
		for(int i=0;i<7;i++)
		{
			int n = r.nextInt(set.size());
			int count = 0;
			for(Tile l:set)
			{
				if(count==n)
				{
					if(u[times%2].getTile(i)==null)
					{
						set.remove(l);
						u[times%2].setTile(l, i);
						break;
					}
					else
					{
						break;
					}
				}
				count++;
			}
		}
	}
	
//	public boolean checkIfInALine()
//	{
//		for(int i=0;i<7;i++)
//		{
//			if(coordinate[i][0]!=1000)
//			{
//				int x = coordinate[i][0];
//				int y = coordinate[i][1];
//				Tiles[x][y] = u[times%2].getTile(i);
//			}
//		}
//	}
	
	
	public int checkIfAWord()
	{
		int a = checkIfHorizontallyOrVertically();
		if(a==0)
		{
//			JOptionPane.showMessageDialog(null,"Words can be placed only horizontally or vertically.");
			Object[] options = {"OK"};
			JOptionPane.showOptionDialog(this,"Words can be placed only horizontally or vertically.",null,JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);
			return 0;
		}
		
		for(int i=0;i<7;i++)
		{
			if(coordinate[i][0]!=1000&&u[times%2].getTile(i).getLetter().equals(""))
			{
				Object[] options = {"OK"};
				JOptionPane.showOptionDialog(this,"You can't use a blank tile.",null,JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);
				return 0;
			}
		}
		
		String word;
		int score=0;
		boolean findAWord = false;
		
		//If it is the first word and it is horizontally, weather it start at the center
//╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		if(times==0&&a==1)
		{
			//Check weather the letter is on the middle line.
			for(int i=0;i<7;i++)
			{
				if(coordinate[i][0]!=1000)
				{
					int y = coordinate[i][1];
					if(y!=7)
					{
						Object[] options = {"OK"};
						JOptionPane.showOptionDialog(this,"The first word on the board must start at the star.",null,JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);
						return 0;
					}
				}
			}
			//Check weather the letter touch the center.
			boolean touchTheCenter = false;
			for(int i=0;i<7;i++)
			{
				if(coordinate[i][0]!=1000)
				{
					int x = coordinate[i][0];
					if(x==7)
					{
						touchTheCenter = true;
					}
				}
			}
			if(!touchTheCenter)
			{
				Object[] options = {"OK"};
				JOptionPane.showOptionDialog(this,"The first word on the board must start at the star.",null,JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);
				return 0;
			}
			
			//Check weather the letter start at the center.
			for(int i=0;i<7;i++)
			{
				if(coordinate[i][0]!=1000)
				{
					int x = coordinate[i][0];
					if(x<7)
					{
						Object[] options = {"OK"};
						JOptionPane.showOptionDialog(this,"The first word on the board must start at the star.",null,JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);
						return 0;
					}
				}
			}
		}
//╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

		//If it is the first word and it is vertically, weather it start at the center
//╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
		if(times==0&&a==2)
		{
			//Check weather the letter is on the middle row.
			for(int i=0;i<7;i++)
			{
				if(coordinate[i][0]!=1000)
				{
					int x = coordinate[i][0];
					if(x!=7)
					{
						Object[] options = {"OK"};
						JOptionPane.showOptionDialog(this,"The first word on the board must start at the star.",null,JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);
						return 0;
					}
				}
			}
			//Check weather the letter touch the center.
			boolean touchTheCenter = false;
			for(int i=0;i<7;i++)
			{
				if(coordinate[i][0]!=1000)
				{
					int y = coordinate[i][1];
					if(y==7)
					{
						touchTheCenter = true;
					}
				}
			}
			if(!touchTheCenter)
			{
				Object[] options = {"OK"};
				JOptionPane.showOptionDialog(this,"The first word on the board must start at the star.",null,JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);
				return 0;
			}
			
			//Check weather the letter start at the center.
			for(int i=0;i<7;i++)
			{
				if(coordinate[i][0]!=1000)
				{
					int y = coordinate[i][1];
					if(y<7)
					{
						Object[] options = {"OK"};
						JOptionPane.showOptionDialog(this,"The first word on the board must start at the star.",null,JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);
						return 0;
					}
				}
			}
		}
//╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

		for(int i=0;i<7;i++)
		{
			if(coordinate[i][0]!=1000)
			{
				int x = coordinate[i][0];
				int y = coordinate[i][1];
				if(Tiles[x][y]!=null)
				{
					Object[] options = {"OK"};
					JOptionPane.showOptionDialog(this,"Tiles cannot be overlaped.",null,JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);
					return 0;
				}
				Tiles[x][y] = u[times%2].getTile(i);
			}
		}
		
		
		
		for(int i=0;i<7;i++)
		{
			if(coordinate[i][0]!=1000)
			{
				word = "";
				int x = coordinate[i][0];
				int y = coordinate[i][1];
//				System.out.println("2."+x+"  "+y);
				int count1=1;
				int count2=1;

				while(x-count1>-1&&x-count1<15&&Tiles[x-count1][y]!=null)
				{
					count1++;
				}
				while(x+count2>-1&&x+count2<15&&Tiles[x+count2][y]!=null)
				{
					count2++;
				}

				int xl = x-count1+1;
				int xr = x+count2-1;
//				System.out.println("2.5. "+(xr-xl));
				if(xr-xl!=0)
				{
					for(int j=0;j<xr-xl+1;j++)
					{
						word = word + Tiles[xl+j][y].getLetter();
					}	
				}
				if(word!="")
				{
//					System.out.println("4."+word);
					if(d.confirm(word))
					{
						if(word.length()>7)
						{
							Object[] options = {"OK"};
							JOptionPane.showOptionDialog(this,"Each word can be at most seven letters long.",null,JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);
							return 0;
						}
						else
						{
							findAWord = true;
//							for(int j=0;j<xr-xl+1;j++)
//							{
//								score = score + Tiles[xl+j][y].getScore();
//							}	
							score = calculateScore(xl, xr,y,true);
						}
					}
				}
				if(a==1)
				{
					break;
				}
			}
		}
	//-----------------------------------------------------------------------------------------------------------------------			
		for(int i=0;i<7;i++)
		{
			if(coordinate[i][0]!=1000)
			{
				word = "";
				int x = coordinate[i][0];
				int y = coordinate[i][1];
				int count1=1;
				int count2=1;
				word = "";
				while(y-count1>-1&&y-count1<15&&Tiles[x][y-count1]!=null)
				{
					count1++;	
				}
				while(y+count2>-1&&y+count2<15&&Tiles[x][y+count2]!=null)
				{
					count2++;
				}
				int yu = y-count1+1;
				int yd = y+count2-1;
				if(yd-yu!=0)
				{
					for(int j=0;j<yd-yu+1;j++)
					{
						word = word + Tiles[x][yu+j].getLetter();
					}	
				}
				if(word!="")
				{
//					System.out.println(word);
					if(d.confirm(word))
					{
						if(word.length()>7)
						{
							Object[] options = {"OK"};
							JOptionPane.showOptionDialog(this,"Each word can be at most seven letters long.",null,JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);
							return 0;
						}
						else
						{
							findAWord = true;

							score = calculateScore(yu, yd, x, false);
						}
					}
				}
				if(a==2)
				{
					break;
				}
			}
		}
		if(findAWord==false)
		{
			Object[] options = {"OK"};
			JOptionPane.showOptionDialog(this,"Oops..it's not a word.",null,JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);
			for(int j=0;j<7;j++)
			{
				if(coordinate[j][0]!=1000)
				{
					int x = coordinate[j][0];
					int y = coordinate[j][1];
					Tiles[x][y] = null;
				}
			}

			return 0;
		}
		for(int i=0;i<7;i++)
		{
			if(coordinate[i][0]!=1000)
			{
				u[times%2].setTile(null, i);
			}
		}
		
		return score;
	}
	
	//1 means horizontally, 2 means vertically, 3 means just one letter, 0 means neither of them.
		public int checkIfHorizontallyOrVertically()
		{
			int X[] = {1000,1000,1000,1000,1000,1000,1000};
			int Y[] = {1000,1000,1000,1000,1000,1000,1000};
			int count = 0;
			for(int i=0;i<7;i++)
			{
				if(coordinate[i][0]!=1000)
				{
					count++;
				}
			}
			if(count==1)
			{
				return 3;
			}
			
			int j = 0;
			for(int i=0;i<7;i++)
			{
				if(coordinate[i][0]!=1000)
				{
					X[j] = coordinate[i][0];
					Y[j] = coordinate[i][1];
					j++;
				}
			}
			
			boolean horizontally = true;
			for(int i=0;i<6;i++)
			{
				if(Y[i+1]!=1000)
				{
					if(Y[i]!=Y[i+1])
					{
						horizontally = false;
						break;
					}
				}
				else
				{
					break;
				}
			}
			
			boolean vertically = true;
			for(int i=0;i<6;i++)
			{
				if(X[i+1]!=1000)
				{
					if(X[i]!=X[i+1])
					{
						vertically = false;
						break;
					}
				}
				else
				{
					break;
				}
			}
				
			for(int i=0;i<15;i++)
			{
				for(int k=0;k<15;k++)
				{
					tiles[i][k]=false;
				}
			}
			for(int i=0;i<15;i++)
			{
				for(int k=0;k<15;k++)
				{
					if(Tiles[i][k]!=null)
					{
						tiles[i][k]=true;
					}
				}
			}
			for(int i=0;i<7;i++)
			{
				if(X[i]!=1000)
				{
					tiles[X[i]][Y[i]]=true;
				}
			}
			//judge if all these horizontally letters are put one by one
			if(horizontally)
			{
				for(int i=0;i<7;i++)
				{
					if(X[i]!=1000)
					{
						boolean hasANeighboor = false;
//						for(int k=0;k<7;k++)
//						{
//							if(X[k]!=1000&&i!=k)
//							{
//								if(X[i]-X[k]==1||X[i]-X[k]==-1)
//								{
//									hasANeighboor = true;
//									break;
//								}
//							}
//						}
						for(int k=0;k<15;k++)
						{
							for(int l=0;l<15;l++)
							{
								if(tiles[k][l]!=false)
								{
									if(X[i]-k==1||X[i]-k==-1)
									{
										hasANeighboor = true;
										break;
									}
								}
							}
						}
						if(hasANeighboor==false)
						{
							return 0;
						}
					}
				}
				return 1;
			}
			
			//judge if all these vertically letters are put one by one
			else if(vertically)
			{
				for(int i=0;i<6;i++)
				{
					if(Y[i]!=1000)
					{
						boolean hasANeighboor = false;
//						for(int k=0;k<6;k++)
//						{
//							if(Y[k]!=1000&&i!=k)
//							{
//								if(Y[i]-Y[k]==1||Y[i]-Y[k]==-1)
//								{
//									hasANeighboor = true;
//									break;
//								}
//							}
//						}
						for(int k=0;k<15;k++)
						{
							for(int l=0;l<15;l++)
							{
								if(tiles[k][l]!=false)
								{
									if(Y[i]-l==1||Y[i]-l==-1)
									{
										hasANeighboor = true;
										break;
									}
								}
							}
						}
						if(hasANeighboor==false)
						{
							return 0;
						}
					}
				}
				return 2;
			}
			return 0;
		}
	
	public int calculateScore(int first, int last, int line, boolean hOrV)
	{
		int score = 0;
		if(hOrV)
		{
			for(int i=0;i<last-first+1;i++)
			{
				score = score + Tiles[first+i][line].getScore();
			}
			
			//double/triple word score
			for(int i=0;i<last-first+1;i++)
			{
				switch(IncreaseScore[first+i][line])
				{
					case 0:
						break;
					case 1:
						score = score*2;
						break;
					case 2:
						score = score*3;
						break;
					case 3:
						break;
					case 4:
						break;
				}	
			}	
			
			//double/triple letter score
			for(int i=0;i<last-first+1;i++)
			{
				switch(IncreaseScore[first+i][line])
				{
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						score = score + Tiles[first+i][line].getScore();
						break;
					case 4:
						score = score + Tiles[first+i][line].getScore()*2;
						break;
				}	
			}	
		}
		else
		{
			for(int i=0;i<last-first+1;i++)
			{
				score = score + Tiles[line][first+i].getScore();
			}
			
			//double/triple word score
			for(int i=0;i<last-first+1;i++)
			{
				switch(IncreaseScore[line][first+i])
				{
					case 0:
						break;
					case 1:
						score = score*2;
						break;
					case 2:
						score = score*3;
						break;
					case 3:
						break;
					case 4:
						break;
				}	
			}	
			
			//double/triple letter score
			for(int i=0;i<last-first+1;i++)
			{
				switch(IncreaseScore[line][first+i])
				{
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						score = score + Tiles[line][first+i].getScore();
						break;
					case 4:
						score = score + Tiles[line][first+i].getScore()*2;
						break;
				}	
			}	
		}
		return score;
	}
	
	
	public void judgment(boolean pass)
	{
		if(pass)
		{
			for(int i=0;i<7;i++)
			{
				if(coordinate[i][0]==1000)
				{
					board.remove(letter[i]);
					board.remove(letter2[i]);
				}
			}
			times++;
			assignLettersToUser();
			showTiles();
		}
		else 
		{
			int score = checkIfAWord();
			if(score!=0)
			{
				u[times%2].setScore(score);
				for(int i=0;i<7;i++)
				{
					if(coordinate[i][0]==1000)
					{
						board.remove(letter[i]);
						board.remove(letter2[i]);
					}
				}
				user1Score.setText(Integer.toString(u[0].getScore()));
				user2Score.setText(Integer.toString(u[1].getScore()));
				times++;
				assignLettersToUser();
				showTiles();
			}
			else
			{
				for(int i=0;i<7;i++)
				{
					if(coordinate[i][0]!=1000)
					{
						Tiles[coordinate[i][0]][coordinate[i][1]]=null;
						
						double frameWidth = (int) frame.getSize().getWidth();
						double frameHeight = (int)frame.getSize().getHeight();
		
//							ImageIcon image = new ImageIcon(tileSrc); 
//							letter[i].setLayout(new BorderLayout());
//							image.setImage(image.getImage().getScaledInstance((int)(frameWidth*50/890),(int)(frameHeight*50/820), Image.SCALE_SMOOTH)); 
//							letter[i].setIcon(image);
//							letter[i].add("Center",letter2[i]);
//							letter2[i].setHorizontalAlignment(JTextField.CENTER);
//							letter2[i].setFont(f1);
//							letter2[i].setOpaque(false);
							letter[i].setBounds( (int)(frameWidth*200/890+i*frameWidth*50/890), (int)(frameHeight*750/820), (int)(frameWidth*50/890), (int)(frameHeight*50/820));
					}
				}
			}
			
		}

		for(int i=0;i<7;i++)
		{
			coordinate[i][0]=1000;
			coordinate[i][1]=1000;
		}
	}
	
	
//	public static void main(String[] args) throws FileNotFoundException 
//	{
//		 try
//		    {
//		        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
//		        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//		    }
//		    catch(Exception e)
//		    {
//		        //TODO exception
//		    }
//		GUI_graduated GUI_Normal1 = new GUI_graduated();
//	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		for(int i=0;i<7;i++)
		{
			if(e.getSource()==letter[i])
			{
				double frameWidth =  frame.getSize().getWidth();
				double frameHeight = frame.getSize().getHeight();
	            int X=(int)(e.getX()+letter[i].getX()-frameWidth*25/890);
	            int Y=(int)(e.getY()+letter[i].getY()-frameHeight*25/890);
	            letter[i].setBounds(X,Y,(int)(frameWidth*50/890), (int)(frameHeight*50/820));
			}
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if(e.getSource()==pass)
		{
			judgment(true);
		}
		if(e.getSource()==confirm)
		{
			judgment(false);
		}
//		
//		for(int i=0;i<11;i++)
//		{
//			for(int j=0;j<11;j++)
//			{
//				if(e.getSource()==label[i][j])
//				{
//					judgment(i,j);
//				}
//			}
//		}
		
		if(e.getSource()==back)
		{
			frame.dispose();
			new mainFrame();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased (MouseEvent z)
    {
		for(int i=0;i<7;i++)
		{
			if(z.getSource()==letter[i])
			{
				double frameWidth = frame.getSize().getWidth();
				double frameHeight = frame.getSize().getHeight();
				double X=letter[i].getX()+frameWidth*25/890;
				double Y=letter[i].getY()+frameHeight*25/820;
				
				System.out.println(X+"  "+Y);
				if(X<-0||X>frameWidth||Y<-0||Y>frameHeight*749/820)
				{
					letter[i].setBounds( (int)(frameWidth*200/890+i*frameWidth*50/890), (int)(frameHeight*750/820), (int)(frameWidth*50/890), (int)(frameHeight*50/820));
					int a[]={1000,1000};
					coordinate[i]=a;
				}
				else
				{
					letter[i].setBounds(Integer.parseInt(new java.text.DecimalFormat("0").format(letter[i].getX()-((X%(frameWidth*50/890))-frameWidth*25/890))),
							Integer.parseInt(new java.text.DecimalFormat("0").format(letter[i].getY()-((Y%(frameHeight*50/820))-frameHeight*25/820))), 
							Integer.parseInt(new java.text.DecimalFormat("0").format(frameWidth*50/890)), 
							Integer.parseInt(new java.text.DecimalFormat("0").format(frameHeight*50/820)));
					int a[]={(int)(X/(frameWidth*50/890)),(int)(Y/(frameHeight*50/820))};
					coordinate[i]=a;
				}
			}
		}
    }

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}

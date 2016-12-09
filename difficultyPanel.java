import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class difficultyPanel extends JPanel
{
	
	static JButton easy;
	static JButton medium;
	static JButton hard;
	static JButton nightmare;
	static JButton attack;
	public monsterPanel currentMonster = new monsterPanel();
	public monsterPanel newMonster = new monsterPanel();
	public Monster monsterCreate;
	
	public difficultyPanel()
	{
		GridBagLayout gridBagDifficulty = new GridBagLayout();
		gridBagDifficulty.columnWidths = new int[]{50, 0};
		gridBagDifficulty.rowHeights = new int[]{50, 40, 40, 40, 0};
		gridBagDifficulty.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagDifficulty.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagDifficulty);
		
		easy = new JButton("Easy");
		GridBagConstraints gbc_easy = new GridBagConstraints();
		gbc_easy.fill = GridBagConstraints.BOTH;
		gbc_easy.insets = new Insets(10, 0, 0, 0);
		gbc_easy.gridx = 0;
		gbc_easy.gridy = 0;
		
		medium = new JButton("Medium");
		GridBagConstraints gbc_medium = new GridBagConstraints();
		gbc_medium.fill = GridBagConstraints.BOTH;
		gbc_medium.insets = new Insets(0, 0, 0, 0);
		gbc_medium.gridx = 0;
		gbc_medium.gridy = 1;
		
		hard = new JButton("Hard");
		GridBagConstraints gbc_hard = new GridBagConstraints();
		gbc_hard.fill = GridBagConstraints.BOTH;
		gbc_hard.insets = new Insets(0, 0, 0, 0);
		gbc_hard.gridx = 0;
		gbc_hard.gridy = 2;
		
		nightmare = new JButton("Nightmare");
		GridBagConstraints gbc_nightmare = new GridBagConstraints();
		gbc_nightmare.fill = GridBagConstraints.BOTH;
		gbc_nightmare.insets = new Insets(0, 0, 0, 0);
		gbc_nightmare.gridx = 0;
		gbc_nightmare.gridy = 3;

		easy.addActionListener(new MyDifficultyListener());
		medium.addActionListener(new MyDifficultyListener());
		hard.addActionListener(new MyDifficultyListener());
		nightmare.addActionListener(new MyDifficultyListener());
		
		add(easy, gbc_easy);
		add(medium, gbc_medium);
		add(hard, gbc_hard);
		add(nightmare, gbc_nightmare);	
	}

	private class MyDifficultyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String buttonPressed = e.getActionCommand();
			
			if (buttonPressed.equals("Easy"))
			{
				Monster monsterCreate = new Monster("easy");
				currentMonster.spawnMonster(monsterCreate);
			}
			else if(buttonPressed.equals("Medium"))
			{
				Monster monsterCreate = new Monster("medium");
				currentMonster.spawnMonster(monsterCreate);
			}
			else if (buttonPressed.equals("Hard"))
			{
				Monster monsterCreate = new Monster("hard");
				currentMonster.spawnMonster(monsterCreate);
			}
			else if(buttonPressed.equals("Nightmare"))
			{
				Monster monsterCreate = new Monster("nightmare");
				currentMonster.spawnMonster(monsterCreate);
			}
		}
	}
}

//JOptionPane.showMessageDialog(null,  "You clicked the Nightmare Button");

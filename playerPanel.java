import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class playerPanel extends JPanel
{
	
	Player player1 = new Player();
	
	static JLabel playerHealth;
	static JLabel playerDefense;
	static JLabel playerDamage;
	static JLabel playerName;
	private JLabel dividerP;
	private JButton attack;
	private JButton potion;
	static int pHealth;
	static int pDamage;
	static monsterPanel theMonster = new monsterPanel();
	
	int pot = 10;
	
	public playerPanel()
	{
		GridBagLayout gridBagPlayer = new GridBagLayout();
		gridBagPlayer.columnWidths = new int[]{180, 0};
		gridBagPlayer.rowHeights = new int[]{35, 5, 20, 20, 20, 0, 0, 0};
		gridBagPlayer.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagPlayer.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagPlayer);
		
		playerName = new JLabel("Player1");
		GridBagConstraints gbc_playerName = new GridBagConstraints();
		gbc_playerName.fill = GridBagConstraints.BOTH;
		gbc_playerName.insets = new Insets(10, 10, 0, 0);
		gbc_playerName.gridx = 0;
		gbc_playerName.gridy = 0;
		
		dividerP = new JLabel("--------------------");
		GridBagConstraints gbc_dividerP = new GridBagConstraints();
		gbc_dividerP.fill = GridBagConstraints.BOTH;
		gbc_dividerP.insets = new Insets(0, 10, 0, 0);
		gbc_dividerP.gridx = 0;
		gbc_dividerP.gridy = 1;
		
		playerHealth = new JLabel("Player Health: " +player1.getMaxhealth());
		GridBagConstraints gbc_playerHealth = new GridBagConstraints();
		gbc_playerHealth.fill = GridBagConstraints.BOTH;
		gbc_playerHealth.insets = new Insets(0, 10, 0, 0);
		gbc_playerHealth.gridx = 0;
		gbc_playerHealth.gridy = 2;
		
		playerDefense = new JLabel("Player Defense: 7");
		GridBagConstraints gbc_playerDefense = new GridBagConstraints();
		gbc_playerDefense.fill = GridBagConstraints.BOTH;
		gbc_playerDefense.insets = new Insets(0, 10, 0, 0);
		gbc_playerDefense.gridx = 0;
		gbc_playerDefense.gridy = 3;
		
		playerDamage = new JLabel("Player Damage: " +player1.getMaxdamage());
		GridBagConstraints gbc_playerDamage = new GridBagConstraints();
		gbc_playerDamage.fill = GridBagConstraints.BOTH;
		gbc_playerDamage.insets = new Insets(0, 10, 0, 0);
		gbc_playerDamage.gridx = 0;
		gbc_playerDamage.gridy = 4;
		
		attack = new JButton("Attack");
		GridBagConstraints gbc_attack = new GridBagConstraints();
		gbc_attack.fill = GridBagConstraints.BOTH;
		gbc_attack.insets = new Insets(0, 0, 0, 0);
		gbc_attack.gridx = 1;
		gbc_attack.gridy = 5;
		
		potion = new JButton("Potion");
		GridBagConstraints gbc_potion = new GridBagConstraints();
		gbc_potion.fill = GridBagConstraints.BOTH;
		gbc_potion.insets = new Insets(0, 0, 0, 0);
		gbc_potion.gridx = 1;
		gbc_potion.gridy = 6;

		potion.addActionListener(new MyButtonListener());
		attack.addActionListener(new MyButtonListener());

		add(playerName, gbc_playerName);
		add(playerHealth, gbc_playerHealth);
		add(dividerP, gbc_dividerP);
		add(playerDefense, gbc_playerDefense);
		add(playerDamage, gbc_playerDamage);
		add(attack, gbc_attack);
		add(potion, gbc_potion);
	}

private class MyButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		String buttonPressed = e.getActionCommand();
		if (buttonPressed.equals("Potion"))
		{
			if (pHealth == 100)
			{
				JOptionPane.showMessageDialog(null,  "You're already at maximum health!");
			}
			player1.addCurrenthealth(pot);
			playerHealth.setText("Current Health: " +player1.getCurrenthealth());
			pHealth = player1.getCurrenthealth();
		}
		
		else if (buttonPressed.equals("Attack"))
		{
			pHealth = player1.getCurrenthealth();
			playerHealth.setText("Current Health: " +player1.getCurrenthealth());
			
			if (pHealth > 0)
			{
				theMonster.takeDamage(player1);
				theMonster.giveDamage(player1);
				pHealth = player1.getCurrenthealth();
				playerHealth.setText("Current Health: " +player1.getCurrenthealth());
				if(pHealth == 0)
				{
					JOptionPane.showMessageDialog(null,  "You’ve Met with a Terrible Fate, Haven’t You?");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(null,  "You’ve Met with a Terrible Fate, Haven’t You?");
			}
		}
		}
}

public void setDamage(Player equipItem)
{
	pDamage = equipItem.getMaxdamage();
	player1.addDamage(equipItem.getMaxdamage());
}
}
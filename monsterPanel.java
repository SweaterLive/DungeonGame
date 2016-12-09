import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class monsterPanel extends JPanel
{
	static JLabel monsterHealth;
	static JLabel monsterDamage;
	static JLabel monsterName;
	static int mHealth;
	static int mDamage;
	static String mName;
	static JLabel dividerM;
	static int playerDamage;
	static int monsterCurrentHealth;
	Monster currentMonster = new Monster();
	
	public monsterPanel()
	{
		GridBagLayout gridBagMonster = new GridBagLayout();
		gridBagMonster.columnWidths = new int[]{0, 0};
		gridBagMonster.rowHeights = new int[]{35, 1, 20, 20, 0, 0, 0};
		gridBagMonster.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagMonster.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagMonster);
		
		monsterName = new JLabel(currentMonster.getMonsterName());
		GridBagConstraints gbc_monsterName = new GridBagConstraints();
		gbc_monsterName.fill = GridBagConstraints.BOTH;
		gbc_monsterName.insets = new Insets(10, 15, 0, 10);
		gbc_monsterName.gridx = 0;
		gbc_monsterName.gridy = 0;
		
		dividerM = new JLabel("--------------------");
		GridBagConstraints gbc_dividerM = new GridBagConstraints();
		gbc_dividerM.fill = GridBagConstraints.BOTH;
		gbc_dividerM.insets = new Insets(0, 15, 0, 10);
		gbc_dividerM.gridx = 0;
		gbc_dividerM.gridy = 1;
		
		monsterHealth = new JLabel("Monster Health: " +currentMonster.getMonsterhealth());
		GridBagConstraints gbc_monsterHealth = new GridBagConstraints();
		gbc_monsterHealth.fill = GridBagConstraints.BOTH;
		gbc_monsterHealth.insets = new Insets(0, 15, 0, 10);
		gbc_monsterHealth.gridx = 0;
		gbc_monsterHealth.gridy = 2;
		
		monsterDamage = new JLabel("Monster Damage: " +currentMonster.getMonsterdamage());
		GridBagConstraints gbc_monsterDamage = new GridBagConstraints();
		gbc_monsterDamage.fill = GridBagConstraints.BOTH;
		gbc_monsterDamage.gridx = 0;
		gbc_monsterDamage.gridy = 3;
		gbc_monsterDamage.insets = new Insets(0, 15, 0, 10);
		
		add(monsterName, gbc_monsterName);
		add(dividerM, gbc_dividerM);
		add(monsterHealth, gbc_monsterHealth);
		add(monsterDamage, gbc_monsterDamage);
	}
	
	public void spawnMonster(Monster newMonsterName)
	{
		mHealth = newMonsterName.getCurrentmhealth();
		mDamage = newMonsterName.getMonsterdamage();
		currentMonster.setMonstername(newMonsterName.getMonsterName());
		currentMonster.setMonsterhealth(mHealth);
		currentMonster.setMonsterdamage(mDamage);
		monsterName.setText(currentMonster.getMonsterName());
		monsterHealth.setText("Monster Health: " +currentMonster.getMonsterhealth());
		monsterDamage.setText("Monster Damage: " +currentMonster.getMonsterdamage());
	}
	
	public void takeDamage(Player playerName)
	{
		mName = currentMonster.getMonsterName();
		playerDamage = playerName.getMaxdamage();
		
		if(mName == "Select a Difficulty")
		{
			JOptionPane.showMessageDialog(null,  "You haven't selected a difficulty!");
		}
		
		else
		{
			currentMonster.monsterTakedamage(playerDamage);
			mHealth = currentMonster.getCurrentmhealth();
			if(mHealth <= 0)
			{
				currentMonster.setCmonsterhealth(0);
				monsterHealth.setText("Monster Health: " +currentMonster.getCurrentmhealth());
			}
			monsterHealth.setText("Monster Health: " +currentMonster.getCurrentmhealth());
		}
	}
	
	public Player giveDamage(Player playerName)
	{
		mHealth = currentMonster.getCurrentmhealth();
		if (mHealth == 0)
		{
			JOptionPane.showMessageDialog(null,  "The monster has been slain.");
		}
		else
		{
		mDamage = currentMonster.getMonsterdamage();
		playerName.takeDamage(mDamage);
		}
		return playerName;
	}
}

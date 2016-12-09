import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inventoryPanel extends JPanel
{
	private JLabel mainWeapon;
	static JComboBox mWeapon;
	private JLabel offWeapon;
	static JComboBox oWeapon;
	private JLabel Potion;
	static JComboBox currentPotion;
	private JLabel dividerI;
	static monsterPanel dropMonster = new monsterPanel();
	static playerPanel currentPlayer = new playerPanel();
	static Player newPlayer = new Player();
	static String[] weapons = {"", "Sword +3", "Sword +5", "Sword +10", "Sword +25" };
	static String[] potions = {"", "Minor Health Potion", "Major Health Potion"};
	
	static int currentWeaponDamage;
	
	public inventoryPanel()
	{
		GridBagLayout gridBagInventory = new GridBagLayout();
		gridBagInventory.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagInventory.rowHeights = new int[]{0, 0};
		gridBagInventory.columnWeights = new double[]{0.0, 0.0};
		gridBagInventory.rowWeights = new double[]{0.0, 0.0};
		setLayout(gridBagInventory);
		
		dividerI = new JLabel("-----------------------------------------------------------------"
				+ "--------------------------------------------------------------------------------");
		GridBagConstraints gbc_dividerI = new GridBagConstraints();
		gbc_dividerI.fill = GridBagConstraints.BOTH;
		gbc_dividerI.insets = new Insets(0, 0, 25, 0);
	    gbc_dividerI.gridwidth = 6;
		gbc_dividerI.gridx = 0;
		gbc_dividerI.gridy = 0;
		
		mainWeapon = new JLabel("Main Hand:");
		GridBagConstraints gbc_mainWeapon = new GridBagConstraints();
		gbc_mainWeapon.fill = GridBagConstraints.BOTH;
		gbc_mainWeapon.insets = new Insets(0, 10, 18, 3);
		gbc_mainWeapon.gridx = 0;
		gbc_mainWeapon.gridy = 1;
		
		mWeapon = new JComboBox(weapons);
		mWeapon.setSelectedIndex(0);
		GridBagConstraints gbc_mWeapon = new GridBagConstraints();
		gbc_mWeapon.fill = GridBagConstraints.BOTH;
		gbc_mWeapon.insets = new Insets(0, 5, 18,15);
		gbc_mWeapon.gridx = 1;
		gbc_mWeapon.gridy = 1;
		
		offWeapon = new JLabel("Off Hand");
		GridBagConstraints gbc_offWeapon = new GridBagConstraints();
		gbc_offWeapon.fill = GridBagConstraints.BOTH;
		gbc_offWeapon.insets = new Insets(0, 15, 18, 3);
		gbc_offWeapon.gridx = 2;
		gbc_offWeapon.gridy = 1;
		
		oWeapon = new JComboBox(weapons);
		oWeapon.setSelectedIndex(0);
		GridBagConstraints gbc_oWeapon = new GridBagConstraints();
		gbc_oWeapon.fill = GridBagConstraints.BOTH;
		gbc_oWeapon.insets = new Insets(0, 5, 18, 15);
		gbc_oWeapon.gridx = 3;
		gbc_oWeapon.gridy = 1;
		
		Potion = new JLabel("Potion");
		GridBagConstraints gbc_Potion = new GridBagConstraints();
		gbc_Potion.fill = GridBagConstraints.BOTH;
		gbc_Potion.insets = new Insets(0, 15, 18, 3);
		gbc_Potion.gridx = 4;
		gbc_Potion.gridy = 1;
		
		currentPotion = new JComboBox(potions);
		currentPotion.setPrototypeDisplayValue("Holy Elixir");
		currentPotion.setSelectedIndex(0);
		GridBagConstraints gbc_currentPotion = new GridBagConstraints();
		gbc_currentPotion.fill = GridBagConstraints.BOTH;
		gbc_currentPotion.insets = new Insets(0, 5, 18, 10);
		gbc_currentPotion.gridx = 5;
		gbc_currentPotion.gridy = 1;
		
		mWeapon.setPrototypeDisplayValue("Apprentice's");
		oWeapon.setPrototypeDisplayValue("Apprentice's");
		currentPotion.setPrototypeDisplayValue("Major Health");
		
		add (dividerI, gbc_dividerI);
		add(mainWeapon, gbc_mainWeapon);
		add(mWeapon, gbc_mWeapon);
		add(offWeapon, gbc_offWeapon);
		add(oWeapon, gbc_oWeapon);	
		add(Potion, gbc_Potion);	
		add(currentPotion, gbc_currentPotion);	
	}
	private class weaponListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JComboBox weapon = (JComboBox)e.getSource();
			String selectedWeapon = (String)weapon.getSelectedItem();
			updatePlayer(selectedWeapon);
		}		
}
	public void updatePlayer(String weapon)
	{
		if(weapon == "")
		{
			newPlayer.removeDamage(currentWeaponDamage);
			newPlayer.addDamage(0);
			currentWeaponDamage = 0;
		}
		if(weapon == "Sword +5")
		{
			newPlayer.removeDamage(currentWeaponDamage);
			newPlayer.addDamage(5);
			currentWeaponDamage = 5;
		}
		if(weapon == "Sword +10")
		{
			newPlayer.removeDamage(currentWeaponDamage);
			newPlayer.addDamage(10);
			currentWeaponDamage = 10;
		}
		if(weapon == "Sword +25")
		{
			newPlayer.removeDamage(currentWeaponDamage);
			newPlayer.addDamage(25);
			currentWeaponDamage = 25;
		}
		
		currentPlayer.setDamage(newPlayer);
	}
}
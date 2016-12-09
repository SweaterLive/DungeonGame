import java.util.Random;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class DungeonGame extends JFrame
{
	
	private JPanel playerPanel;
	private JPanel difficultyPanel;
	private JPanel monsterPanel;
//	private JPanel inventoryPanel;
	
	   public DungeonGame()
	   {
	      // Display a title.
	      setTitle("Dungeon Game");
	      setSize(600, 300);

	      // Specify an action for the close button.
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      // Create a BorderLayout manager.

	      // Create the custom panels.
	      playerPanel = new playerPanel();
	      difficultyPanel = new difficultyPanel();
	      monsterPanel = new monsterPanel();
//	      inventoryPanel = new inventoryPanel();
	      add(playerPanel, BorderLayout.WEST);
	      add(difficultyPanel, BorderLayout.CENTER);
	      add(monsterPanel,BorderLayout.EAST);
//	      add(inventoryPanel, BorderLayout.SOUTH);
	      // Create the button panel.
	      setVisible(true);
	      // Add the components to the content pane.

	      // Pack the contents of the window and display it.
	   }
	   
	   
	   
	   public static void main(String[] args)
	   {
	      new DungeonGame();
	   }
}

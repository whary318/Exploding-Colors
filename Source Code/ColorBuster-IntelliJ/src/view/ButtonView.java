/**
 * 
 */
package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.*;

/**
 * @author Frank J. Mitropoulos
 * @author Wael M. Alghamdi
 *
 */
public class ButtonView extends JPanel {

	 
	/**
	 * Simple button view that contains a New Game button and a levelSelector combo box.
	 * Only the NewGame button listener is currently implemented.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton newGameButton;
	private JComboBox levelSelector;
	private JLabel levelLabel;
	
	public ButtonView(ActionListener gameButtonListener, ActionListener gameLevelChange) {
		
		levelLabel = new JLabel();
		levelLabel.setText("Min Matches: ");
		add(levelLabel);
		
		levelSelector = new JComboBox();
		levelSelector.addItem("3");
		levelSelector.addItem("4");
		levelSelector.addItem("5");
		levelSelector.addActionListener(gameLevelChange);
		add(levelSelector);
		
		newGameButton = new JButton();
		newGameButton.setText("New Game");
		newGameButton.addActionListener(gameButtonListener);
		add(newGameButton);
		

	}
}

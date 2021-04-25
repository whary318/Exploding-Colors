/**
 * 
 */
package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;


/**
 * @author Frank J. Mitropoulos
 * @author Wael M. Alghamdi
 * 
 *  A very simple score panel
 *  call updateScore and pass in the score to update the display
 */
public class ScoreView extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	private JLabel scoreLabel;
	
	public ScoreView() {
		scoreLabel = new JLabel("Score: 0");
		add(scoreLabel);

	}
	
	public void updateScore(int score) {
		scoreLabel.setText("Score: " + score);
	}
}

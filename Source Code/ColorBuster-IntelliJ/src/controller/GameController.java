/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.ButtonView;
import view.GameView;
import view.TileView;

/**
 * @author Frank J. Mitropoulos
 * @author Wael M. Alghamdi
 *
 */
public class GameController {
	// These aren't used, but could be depending on your gme and what you want to do
	private int score;
	private int gameStatus;
	private int rows;
	private int cols;
	
	private int moveNumber = 3;
	
	private GameView gameView;
	
	

	/**
	 * Create the GameView and pass in the appropriate listeners
	 */
	public GameController() {
		super();		
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
			
				gameView = new GameView("Exploding Colors",6,6,null,new NewGameListener(), new TileTouchedListener(), new LevelChangeListener());
				gameView.setVisible(true);	
				
			}
		});
		
	}
	
	// Listener used to process touches on TileView
	
	class TileTouchedListener implements ActionListener {
		@Override 
		public void actionPerformed(ActionEvent event) {
			TileView tv = (TileView) event.getSource();
			System.out.println("Tile touched..." + tv.toString());
			// TODO -- you implement this
			// delegate to GameView!

//			System.out.println("Not implemented yet");

            gameView.processTouchedTile(tv, moveNumber);

            // If no move is available display a message
			
			if (!gameView.isMoveAvailable()) {
				JOptionPane.showMessageDialog(gameView,
					    "No more moves...");
				gameView.newGame();
			}
		}
		
	}
	
	// Listener used to process click on New Game Button
	
	class NewGameListener implements ActionListener {
		@Override 
		public void actionPerformed(ActionEvent event) {
			System.out.println("Starting new game...");
//			System.out.println("Not yet implemented..");

			
			// TODO
			// You implement this method. Delegate to GameView!

			gameView.newGame();
		}
		
	}

	class LevelChangeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            moveNumber = Integer.valueOf(String.valueOf(e.getSource().toString().charAt(
                    e.getSource().toString().length() - 2
            )));
			System.out.println();
        }

    }
}

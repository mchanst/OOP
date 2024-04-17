package sudoku;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
// Add any other imports you need below this line

import javax.swing.SwingUtilities;



/**
 * The main Sudoku program.
 */
public class SudokuMain extends JFrame {
   private static final long serialVersionUID = 1L;  // to prevent serial warning

   // Private variables
   GameBoardPanel board = new GameBoardPanel(); // Assuming GameBoardPanel is a custom JPanel
   JButton btnNewGame = new JButton("New Game");

  

   // Constructor
   public SudokuMain() {
    

      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());

      cp.add(board, BorderLayout.CENTER); // Add the game board to the center

      // Add a button to the south to re-start the game via board.newGame()
      cp.add(btnNewGame, BorderLayout.SOUTH);
      btnNewGame.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              board.newGame(); // Call the newGame() method of the board when the button is clicked
              SoundEffect.NEW_GAME.play();
              SoundEffect.BGMUSIC.play();

            }
      });

      // Initialize the game board to start the game
      board.newGame();
      // Assuming SoundEffect is correctly defined elsewhere
      SoundEffect.NEW_GAME.play();
      SoundEffect.BGMUSIC.play();
    

      pack();     // Pack the UI components, instead of using setSize()
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Handle window closing
      setTitle("Sudoku");
      setVisible(true);   // Make the frame visible

    
      
   }

   /**
    * SwingTemplate class - a simple Swing application example.
    */
    public static class SwingTemplate extends JFrame {
        // Name-constants to define the various dimensions
        public static final int WINDOW_WIDTH = 300;
        public static final int WINDOW_HEIGHT = 150;

        // Private variables of UI components
        private JButton btnExample = new JButton("Click Me!");

        /** Constructor to setup the UI components */
        public SwingTemplate() {
            Container cp = this.getContentPane();
            cp.setLayout(new FlowLayout()); // Set the container's layout
            
            // Allocate the UI components
            btnExample.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(SwingTemplate.this,
                                                  "Button Clicked!",
                                                  "Example",
                                                  JOptionPane.INFORMATION_MESSAGE);
                }
            });

            // Content-pane adds components
            cp.add(btnExample);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit when close button clicked
            setTitle("Swing Template Example"); // "this" JFrame sets title
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // or pack() the components
            setVisible(true); // show it
        }
    }

    /** The entry main() method */
    public static void main(String[] args) {
        // Run GUI codes in the Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //new SwingTemplate(); //for testing
                new SudokuMain();    // Let the constructor do the job                   
            }
        });
    }
}

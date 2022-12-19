import javax.swing.*;
import java.awt.*;

public class MainFrame extends JPanel {

    ChessBoard board = new ChessBoard();

    public void paint (Graphics g){
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        board.paint(g2d);
    }
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("JavaChess");

        MainFrame display = new MainFrame();
        
        frame.add(display);

        frame.setSize(1020,640);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true){
            Thread.sleep(10);
        }
    }
    
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class MainFrame extends JPanel {

    ChessBoard board = new ChessBoard();

    public MainFrame(){
        addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                board.mouseClicked(event);
            }
        });
    }
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
            display.repaint();
            Thread.sleep(10);
        }
    }
    
}

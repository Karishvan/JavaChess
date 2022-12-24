import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class Queen extends Pieces{
    
    private int x;
    private int y;
    private Color team;
    private BufferedImage img;
    private BufferedImage whiteQueen;
    private BufferedImage blackQueen;
    public Queen(Color teamColor, int xVal, int yVal){
        team = teamColor;
        x = xVal;
        y = yVal;
        try {
            blackQueen = ImageIO.read(new File("blackQueen.png"));
            whiteQueen = ImageIO.read(new File ("whiteQueen.png")); 
        } catch (IOException e) {
            
        }
        if (team == Color.white){
            img = whiteQueen;
        } else {
            img = blackQueen;
        }
    }

    public BufferedImage getImg(){
        return img;
    }
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void paint(Graphics2D g){
        g.drawImage(getImg(), getX(), getY(), 75,75,null);
        
    }
}


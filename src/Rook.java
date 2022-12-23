import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class Rook{
    private int x;
    private int y;
    private Color team;
    private BufferedImage img;
    private BufferedImage whiteRook;
    private BufferedImage blackRook;
    public Rook(Color teamColor, int xVal, int yVal){
        team = teamColor;
        x = xVal;
        y = yVal;
        try {
            blackRook = ImageIO.read(new File("blackRook.png"));
            whiteRook = ImageIO.read(new File ("whiteRook.png")); 
        } catch (IOException e) {
            
        }
        if (team == Color.white){
            img = whiteRook;
        } else {
            img = blackRook;
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

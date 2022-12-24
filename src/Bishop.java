import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
public class Bishop extends Pieces{
    private int x;
    private int y;
    private Color team;
    private BufferedImage img;
    private BufferedImage whiteBishop;
    private BufferedImage blackBishop;
    public Bishop(Color teamColor, int xVal, int yVal){
        team = teamColor;
        x = xVal;
        y = yVal;
        try {
            blackBishop = ImageIO.read(new File("blackBishop.png"));
            whiteBishop = ImageIO.read(new File ("whiteBishop.png")); 
        } catch (IOException e) {
            
        }
        if (team == Color.white){
            img = whiteBishop;
        } else {
            img = blackBishop;
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

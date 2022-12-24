import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class Pawn extends Pieces{
    private int x;
    private int y;
    private Color team;
    private BufferedImage img;
    private BufferedImage whitePawn;
    private BufferedImage blackPawn;

    public Pawn(Color teamColor, int xVal, int yVal){
        team = teamColor;
        x = xVal;
        y = yVal;
        try {
            blackPawn = ImageIO.read(new File("blackPawn.png"));
            whitePawn = ImageIO.read(new File ("whitePawn.png")); 
        } catch (IOException e) {
            
        }
        if (team == Color.white){
            img = whitePawn;
        } else {
            img = blackPawn;
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
        //g.drawRect(0, 0, 5, 5);
    }

    
}

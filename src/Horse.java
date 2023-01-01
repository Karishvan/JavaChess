import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
public class Horse extends Pieces {
    private int x;
    private int y;
    private Color team;
    private BufferedImage img;
    private BufferedImage whiteHorse;
    private BufferedImage blackHorse;
    public Horse(Color teamColor, int xVal, int yVal){
        team = teamColor;
        x = xVal;
        y = yVal;
        try {
            blackHorse = ImageIO.read(new File("blackHorse.png"));
            whiteHorse = ImageIO.read(new File ("whiteHorse.png")); 
        } catch (IOException e) {
            
        }
        if (team == Color.white){
            img = whiteHorse;
        } else {
            img = blackHorse;
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

    public void setY(int newY){
        y = newY;
    }

    public void setX(int newX){
        x = newX;
    }

    public void select(ChessBoard board){
        
    }

    public Color getTeam(){
        return team;
    }

    public void paint(Graphics2D g){
        g.drawImage(getImg(), getX(), getY(), 75,75,null);
        
    }

    public void move(ChessBoard board){

    }
}

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
public class King extends Pieces {
    private int x;
    private int y;
    private Color team;
    private BufferedImage img;
    private BufferedImage whiteKing;
    private BufferedImage blackKing;
    public King(Color teamColor, int xVal, int yVal){
        team = teamColor;
        x = xVal;
        y = yVal;
        try {
            blackKing = ImageIO.read(new File("blackKing.png"));
            whiteKing = ImageIO.read(new File ("whiteKing.png")); 
        } catch (IOException e) {
            
        }
        if (team == Color.white){
            img = whiteKing;
        } else {
            img = blackKing;
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

    public Color getTeam(){
        return team;
    }

    public void select(ChessBoard board){
        
    }

    public void paint(Graphics2D g){
        g.drawImage(getImg(), getX(), getY(), 75,75,null);
        
    }

    public void move(ChessBoard board){

    }
}

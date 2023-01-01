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

    public void setY(int newY){
        y = newY;
    }

    public void setX(int newX){
        x = newX;
    }

    public void paint(Graphics2D g){
        g.drawImage(getImg(), getX(), getY(), 75,75,null);
        
    }

    public Color getTeam(){
        return team;
    }

    public void select(ChessBoard board){
        
    }

    //Experimenting
    public void move(ChessBoard board){
        if (getTeam() == Color.black){
            setY(getY() - ChessBoard.getTileSize() * 2);
        } else {
            setY(getY() + ChessBoard.getTileSize() * 2);
        }
    }
}


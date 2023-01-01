import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Pawn extends Pieces{
    private int moves;
    private int x;
    private int y;
    private Color team;
    private BufferedImage img;
    private BufferedImage whitePawn;
    private BufferedImage blackPawn;
    private static BufferedImage openSpots;
    private int [][] availableSpots = new int[1][2]; 
    private boolean showSpots;

    public Pawn(Color teamColor, int xVal, int yVal){
        team = teamColor;
        x = xVal;
        y = yVal;
        moves = 0;
        showSpots = false;
        try {
            blackPawn = ImageIO.read(new File("blackPawn.png"));
            whitePawn = ImageIO.read(new File ("whitePawn.png"));
            openSpots = ImageIO.read(new File("possibleSpots.png")); 
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

    public boolean getShowSpots(){
        return showSpots;
    }

    public void setShowSpots(boolean newShowSpots){
        showSpots = newShowSpots;
    }

    public static BufferedImage getOpenImg(){
        return openSpots;
    }
    public int getX(){
        return x;
    }

    public void setX(int newX){
        x = newX;
    }

    public int getY(){
        return y;
    }

    public void setY(int newY){
        y = newY;
    }

    public Color getTeam(){
        return team;
    }

    private int getMoves(){
        return moves;
    }

    private void addMoves(){
        moves++;
    }

    public void paint(Graphics2D g){
        g.drawImage(getImg(), getX(), getY(), 75,75,null);
        if (getShowSpots()){
            for (int i = 0; i < availableSpots.length; i++){
                g.drawImage(getOpenImg(), availableSpots[i][0], availableSpots[i][1], 75,75,null);
                //System.out.println(availableSpots[i][0]);
            }
            
        }
        //g.drawRect(0, 0, 5, 5);
    }

    public void capture(boolean left){
        
        if (left){
            setX(getX() - ChessBoard.getTileSize());
        } else {
            setX(getX() + ChessBoard.getTileSize());
        }

        if (getTeam() == Color.black){
            setY(getY() + ChessBoard.getTileSize());
        } else {
            setY(getY() - ChessBoard.getTileSize());
        }
            
    }

    public void move(ChessBoard board){
        setY(getY()+ChessBoard.getTileSize());
        addMoves();
    }

    public void select(ChessBoard board){
        //int [] thing = {5,2};
        
        for (int i = 0; i < board.allPieces.length; i++){
            for (int j = 0; j < board.allPieces[i].length; j++){
                if (getTeam() == Color.white){
                    if (getMoves() == 0){
                        int xy[] = {getX(), getY() + 2 * ChessBoard.getTileSize()};
                        if (board.checkBox(xy, board.allPieces[i][j]) == null){
                            int [][] spots = {xy};
                            availableSpots = spots;
                            System.out.println("HI");
                        }


                    }
                    
                    
                }
            }
        }
        setShowSpots(true);
        
    }
    
}

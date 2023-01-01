import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
public class ChessBoard {
    private int x;
    private int y;
    private int length;
    private boolean select;
    private Color currentTurn;
    
    public static int tileSize;

    public Pawn[] whitePawns = new Pawn[8];
    public Pawn[] blackPawns = new Pawn[8];

    public Rook[] whiteRooks = new Rook[2];
    public Rook[] blackRooks = new Rook[2];

    public Queen[] allQueens = new Queen[2];
    public King[] allKings = new King[2];

    public Bishop[] allBishops = new Bishop[4];

    public Horse[] allHorses = new Horse[4];

    public Pieces[][] allPieces = {whitePawns, blackPawns, whiteRooks, blackRooks, allQueens, allKings, allBishops, allHorses};

    public Pieces originalPiece;
    public ChessBoard(){
        x = 0;
        y = 0;
        length = 600;
        tileSize = length/8;
        select = false;
        currentTurn = Color.black;
        originalPiece = null;

        for (int i = 0; i < whitePawns.length; i++){
            whitePawns[i] = new Pawn(Color.white, i * tileSize, tileSize);
            blackPawns[i] = new Pawn(Color.black, i * tileSize, length-2*tileSize);
        }

        
        whiteRooks[0] = new Rook(Color.white, 0, 0);
        whiteRooks[1] = new Rook(Color.white, length-tileSize, 0);

        blackRooks[0] = new Rook(Color.black, 0, length-tileSize);
        blackRooks[1] = new Rook(Color.black, length-tileSize, length-tileSize);

        //Queen 0 is white, Queen 1 is black
        allQueens[0] = new Queen(Color.white, 4 * tileSize, 0);
        allQueens[1] = new Queen(Color.black, 4 * tileSize, length-tileSize);

        //King 0 is white, King 1 is black
        allKings[0] = new King(Color.white, 3 * tileSize, 0);
        allKings[1] = new King(Color.black, 3 * tileSize, length-tileSize);

        for (int i = 0; i < allBishops.length; i ++){
            int xVal;
            int yVal;
            Color team;
            if (i % 2 == 0){
                xVal = 2 * tileSize;
            } else {
                xVal = 5 * tileSize;
            }
            
            if (i > 1){
                team = Color.black;
                yVal = length-tileSize;
            } else {
                team = Color.white;
                yVal = 0;
            }
            allBishops[i] = new Bishop(team, xVal, yVal);
        }

        for (int i = 0; i < allHorses.length; i ++){
            int xVal;
            int yVal;
            Color team;
            if (i % 2 == 0){
                xVal = 1 * tileSize;
            } else {
                xVal = 6 * tileSize;
            }
            
            if (i > 1){
                team = Color.black;
                yVal = length-tileSize;
            } else {
                team = Color.white;
                yVal = 0;
            }
            allHorses[i] = new Horse(team, xVal, yVal);
        }
        


    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getLength(){
        return length;
    }
    public static int getTileSize(){
        return tileSize;
    }

    public boolean getSelect(){
        return select;
    }

    public Pieces getOriginalPiece(){
        return originalPiece;
    }

    public void setOriginalPiece(Pieces newPiece){
        originalPiece = newPiece;
    }

    public Color getTurn(){
        return currentTurn;
    }

    public void toggleTurn(){
        if (currentTurn == Color.black){
            currentTurn = Color.white;
        } else {
            currentTurn = Color.black;
        }
    }
    public void setSelect(boolean newSelect){
        select = newSelect;
    }


    public void paint(Graphics2D g){
        for (int i = 0; i < 8; i+=1){
            for (int j = 0; j < 8; j+=1){
                if (i % 2 == j % 2){
                    //g.setColor(Color.red);
                    Color maroon = new Color(153,0,0);
                    g.setColor(maroon);
                } else{
                    Color myGray = new Color(224,224,224);
                    //g.setColor(Color.gray);
                    g.setColor(myGray);
                }
                g.fillRect(i* getTileSize(), j * getTileSize(), getTileSize(), getTileSize());
            }

        }
        for (Pawn w: whitePawns){
            w.paint(g);
        }
        for (Pawn b: blackPawns){
            b.paint(g);
        }
        for (Rook w: whiteRooks){
            w.paint(g);
        }
        for (Rook b: blackRooks){
            b.paint(g);
        }
        for (Queen q: allQueens){
            q.paint(g);
        }
        for (King k: allKings){
            k.paint(g);
        }
        for (Bishop b: allBishops){
            b.paint(g);
        }
        for (Horse h: allHorses){
            h.paint(g);
        }
        
    }

    public void mouseClicked(MouseEvent e){
        
            
        checkTeam(e, allPieces);
            
        
    }


    //UPDATE THIS
    public Pieces checkBox(MouseEvent e, Pieces[][] totalPieces){
        for (int i = 0; i < totalPieces.length; i ++){
            for (int j = 0; j < totalPieces[i].length; j++){
                if (e.getX() < totalPieces[i][j].getX() + getTileSize() && e.getX() > totalPieces[i][j].getX() && e.getY() < totalPieces[i][j].getY() + getTileSize() && e.getY() > totalPieces[i][j].getY()){
                    return totalPieces[i][j];
                 }
            }
        }
        return null;
       
        
    }

    public Pieces checkBox(int[] xy, Pieces piece){
        if (xy[0] < piece.getX() + getTileSize() && xy[0] > piece.getX() && xy[1] < piece.getY() + getTileSize() && xy[1] > piece.getY()){
            return piece;
         } else {
             return null;
         }
    }
    
    private void checkTeam(MouseEvent e, Pieces[][] totalPieces){


        /*for (int i = 0; i < totalPieces.length; i ++){
            for (int j = 0; j < totalPieces[i].length; j ++){
                if (checkBox(e, totalPieces[i][j]) != null && checkBox(e, totalPieces[i][j]).getTeam() == getTurn()){
                    totalPieces[i][j].select(this);
                    setOriginalPiece(originalPiece);
                    setSelect(true);
                    break;
                } else if (getSelect() && checkBox(e, ) == null || checkBox(e, originalPiece))
            }
        }*/
        Pieces itemInBox = checkBox(e, totalPieces);
        if (itemInBox!= null && itemInBox.getTeam() == getTurn()){
            itemInBox.select(this);
            setOriginalPiece(itemInBox);
            setSelect(true);
            
            
        } else if (getSelect() == true && (itemInBox == null || itemInBox.getTeam() != getTurn())){
            getOriginalPiece().move(this);
            toggleTurn();
            setSelect(false);
        } 
    }

}

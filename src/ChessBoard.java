import java.awt.*;
public class ChessBoard {
    private int x;
    private int y;
    private int length;
    private int tileSize;
    public Pawn[] whitePawns = new Pawn[8];
    public Pawn[] blackPawns = new Pawn[8];

    public Rook[] whiteRooks = new Rook[2];
    public Rook[] blackRooks = new Rook[2];

    public Queen[] allQueens = new Queen[2];
    public King[] allKings = new King[2];

    public Bishop[] allBishops = new Bishop[4];

    public Horse[] allHorses = new Horse[4];

    public ChessBoard(){
        x = 0;
        y = 0;
        length = 600;
        tileSize = length/8;

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
    public int getTileSize(){
        return tileSize;
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
}

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
        
    }
}

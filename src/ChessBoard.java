import java.awt.*;
public class ChessBoard {
    private int x;
    private int y;
    private int length;

    public ChessBoard(){
        x = 0;
        y = 0;
        length = 600;

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
                g.fillRect(i* getLength()/8, j * getLength()/8, getLength()/8, getLength()/8);
            }

        }
    }
}

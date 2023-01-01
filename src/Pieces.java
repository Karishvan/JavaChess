import java.awt.*;
public abstract class Pieces {
    public abstract void move(ChessBoard board);
    public abstract void paint(Graphics2D g);
    public abstract int getX();
    public abstract int getY();
    public abstract void setX(int newVal);
    public abstract void setY(int newVal);
    public abstract void select(ChessBoard board);
    public abstract Color getTeam();
}

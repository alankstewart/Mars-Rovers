package alankstewart.marsrovers.model;

/**
 * Created by alanstewart on 28/11/2015.
 */
public final class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position from(int x, int y) {
        return new Position(this.x + x, this.y + y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("%s %s", x, y);
    }
}

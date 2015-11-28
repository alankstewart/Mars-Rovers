package alankstewart.marsrovers;

/**
 * Created by alanstewart on 28/11/2015.
 */
public final class Plateau {

    private final Position lowerLeft = new Position(0, 0);
    private final Position upperRight;

    public Plateau(int upperRightX, int upperRightY) {
        upperRight = new Position(upperRightX, upperRightY);
    }

    public boolean contains(Position position) {
        return position.getX() >= lowerLeft.getX() && position.getX() <= upperRight.getX()
                && position.getY() >= lowerLeft.getY() && position.getY() <= upperRight.getY();
    }
}

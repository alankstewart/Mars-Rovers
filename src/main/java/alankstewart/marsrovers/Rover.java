package alankstewart.marsrovers;

/**
 * Created by alanstewart on 28/11/2015.
 */
public final class Rover {

    private final Plateau plateau;
    private Position position;
    private Direction direction;

    public Rover(Plateau plateau, Position position, Direction direction) {
        this.plateau = plateau;
        this.position = position;
        this.direction = direction;
    }

    public void run(String commandString) {
        new RoverCommandBuilder(commandString).build().forEach(c -> c.execute(this));
    }

    public void turnLeft() {
        direction = direction.left();
    }

    public void turnRight() {
        direction = direction.right();
    }

    public void move() {
        Position newPosition;
        switch (direction) {
            case North:
                newPosition = position.from(0, 1);
                break;
            case South:
                newPosition = position.from(0, -1);
                break;
            case East:
                newPosition = position.from(1, 0);
                break;
            case West:
                newPosition = position.from(-1, 0);
                break;
            default:
                newPosition = position;
                break;
        }

        if (plateau.contains(newPosition)) {
            position = newPosition;
        }
    }

    public String getCurrentPosition() {
        return toString();
    }

    @Override
    public String toString() {
        return String.format("%s %s", position.toString(), direction.name());
    }
}

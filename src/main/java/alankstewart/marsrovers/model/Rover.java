package alankstewart.marsrovers.model;

import alankstewart.marsrovers.command.RoverCommandBuilder;

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

    public void executeCommands(String commands) {
        new RoverCommandBuilder(commands).build().forEach(c -> c.execute(this));
    }

    public void turnLeft() {
        direction = direction.left();
    }

    public void turnRight() {
        direction = direction.right();
    }

    public void move() {
        Position newPosition = position.from(direction.getX(), direction.getY());
        if (plateau.contains(newPosition)) {
            position = newPosition;
        }
    }

    public String getCurrentPosition() {
        return String.format("%s %s", position.toString(), direction.name());
    }
}

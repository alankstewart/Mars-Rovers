package alankstewart.marsrovers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by alanstewart on 28/11/2015.
 */
public class RoverTest {

    @Test
    public void shouldMoveAndTurnLeft() {
        var plateau = new Plateau(5, 5);
        var rover = new Rover(plateau, new Position(1, 2), Direction.North);
        rover.run("LMLMLMLMM");
        assertEquals("1 3 North", rover.getCurrentPosition());
    }

    @Test
    public void shouldMoveAndTurnRight() {
        var plateau = new Plateau(5, 5);
        var rover = new Rover(plateau, new Position(3, 3), Direction.East);
        rover.run("MMRMMRMRRM");
        assertEquals("5 1 East", rover.getCurrentPosition());
    }

    @Test
    public void shouldStayWithinPlateau() {
        var plateau = new Plateau(5, 5);
        var rover = new Rover(plateau, new Position(2, 3), Direction.North);
        rover.run("MMMMMMMMMMMMMRML");
        assertEquals("3 5 North", rover.getCurrentPosition());
    }
}

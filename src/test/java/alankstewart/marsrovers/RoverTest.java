package alankstewart.marsrovers;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alanstewart on 28/11/2015.
 */
public class RoverTest {

    @Test
    public void shouldMoveAndTurnLeft() {
        var plateau = new Plateau(5, 5);
        var rover = new Rover(plateau, new Position(1, 2), Direction.North);
        rover.run("LMLMLMLMM");
        assertThat(rover.getCurrentPosition(), is("1 3 North"));
    }

    @Test
    public void shouldMoveAndTurnRight() {
        var plateau = new Plateau(5, 5);
        var rover = new Rover(plateau, new Position(3, 3), Direction.East);
        rover.run("MMRMMRMRRM");
        assertThat(rover.getCurrentPosition(), is("5 1 East"));
    }

    @Test
    public void shouldStayWithinPlateau() {
        var plateau = new Plateau(5, 5);
        var rover = new Rover(plateau, new Position(2, 3), Direction.North);
        rover.run("MMMMMMMMMMMMMRML");
        assertThat(rover.getCurrentPosition(), is("3 5 North"));
    }
}

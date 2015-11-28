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
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(plateau, new Position(1, 2), Direction.N);
        rover.executeCommands("LMLMLMLMM");
        assertThat(rover.getCurrentPosition(), is("1 3 N"));
    }

    @Test
    public void shouldMoveAndTurnRight() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(plateau, new Position(3, 3), Direction.E);
        rover.executeCommands("MMRMMRMRRM");
        assertThat(rover.getCurrentPosition(), is("5 1 E"));
    }

    @Test
    public void shouldStayWithinPlateau() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(plateau, new Position(2, 3), Direction.N);
        rover.executeCommands("MMMMMMMMMMMMMRML");
        assertThat(rover.getCurrentPosition(), is("3 5 N"));
    }
}

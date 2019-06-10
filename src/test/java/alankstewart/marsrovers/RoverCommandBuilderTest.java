package alankstewart.marsrovers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by alanstewart on 28/11/2015.
 */
public class RoverCommandBuilderTest {

    @Test
    public void shouldReturnValidCommands() {
        var roverCommands = new RoverCommandBuilder("LMLMLMLMM").build();
        assertEquals(roverCommands.size(), 9);
    }

    @Test
    public void shouldHandleNullCommand() {
        assertThrows(NullPointerException.class, () -> new RoverCommandBuilder(null).build());
    }

    @Test
    public void shouldHandleEmptyCommand() {
        var roverCommands = new RoverCommandBuilder("").build();
        assertEquals(roverCommands.size(), 0);
    }

    @Test
    public void shouldHandleUnrecognizedCommands() {
        var roverCommands = new RoverCommandBuilder("LRM tgmlr").build();
        assertEquals(roverCommands.size(), 6);
    }
}

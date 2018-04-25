package alankstewart.marsrovers;

import org.junit.Test;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

/**
 * Created by alanstewart on 28/11/2015.
 */
public class RoverCommandBuilderTest {

    @Test
    public void shouldReturnValidCommands() {
        var roverCommands = new RoverCommandBuilder("LMLMLMLMM").build();
        assertThat(roverCommands, hasSize(9));
    }

    @Test(expected = NullPointerException.class)
    public void shouldHandleNullCommand() {
        new RoverCommandBuilder(null).build();
    }

    @Test
    public void shouldHandleEmptyCommand() {
        var roverCommands = new RoverCommandBuilder("").build();
        assertThat(roverCommands, hasSize(0));
    }

    @Test
    public void shouldHandleUnrecognizedCommands() {
        var roverCommands = new RoverCommandBuilder("LRM tgmlr").build();
        assertThat(roverCommands, hasSize(6));
    }
}

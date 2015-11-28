package alankstewart.marsrovers.command;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

/**
 * Created by alanstewart on 28/11/2015.
 */
public class RoverCommandBuilderTest {

    @Test
    public void shouldReturnValidCommands() {
        List<RoverCommand> roverCommands = new RoverCommandBuilder("LMLMLMLMM").build();
        assertThat(roverCommands, hasSize(9));
    }

    @Test
    public void shouldHandleNullCommand() {
        List<RoverCommand> roverCommands = new RoverCommandBuilder(null).build();
        assertThat(roverCommands, hasSize(0));
    }

    @Test
    public void shouldHandleEmptyCommand() {
        List<RoverCommand> roverCommands = new RoverCommandBuilder("").build();
        assertThat(roverCommands, hasSize(0));
    }

    @Test
    public void shouldHandleUnrecognizedCommands() {
        List<RoverCommand> roverCommands = new RoverCommandBuilder("LRM tgmlr").build();
        assertThat(roverCommands, hasSize(6));
    }
}

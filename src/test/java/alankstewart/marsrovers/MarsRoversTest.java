package alankstewart.marsrovers;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alanstewart on 28/11/2015.
 */
public class MarsRoversTest {

    @Test
    public void shouldLoadInputDataAndRun() throws Exception {
        assertThat(getOutput("commands.txt"), is("1 3 North\n5 1 East\n"));
    }

    @Test
    public void shouldLoadTestInputDataAndRun() throws Exception {
        assertThat(getOutput("test-commands.txt"), is("1 3 North\n5 1 East\n3 5 North\n4 2 North\n4 0 West\n"));
    }

    private String getOutput(String fileName) throws URISyntaxException, IOException {
        var baos = new ByteArrayOutputStream();
        try (var writer = new PrintWriter(new PrintStream(baos))) {
            var file = Paths.get(getClass().getClassLoader().getResource(fileName).toURI()).toFile();
            new MarsRovers().loadInputDataAndRun(file, writer);
        }
        return baos.toString();
    }
}

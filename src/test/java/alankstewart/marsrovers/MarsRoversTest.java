package alankstewart.marsrovers;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Paths;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alanstewart on 28/11/2015.
 */
public class MarsRoversTest {

    @Test
    public void shouldLoadInputDataAndRun() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (PrintWriter writer = new PrintWriter(new PrintStream(baos))) {
            File file = Paths.get(getClass().getClassLoader().getResource("commands.txt").toURI()).toFile();
            new MarsRovers().loadInputDataAndRun(file, writer);
        }
        assertThat(baos.toString(), is("1 3 N\n5 1 E\n"));
    }
}

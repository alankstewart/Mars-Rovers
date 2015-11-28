package alankstewart.marsrovers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

/**
 * Created by alanstewart on 28/11/2015.
 */
public class MarsRovers {

    private static final Pattern PLATEAU_REGEX = Pattern.compile("(\\d+)\\s+(\\d+)");
    private static final Pattern ROVER_POSITION_REGEX = Pattern.compile("(\\d+)\\s+(\\d+)\\s+([NSEW])");
    private static final Pattern ROVER_COMMANDS_REGEX = Pattern.compile("[LlRrMm]*");

    public static void main(String[] args) {
        String fileName = args.length == 0 ? "commands.txt" : args[0];
        try {
            File file = Paths.get(MarsRovers.class.getClassLoader().getResource(fileName).toURI()).toFile();
            new MarsRovers().loadInputDataAndRun(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadInputDataAndRun(File file) throws IOException {
        try (PrintWriter writer = new PrintWriter(System.out)) {
            loadInputDataAndRun(file, writer);
        }
    }

    public void loadInputDataAndRun(File file, PrintWriter writer) throws IOException {
        Path path = file.toPath();
        Plateau plateau = getPlateau(path);
        List<Rover> rovers = getRovers(path, plateau);
        List<String> commandsStrings = getCommandsStrings(path);
        if (rovers.size() != commandsStrings.size()) {
            throw new IllegalStateException("Each Mars Rover must have commands");
        }

        IntStream.range(0, rovers.size())
                .forEach(i -> {
                    Rover rover = rovers.get(i);
                    rover.executeCommands(commandsStrings.get(i));
                    writer.println(rover.getCurrentPosition());
                });
    }

    private Plateau getPlateau(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines
                    .limit(1)
                    .findFirst()
                    .map(PLATEAU_REGEX::matcher)
                    .filter(Matcher::matches)
                    .map(m -> new Plateau(parseInt(m.group(1)), parseInt(m.group(2))))
                    .get();
        }
    }

    private List<Rover> getRovers(Path path, Plateau plateau) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines
                    .map(ROVER_POSITION_REGEX::matcher)
                    .filter(Matcher::matches)
                    .map(m -> new Rover(plateau, new Position(parseInt(m.group(1)), parseInt(m.group(2))), Direction.valueOf(m.group(3))))
                    .collect(toList());
        }
    }

    private List<String> getCommandsStrings(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines
                    .map(ROVER_COMMANDS_REGEX::matcher)
                    .filter(Matcher::matches)
                    .map(Matcher::group)
                    .collect(toList());
        }
    }
}

package alankstewart.marsrovers;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

/**
 * Created by alanstewart on 28/11/2015.
 */
public final class RoverCommandBuilder {

    private final String commandsString;

    public RoverCommandBuilder(String commandsString) {
        Objects.requireNonNull(commandsString, "Commands string must not be null");
        this.commandsString = commandsString;
    }

    public List<RoverCommand> build() {
        return commandsString.toUpperCase().chars()
                .mapToObj(c -> getRoverCommand((char) c))
                .filter(Objects::nonNull)
                .collect(toList());
    }

    private RoverCommand getRoverCommand(char c) {
        switch (c) {
            case 'L':
                return Rover::turnLeft;
            case 'R':
                return Rover::turnRight;
            case 'M':
                return Rover::move;
            default:
                return null;
        }
    }
}

package alankstewart.marsrovers.command;

import alankstewart.marsrovers.model.Rover;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

/**
 * Created by alanstewart on 28/11/2015.
 */
public final class RoverCommandBuilder {

    private final String commandsString;

    public RoverCommandBuilder(String commandsString) {
        this.commandsString = commandsString;
    }

    public List<RoverCommand> build() {
        return commandsString == null ? Collections.emptyList() : commandsString.chars()
                .mapToObj(c -> getRoverCommand((char) c))
                .filter(Objects::nonNull)
                .collect(toList());
    }

    private RoverCommand getRoverCommand(char c) {
        switch (c) {
            case 'L':
            case 'l':
                return Rover::turnLeft;
            case 'R':
            case 'r':
                return Rover::turnRight;
            case 'M':
            case 'm':
                return Rover::move;
            default:
                return null;
        }
    }
}

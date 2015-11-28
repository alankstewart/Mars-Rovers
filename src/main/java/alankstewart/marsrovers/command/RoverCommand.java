package alankstewart.marsrovers.command;

import alankstewart.marsrovers.model.Rover;

/**
 * Created by alanstewart on 28/11/2015.
 */
@FunctionalInterface
public interface RoverCommand {

    void execute(Rover rover);
}

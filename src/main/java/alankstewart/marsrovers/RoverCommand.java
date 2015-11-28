package alankstewart.marsrovers;

/**
 * Created by alanstewart on 28/11/2015.
 */
@FunctionalInterface
public interface RoverCommand {

    void execute(Rover rover);
}

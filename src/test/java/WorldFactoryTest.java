import org.junit.Test;

import Base.TrainerFactory;
import Base.WorldFactory;
import Decorators.FireAMon;
import Decorators.GrassAMon;
import Decorators.WaterAMon;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class WorldFactoryTest {

    @Test
    public void testAddTrainer() {
        WorldFactory world = new WorldFactory();
        TrainerFactory trainer1 = new TrainerFactory("Ash");
        world.addTrainer(trainer1);
        assertEquals(world.getTrainers().get(0), trainer1);
    }
    
    @Test
    public void testStartSimulation() {

        WorldFactory world = new WorldFactory();
    
        // Create trainers and add them to the world
        TrainerFactory ash = new TrainerFactory("Ash");
        ash.addCodeAMon(new FireAMon("Charizard"));
        world.addTrainer(ash);
    
        TrainerFactory misty = new TrainerFactory("Misty");
        misty.addCodeAMon(new WaterAMon("Starmie"));
        misty.addCodeAMon(new WaterAMon("Gyarados"));
        world.addTrainer(misty);
    
        TrainerFactory brock = new TrainerFactory("Brock");
        brock.addCodeAMon(new GrassAMon("Onix"));
        world.addTrainer(brock);
    
        // Start the simulation
        world.startSimulation();

        assertEquals(ash.getName(), "Ash");
        assertEquals(misty.getName(), "Misty");
    }

}

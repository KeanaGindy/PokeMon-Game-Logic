import Base.CodeAMonFactory;
import Base.TrainerFactory;
import Base.WorldFactory;
import Decorators.FireAMon;
import Decorators.GrassAMon;
import Decorators.WaterAMon;

public class main {
    public static void main(String[] args) {
        // Create a world simulation
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
    }
    
}

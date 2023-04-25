package Base;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldFactory implements WorldFactoryInt {
    private List<TrainerFactory> trainers;

    public WorldFactory() {
        this.trainers = new ArrayList<>();
    }

    public void addTrainer(TrainerFactory trainer) {
        trainers.add(trainer);
    }

    public void startSimulation() {
        WorldMediator mediator = new WorldMediator(trainers);
        int numCycles = 0;
        System.out.println("A world simulation has started!");
        while (numCycles < 3) {
            WeatherFactory weather;
            if (numCycles == 0 || numCycles == 2) {
                Random rand = new Random();
                int randomNum = rand.nextInt((100 - 0) + 1) + 0;
    
                if (randomNum <= 100 && randomNum > 75) {
                    weather = new WeatherFactory("Sunny");
                } else if (randomNum <= 45 && randomNum > 25) {
                    weather = new WeatherFactory("Clear");
                } else {
                    weather = new WeatherFactory("Rainy");
                }
            } else {
                weather = new WeatherFactory("Night");
            }
            mediator.setWeather(weather);
            mediator.simulateCycle();
            numCycles++;
        }
        System.out.println("The world simulation is over!");
    }
    
}

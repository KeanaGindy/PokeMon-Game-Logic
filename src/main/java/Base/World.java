package Base;
import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Trainer> trainers;

    public World() {
        this.trainers = new ArrayList<>();
    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    public void startSimulation() {
        int numCycles = 10; // or any other number of cycles you want to run
        for (int i = 0; i < numCycles; i++) {
            Weather weather = generateWeather(i);
            System.out.println("Cycle " + (i+1) + " started. Weather: " + weather.getName());
            for (Trainer trainer : trainers) {
                if (trainer.hasActiveCodeAMon()) {
                    CodeAMon codeAMon = trainer.getActiveCodeAMon();
                    if (codeAMon.isFainted()) {
                        System.out.println("Trainer " + trainer.getName() + " has no active Code-a-mon, skipping turn.");
                        continue;
                    }
                    System.out.println("Trainer " + trainer.getName() + "'s turn.");
                    trainer.handleTurn(weather, trainers);
                } else {
                    System.out.println("Trainer " + trainer.getName() + " has no active Code-a-mon, skipping turn.");
                }
            }
            System.out.println("Cycle " + (i+1) + " ended.");
        }
    }

    private Weather generateWeather(int cycleNumber) {
        // This is just an example implementation. You can generate the weather however you want.
        switch(cycleNumber % 3) {
            case 0:
                return new SunnyWeather();
            case 1:
                return new ClearWeather();
            case 2:
                return new RainyWeather();
            default:
                return new ClearWeather();
        }
    }
}

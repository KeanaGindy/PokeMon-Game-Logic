package Base;

import java.util.List;
import java.util.Random;

public class WorldMediator {
    private List<TrainerFactory> trainers;
    private WeatherFactory weather;

    public WorldMediator(List<TrainerFactory> trainers) {
        this.trainers = trainers;
    }

    public void setWeather(WeatherFactory weather) {
        this.weather = weather;
    }

    public void simulateCycle() {
        System.out.println("Cycle started. Weather: " + weather.getWeather());

        for (int i = 0; i < trainers.size(); i++) {
            TrainerFactory currentTrainer = trainers.get(i);
            if(!weather.notNight()){
                System.out.println("\n |||||||||||| NIGHT CYCLE for " + currentTrainer.getName() + " |||||||||||| \n |=|=|=|=|=|=|=|=|EVOLUTION =|=|=|==|=| \n Adding a random new attack to this player's first code-a-mon in their collection!! \n Current code-a-mons remain with their health from previous battles. \n");
                
                Random rand = new Random();
                int randomNum = rand.nextInt((100 - 0) + 1) + 0;
                AttackFactory random;

                if(randomNum <= 100 && randomNum > 75){
                    random = new AttackFactory("Java", 10, "fire");
                } else if (randomNum <= 45 && randomNum> 25){ 
                    random = new AttackFactory("Python", 10, "water");
                } else {
                    random = new AttackFactory("C++", 10, "grass");
                }
                
                currentTrainer.getCodeAMons()[0].addAttack(random);

                System.out.println("\n +++++++ Added " + random.getName() + " with the damage amount of "+ random.getDamage() + " to "+ currentTrainer.getCodeAMons()[0].getName() +"\n\n");
                

            } else {
                if (!currentTrainer.hasActiveCodeAMon()) {
                    System.out.println("Trainer " + currentTrainer.getName() + " has no active Code-a-mon, skipping turn.");
                    continue;
                }
                System.out.println("Trainer " + currentTrainer.getName() + "'s turn.");
                BattleFactory battle = new BattleFactory(currentTrainer, getOpponentTrainer(i));

                battle.start(weather);
            }
        }
        System.out.println("Cycle ended.");
    }

    private TrainerFactory getOpponentTrainer(int i) {
        int currentIndex = trainers.indexOf(i);
        int opponentIndex = currentIndex == 0 ? 1 : 0;
        return trainers.get(opponentIndex);
    }
}

package Base;

import java.util.HashMap;
import java.util.Map;

public class BattleFactory implements BattleFactoryInt{
    private TrainerFactory trainer1;
    private TrainerFactory trainer2;
    private int currentTrainerIndex;
    private int currentCodeAMonIndex;

    public BattleFactory(TrainerFactory trainer1, TrainerFactory trainer2) {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        this.currentTrainerIndex = 0;
        this.currentCodeAMonIndex = 0;
    }

    // method to start the battle
    public void start(WeatherFactory weather) {
        System.out.println("A battle has started between " + trainer1.getName() + " and " + trainer2.getName() + "!");

        CodeAMonFactory currentCodeAMon = getCurrentCodeAMon();
        CodeAMonFactory opponentCodeAMon = getOpponentCodeAMon();

        Map<String, String> boostWeatherByType = new HashMap<>();
        boostWeatherByType.put("fire", "Sunny");
        boostWeatherByType.put("water", "Rainy");
        boostWeatherByType.put("grass", "Clear");

        String currentWeather = weather.getWeather();

        for (Map.Entry<String, String> entry : boostWeatherByType.entrySet()) {
            String type = entry.getKey();
            String boostWeather = entry.getValue();
            CodeAMonFactory codeAMon = currentCodeAMon;
            String trainer = "Trainer's";
            if (opponentCodeAMon.getType().equalsIgnoreCase(type) && boostWeather.equalsIgnoreCase(currentWeather)) {
                codeAMon = opponentCodeAMon;
                trainer = "Opponent's";
            }
            if (codeAMon.getType().equalsIgnoreCase(type)) {
                if (codeAMon.health == 0) {
                    System.out.println(trainer + " CodeAMon health has NOT increased because it has fainted or not the correct type.");
                } else {
                    codeAMon.setHealth(codeAMon.health + 20);
                    System.out.println(trainer + " CodeAMon health has increased by 20 due to weather.");
                }
            }
        }

        while (!isBattleOver()) {
            TrainerFactory currentTrainer = getCurrentTrainer();
            TrainerFactory opponentTrainer = getOpponentTrainer();
            currentCodeAMon = getCurrentCodeAMon();
            opponentCodeAMon = getOpponentCodeAMon();
            AttackFactory attack = currentTrainer.getCodeAMons()[currentCodeAMonIndex].chooseAttack();

            System.out.println(currentTrainer.getName() + "'s " + currentCodeAMon.getName() + " used " + attack.getName() + " on " + opponentTrainer.getName() + "'s " + opponentCodeAMon.getName() + "!");
            

            if (attack.getType().equalsIgnoreCase(opponentCodeAMon.getType())) {
                System.out.println("It's super effective!");
                opponentCodeAMon.takeDamage(attack.calculateDamage() * 2);
            } else {
                opponentCodeAMon.takeDamage(attack.calculateDamage());
            }

            if (opponentCodeAMon.getHealth() <= 0) {
                System.out.println(opponentTrainer.getName() + "'s " + opponentCodeAMon.getName() + " has fainted! ");
                opponentTrainer.addFaintedCodeAMon();
                opponentTrainer.removeCodeAMon(currentCodeAMonIndex);
                if (opponentTrainer.getFaintedCodeAMon() == opponentTrainer.getCodeAMons().length) {
                    System.out.println(opponentTrainer.getName() + " has no more CodeAMons!");
                    break;
                }
            }

            if (currentCodeAMon.getHealth() <= 0) {
                System.out.println(currentTrainer.getName() + "'s " + currentCodeAMon.getName() + " has fainted! ");
                currentTrainer.addFaintedCodeAMon();
                if (currentTrainer.getFaintedCodeAMon() == currentTrainer.getCodeAMons().length) {
                    System.out.println(currentTrainer.getName() + " has no more CodeAMons!");
                    break;
                }
            }

            switchTurns();
        }

        System.out.println("The battle is over!");
        
    }

    // method to determine if the battle is over
    public boolean isBattleOver() {
        return trainer1.getCodeAMons().length == trainer1.getFaintedCodeAMon() || trainer2.getCodeAMons().length == trainer2.getFaintedCodeAMon();
    }

    // method to get the current trainer
    private TrainerFactory getCurrentTrainer() {
        return currentTrainerIndex == 0 ? trainer1 : trainer2;
    }

    // method to get the opponent trainer
    private TrainerFactory getOpponentTrainer() {
        return currentTrainerIndex == 0 ? trainer2 : trainer1;
    }

    // method to get the current CodeAMon
    private CodeAMonFactory getCurrentCodeAMon() {
        return getCurrentTrainer().getCodeAMons()[currentCodeAMonIndex];
    }

    // method to get the opponent CodeAMon
    private CodeAMonFactory getOpponentCodeAMon() {
        return getOpponentTrainer().getCodeAMons()[0];
    }

    // method to switch turns between trainers
    private void switchTurns() {
        if (currentTrainerIndex == 0 && trainer2.getCodeAMons().length > 0) {
            currentTrainerIndex = 1;
            currentCodeAMonIndex = 0;
        } else if (currentTrainerIndex == 1 && trainer1.getCodeAMons().length > 0) {
            currentTrainerIndex = 0;
            currentCodeAMonIndex = 1;
        }
    }


}

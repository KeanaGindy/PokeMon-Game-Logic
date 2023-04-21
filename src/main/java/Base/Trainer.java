package Base;
public class Trainer {
    private String name;
    private CodeAMon[] codeAMons;
    private int money;
    private int experiencePoints;

    public Trainer(String name) {
        this.name = name;
        this.codeAMons = new CodeAMon[1];
        this.codeAMons[0] = new CodeAMon("Chirpy", "fire"); // create a default CodeAMon for the Trainer
        this.money = 0;
        this.experiencePoints = 0;
    }

    // getters and setters for private fields
    public String getName() {
        return name;
    }

    public CodeAMon[] getCodeAMons() {
        return codeAMons;
    }

    public int getMoney() {
        return money;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    // method to add a CodeAMon to the Trainer's collection
    public void addCodeAMon(CodeAMon codeAMon) {
        if (this.codeAMons.length < 6) {
            CodeAMon[] newCodeAMons = new CodeAMon[this.codeAMons.length + 1];
            for (int i = 0; i < this.codeAMons.length; i++) {
                newCodeAMons[i] = this.codeAMons[i];
            }
            newCodeAMons[newCodeAMons.length - 1] = codeAMon;
            this.codeAMons = newCodeAMons;
        } else {
            System.out.println("Cannot add CodeAMon. Trainer already has the maximum of 6.");
        }
    }

    // method to remove a CodeAMon from the Trainer's collection
    public void removeCodeAMon(int index) {
        if (index >= 0 && index < this.codeAMons.length) {
            CodeAMon[] newCodeAMons = new CodeAMon[this.codeAMons.length - 1];
            int j = 0;
            for (int i = 0; i < this.codeAMons.length; i++) {
                if (i != index) {
                    newCodeAMons[j++] = this.codeAMons[i];
                }
            }
            this.codeAMons = newCodeAMons;
        } else {
            System.out.println("Cannot remove CodeAMon. Invalid index.");
        }
    }

    // method to start a battle with another Trainer
    public void startBattle(Trainer opponent) {
        // code to start a battle with opponent Trainer
    }

    // method to start a battle with a wild CodeAMon
    public void startWildBattle(CodeAMon wildCodeAMon) {
        // code to start a battle with wild CodeAMon
    }

    public CodeAMon getNextCodeAMon() {
        return null;
    }
}

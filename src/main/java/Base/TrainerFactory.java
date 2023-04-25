package Base;

import Decorators.FireAMon;

public class TrainerFactory implements TrainerFactoryInt {
    private String name;
    private CodeAMonFactory[] codeAMons;
    private CodeAMonFactory[] healthyCodeAMons;
    private int faintedCodeAMon;

    public TrainerFactory(String name) {
        this.name = name;
        this.codeAMons = new CodeAMonFactory[1];
        this.healthyCodeAMons = new CodeAMonFactory[1];
        this.codeAMons[0] = new FireAMon("Chirpy"); // create a default CodeAMon for the Trainer
        this.faintedCodeAMon = 0;
    }

    // getters and setters for private fields
    public String getName() {
        return name;
    }

    public CodeAMonFactory[] getCodeAMons() {
        return codeAMons;
    }


    // method to add a CodeAMon to the Trainer's collection
    public void addCodeAMon(CodeAMonFactory codeAMon) {
        if (this.codeAMons.length < 6) {
            CodeAMonFactory[] newCodeAMons = new CodeAMonFactory[this.codeAMons.length + 1];
            for (int i = 0; i < this.codeAMons.length; i++) {
                newCodeAMons[i] = this.codeAMons[i];
            }
            newCodeAMons[newCodeAMons.length - 1] = codeAMon;
            this.healthyCodeAMons = newCodeAMons;
            this.codeAMons = newCodeAMons;
        } else {
            System.out.println("Cannot add CodeAMon. Trainer already has the maximum of 6.");
        }
    }


    public void addFaintedCodeAMon() {
        this.faintedCodeAMon++;
    }

    public int getFaintedCodeAMon(){
        return this.faintedCodeAMon;
    }

    // method to remove a CodeAMon from the Trainer's collection
    public void removeCodeAMon(int index) {
        if (index >= 0 && index < this.codeAMons.length) {
            CodeAMonFactory[] newCodeAMons = new CodeAMonFactory[this.codeAMons.length - 1];
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

    public boolean hasActiveCodeAMon(){
        boolean active = false;
        for(CodeAMonFactory x : this.healthyCodeAMons){
            if(x.health > 0){
                active = true;
            } 
        }
        return active;
    }

}

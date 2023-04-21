package Base;
public class Attack {
    private String name;
    private int power;
    private int accuracy;
    private String type;
    
    public Attack(String name, int power, int accuracy, String type) {
        this.name = name;
        this.power = power;
        this.accuracy = accuracy;
        this.type = type;
    }
    
    // Getters and setters
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPower() {
        return power;
    }
    
    public void setPower(int power) {
        this.power = power;
    }
    
    public int getAccuracy() {
        return accuracy;
    }
    
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    
    public int getEffectivePower(CodeAMon attacker, CodeAMon defender) {
        double effectiveness = type.getEffectiveness(defender.getType());
        return (int) Math.round(power * effectiveness);
    }
    
    public boolean attemptHit() {
        int random = (int) (Math.random() * 100);
        return random < accuracy;
    }
    
    public boolean attemptCrit() {
        int random = (int) (Math.random() * 100);
        return random < 10; // 10% chance of a critical hit
    }
}

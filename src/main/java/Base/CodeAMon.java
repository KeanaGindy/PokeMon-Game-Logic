package Base;
import java.util.List;

public class CodeAMon {
    private String name;
    private int level;
    private int health;
    private int defense;
    private String type;
    private List<Attack> attacks;

    
    public CodeAMon(String name, String type) {
        this.name = name;
        this.type = type;
        this.level = 1;
        this.defense = 10;
        this.health = 100;
        this.attacks = attacks;
    }
    
    public String getName() {
        return name;
    }
    
    public int getLevel() {
        return level;
    }
    
 
    public int getHealth() {
        return health;
    }
    

    public int getDefense() {
        return defense;
    }
    
    public String getType() {
        return type;
    }
    
    public List<Attack> getAttacks() {
        return attacks;
    }
    
    public void attack(CodeAMon target, Attack attack) {
        // calculate damage based on attack, defense, and type effectiveness
        int damage = calculateDamage(attack, target);
        
        // apply damage to target's health
        target.health -= damage;
        
        System.out.println(this.name + " used " + attack.getName() + " and dealt " + damage + " damage to " + target.getName());
        
        if (target.health <= 0) {
            System.out.println(target.getName() + " fainted!");
        }
    }
    
    private int calculateDamage(Attack attack, CodeAMon target) {
        // calculate damage based on attack, defense, and type effectiveness
        double effectiveness = attack.getType().getEffectiveness(target.getType());
        double modifier = Math.random() * (1.0 - 0.85) + 0.85; // random modifier between 0.85 and 1.0
        int damage = (int) Math.round((((2.0 * this.level / 5.0 + 2.0) * attack.getPower() * this.attack / target.getDefense()) / 50.0 + 2.0) * effectiveness * modifier);
        return Math.max(damage, 1);
    }
}

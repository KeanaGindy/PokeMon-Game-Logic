package Base;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CodeAMonFactory implements CodeAMonFactoryInt{
    protected String name;
    protected int level;
    protected int health;
    protected int defense;
    protected List<AttackFactory> attacks = new ArrayList<AttackFactory>();
    protected String type;

    public CodeAMonFactory(String name, String type) {
        this.name = name;
        this.health = 100;
        this.type = type;
        this.attacks.add(new AttackFactory("Base Attack", 10, "All types"));
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isFainted(){
        boolean isFainted;
        if(this.health <= 0){
            isFainted = true;
        } else {
            isFainted = false;
        }
        return isFainted;

    }

    public void takeDamage(int damage) {
        int netDamage = damage - this.defense;
        if (netDamage < 0) {
            netDamage = 0;
        }
        this.health -= netDamage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void setDefense(int defense){
        this.defense = defense;
    }


    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getDefense() {
        return defense;
    }

    public String getType() {
        return type;
    }

    public List<AttackFactory> getAttacks() {
        return attacks;
    }

    public void addAttack(AttackFactory attack) {
        if (this.attacks.size() < 4) {
            this.attacks.add(attack);
        }
    }

    // method to allow the current CodeAMon to choose an attack
    public AttackFactory chooseAttack() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(this.getAttacks().size());
        AttackFactory attack = this.getAttacks().get(randomIndex);
        return attack;
    }

}


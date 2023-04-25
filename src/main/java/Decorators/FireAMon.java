package Decorators;


import Base.AttackFactory;
import Base.CodeAMonFactory;

public class FireAMon extends CodeAMonFactory {
    
    public FireAMon(String name) {
        super(name, "fire");
        this.defense = 10;

        AttackFactory blaze = new AttackFactory("blaze", 20, "fire");
        this.addAttack(blaze);

        AttackFactory flameThrower = new AttackFactory("flameThrower", 30, "fire");
        this.addAttack(flameThrower);

        AttackFactory blueFlare  = new AttackFactory("blueFlare", 40, "fire");
        this.addAttack(blueFlare);


    }
}

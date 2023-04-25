package Decorators;

import java.util.List;

import Base.AttackFactory;
import Base.CodeAMonFactory;

public class WaterAMon extends CodeAMonFactory{

    
    public WaterAMon(String name) {
        super(name, "water");
        this.defense = 20;

        AttackFactory waterSpout = new AttackFactory("waterSpout", 20, "water");
        this.addAttack(waterSpout);

        AttackFactory steamEruption = new AttackFactory("steamEruption", 30, "water");
        this.addAttack(steamEruption);

        AttackFactory hydroPump  = new AttackFactory("hydroPump", 40, "water");
        this.addAttack(hydroPump);

    }

}

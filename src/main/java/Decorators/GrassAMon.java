package Decorators;

import Base.AttackFactory;
import Base.CodeAMonFactory;

public class GrassAMon extends CodeAMonFactory {

    public GrassAMon(String name) {
        super(name, "grass");
        this.defense = 15;

        AttackFactory leafStorm = new AttackFactory("leafStorm", 20, "grass");
        this.addAttack(leafStorm);

        AttackFactory glassyGlide = new AttackFactory("glassyGlide", 30, "grass");
        this.addAttack(glassyGlide);

        AttackFactory petalBlizzard  = new AttackFactory("petalBlizzard", 40, "grass");
        this.addAttack(petalBlizzard);


    }
    
}

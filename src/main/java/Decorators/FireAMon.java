package Decorators;

import java.util.List;

import Base.Attack;
import Base.CodeAMon;

public class FireAMon extends CodeAMon {

    private static List<Attack> attacks;
    
    public FireAMon(String name) {
        super(name, "fire");

    }


}

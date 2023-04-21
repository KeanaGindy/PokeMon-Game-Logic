package Decorators;

import java.util.List;

import Base.Attack;
import Base.CodeAMon;

public class WaterAMon extends CodeAMon{

    private static List<Attack> attacks;
    
    public WaterAMon(String name) {
        super(name, "water");

    }

}

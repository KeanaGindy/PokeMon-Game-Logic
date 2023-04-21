package Decorators;

import java.util.List;

import Base.Attack;
import Base.CodeAMon;

public class GrassAMon extends CodeAMon {

    private static List<Attack> attacks;
    
    public GrassAMon(String name) {
        super(name, "grass");

    }
    
}

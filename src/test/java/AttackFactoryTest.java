import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
 
import org.junit.Test;
import Base.AttackFactory;
import Base.CodeAMonFactory;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AttackFactoryTest {
    
    @Test
    public void testGetName() {
        AttackFactory attack = new AttackFactory("Quick Attack", 10, "Normal");
        assertEquals("Quick Attack", attack.getName());
    }
    
    @Test
    public void testGetDamage() {
        AttackFactory attack = new AttackFactory("Quick Attack", 10, "Normal");
        assertEquals(10, attack.getDamage());
    }
    
    @Test
    public void testGetType() {
        AttackFactory attack = new AttackFactory("Quick Attack", 10, "Normal");
        assertEquals("Normal", attack.getType());
    }

    @Test
    public void testCalculateDamage() {
        AttackFactory attack = new AttackFactory("Quick Attack", 10, "Normal");
        int damage = attack.calculateDamage();
        assertTrue(damage >= 0);

        int damage2 = attack.calculateDamage();
        assertTrue(damage2 >= 0);

        int damage3 = attack.calculateDamage();
        assertTrue(damage3 >= 0);

        int damage4 = attack.calculateDamage();
        assertTrue(damage4 >= 0);
    }
    
}

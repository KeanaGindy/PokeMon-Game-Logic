
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
 
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Base.AttackFactory;
import Base.CodeAMonFactory;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CodeAMonFactoryTest {

    private CodeAMonFactory codeAMon;
    private List<AttackFactory> attacks;

    @Test
    public void testAddAttack() {
        CodeAMonFactory codeAMon = new CodeAMonFactory("Charmander", "Fire");
        AttackFactory attack1 = new AttackFactory("Ember", 20, "Fire");
        AttackFactory attack2 = new AttackFactory("Scratch", 10, "Normal");
        codeAMon.addAttack(attack1);
        codeAMon.addAttack(attack2);
        assertTrue(codeAMon.getAttacks().contains(attack1));
        assertTrue(codeAMon.getAttacks().contains(attack2));
    }

    @Test
    public void testChooseAttack() {
        CodeAMonFactory codeAMon = new CodeAMonFactory("Charmander", "Fire");
        AttackFactory attack1 = new AttackFactory("Ember", 20, "Fire");
        AttackFactory attack2 = new AttackFactory("Scratch", 10, "Normal");
        codeAMon.addAttack(attack1);
        codeAMon.addAttack(attack2);
        AttackFactory chosenAttack = codeAMon.chooseAttack();
        assertTrue(codeAMon.getAttacks().contains(chosenAttack));
    }

    @Test
    public void testTakeDamage() {
        CodeAMonFactory codeAMon = new CodeAMonFactory("Charmander", "Fire");
        codeAMon.setDefense(5);
        codeAMon.takeDamage(10);
        assertEquals(95, codeAMon.getHealth());
        codeAMon.takeDamage(5);
        assertEquals(95, codeAMon.getHealth()); // damage should be reduced to 0 due to defense
    }

    @Test
    public void testTakeDamage0() {
        CodeAMonFactory codeAMon = new CodeAMonFactory("Charmander", "Fire");
        codeAMon.setDefense(5);
        codeAMon.takeDamage(0);
        assertEquals(100, codeAMon.getHealth());
        codeAMon.takeDamage(200);
        assertEquals(0, codeAMon.getHealth()); // damage should be reduced to 0 due to defense
    }

    @Test
    public void testGetLevel() {
        CodeAMonFactory codeAMon = new CodeAMonFactory("Charmander", "Fire");
        assertEquals(0, codeAMon.getLevel()); // level should start at 0
    }

    @Test
    public void testGetDefense() {
        CodeAMonFactory codeAMon = new CodeAMonFactory("Charmander", "Fire");
        codeAMon.setDefense(5);
        assertEquals(5, codeAMon.getDefense());
    }


    @Test
    public void testConstructor() {
        CodeAMonFactory codeAMon = new CodeAMonFactory("Charmander", "Fire");
        assertEquals("Charmander", codeAMon.getName());
        assertEquals(100, codeAMon.getHealth());
        assertEquals("Fire", codeAMon.getType());
        assertEquals(1, codeAMon.getAttacks().size());
        assertEquals("Base Attack", codeAMon.getAttacks().get(0).getName());
        assertEquals(10, codeAMon.getAttacks().get(0).getDamage());
        assertEquals("All types", codeAMon.getAttacks().get(0).getType());
    }
    
    @Test
    public void testIsFainted() {
        CodeAMonFactory codeAMon = new CodeAMonFactory("Charmander", "Fire");
        assertFalse(codeAMon.isFainted());
        codeAMon.setHealth(0);
        assertTrue(codeAMon.isFainted());
        codeAMon.setHealth(-10);
        assertTrue(codeAMon.isFainted());
    }
    
    @Test
    public void testTakeDamageNorm() {
        CodeAMonFactory codeAMon = new CodeAMonFactory("Charmander", "Fire");
        codeAMon.setDefense(5);
        codeAMon.takeDamage(10);
        assertEquals(95, codeAMon.getHealth());
        codeAMon.takeDamage(5);
        assertEquals(95, codeAMon.getHealth());
        codeAMon.takeDamage(100);
        assertEquals(0, codeAMon.getHealth());
    }
    

    @Test
    public void testAddAttackNorm() {
        CodeAMonFactory codeAMon = new CodeAMonFactory("Charmander", "Fire");
        AttackFactory attack1 = new AttackFactory("Ember", 20, "Fire");
        AttackFactory attack2 = new AttackFactory("Scratch", 10, "Normal");
        codeAMon.addAttack(attack1);
        codeAMon.addAttack(attack2);
        List<AttackFactory> attacks = codeAMon.getAttacks();
        assertEquals(3, attacks.size());
        assertEquals("Ember", attacks.get(1).getName());
        assertEquals(20, attacks.get(1).getDamage());
        assertEquals("Fire", attacks.get(1).getType());
        codeAMon.addAttack(new AttackFactory("Tackle", 10, "Normal"));
        codeAMon.addAttack(new AttackFactory("Bubble", 10, "Water"));
        assertEquals(4, codeAMon.getAttacks().size());
        codeAMon.addAttack(new AttackFactory("Flamethrower", 50, "Fire"));
        assertEquals(4, codeAMon.getAttacks().size());
    }
    
    
}

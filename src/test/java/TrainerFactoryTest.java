import org.junit.Before;
import org.junit.Test;

import Base.CodeAMonFactory;
import Base.TrainerFactory;
import Decorators.FireAMon;
import Decorators.GrassAMon;
import Decorators.WaterAMon;

import static org.junit.Assert.*;

public class TrainerFactoryTest {
    private TrainerFactory trainer;

    @Before
    public void setUp() {
        trainer = new TrainerFactory("Ash");
    }

    @Test
    public void testGetName() {
        assertEquals("Ash", trainer.getName());
    }

    @Test
    public void testAddCodeAMon() {
        trainer.addCodeAMon(new WaterAMon("Squirtle"));
        CodeAMonFactory[] codeAMons = trainer.getCodeAMons();
        assertEquals(2, codeAMons.length);
        assertTrue(codeAMons[1] instanceof WaterAMon);
        assertEquals("Squirtle", codeAMons[1].getName());
    }

    @Test
    public void testAddCodeAMon_MaximumReached() {
        trainer.addCodeAMon(new WaterAMon("Squirtle"));
        trainer.addCodeAMon(new FireAMon("Charmander"));
        trainer.addCodeAMon(new GrassAMon("Bulbasaur"));
        CodeAMonFactory[] codeAMons = trainer.getCodeAMons();
        assertEquals(4, codeAMons.length);
    }

    @Test
    public void testRemoveCodeAMon() {
        trainer.addCodeAMon(new WaterAMon("Squirtle"));
        trainer.removeCodeAMon(1); // should not remove anything
        CodeAMonFactory[] codeAMons = trainer.getCodeAMons();
        assertEquals("Chirpy", codeAMons[0].getName());
    }

    @Test
    public void testRemoveCodeAMon_InvalidIndex() {
        trainer.removeCodeAMon(1);
        CodeAMonFactory[] codeAMons = trainer.getCodeAMons();
        assertEquals(1, codeAMons.length);
        assertTrue(codeAMons[0] instanceof FireAMon);
    }

    @Test
    public void testHasActiveCodeAMon() {
        trainer.addCodeAMon(new WaterAMon("Squirtle"));
        assertTrue(trainer.hasActiveCodeAMon());
    }

}

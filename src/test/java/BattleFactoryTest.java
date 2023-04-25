import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import Base.AttackFactory;
import Base.BattleFactory;
import Base.CodeAMonFactory;
import Base.TrainerFactory;
import Base.TrainerFactoryInt;
import Base.WeatherFactory;

public class BattleFactoryTest {

    
    // test start method with same type CodeAMon
    @Test
    public void testStartWithSameTypeCodeAMon() {
        TrainerFactory trainer1 = new TrainerFactory("Ash");
        trainer1.addCodeAMon(new CodeAMonFactory("Pikachu", "Electric"));
        TrainerFactory trainer2 = new TrainerFactory("Gary");
        trainer2.addCodeAMon(new CodeAMonFactory("Raichu", "Electric"));
        BattleFactory battle = new BattleFactory(trainer1, trainer2);
        
        WeatherFactory sunny = new WeatherFactory("Sunny");
        battle.start(sunny);
    }
    

}


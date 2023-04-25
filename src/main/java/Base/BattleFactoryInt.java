package Base;
/**
 * An interface for creating battles between two trainers.
 */
public interface BattleFactoryInt {
    
    /**
     * Starts a new battle between the two trainers.
     *
     * @return the Battle object representing the battle
     */
    public void start(WeatherFactory weather);
    
    
    
}

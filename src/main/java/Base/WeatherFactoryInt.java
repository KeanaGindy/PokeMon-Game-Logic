package Base;

public interface WeatherFactoryInt {
    
    /**
     * Gets the weather condition.
     * 
     * @return The weather condition.
     */
    String getWeather();
    
    /**
     * Determines whether it is not night time.
     * 
     * @return True if it is not night time, false otherwise.
     */
    boolean notNight();
}


import org.junit.Test;

import Base.WeatherFactory;

import static org.junit.Assert.*;

public class WeatherFactoryTest {

    @Test
    public void testGetWeather() {
        WeatherFactory weather = new WeatherFactory("Sunny");
        assertEquals("Sunny", weather.getWeather());
    }

    @Test
    public void testNotNight() {
        WeatherFactory weather = new WeatherFactory("Sunny");
        assertTrue(weather.notNight());
        WeatherFactory night = new WeatherFactory("Night");
        assertFalse(night.notNight());
        WeatherFactory mixedCase = new WeatherFactory("nIgHt");
        assertFalse(mixedCase.notNight()); // method should be case-insensitive
    }

}

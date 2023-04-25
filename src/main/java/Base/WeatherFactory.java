package Base;

public class WeatherFactory implements WeatherFactoryInt{
    
    protected String weather;

    public WeatherFactory(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }

    public boolean notNight(){
        if (this.weather.equalsIgnoreCase("night")){
            return false;
        } else {
            return true;
        }
    }
}

package app.world.nature.weather.domain.model.dic;

/**
 * Created by HB .
 */
public enum WeatherType {
    小雨,中雨,大雨,阵雨,阴,多云,晴;

    public boolean isRainy(){
        if(this == WeatherType.小雨 || this == WeatherType.中雨 || this == WeatherType.大雨 || this == WeatherType.阵雨){
            return true;
        }else{
            return false;
        }
    };

    public boolean isCloudy(){
        if(this == WeatherType.多云 || this == WeatherType.阴){
            return true;
        }else{
            return false;
        }
    };

    public boolean isSunny(){
        if(this == WeatherType.晴){
            return true;
        }else{
            return false;
        }
    };
}

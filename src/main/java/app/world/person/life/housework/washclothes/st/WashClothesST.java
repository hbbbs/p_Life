package app.world.person.life.housework.washclothes.st;

import app.world.nature.weather.domain.model.Weather;
import app.world.person.life.housework.washclothes.domain.model.WashClothes;
import org.joda.time.DateTimeConstants;

/**
 * Created by HB on 2015/6/22.
 */
public class WashClothesST {
    private static final int WEIGHT_RAINY = 10;                     //雨天权重
    private static final int WEIGHT_ADD_CONTINUE_RAINY = 20;        //连续雨天增加权重

    private static final int WEIGHT_CLOUDY = 30;                    //阴天权重
    private static final int WEIGHT_ADD_CONTINUE_CLOUDY = 5;        //连续阴天增加权重

    private static final int WEIGHT_SUNNY = 50;                     //晴天权重

    private static final int WEIGHT_FRIDAY = 30;                     //星期五权重
    private static final int WEIGHT_THURSDAY = 20;                   //星期四权重


    public static void exec(WashClothes[] wcs, Weather[] weathers) {

        int[] values = new int[weathers.length];

        execByWeather(weathers,values);
        execByDate(weathers, values);

        for (int i = 0; i < wcs.length ; i++) {
            wcs[i].$add_suitValue(weathers[i].getKarma(),values[i]);
        }
    }

    /**
     * 根据星期几执行策略
     *
     * @param weathers
     * @param values
     */
    private static void execByDate(Weather[] weathers, int[] values) {
        //@todo: 将来增加节假日的判断
        for (int i = 0; i < weathers.length; i++) {
            Weather w = weathers[i];
            int dayOfWeek = w.getDate().getDayOfWeek();

            switch (dayOfWeek) {                            //周末要衣服穿，所以周四，周五有洗衣的权重加成
                case DateTimeConstants.FRIDAY:
                    values[i] = values[i] + WEIGHT_FRIDAY;
                    break;
                case DateTimeConstants.THURSDAY:
                    values[i] = values[i] + WEIGHT_THURSDAY;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 根据天气情况执行策略
     *
     * @param weathers
     * @param values
     */
    private static void execByWeather(Weather[] weathers, int[] values) {
        int index_preSunny = -1;
        int index_preCloudy = -1;

        for (int i = 0; i < weathers.length; i++) {
            Weather w = weathers[i];

            if (w.getWeather().isRainy()) {                   //雨天
                values[i] = values[i] + WEIGHT_RAINY;

                if (index_preSunny != -1) {
                    values[index_preSunny] = values[index_preSunny] + WEIGHT_ADD_CONTINUE_RAINY;
                }
                if (index_preCloudy != -1) {
                    values[index_preCloudy] = values[index_preCloudy] + WEIGHT_ADD_CONTINUE_RAINY;
                }
            } else if (w.getWeather().isCloudy()) {            //阴天

                values[i] = values[i] + WEIGHT_CLOUDY;

                if (index_preSunny != -1) {
                    values[index_preSunny] = values[index_preSunny] + WEIGHT_ADD_CONTINUE_CLOUDY;
                }

                index_preCloudy = i;

            } else if (w.getWeather().isSunny()) {            //晴天
                values[i] = values[i] + WEIGHT_SUNNY;

                index_preSunny = i;
            }
        }
    }
}

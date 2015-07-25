package app.world.society.organization.company.具体化.啦啦好.st;

import app.world.god.action.domain.Action;
import app.world.nature.weather.domain.model.Weather;
import org.joda.time.DateTimeConstants;

/**
 * Created by HB .
 * 啦啦好_玩玩具策略
 */
public class 啦啦好_玩玩具ST {
    private static final int WEIGHT_RAINY = 0;                     //雨天权重

    private static final int WEIGHT_CLOUDY = 20;                    //阴天权重

    private static final int WEIGHT_SUNNY = 20;                     //晴天权重

    private static final int WEIGHT_WEEKEND = 50;                   //周末权重
private static final int WEIGHT_WORKING = -100;                     //工作日权重

    public static void exec(Action[] wcs, Weather[] weathers) {

        int[] values = new int[weathers.length];

        execByWeather(weathers, values);
        execByDate(weathers, values);

        for (int i = 0; i < wcs.length; i++) {
            wcs[i].$add_suitValue(weathers[i].getKarma(), values[i]);
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

            switch (dayOfWeek) {                            //周末权重加成
                case DateTimeConstants.SATURDAY:
                    values[i] = values[i] + WEIGHT_WEEKEND;
                    break;
                case DateTimeConstants.SUNDAY:
                    values[i] = values[i] + WEIGHT_WEEKEND;
                    break;
                default:
                    values[i] = values[i] + WEIGHT_WORKING;
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

        for (int i = 0; i < weathers.length; i++) {
            Weather w = weathers[i];

            if (w.getWeather().isRainy()) {                   //雨天
                values[i] = values[i] + WEIGHT_RAINY;
            } else if (w.getWeather().isCloudy()) {            //阴天
                values[i] = values[i] + WEIGHT_CLOUDY;

            } else if (w.getWeather().isSunny()) {            //晴天
                values[i] = values[i] + WEIGHT_SUNNY;
            }
        }
    }
}

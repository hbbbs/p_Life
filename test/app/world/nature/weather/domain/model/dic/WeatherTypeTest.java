package app.world.nature.weather.domain.model.dic;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by HB on 2015/7/10.
 */
public class WeatherTypeTest {

    @Test
    public void testIsRain() throws Exception {
        assertThat(WeatherType.中雨.isRainy(), is(true));
        assertThat(WeatherType.阵雨.isRainy(), is(true));

        assertThat(WeatherType.阴.isRainy(), is(false));
        assertThat(WeatherType.多云.isRainy(), is(false));

        assertThat(WeatherType.晴.isRainy(), is(false));
    }

    @Test
    public void testIsCloudy() throws Exception {
        assertThat(WeatherType.中雨.isCloudy(), is(false));
        assertThat(WeatherType.阵雨.isCloudy(), is(false));

        assertThat(WeatherType.阴.isCloudy(), is(true));
        assertThat(WeatherType.多云.isCloudy(), is(true));

        assertThat(WeatherType.晴.isRainy(), is(false));
    }

    @Test
    public void testIsSunny() throws Exception {
        assertThat(WeatherType.中雨.isSunny(), is(false));
        assertThat(WeatherType.阵雨.isSunny(), is(false));

        assertThat(WeatherType.阴.isSunny(), is(false));
        assertThat(WeatherType.多云.isSunny(), is(false));

        assertThat(WeatherType.晴.isSunny(), is(true));
    }
}
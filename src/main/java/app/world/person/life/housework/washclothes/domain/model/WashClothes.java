package app.world.person.life.housework.washclothes.domain.model;

import app.world.common.base.model.karma.Karma;
import app.world.nature.weather.domain.model.Weather;
import org.joda.time.LocalDate;

/**
 * Created by HB on 2015/6/22.
 */

public class WashClothes extends WashClothesModel {

    public int $add_suitValue(Karma karma,int num) {
        this.setSuitValue(this.getSuitValue()+num);
        return this.getSuitValue();
    }

    public static void main(String[] args) {
        WashClothes wc = new WashClothes();
        Weather weather = new Weather();
        weather.setDate(new LocalDate("2015-06-01"));
        wc.$add_suitValue(weather.getKarma(),100);
        System.out.println("..");
    }

}


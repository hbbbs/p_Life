package test.DateTime;

import org.joda.time.DateTime;

/**
 * Created by HB on 2015/7/6.
 */
public class DateTimeTest {
    public static void main(String[] args) {
        DateTime dt = new DateTime("2012-05-20");
        DateTime dt1 = new DateTime("2012-05-20");

        System.out.println(dt == dt1);
        System.out.println(dt.isEqual(dt1));
        System.out.println(dt.equals(dt1));

    }

}

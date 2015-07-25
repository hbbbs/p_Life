package test.run;

import org.joda.time.LocalDate;

import java.io.IOException;

/**
 * Created by HB .
 */
public class Test {

    public static void main(String[] args) throws IOException {
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.class.getProtectionDomain());
    }

}

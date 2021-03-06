package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppDateTime {
    public static String getFull() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss.SSS z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String dateOnly() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}

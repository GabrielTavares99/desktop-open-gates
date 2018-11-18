package SistemaDesktop.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataUtil {

    public static Timestamp dataUtilToSqlDate(java.util.Date dataUtil) {
        long time = dataUtil.getTime();
        Timestamp timestamp = new java.sql.Timestamp(time);
        return timestamp;
    }

    public static java.util.Date addDays(java.util.Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);

        return cal.getTime();
    }

    public static java.util.Date subtractDays(java.util.Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, -days);

        return cal.getTime();
    }
}

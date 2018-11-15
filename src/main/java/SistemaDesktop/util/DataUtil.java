package SistemaDesktop.util;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataUtil {

    public static Date dataUtilToSqlDate(java.util.Date dataUtil) {
        long time = dataUtil.getTime();
        Date sqlDate = new Date(time);
        return sqlDate;
    }
    public static java.util.Date addDays(Date date, int days) {
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

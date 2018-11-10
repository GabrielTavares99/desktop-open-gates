package SistemaDesktop.util;

import java.sql.Date;

public class DataUtil {

    public static Date dataUtilToSqlDate(java.util.Date dataUtil) {
        long time = dataUtil.getTime();
        Date sqlDate = new Date(time);
        return sqlDate;
    }

}

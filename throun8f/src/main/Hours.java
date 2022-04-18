package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hours {
    public static String tripTime(String from, String to)
    {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        Date timeDateFrom = null;
        Date timeDateTo = null;
        try{
            timeDateFrom = format.parse(from);
            timeDateTo = format.parse(to);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        long diffrence = timeDateTo.getTime() - timeDateFrom.getTime();
        String result = String.format("[%s] h : [%s] m", Long.toString(TimeUnit.MILLISECONDS.toHours(diffrence)) , TimeUnit.MILLISECONDS.toMinutes(diffrence));

        return result;
    }
    public static String trimDate(String date)
    {
        String[] trimed = date.split(":");
        String result = trimed[0] + ":" + trimed[1];
        return result;
    }

}

package ro.cuzma.larry.persistance.xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class XMLUtil {

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public static String getStartTag(String tag, String indent) {
        String ret = "";
        if (tag == null) {
            ret = "";
        } else {
            if (indent != null && !indent.equals("")) {
                ret = "\n";
            }
            ret += indent + "<" + tag + ">";
        }
        return ret;
    }

    public static String getEndTagNewLine(String tag, String indent) {
        if (tag == null) {
            return "";
        } else {
            return "\n" + indent + "</" + tag + ">";
        }

    }

    public static String getEndTag(String tag) {
        if (tag == null) {
            return "";
        } else {
            return "</" + tag + ">";
        }

    }

    public static String convertGregorianCalendar(GregorianCalendar cal, SimpleDateFormat format) {
        if (format == null) {
            format = simpleDateFormat;
        }
        return format.format(cal.getTime());
    }

    public static GregorianCalendar convertGregorianCalendar(String value, SimpleDateFormat format) {
        if (format == null) {
            format = simpleDateFormat;
        }
        Date date;
        try {
            date = format.parse(value);
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}

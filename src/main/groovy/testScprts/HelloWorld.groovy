import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * @author taylor
 * @date 2018/12/7
 */

class HelloWorld {
    static void main(args) {
        println "Hello World"

        println dateToStamp("2011-1-1 11:1:0");
        println dateToStamp("2011-1-1");
    }

    static String output(String message) {
        println message
        return message + " : taylor"
    }

    public static Long dateToStamp(String s) throws ParseException{
        SimpleDateFormat simpleDateFormat;
        if (s.contains(":")) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            println ":"
        }
        else {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            println "no :"
        }

        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        return ts;
    }
}
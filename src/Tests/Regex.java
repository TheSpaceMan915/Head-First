package Tests;
import java.util.regex.*;

public class Regex
{
    public static final String m_str = "Nothing important happened, but I saw a lion.";

    // |
    public static void matchTest()
    {
        Pattern pattern_obj = Pattern.compile("");
        Matcher matcher_obj = pattern_obj.matcher(m_str);

        boolean res = matcher_obj.find();

        if (res)
        {
            System.out.println("Start: " + matcher_obj.start());
            System.out.println("End: " + matcher_obj.end());
        }
        else
        {
            System.out.println("Not found");
        }
    }

    public static void deletePunctuation()
    {
        String pattern_str = "(\\w+)([\\.,])";

        String cleared_str = m_str.replaceAll(pattern_str,"$1");

        System.out.println(cleared_str);
    }

    public static void main(String[] args) {

        deletePunctuation();
    }
}

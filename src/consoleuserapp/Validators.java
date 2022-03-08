package consoleuserapp;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validators{
    
    public static boolean emailValidator(String email) throws Exception{
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[a-zA-Z]{1}[a-z-A-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-z]{2,4}$";

        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static boolean phoneValidator(long mob_tel) throws Exception{
        Pattern pattern;
        Matcher matcher;
        final String PHONE_PATTERN =
                    "^(375)+\\d{2}+\\s?\\d{7}$";

        pattern = Pattern.compile(PHONE_PATTERN);
        String phone = String.valueOf(mob_tel);
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }
    
}

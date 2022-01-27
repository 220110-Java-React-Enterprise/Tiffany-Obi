package Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthClass {


    public AuthClass(){

    }

    public boolean authenticateEmail(String email){

        String regex ="^([0-9a-zA-Z.]+@[a-zA-Z]+[.][a-zA-Z]+){1,40}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()){
            return true;
        }


        return false;
    }




}

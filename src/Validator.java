import java.io.IOException;
import java.util.regex.Pattern;

public class Validator {

    private static final String ALLOWED_CHARS = "qwertyuiopasdfghjklzxcvbnm_";

    public static void check(String login, String password, String confirmPassword) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Логин не может быть больше 20 символов");
        }

        if (!checkWithRegex(login)) {
            throw new WrongLoginException("Строка содержит недопустимые символы!");
        }

        if (password.length() > 20) {
            throw new WrongPasswordException("Пароль не может быть больше 20 символов");
        }
        if (!checkWithRegex(password)) {
            throw new WrongPasswordException("Строка содержит недопустимые символы!");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не равны!");
        }
    }
    private static boolean checkWithRegex(String str){
        return str.matches("[a-zA-Z0-9_]+");
    }


    private static boolean checkAlphabet(String str){
        var lowercase = str.toLowerCase();
        for (int i = 0; i < lowercase.length(); i++) {
            var c = lowercase.charAt(i);
            for (int j = 0; j < ALLOWED_CHARS.length(); j++) {
                if (ALLOWED_CHARS.charAt(j) == c){
                    return false;
                }
            }
        }
            return true;


    }

    private static boolean checkAlphabet2(String str){
        var lowercase = str.toLowerCase();
        for (int i = 0; i < lowercase.length(); i++) {
            var c = lowercase.charAt(i);
                if (ALLOWED_CHARS.contains(String.valueOf(c))){
                    return false;
                }
            }

        return true;


    }
    private static void checkLength(String str) throws WrongLoginException {
        if (str.length() > 20){
            throw new WrongLoginException("Логин не может быть больше 20 символов");
        }
    }
}

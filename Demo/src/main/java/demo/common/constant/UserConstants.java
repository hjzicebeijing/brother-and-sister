package demo.common.constant;

public class UserConstants {
    public static final int USERNAME_MIN_LENGTH=2;
    public static final int USERNAME_MAX_LENGTH=20;
    public static final int PASSWORD_MIN_LENGTH=4;
    public static final int PASSWORD_MAX_LENGTH=20;

    public static final String PHONR_NUMBER_PATTERN="^0{0,1}(13[0-9]|15[0-9]|14[0-9]|18[0-9])[0-9]{8}$";

    public static final String EMAIL_PATTERN="^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
}

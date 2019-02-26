package demo.common.exception.user;

public class CaptchaException extends UserException{
    public CaptchaException() {
        super("验证码错误", null);
    }
}

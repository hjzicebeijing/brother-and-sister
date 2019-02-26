package demo.common.exception.user;

public class UserPasswordNotMatchException extends UserException{
    private static final long SerialVersionUID=1L;

    public UserPasswordNotMatchException() {
        super("密码错误", null);
    }
}

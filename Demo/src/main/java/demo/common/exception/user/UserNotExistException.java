package demo.common.exception.user;

public class UserNotExistException extends UserException{
    private static final Long SerialVersionUID=1L;
    public UserNotExistException() {
        super("用户不存在", null);
    }
}

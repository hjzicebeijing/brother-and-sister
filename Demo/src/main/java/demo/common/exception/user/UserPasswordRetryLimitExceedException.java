package demo.common.exception.user;

public class UserPasswordRetryLimitExceedException extends UserException{
    private static final long SerialVersionUID=1L;
    public UserPasswordRetryLimitExceedException(int retryLimit, String password) {
        super("user.password.retry.limit.count", new Object[]{retryLimit,password});
    }
}

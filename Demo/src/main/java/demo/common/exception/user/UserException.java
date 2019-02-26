package demo.common.exception.user;

import demo.common.exception.base.BaseException;

public class UserException extends BaseException {
    private static final long SerialVersionUID=1L;
    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}

package demo.framework.manager;

import demo.project.system.user.domain.User;

public class UserRegiste {
    public static User initUser(User user){
        user.setStatus("1");
        user.setHeadPortrait("/image/user/normal.jpg");
        user.setRefuseDes("none");
        user.setSalt(user.getPassword());
        return user;
    }
}

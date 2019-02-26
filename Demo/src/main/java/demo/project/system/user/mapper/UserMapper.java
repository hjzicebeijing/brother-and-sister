package demo.project.system.user.mapper;

import demo.project.system.user.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public User selectUserByLoginName(String login_name);
    public User selectUserByPhoneNumber(String phoneNumber);
    public User selectUserByEmail(String email);
    public User selectUserById(int id);
    public int checkLoginNameUnique(String loginName);
    public int checkPhoneNumberUnique(String phoneNumber);
    public int checkEmailUnique(String email);
    public int checkUserNameUnique(String userName);
    public void insertUser(User user);
}

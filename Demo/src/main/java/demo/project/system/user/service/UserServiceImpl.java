package demo.project.system.user.service;

import demo.project.system.user.domain.User;
import demo.project.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper usermapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Cacheable(value="user",key="#login_name")
    public User selectUserByLoginName(String login_name) {
        return usermapper.selectUserByLoginName(login_name);
    }

    @Override
    public User selectUserByPhoneNumber(String phoneNumber) {
        return usermapper.selectUserByPhoneNumber(phoneNumber);
    }

    @Override
    public User selectUserByEmail(String email) {
        return usermapper.selectUserByEmail(email);
    }

    @Override
    public User selectUserById(int id) {
        return usermapper.selectUserById(id);
    }

    @Override
    public int checkLoginNameUnique(String loginName) {
        return usermapper.checkLoginNameUnique(loginName);
    }

    @Override
    public int checkPhoneNumberUnique(String phoneNumber) {
        return usermapper.checkPhoneNumberUnique(phoneNumber);
    }

    @Override
    public int checkEmailUnique(String email) {
        return usermapper.checkEmailUnique(email);
    }

    public int checkUserNameUnique(String userName) {return usermapper.checkUserNameUnique(userName);}

    public void insertUser(User user){usermapper.insertUser(user);}
}

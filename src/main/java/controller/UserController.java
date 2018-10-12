package controller;

import bean.User;
import dao.UserDao;

/**
 * @author : qcg
 * @datetime: 18-9-17 上午12:21
 * @description:
 **/

public class UserController {

    private static UserDao userDao = new UserDao();


    /**
     *  默认返回插入的id值，如果插入失败返回的是0
     * @param user
     * @return
     */
    public int add(User user) {
        return userDao.add(user);
    }

    public boolean del(int id) {
        return userDao.del(id);
    }

    public boolean update(User user) {
        return userDao.update(user);
    }

}

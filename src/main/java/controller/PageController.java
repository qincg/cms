package controller;

import bean.PageBean;
import bean.User;

import java.util.List;

public class PageController {
    public PageBean<User> getPage(int pageSize,int currentPage){
        UserController userController = new UserController();
        List<User> userList = userController.list();
        int userCount = userList.size();
        PageBean<User> userPageBean = new PageBean<>(pageSize,userCount,currentPage);
//        int start = userPageBean.getStart();
        List<User> list = userController.list(pageSize,currentPage - 1);
        userPageBean.setList(list);
        return userPageBean;

    }
}

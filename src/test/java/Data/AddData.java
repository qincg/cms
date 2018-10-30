package Data;

import bean.User;
import controller.UserController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class AddData {

    Logger logger = LogManager.getLogger();

    @Test
    public void add(){
        UserController userController = new UserController();
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        logger.debug("循环插入--开始时间:" + start);

        for (int i = 0; i<1000; i ++){
            User user = new User();
            user.setUserName("测试"+i);
            user.setGender("男");
            user.setGj("中国");
            userController.add(user);
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + end );
        logger.debug("循环插入--结束时间:" + end);

        System.out.println("end - start = " + String.valueOf(end - start) );
        logger.debug("循环插入--耗时:" + String.valueOf(end - start));
    }

    @Test
    public void batchAdd(){
        UserController userController = new UserController();
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        logger.debug("批量插入--开始时间:" + start);

        List<User> userList = new ArrayList<>();
        for (int i = 0; i<1000; i ++){
            User user = new User();
            user.setUserName("测试"+i);
            user.setGender("男");
            user.setGj("中国");
            userList.add(user);
        }
        userController.batchAdd(userList);
        long end = System.currentTimeMillis();
        System.out.println("end = " + end );
        logger.debug("批量插入--结束时间:" + end);

        System.out.println("end - start = " + String.valueOf(end - start) );
        logger.debug("批量插入--耗时:" + String.valueOf(end - start));
    }

    @Test
    public void add1w(){
        UserController userController = new UserController();
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        logger.debug("1w循环插入--开始时间:" + start);

        for (int i = 0; i<10000; i ++){
            User user = new User();
            user.setUserName("测试"+i);
            user.setGender("男");
            user.setGj("中国");
            userController.add(user);
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + end );
        logger.debug("1w循环插入--结束时间:" + end);

        System.out.println("end - start = " + String.valueOf(end - start) );
        logger.debug("1w循环插入--耗时:" + String.valueOf(end - start));
    }

    @Test
    public void batchAdd1w(){
        UserController userController = new UserController();
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        logger.debug("1w批量插入--开始时间:" + start);

        List<User> userList = new ArrayList<>();
        for (int i = 0; i<10000; i ++){
            User user = new User();
            user.setUserName("测试"+i);
            user.setGender("男");
            user.setGj("中国");
            userList.add(user);
        }
        userController.batchAdd(userList);
        long end = System.currentTimeMillis();
        System.out.println("end = " + end );
        logger.debug("1w批量插入--结束时间:" + end);

        System.out.println("end - start = " + String.valueOf(end - start) );
        logger.debug("1w批量插入--耗时:" + String.valueOf(end - start));
    }
}

package dao;

import bean.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author : qcg
 * @datetime: 18-9-17 上午12:22
 * @description:
 **/
public class UserDao implements BaseDao<User> {
    /**
     * 日志
     */
    static Logger logger = LogManager.getLogger();

    @Override
    public boolean add(User user) {

        String sql = "insert into user(userName,gender,gj) values(?,?,?)";
        Connection connection = JDBCUtils.getConn();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(1,user.getGender());
            preparedStatement.setString(1,user.getGj());
            return preparedStatement.execute();

        } catch (SQLException e) {
            logger.error("数据库连接失败: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean del(User user) {
        return false;
    }

    @Override
    public boolean modify(User user) {
        return false;
    }
}

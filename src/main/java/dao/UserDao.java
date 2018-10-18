package dao;

import bean.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public int add(User user) {

        String sql = "insert into user(userName,gender,gj) values(?,?,?)";
        Connection connection = JDBCUtils.getConn();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            if(connection != null) {
                preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(1, user.getGender());
                preparedStatement.setString(1, user.getGj());
                preparedStatement.execute();
                rs = preparedStatement.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            logger.error("数据库连接失败: " + e.getMessage());
        } finally {
            JDBCUtils.closeConn(connection, preparedStatement, rs);
        }
        return 0;
    }

    @Override
    public boolean del(int id) {
        String sql = "delete from user where id = ?";
        Connection connection = JDBCUtils.getConn();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                int result = preparedStatement.executeUpdate();
                if (result == 1) {
                    return true;
                }
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            JDBCUtils.closeConn(connection, preparedStatement, resultSet);
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        String sql = "update user set userName = ? , gender = ? , gj = ? where id = ?";
        Connection connection = JDBCUtils.getConn();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
                int result = preparedStatement.executeUpdate();
                if (result == 1) {
                    return true;
                }
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            JDBCUtils.closeConn(connection, preparedStatement, resultSet);
        }
        return false;
    }

    @Override
    public List<User> list() {
        String sql = "select * from user";
        List<User> userList = new ArrayList<>();
        Connection connection = JDBCUtils.getConn();
        PreparedStatement preparedStatement = null;
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    long id = resultSet.getLong("id");
                    String userName = resultSet.getString("userName");
                    String gender = resultSet.getString("gender");
                    String gj = resultSet.getString("gj");
                    User user = new User();
                    user.setUserName(userName);
                    user.setGender(gender);
                    user.setGj(gj);
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return userList;
    }
}

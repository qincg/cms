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
                preparedStatement.setString(2, user.getGender());
                preparedStatement.setString(3, user.getGj());
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
                preparedStatement.setString(1,user.getUserName());
                preparedStatement.setString(2,user.getGender());
                preparedStatement.setString(3,user.getGj());
                preparedStatement.setInt(4,user.getId());
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
        String sql = "select * from user order by id desc";
        List<User> userList = new ArrayList<>();
        Connection connection = JDBCUtils.getConn();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    long id = resultSet.getLong("id");
                    String userName = resultSet.getString("userName");
                    String gender = resultSet.getString("gender");
                    String gj = resultSet.getString("gj");
                    User user = new User();
                    user.setUserName(userName);
                    user.setGender(gender);
                    user.setGj(gj);
                    user.setId(new Long(id).intValue());
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {
            JDBCUtils.closeConn(connection,preparedStatement,resultSet);
        }
        return userList;
    }

    @Override
    public User queryById(int id) {
        String sql = "select * from user where id = ?";
        Connection connection = JDBCUtils.getConn();
        User user = new User();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String userName = resultSet.getString("userName");
                String gender = resultSet.getString("gender");
                String gj = resultSet.getString("gj");
                user.setUserName(userName);
                user.setGender(gender);
                user.setGj(gj);
                user.setId(id);
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            JDBCUtils.closeConn(connection,preparedStatement,resultSet);
        }

        return user;

    }

    @Override
    public List<User> list(int pageSize, int currentPage) {
        String sql = "select * from user limit ?,?";
        Connection connection = JDBCUtils.getConn();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,currentPage * pageSize);
            preparedStatement.setInt(2,pageSize);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String gj = resultSet.getString("gj");
                String gender = resultSet.getString("gender");
                User user = new User();
                user.setId(id);
                user.setUserName(userName);
                user.setGender(gender);
                user.setGj(gj);
                userList.add(user);
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            JDBCUtils.closeConn(connection,preparedStatement,resultSet);
        }

        return userList;
    }

    @Override
    public void batchAdd(List<User> list) {
        String sql = "insert into user(userName, gender, gj) values(?,?,?)";
        Connection connection = JDBCUtils.getConn();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (User user : list){
                preparedStatement.setString(1,user.getUserName());
                preparedStatement.setString(2,user.getGender());
                preparedStatement.setString(3,user.getGj());
                preparedStatement.addBatch();
            }
            int[] temp = preparedStatement.executeBatch();
            logger.debug(temp.length);
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            JDBCUtils.closeConn(connection,preparedStatement);
        }
    }


}

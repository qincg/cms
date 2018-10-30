package util;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : qcg
 * @datetime: 18-9-11 下午8:46
 * @description:
 **/
public class JDBCUtils {
    /**
     *  日志
     */
    private static Logger logger = LogManager.getLogger();

    /**
     * 获取数据源
     */
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("mariadb");

    /**
     * 获取数据库连接
     */
    public static Connection getConn() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("获取数据库连接失败 " + e.getMessage());
        }
        return null;
    }

    public static void closeConn(Connection connection, PreparedStatement ps, ResultSet rs) {
        if (StrUtils.isNotNull(rs)) {
            try {
                rs.close();
            } catch (SQLException e) {
                logger.error("数据库连接关闭失败 " + e.getMessage());
            }
        }
        if (StrUtils.isNotNull(ps)) {
            try {
                ps.close();
            } catch (SQLException e) {
                logger.error("数据库连接关闭失败 " + e.getMessage());
            }
        }
        if (StrUtils.isNotNull(connection)) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("数据库关闭失败 " + e.getMessage());
            }

        }
    }

    public static void closeConn(Connection connection, PreparedStatement preparedStatement) {
        if (StrUtils.isNotNull(preparedStatement)) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error("数据库连接关闭失败 " + e.getMessage());
            }
        }
        if (StrUtils.isNotNull(connection)) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("数据库关闭失败 " + e.getMessage());
            }

        }
    }
}

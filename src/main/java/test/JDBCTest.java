package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.JDBCUtils;

import java.sql.*;

/**
 * @author : qcg
 * @datetime: 18-9-16 下午8:39
 * @description:
 **/
public class JDBCTest {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            logger.info("数据库名称为： " + test01().getSchema());
            test02();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    static Connection test01() {
        return JDBCUtils.getConn();
    }

    static void test02() {
        Connection connection = test01();
        String sql = "select * from test";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ResultSetMetaData rsm = rs.getMetaData();
                int columnCount = rsm.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    logger.info("列名： " + rsm.getColumnName(i + 1) + " 列的值： " + rs.getObject(i + 1));
                }
            }
            rs.getFetchSize();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

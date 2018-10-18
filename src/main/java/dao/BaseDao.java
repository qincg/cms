package dao;

import bean.User;

import java.util.List;

/**
 * @author : qcg
 * @datetime: 18-9-17 上午12:45
 * @description:
 **/
public interface BaseDao<T> {
    /**
     *  增
     * @param t
     * @return
     */
    int add(T t);

    /**
     *  删
     * @param id
     * @return
     */
    boolean del(int id);

    /**
     * 改
     * @param t
     * @return
     */
    boolean update(T t);

    List<User> list();

}

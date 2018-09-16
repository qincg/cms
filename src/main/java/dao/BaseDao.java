package dao;

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
    boolean add(T t);

    /**
     *  删
     * @param t
     * @return
     */
    boolean del(T t);

    /**
     * 改
     * @param t
     * @return
     */
    boolean modify(T t);

}

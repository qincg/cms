package bean;

/**
 * @author : qcg
 * @datetime: 18-9-16 下午11:25
 * @description:
 **/
public class User {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 性别
     */
    private String gender;

    /**
     * 国籍
     */

    private String gj;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGj() {
        return gj;
    }

    public void setGj(String gj) {
        this.gj = gj;
    }
}

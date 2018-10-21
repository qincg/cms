package servlet;

import bean.User;
import controller.UserController;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.StrUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: qcg
 * @Description:
 * @Date: 2018/10/12 13:05
 */
@WebServlet(name = "addAndEdit",urlPatterns = {"/addAndEdit"})
public class UserAddAndEditServlet extends HttpServlet {

    private Logger logger = LogManager.getLogger();


    private UserController userController = new UserController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取页面传入的所有参数
        Map<String,String[]> parameterMap =  req.getParameterMap();
        logger.debug(StrUtils.mapToString(parameterMap));
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        }catch (Exception e){
            logger.error("map 转换 user对象异常！");
        }

        int result = userController.add(user);
        String msg = "";
        if (result == 0 ){
            msg = "操作失败!";
        }else {
            msg = "操作成功";
        }

        // 重定向到message页面
        req.setAttribute("msg",msg);
        req.getRequestDispatcher("message.jsp").forward(req,resp);
    }
}

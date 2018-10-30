package servlet;

import bean.User;
import controller.UserController;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ParamUtil;
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

        // 获取页面传入的所有参数,如果是post传入，则通过filter处理，get传入，则通过paramutil处理
        String method = req.getMethod();
        Map<String,String[]> parameterMap;
        if ("get".equals(method)){
            parameterMap = ParamUtil.getAllParams(req);
        }else {
             parameterMap =  req.getParameterMap();
        }

        logger.debug(StrUtils.mapToString(parameterMap));
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        }catch (Exception e){
            logger.error("map 转换 user对象异常！");
        }
        String op = ParamUtil.getParam(req,"op");
        int id = 0;
        boolean result = false;
        if ("add".equals(op)){
            id = userController.add(user);
        }else if ("edit".equals(op)){
            result = userController.update(user);
        }
        if (id != 0){
            result = true;
        }

        String msg = "";
        if (result ){
            msg = "操作成功!";
        }else {
            msg = "操作失败";
        }

        // 重定向到message页面
        req.setAttribute("msg",msg);
        req.getRequestDispatcher("message.jsp").forward(req,resp);
    }
}

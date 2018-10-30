package servlet;

import bean.User;
import controller.UserController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ParamUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userShow",urlPatterns = {"/userShow"})
public class UserShowServlet extends HttpServlet {
    private Logger logger = LogManager.getLogger();
    private UserController userController = new UserController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = ParamUtil.getParam(req,"id");
        String op = ParamUtil.getParam(req, "op");
        User user = userController.queryById(Integer.parseInt(userId));
        req.setAttribute("user",user);
        if ("edit".equals(op)){
            req.getRequestDispatcher("/edit.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("/show.jsp").forward(req, resp);
        }
    }
}

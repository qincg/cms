package servlet;

import bean.PageBean;
import bean.User;
import controller.PageController;
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
import java.util.List;

@WebServlet(name = "userList",urlPatterns = {"/userList"})
public class UserListServlet extends HttpServlet {

    private Logger logger = LogManager.getLogger();
    private UserController userController = new UserController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = Integer.parseInt(ParamUtil.getParam(req,"currentPage","1"));
        int pageSize = 10;
        PageController pageController = new PageController();
        PageBean<User> pageBean = pageController.getPage(pageSize, currentPage);
        req.setAttribute("pageBean",pageBean);
        //List<User> userList = userController.list();
        //req.setAttribute("userList",userList);

        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }
}

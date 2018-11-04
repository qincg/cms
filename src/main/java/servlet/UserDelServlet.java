package servlet;

import controller.UserController;
import util.ParamUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userDel")
public class UserDelServlet extends HttpServlet {
    private UserController userController = new UserController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = ParamUtil.getParam(req,"id");
        boolean result = userController.del(Integer.parseInt(id));
        String msg;
        if (result){
            msg = "操作成功!";
        }else {
            msg = "操作失败!";
        }

        req.setAttribute("msg",msg);
        req.getRequestDispatcher("/message.jsp").forward(req,resp);

    }
}

package book.chapter25;

import book.bean.Customer;
import book.dao.CustomerDAO;
import book.tool.Action;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginAction extends Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        CustomerDAO dao = new CustomerDAO();
        Customer customer = dao.search(login, password);

        if (customer != null) {
            session.setAttribute("customer", customer);
            return "login-out.jsp";
        }
        return "login-error.jsp";
    }
}

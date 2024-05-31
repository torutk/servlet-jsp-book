package book.chapter25;

import book.tool.Action;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutAction extends Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("customer") != null) {
            session.invalidate();
            return "logout-out.jsp";
        }
        return "logout-error.jsp";
    }
}

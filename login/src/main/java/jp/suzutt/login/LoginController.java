package jp.suzutt.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("user_id");
		String userPassword = request.getParameter("user_password");
		
		System.out.println(userId + userPassword);
		
		String errorMsg = "";
		
		if(userId == null || userId.length() == 0){
			errorMsg += "名前が入力されていません<br>";
		}
		if(userPassword == null || userPassword.length() == 0){
			errorMsg += "パスワードが入力されていません<br>";
		}
		String msg = "";
		if(errorMsg.length() != 0){
			msg =errorMsg;
		}else{
			if(checkLogin(userId, userPassword)){
				msg = "Login Success";
			}else{
				msg = "Login Failure";
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!Doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Login result</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>" + msg + "</p>");
		out.println("</body>");
		out.println("</html>");
	}
	
	private boolean checkLogin(String userId ,String userPassword){
		if (userId.equals("user") && userPassword.equals("1234"))
			return true;
		else
			return false;
	}

}

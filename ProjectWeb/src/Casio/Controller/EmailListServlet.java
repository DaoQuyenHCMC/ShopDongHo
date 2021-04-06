package Casio.Controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Casio.Utl.MailUtlLocal;

/**
 * Servlet implementation class EmailListServlet
 */
@WebServlet("/EmailListServlet")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// get current action
		String action =request.getParameter("action");
		if(action==null) {
			action= "join";   // default action
		}
		
		String url="/index.jsp";
		if(action.equals("join")) {
			url="/index.jsp";
		}
		else if(action.equals("add")) {
			// get parameters from the request
			String email=request.getParameter("email");
			
			//store data in UserObject
			//User user= new User(firstname,lastname,email);
			// send email to user
			String to=email;
			String from="dquyenhcmute@gmail.com";
			String subject= "Đồng hồ CASIO";
			String body="Cám ơn quý khách đã đăng ký tài khoản tại CASIO \nChúc quý khách mua hàng vui vẻ";
			boolean bodyIsHTML= false;
			try {
				MailUtlLocal.SendMail(to, from, subject, body, bodyIsHTML);
			}
			catch (MessagingException e){
				String err="Error unable to send email because:" + e.getMessage();
				System.out.print(err);
			}
		}
		response.sendRedirect("Cart/UserMuaHang.jsp");
		return;
	}

}

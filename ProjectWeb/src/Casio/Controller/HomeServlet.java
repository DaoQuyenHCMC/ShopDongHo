package Casio.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Casio.Dao.SanPhamDao;
import Casio.Models.SanPhamEntity;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SanPhamDao SanPhamDao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
		SanPhamDao=new SanPhamDao();
    }
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SP(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SP(request, response);
	}
	private void listSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List < SanPhamEntity > listOfSanPham = SanPhamDao.getAllSanPham();
		request.setAttribute("listOfSanPham", listOfSanPham);
		RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request,response);
	}
	protected void SP(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
			listSanPham(request,response);
		
	}

}
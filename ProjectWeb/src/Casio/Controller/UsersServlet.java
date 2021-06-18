package Casio.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Casio.Dao.CartDao;
import Casio.Dao.UsersDao;
import Casio.Models.UsersEntity;

/**
 * Servlet implementation class UsersServlet
 */

public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDao usersDao;
	private Pattern numberPattern = Pattern.compile("[0-9]");
	private Pattern phonePattern = Pattern.compile("^(\\d){10}$");
	Pattern emailPattern = Pattern.compile(
			"\\A(?:[a-z0-9!#$%&'*+=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?)\\Z");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		usersDao = new UsersDao();
	}

	public UsersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users(request, response);
	}

	protected void Users(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert": // user-form.jsp
				insertUser(request, response);
				break;
			case "delete":
				deleteUser(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update": // user-form.jsp
				updateUser(request, response);
				break;
			case "registration":
				DangKyUser(request, response);
				break;
			case "insert4dangky":
				insert4DangKyUser(request, response);
				break;
			case "login":
				LoginUser(request, response);
				break;
			case "checklogin":
				CheckUser(request, response);
				break;
			case "shoppingcontinue":
				list4UserShoppingContinue(request, response);
				break;
			case "quanly":
				LoginQuanLy(request, response);
				break;
			case "checkquanly":
				CheckQuanLy(request, response);
				break;
			case "dangxuat":
				DangXuat(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	private void DangXuat(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.html");
		return;
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null || user.getAllowed()!=1) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		List<UsersEntity> listUser = usersDao.getAllUser();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/Userss/user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void list4UserShoppingContinue(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		response.sendRedirect("Cart/UserMuaHang.jsp");
		return;
	}

	private void DangKyUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("KhachHang/dangky.jsp");
		dispatcher.forward(request, response);
	}

	private void LoginUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("KhachHang/dangnhap.jsp");
		dispatcher.forward(request, response);
	}

	private void LoginQuanLy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/dangnhapquanly.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null || user.getAllowed()!=1) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/Userss/user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null || user.getAllowed()!=1) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		UsersEntity existingUser = usersDao.getUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/Userss/user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String sdt = request.getParameter("sdt");
		String address = request.getParameter("address");
		int allowed = 1;
		String avata = " ";

		Map<String, String> errors = new HashMap<String, String>();

		userName = (userName == null) ? "" : userName;
		if (userName.length() == 0) {
			errors.put("userName", "Không được để trống");
		} else if (numberPattern.matcher(userName).find()) {
			errors.put("userName", "Không được có chữ số");
		}

		email = (email == null) ? "" : email;
		if (email.length() == 0) {
			errors.put("email", "Không được để trống");
		} else if (!emailPattern.matcher(email).find()) {
			errors.put("email", "Phải là địa chỉ email hợp lệ");
		} else {
			email = emailPattern.matcher(email).group();
		}

		password = (password == null) ? "" : password;
		if (password.length() == 0) {
			errors.put("password", "Không được để trống");
		}

		sdt = (sdt == null) ? "" : sdt;
		if (!phonePattern.matcher(sdt).find()) {
			errors.put("sdt", "Phải có 10 chữ số");
		}

		address = (address == null) ? "" : address;
		if (address.length() == 0) {
			errors.put("diaChi", "Không được để trống");
		} else if (numberPattern.matcher(address).find()) {
			errors.put("diaChi", "Không được có chữ số");
		}

		if (!errors.isEmpty()) {
			request.setAttribute("error", errors);
			try {
				showNewForm(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		UsersEntity newUser = new UsersEntity(userName, password, email, sdt, address, allowed, avata);
		usersDao.saveUser(newUser);
		response.sendRedirect("UsersServlet");
		return;
	}

	private void insert4DangKyUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String sdt = request.getParameter("sdt");
		String address = request.getParameter("address");
		int allowed = 2;
		String avata = " ";

		Map<String, String> errors = new HashMap<String, String>();

		userName = (userName == null) ? "" : userName;
		if (userName.length() == 0) {
			errors.put("userName", "Không được để trống");
		} else if (numberPattern.matcher(userName).find()) {
			errors.put("userName", "Không được có chữ số");
		}

		email = (email == null) ? "" : email;
		if (email.length() == 0) {
			errors.put("email", "Không được để trống");
		} else if (!emailPattern.matcher(email).find()) {
			errors.put("email", "Phải là địa chỉ email hợp lệ");
		}

		password = (password == null) ? "" : password;
		if (password.length() == 0) {
			errors.put("password", "Không được để trống");
		}

		sdt = (sdt == null) ? "" : sdt;
		if (!phonePattern.matcher(sdt).find()) {
			errors.put("sdt", "Phải có 10 chữ số");
		}

		address = (address == null) ? "" : address;
		if (address.length() == 0) {
			errors.put("diaChi", "Không được để trống");
		} else if (numberPattern.matcher(address).find()) {
			errors.put("diaChi", "Không được có chữ số");
		}

		if (!errors.isEmpty()) {
			request.setAttribute("error", errors);
			try {
				DangKyUser(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		UsersEntity newUser = new UsersEntity(userName, password, email, sdt, address, allowed, avata);
		usersDao.saveUser(newUser);
		HttpSession session = request.getSession();
		session.setAttribute("user", newUser);
		response.sendRedirect("EmailListServlet?action=add&" + "email=" + email);
		return;
		// response.sendRedirect("Cart/UserMuaHang.jsp");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null || user.getAllowed()!=1) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		int userId = Integer.parseInt(request.getParameter("userId"));
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String sdt = request.getParameter("sdt");
		String address = request.getParameter("address");
		int allowed = Integer.parseInt(request.getParameter("allowed"));

		UsersEntity userupdate = new UsersEntity(userId, userName, password, email, sdt, address, allowed);
		usersDao.updateUser(userupdate);
		response.sendRedirect("TaiKhoan");
		return;
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		if (user == null || user.getAllowed()!=1) {
			session.invalidate();
			response.sendRedirect("error/errorShoppingContinue.html");
			return;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		usersDao.deleteUser(id);
		response.sendRedirect("TaiKhoan");
	}

	private void CheckUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		HttpSession session = request.getSession();
		UsersEntity user = (UsersEntity) session.getAttribute("user");
		CartDao cart = (CartDao) session.getAttribute("cart");
		String url = "KhachHang/dangnhap.jsp";
		if (user == null) {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");

			Map<String, String> errors = new HashMap<String, String>();

			userName = (userName == null) ? "" : userName;
			if (userName.trim().length() == 0) {
				errors.put("userName", "Không được để trống");
			} else if (numberPattern.matcher(userName).find()) {
				errors.put("userName", "Không được có chữ số");
			}

			List<UsersEntity> listUser = usersDao.getAllUser();
			for (UsersEntity usersEntity : listUser) {
				if (usersEntity.getUserName().equals(userName)) {
					if (usersEntity.getPassword().equals(password)) {
						url = "Cart/UserMuaHang.jsp";

						if (cart != null) {
							cart = new CartDao();
						}
						session.setAttribute("user", usersEntity);
						session.setAttribute("cart", cart);

						response.sendRedirect(url);
						return;
					}
				}
			}
			if (url.equals("KhachHang/dangnhap.jsp")) {
				errors.put("userName", "Tên tài khoản không tồn tại");
			}

			if (!errors.isEmpty()) {
				request.setAttribute("error", errors);
				try {
					LoginUser(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			
		} else {
			if (cart != null) {
				cart = new CartDao();
			}
			session.setAttribute("cart", cart);
			url = "Cart/UserMuaHang.jsp";

		}
		response.sendRedirect(url);
		return;

	}

	private void CheckQuanLy(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String url = "Admin/dangnhapquanly.jsp";
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		Map<String, String> errors = new HashMap<String, String>();

		userName = (userName == null) ? "" : userName;
		if (userName.trim().length() == 0) {
			errors.put("userName", "Không được để trống");
		} else if (numberPattern.matcher(userName).find()) {
			errors.put("userName", "Không được có chữ số");
		}

		List<UsersEntity> listUser = usersDao.getAllUser();
		for (UsersEntity usersEntity : listUser) {
			if (usersEntity.getUserName().equals(userName)) {
				if (usersEntity.getPassword().equals(password)) {
					if (usersEntity.getAllowed() == 1) {
						url = "Admin/mainadmin.jsp";
						response.sendRedirect(url);
						return;
					}
				}
			}
		}
		if (url.equals("KhachHang/dangnhap.jsp")) {
			errors.put("userName", "Tên tài khoản không tồn tại");
		}

		if (!errors.isEmpty()) {
			request.setAttribute("error", errors);
			try {
				LoginUser(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		response.sendRedirect(url);
		return;
	}

}
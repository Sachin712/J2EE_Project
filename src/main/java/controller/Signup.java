package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SignupDao;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signup() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		try {
			SignupDao sd = new SignupDao();

			String fullname = request.getParameter("fullname");
			String username = request.getParameter("username");
			String passwrod = request.getParameter("password");
			String phone = request.getParameter("phoneNumber");
			String email = request.getParameter("email");
			String address = request.getParameter("address");

			if (!fullname.isEmpty() && !username.isEmpty() && !passwrod.isEmpty() && !phone.isEmpty()
					&& !email.isEmpty() && !address.isEmpty()) {
				out.println(fullname + "..." + username + "..." + passwrod + "..." + phone + "..." + email + "..."
						+ address + "...");

				if (sd.signup(fullname, username, passwrod, phone, email, address) == 1) {
					out.println("Data inserted!");

					String url = "/index.jsp";

					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				} else
					out.println("Data not inserted!");

			} else
				out.println("Empty field not allowed.");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

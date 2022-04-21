package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClaimDao;
import dao.ReadDeviceQuery;

/**
 * Servlet implementation class ReadDeviceAdmin
 */
@WebServlet("/ReadDeviceAdmin")
public class ReadDeviceAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadDeviceAdmin() {
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
		ReadDeviceQuery rdev;
		ClaimDao cd;

		// Execute the read and get the data in the table variable

		try {
			Set<String> paramNames = request.getParameterMap().keySet();

			// iterating over parameter names and get its value

			cd = new ClaimDao();
			for (String name : paramNames) {
				if (!name.isEmpty()) {
					int cid = Integer.parseInt(name);
					cd.approveClaim(cid);
				}
			}

			rdev = new ReadDeviceQuery();
			String table = "";

			rdev.doReadAdmin();
			table = rdev.getAdminHTMLTable();

			request.setAttribute("table", table);
			String url = "/readDevicesAdmin.jsp";

			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} catch (SQLException | ClassNotFoundException e) {
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

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClaimDao;

/**
 * Servlet implementation class Claim
 */
@WebServlet("/Claim")
public class Claim extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Claim() {
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
		PrintWriter out = response.getWriter();
		try {
			// SignupDao sd = new SignupDao();

			ClaimDao cd = new ClaimDao();
			String devId = request.getParameter("deviceId");
			String dClaim = request.getParameter("dateOfClaim");
			String description = request.getParameter("description");

			if (!devId.isEmpty() && !dClaim.isEmpty() && !description.isEmpty()) {
				int deviceId = Integer.parseInt(devId);
				LocalDate dateOfClaim = LocalDate.parse(dClaim);
				String approved = "Pending";

				if (cd.addClaim(deviceId, dateOfClaim, description, approved) == 1) {
					String username = request.getParameter("username");

					String url = "ReadClaim?username=" + username;

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

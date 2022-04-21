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

import dao.RegDeviceDao;

/**
 * Servlet implementation class RegisterDevice
 */
@WebServlet("/RegisterDevice")
public class RegisterDevice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterDevice() {
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
		RegDeviceDao rd = new RegDeviceDao();

		String devId = request.getParameter("deviceId");
		String loginId = request.getParameter("loginId");
		String productName = request.getParameter("deviceName");
		String pDate = request.getParameter("purchaseDate");

		if (!loginId.isEmpty() && !devId.isEmpty() && !productName.isEmpty() && !pDate.isEmpty()) {
			int deviceId = Integer.parseInt(devId);
			LocalDate purchaseDate = LocalDate.parse(pDate);

			if (rd.registerDevice(deviceId, loginId, productName, purchaseDate) == 1) {
				String url = "ReadDevice?username=" + loginId;

				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);

			} else
				out.println("Device not Registered!");

		} else
			out.println("Empty field not allowed.");

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

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddProductDao;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProduct() {
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
			AddProductDao apd = new AddProductDao();

			String devId = request.getParameter("deviceId");
			String deviceName = request.getParameter("deviceName");
			String model = request.getParameter("model");
			String temp_price = request.getParameter("price");
			String description = request.getParameter("description");

			if (!deviceName.isEmpty() && !model.isEmpty() && !temp_price.isEmpty() && !description.isEmpty()) {
				int deviceId = Integer.parseInt(devId);
				Double price = Double.parseDouble(temp_price);
				out.println(deviceId + "...." + deviceName + "..." + model + "..." + price + "..." + description);

				if (apd.updateProduct(deviceId, deviceName, model, price, description) == 1) {
					out.println("Product inserted!");

					String url = "ReadAddProduct?action=update";

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

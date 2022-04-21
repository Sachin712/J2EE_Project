package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReadProductQuery;

/**
 * Servlet implementation class ReadAddProduct
 */
@WebServlet("/ReadAddProduct")
public class ReadAddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadAddProduct() {
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
		ReadProductQuery readprod;
		String action = request.getParameter("action");
		String url = "";
		try {
			readprod = new ReadProductQuery();
			String table = "";
			if (action.equals("delete")) {
				
				String devId = request.getParameter("deviceId");
				int deviceId = Integer.parseInt(devId);
				readprod.doDelete(deviceId);
				
				table = readprod.getDeleteHTMLTable();
				request.setAttribute("table", table);
				url = "/deleteProduct.jsp";
			} 
			else if (action.equals("update")) {
				
				readprod.doRead();
				table = readprod.getHTMLTable();
				request.setAttribute("table", table);
				url = "/productList.jsp";
			}

			else {

				readprod.doRead();
				table = readprod.getDeleteHTMLTable();
				request.setAttribute("table", table);
				url = "/productList.jsp";
			}

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

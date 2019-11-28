package cn.com.single.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.single.service.WareHouseService;
import cn.com.single.service.Impl.WarehouseServiceImpl;

@WebServlet("/wareHouseServlet")
public class WareHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	WareHouseService warehouseService = new WarehouseServiceImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int proId = Integer.parseInt((String) request.getSession().getAttribute("proId"));
		List<Integer> sizeList = this.warehouseService.findSizes(proId);
		request.setAttribute("sizeList", sizeList);
		request.getRequestDispatcher("/WEB-INF/jsp/sizes.jsp").forward(request, response);
	}

}

package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import package01.*;

/**
 * Servlet implementation class Select_room
 */
@WebServlet("/Select_room")
public class Select_room extends HttpServlet {
	Select_all Select_all;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Select_room() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Select_all= (Select_all)applicationContext.getBean("select_all");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String room_class=request.getParameter("room");
		System.out.println("输出调试房型信息"+room_class);
		@SuppressWarnings("rawtypes")
		List list=Select_all.getallInfo(room_class);
		request.setAttribute("goodsList", list);
		request.getRequestDispatcher("add_roomInfo.jsp").forward(request, response);
		
		
	}

}

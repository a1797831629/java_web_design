package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import package01.Add_roomInfo_DAO;
import package01.Person;
import package01.RoomInfo;

/**
 * Servlet implementation class Add_Servlet
 */
@WebServlet("/Add_Servlet")
public class Add_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Servlet() {
        super();
        // TODO Auto-generated constructor stub
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
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String ID_card=request.getParameter("ID_card");
		String ID1=request.getParameter("ID");
		int ID=Integer.parseInt(ID1);
		String status="1";
		RoomInfo roomInfo=new RoomInfo();
		roomInfo.setName(name);
		roomInfo.setStatus(status);
		roomInfo.setID(ID);
		Person person=new Person();
		person.setID_card(ID_card);
		person.setName(name);
		person.setSex(sex);
		ApplicationContext fApplicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Add_roomInfo_DAO add_roomInfo_DAO=(Add_roomInfo_DAO)fApplicationContext.getBean("myDao");
		add_roomInfo_DAO.addInfo(roomInfo, person);
		String Info="尊敬的"+name+"客户，恭喜您预订成功";
		request.setAttribute("success", Info);
		request.getRequestDispatcher("success.jsp").forward(request, response);
	}

}

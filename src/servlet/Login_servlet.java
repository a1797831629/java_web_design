package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import package01.*;

/**
 * Servlet implementation class Login_servlet
 */
@WebServlet("/Login_servlet")
public class Login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String passwd=request.getParameter("passwd");

		Session session=null;
		try {
			Configuration configuration=new Configuration().configure();
			SessionFactory sFactory=configuration.buildSessionFactory(new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());
			session=(sFactory!=null)?sFactory.openSession():null;
			Transaction transaction=session.beginTransaction();
			UserInfo userInfo;
			userInfo=(UserInfo)session.get(UserInfo.class, new Integer(1));
			if (userInfo.getUsername().equals(username)&&userInfo.getPasswd().equals(passwd)) {
				request.getRequestDispatcher("manage.jsp").forward(request, response);
				
			}else {
				request.setAttribute("login_error", "账号或密码错误");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		
	}

}

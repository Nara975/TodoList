package kr.or.connect.TodoList.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.TodoList.dao.TodoDao;
import kr.or.connect.TodoList.dto.TodoDto;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoDao dao = new TodoDao();
		List<TodoDto> dtolist = new ArrayList<TodoDto>();
		dtolist = dao.allTodo();
		
		request.setAttribute("dtolist", dtolist);
		
		RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
		rd.forward(request, response);
		
	}



}
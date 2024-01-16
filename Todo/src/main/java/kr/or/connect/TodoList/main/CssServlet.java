package kr.or.connect.TodoList.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CssServlet
 */
@WebServlet("/cssServlet")
public class CssServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CssServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/css;charset=UTF-8");
        // CSS 파일을 읽어오는 로직
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("/index.css");
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            // 읽어온 CSS 파일의 내용을 응답으로 보냄
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                response.getWriter().write(line);
                response.getWriter().write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            // 예외 처리: 파일을 읽어오는 도중에 문제가 발생한 경우
            response.getWriter().write(".error { color: red; }");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

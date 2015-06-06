package br.com.guiaturistico.servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.guiaturistico.bean.Categoria;
import br.com.guiaturistico.dao.DaoCategoria;

public class CategController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int pages;

	public CategController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String funcao = request.getParameter("funcao");
		int page = Integer.parseInt(request.getParameter ("page"));
		int perPage = 4;
		
		if (funcao.equals("listCategPerPage")) {
			String imagemUrl = "img/icons_marker/";
			DaoCategoria dao = new DaoCategoria();
			try {
				ArrayList<Categoria> a = dao.getAllCategPerPage(page, perPage);
				request.setAttribute("pages", (pages / perPage));
				request.setAttribute("listCategPerPage", a);
				request.setAttribute("imagemUrl", imagemUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/ListaCateg.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}
}

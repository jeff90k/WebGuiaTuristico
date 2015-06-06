<%@page import="br.com.guiaturistico.bean.Categoria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Guia Turístico de São Paulo</title>
    <link href="css/stylesheet.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
      <%@ include file="includes/navbar.jsp" %>
      
      <div class="container">
            <div class="row">
                  <div class="col-md-11">
                  <br/><br/><br/><br/>
                        <h3>Categorias encontradas:</h3><br />                        
                                   <%
										ArrayList <Categoria> lista = (ArrayList <Categoria>)request.getAttribute("listCategPerPage");                                                           
                                        for(int i=0; i<lista.size(); i++){
                                   %>
                                               <h4><b>Nome da Categoria: </b><%= lista.get(i).getNmCategoria() %></h4>
                                               <p><b>Imagem: </b><img src="<%= request.getAttribute("imagemUrl")+lista.get(i).getNmIcon() %>" title="<%= lista.get(i).getNmTitle() %>" /></p>
                                               <table class="col-md-offset-11">
	                                               <tr>
	                                               		<td>
			                                               	<a href="Controller?funcao=edt&id=<%= lista.get(i).getCdCategoria() %>">
																<span class="glyphicon glyphicon-pencil"></span>
															</a>
															<a href="Controller?funcao=del&id=<%= lista.get(i).getCdCategoria() %>">
																<span class="glyphicon glyphicon-trash"></span>
															</a>
														</td>
													</tr>
												</table>
                                               <hr/>
                                   <%
                                         }
                                   %>
                  </div>
            </div>
            <nav>
	            <%
				    int pages = (Integer) request.getAttribute("pages")+1;
	            %>
			  <ul class="pagination pagination-md">
			    <li>
			      <a href="Controller?funcao=listCategPerPage&page=<%= (pages-pages)+1 %>" aria-label="Previous">
			        <span aria-hidden="true">&laquo; Primeira</span>
			      </a>
			    </li>
			    <%
			    	for(int i=1; i<=pages; i++){
			    		int j = Integer.parseInt(request.getParameter("page"));
			    		if(i==j){
			    %>
				    		<li class="active"><a href="Controller?funcao=listCategPerPage&page=<%= i %>"><%= i %></a></li>
				<%
			    		} else {
			    %>
			    			<li><a href="Controller?funcao=listCategPerPage&page=<%= i %>"><%= i %></a></li>
			    <%
			    		}
				    }
				%>
				<li>
			      <a href="Controller?funcao=listCategPerPage&page=<%= pages++ %>" aria-label="Next">
			        <span aria-hidden="true"> Última &raquo; </span>
			      </a>
			    </li>
			  </ul>
			</nav>
      </div>
	<%@	include file="includes/footer.jsp" %>
</body>
</html>

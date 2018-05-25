<%@page pageEncoding="UTF-8"%>  
    <%@ page import="model.Equipamento" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Equipamentos</title>
	</head>
	<body>
		<h3><a href="index.jsp">Home</a></h3>
		<%
			Object o = request.getAttribute("lista");
			if(o instanceof List<?>){
				List<?> le = (List<?>) o;
				if(le.size() > 0){%>
                                    <table>
					<thead>
                                            <tr> <th>Nome</th> <th>Tipo </th> <th> Peso </th> <th>ID </th></tr>
					</thead>
                                            <%
                                            for(int i=0;i<le.size();i++){
                                                    Object ob = le.get(i);
                                                    if(ob instanceof Equipamento){
                                                            Equipamento eq = (Equipamento)ob;%>
                                                                    <tbody>
                                                                                    <tr>
                                                                                            <td><% out.print(eq.getNome()); %></td>
                                                                                            <td><% out.print(eq.getTipo()); %></td>
                                                                                            <td><% out.print(eq.getPeso()+"g"); %></td>
                                                                                            <td><% out.print(eq.getId()); %></td>
                                                                                    </tr>
                                                                    </tbody>
                                                            <%
                                                    }
                                            }%>
                                    </table>
                              <%}
			}
		%>
	</body>
</html>
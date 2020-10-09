<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="backendxpto20202.modelo.bean.Usuario"%>
<%@page import="backendxpto20202.controle.ControleUsuario"%>

<%
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    String status = request.getParameter("STATUS");
    String tipo = request.getParameter("TIPO");
    Usuario usu = new Usuario(0,login,senha,status,tipo);
    ControleUsuario usucont = new ControleUsuario();
    usu = usucont.inseri(usu);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirUsuario.jsp";
    response.sendRedirect(url);
%>

<HTML>
    <BODY>
        <%=login%>  <BR>
        <%=senha%>  <BR>
        <%=status%> <BR>
        <%=tipo%>   <BR>
    </BODY>
</HTML>

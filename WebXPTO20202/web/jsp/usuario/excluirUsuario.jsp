<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="backendxpto.bean.Usuario"%>
<%@page import="backendxpto.control.UsuarioControl"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Usuario usu = new Usuario(id,"","","","");
    UsuarioControl usuCont = new UsuarioControl();
    usu = usuCont.excluiUsuario(usu);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarUsuario.jsp?LOGIN=" + pbusca;
    response.sendRedirect(url);
%>
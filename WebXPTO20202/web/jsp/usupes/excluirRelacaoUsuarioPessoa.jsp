<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="backendxpto.bean.UsuarioPessoa"%>
<%@page import="backendxpto.control.UsuarioPessoaControl"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    UsuarioPessoa usuPes = new UsuarioPessoa(id,0,0,"");
    UsuarioPessoaControl usuPesCont = new UsuarioPessoaControl();
    usuPes = usuPesCont.excluirUsuarioPessoa(usuPes);
    
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoUsuarioPessoa.jsp?OBS=" + pbusca;
    response.sendRedirect(url);

%>


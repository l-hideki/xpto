<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="backendxpto.bean.UsuarioPessoa"%>
<%@page import="backendxpto.control.UsuarioPessoaControl"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idPessoa = Integer.parseInt(request.getParameter("ID_PESSOA"));
    String obs = request.getParameter("OBS");
    String pbusca = request.getParameter("PBUSCA");
    UsuarioPessoa usupes = new UsuarioPessoa(id,idPessoa,idUsuario,obs);
    UsuarioPessoaControl usupescont = new UsuarioPessoaControl();
    usupes = usupescont.alterarUsuarioPessoa(usupes);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoUsuarioPessoa.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>    
    
    
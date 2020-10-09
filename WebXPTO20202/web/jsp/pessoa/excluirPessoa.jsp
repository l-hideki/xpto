<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="backendxpto.bean.PessoaFisica"%>
<%@page import="backendxpto.control.PessoaFisicaControl"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    PessoaFisica pes = new PessoaFisica(id,"","","","");
    PessoaFisicaControl pesCont = new PessoaFisicaControl();
    pes = pesCont.excluiPessoaFisica(pes);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarPessoa.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>
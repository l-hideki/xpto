<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="backendxpto.bean.PessoaFisica"%>
<%@page import="backendxpto.control.PessoaFisicaControl"%>

<%
    String cpf = request.getParameter("CPF");
    String nome = request.getParameter("NOME");
    String mail = request.getParameter("EMAIL");
    String tipo = request.getParameter("TIPO");
 
    PessoaFisica pes = new PessoaFisica(0,cpf,nome,tipo,mail);
    PessoaFisicaControl pescont = new PessoaFisicaControl();
    pes = pescont.inserePessoaFisica(pes);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirPessoa.jsp";
    response.sendRedirect(url);
%>


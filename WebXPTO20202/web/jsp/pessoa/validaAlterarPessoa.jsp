<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="backendxpto.control.PessoaFisicaControl"%>
<%@page import="backendxpto.bean.PessoaFisica"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String cpf = request.getParameter("CPF");
    String nome = request.getParameter("NOME");
    String mail = request.getParameter("EMAIL");
    String tipo = request.getParameter("TIPO");
    String pbusca = request.getParameter("PBUSCA");
    PessoaFisica pes = new PessoaFisica(id,nome,cpf,tipo,mail);
    PessoaFisicaControl pesCont = new PessoaFisicaControl();
    pes = pesCont.alteraPessoaFisica(pes);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarPessoa.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>
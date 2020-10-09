<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="backendxpto.bean.Usuario"%>
<%@page import="backendxpto.bean.PessoaFisica"%>
<%@page import="backendxpto.control.UsuarioControl"%>
<%@page import="backendxpto.control.PessoaFisicaControl"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Usuario usu = new Usuario(id,"","","","");
    UsuarioControl usuCont = new UsuarioControl();
    usu = usuCont.buscaUsuario(usu);
    String pbusca = request.getParameter("PBUSCA");

    PessoaFisicaControl pesCont = new PessoaFisicaControl();
    PessoaFisica pf = new PessoaFisica(0,"","","","");
    List<PessoaFisica> pess = pesCont.listaPessoaFisica(pf);

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - USUÁRIO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR USUÁRIO</h1>
        <form name="alterarUsuario" action="validaAlterarUsuario.jsp" method="post">
            Login: <input type="text" name="LOGIN" value="<%=usu.getLogin()%>"> <br>
            Senha: <input type="password" name="SENHA" value="<%=usu.getSenha()%>"> <br>
            Status: <input type="text" name="STATUS" value="<%=usu.getStatus()%>"> <br>
            Tipo: <input type="text" name="TIPO" value="<%=usu.getTipo()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=usu.getIdUsu()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>
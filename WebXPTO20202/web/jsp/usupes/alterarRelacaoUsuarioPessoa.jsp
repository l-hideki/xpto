<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="backendxpto.bean.UsuarioPessoa"%>
<%@page import="backendxpto.control.UsuarioPessoaControl"%>
<%@page import="java.util.List"%>
<%@page import="backendxpto.bean.Usuario"%>
<%@page import="backendxpto.control.UsuarioControl"%>
<%@page import="backendxpto.bean.PessoaFisica"%>
<%@page import="backendxpto.control.PessoaFisicaControl"%>

<%
PessoaFisicaControl pesCont = new PessoaFisicaControl();
    PessoaFisica pf = new PessoaFisica(0,"","","","");
    List<PessoaFisica> pess = pesCont.listaPessoaFisica(pf);

    UsuarioControl usuCont = new UsuarioControl();
    Usuario usuEnt = new Usuario(0,"","");
    List<Usuario> usus = usuCont.ListaUsuario(usuEnt);
    
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    UsuarioPessoa usuPes = new UsuarioPessoa(id,0,0,"");
    UsuarioPessoaControl usuPesCont = new UsuarioPessoaControl();
    usuPes = usuPesCont.buscarUsuarioPessoa(usuPes);
    String pbusca = request.getParameter("PBUSCA");


%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - USUÁRIO PESSOA</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR - USUÁRIO PESSOA</h1>
        <form name="alterarUsuarioPessoa" action="validaAlterarRelacaoUsuarioPessoa.jsp" method="post">
            <table>
                <tr>
                    <td>Usuario:</td>
                        <td>
                            <select NAME="ID_USUARIO" class="browser-default">
                                <% for (Usuario usu : usus) { %>
                                    <% if( usu.getIdUsu() == usuPes.getIdUsuario() ) { %>
                                        <option selected value="<%=usu.getIdUsu()%>"><%=usu.getLogin()%></option>
                                    <% } else { %>
                                        <option value="<%=usu.getIdUsu()%>"><%=usu.getLogin()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                </tr>
                <tr>
                        <td>Pessoa:</td>
                        <td>
                            <select NAME ="ID_PESSOA" class="browser-default">
                                <% for (PessoaFisica pes : pess) { %>
                                    <% if( pes.getId()== usuPes.getIdPessoa() ) { %>
                                        <option selected value="<%=pes.getId()%>"><%=pes.getNome()%></option>
                                    <% } else { %>
                                        <option value="<%=pes.getId()%>"><%=pes.getNome()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value="<%=usuPes.getObs()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="ID" value="<%=usuPes.getIdUsuPes()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>
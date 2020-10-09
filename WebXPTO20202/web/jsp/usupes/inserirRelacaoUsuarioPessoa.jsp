<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR USUARIO PESSOA</title>
    <body>
        <div class="container"/>
            <h1>Inseri Usuario Pessoa</h1>
            <form name="inseriUsuarioPessoa" action="validaRelacaoUsuarioPessoa.jsp" method="POST">
                <table>
                    <tr>
                        <td>Pessoa:</td>
                        <td>
                            <select NAME ="ID_PESSOA" class="browser-default">
                                <% for (PessoaFisica pes : pess) { %>
                                    <option value="<%=pes.getId()%>"><%=pes.getNome()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Usuario:</td>
                        <td>
                            <select NAME="ID_USUARIO" class="browser-default">
                                <% for (Usuario usu : usus) { %>
                                    <option value="<%=usu.getIdUsu()%>"><%=usu.getLogin()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value=""></td>
                    </tr>
                </table>    
                <input type="submit" name="Enviar" value="Enviar">  <br>
            </form>
        </div>                     
    </body>
</html>

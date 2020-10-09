<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="backendxpto.control.PessoaFisicaControl"%>
<%@page import="backendxpto.bean.Usuario"%>
<%@page import="backendxpto.bean.PessoaFisica"%>
<%
    String nome = request.getParameter("NOME");
    PessoaFisica pes = new PessoaFisica(0,nome,"","","");
    PessoaFisicaControl pescont = new PessoaFisicaControl();
    List<PessoaFisica> pess = pescont.listaPessoaFisica(pes);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + nome+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA PESSOAS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Cpf">Cpf</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(pess.isEmpty())) { %>    
                <tbody>
                    <% for (PessoaFisica listaPessoas : pess) { %>
                        <tr>
                            <td><%=listaPessoas.getId()%></td>
                            <td><%=listaPessoas.getCpf()%></td>
                            <td><%=listaPessoas.getNome()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirPessoa.jsp?<%=url + listaPessoas.getId()%>">Excluir</a></td>
                                <td><a href="alterarPessoa.jsp?<%=url + listaPessoas.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>
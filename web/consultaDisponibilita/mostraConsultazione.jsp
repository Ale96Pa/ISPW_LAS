<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 21/01/2018
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="beanConsultaAule" scope="request" class="useCase.consultazioneAule.View.BeanConsultaAule" />

<html>
<head>
    <title>Mostra Aule disponibili</title>
</head>

<body bgcolor="#e0ffff" >
<br> <br>
<%
    ArrayList<String> auleDisponibili = beanConsultaAule.auleDisponibili();
    if (auleDisponibili.size() == 0){
%> <h3>  NON ci sono aule disponibili per le caratteristiche richieste! </h3>
 <%
}
else { %>
<p>Le aule disponibili sono le seguenti: </p>
<table border="1" cellpadding="5" cellspacing="5">
        <% for(int i=0; i<auleDisponibili.size(); i++){
            %>
    <tr>
        <td> Aula:     <% out.print(auleDisponibili.get(i)); %> </td>
    </tr>
    <%
    }
    System.out.println(auleDisponibili); }
    %>
</table>
</body>
</html>
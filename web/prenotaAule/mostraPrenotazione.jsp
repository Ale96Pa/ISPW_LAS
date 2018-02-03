<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 21/01/2018
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="prenotazioneBean" scope="request" class="useCase.prenotazioneAule.View.PrenotazioneBean" />

<html>
<head>
    <title>Mostra Prenotazioni</title>
</head>

<body bgcolor="#e0ffff" >
    <br> <br>
    <%
        ArrayList<String> aulePrenotate = prenotazioneBean.aulePrenotate();
        if (aulePrenotate.size() == 0){
    %> <h3>  NON ci sono aule disponibili per la prenotazione richiesta! </h3>
            <br> Se hai inserito correttamente i dati l'evento e' gia' presente nel Database <%
        }
        else { %>
            <p>Hai prenotato le seguenti aule: </p>
            <table border="1" cellpadding="5" cellspacing="5">
            <% for(int i=0; i<aulePrenotate.size(); i++){
            %>
            <tr>
                <td> Aula:     <% out.print(aulePrenotate.get(i)); %> </td>
            </tr>
            <% }
            System.out.println(aulePrenotate); }
    %>
    </table>
</body>
</html>

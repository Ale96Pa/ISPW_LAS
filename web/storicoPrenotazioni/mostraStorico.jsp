<%@ page import="useCase.storicoPrenotazioni.Model.PrenotazioneStorico" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 31/01/2018
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="storicoBean" scope="request" class="useCase.storicoPrenotazioni.View.StoricoBean" />
<!-- Mappa automaticamente tutti gli attributi dell'oggetto prenotazioneBean -->
<jsp:setProperty name="storicoBean" property="anno"/>


<html>
<head>
    <title>Storico prenotazioni</title>
</head>

<body bgcolor="#e0ffff" >
<h2> STORICO PRENOTAZIONI </h2>
<br><hr><br><br>
Anno accademico inserito:
<%
    out.print(storicoBean.getAnno() + " / " + (storicoBean.getAnno()+1) );
    ArrayList<PrenotazioneStorico> prenotazioni = storicoBean.storicoPrenotazioni();
%>
<br><hr><br><br>
<%
    if(prenotazioni.size() == 0){
%> <h1> Non ci sono prenotazioni nell'AA scelto </h1> <%
    }
%>
<table border="1" cellpadding="5" cellspacing="5">
        <% for(int i=0; i<prenotazioni.size(); i++){
            %>
        <tr>
        <td> Aula:     <% out.print(prenotazioni.get(i).getNomeAula()); %> </td>
        <td> Evento:    <% out.print(prenotazioni.get(i).getTitoloEvento()); %> </td>
        <td> Data:    <% out.print(prenotazioni.get(i).getData()); %> </td>
        <td> Ora inizio:    <% out.print(prenotazioni.get(i).getOraInizio()); %> </td>
        <td> Ora fine:    <% out.print(prenotazioni.get(i).getOraFine()); %> </td>
        </tr>
        <%
        } %>
</table>

</body>
</html>

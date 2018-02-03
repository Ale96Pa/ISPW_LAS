<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 31/01/2018
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Si dichiara la variabile prenotazioneBean e istanzia un oggetto PrenotazioneBean -->
<jsp:useBean id="storicoBean" scope="request"  class="useCase.storicoPrenotazioni.View.StoricoBean"/>

<!-- Mappa automaticamente tutti gli attributi dell'oggetto prenotazioneBean -->
<jsp:setProperty name="storicoBean" property="*"/>

<%
    if (request.getParameter("prenotazione") != null) {
        if (storicoBean.anno < 2000 || storicoBean.anno > 2100) {
            %> <jsp:forward page="errorAnnoStorico.jsp" /> <%
    }
        %> <jsp:forward page="mostraStorico.jsp" /> <%
    }
%>

<html>

<head>
    <title>Storico prenotazioni</title>
</head>

<body bgcolor="#e0ffff" >
<h2>STORICO PRENOTAZIONI </h2>


<form method="get" action="insertStorico.jsp">

    <img src="logo.png" width="150" height="150" hspace="1000">
    <br>
    <U> <I> Inserire l'anno INIZIALE dell'anno accademico (es: per l'AA 2017/2018 inserire 2017)   </I> </U>

    <br><br><br>
    Inserisci Anno Accademico: <input type="text" name="anno" id="anno">
    <br><hr><br><br>
    <input name="prenotazione" type="submit" id="prenotazione" value="Cerca" class="btn btn-info">

</form>
</body>
</html>

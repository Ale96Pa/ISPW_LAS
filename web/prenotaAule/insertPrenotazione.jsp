<%@ page import="useCase.prenotazioneAule.View.PrenotazioneBean" %>
<%@ page import="useCase.prenotazioneAule.Model.Prenotazione" %>
<%@ page import="exceptions.InsertYearException" %>
<%@ page import="exceptions.InsertOraException" %>

<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 21/01/2018
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Si dichiara la variabile prenotazioneBean e istanzia un oggetto PrenotazioneBean -->
<jsp:useBean id="prenotazioneBean" scope="request"  class="useCase.prenotazioneAule.View.PrenotazioneBean"/>

<!-- Mappa automaticamente tutti gli attributi dell'oggetto prenotazioneBean -->
<jsp:setProperty name="prenotazioneBean" property="*"/>

<%
       if (request.getParameter("prenotazione") != null) {
            if (prenotazioneBean.getAnno() < 2000 || prenotazioneBean.getAnno() > 2100) {
                %> <jsp:forward page="errorAnno.jsp" /> <%
            }
            if (prenotazioneBean.getOrainizio() >= prenotazioneBean.getOrafine()){
                %> <jsp:forward page="errorOra.jsp" /> <%
            }
            %> <jsp:forward page="mostraPrenotazione.jsp" /> <%
        }
        %>



<html>
<head>
    <title>ClientPrenotazione</title>
</head>

<body bgcolor="#e0ffff" >
<h2>SEGRETERIA: Prenotazione di aule per Eventi </h2>
<img src="logo.png" width="150" height="150" align="" hspace="1100">
<br>
<form method="get" action="insertPrenotazione.jsp">

    Inserisci data:         Giorno: <select name="giorno" id="giorno">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
    <option value="11">11</option>
    <option value="12">12</option>
    <option value="13">13</option>
    <option value="14">14</option>
    <option value="15">15</option>
    <option value="16">16</option>
    <option value="17">17</option>
    <option value="18">18</option>
    <option value="19">19</option>
    <option value="20">20</option>
    <option value="21">21</option>
    <option value="22">22</option>
    <option value="23">23</option>
    <option value="24">24</option>
    <option value="25">25</option>
    <option value="26">26</option>
    <option value="27">27</option>
    <option value="28">28</option>
    <option value="29">29</option>
    <option value="30">30</option>
    <option value="31">31</option>
</select>     Mese:<select name="mese" id="mese">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
    <option value="11">11</option>
    <option value="12">12</option>
</select>
    Anno: <input type="text" name="anno" id="anno">
    <br><br><br>

    Inserisci orario:       Da: <select name="orainizio" id="orainizio">
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
    <option value="11">11</option>
    <option value="12">12</option>
    <option value="13">13</option>
    <option value="14">14</option>
    <option value="15">15</option>
    <option value="16">16</option>
    <option value="17">17</option>
    <option value="18">18</option>
</select>
    A: <select name="orafine" id="orafine">
    <option value="9">9</option>
    <option value="10">10</option>
    <option value="11">11</option>
    <option value="12">12</option>
    <option value="13">13</option>
    <option value="14">14</option>
    <option value="15">15</option>
    <option value="16">16</option>
    <option value="17">17</option>
    <option value="18">18</option>
</select>
    <br><hr><br><br>

    Numero posti: <input type="text" name="numeroPosti">

    Microfono: <input type="checkbox" name="microfono">

    Proiettore: <input type="checkbox" name="proiettore">

    <br> <br>

    Evento: <select name="titoloEvento" id="titoloEvento">
    <option value="1">Test D'Ingresso</option>
    <option value="2">Seduta di Laurea</option>

    <br><hr><br><br>

    <input name="prenotazione" type="submit" id="prenotazione" value="Prenota" class="btn btn-info">



</form>
</body>
</html>
